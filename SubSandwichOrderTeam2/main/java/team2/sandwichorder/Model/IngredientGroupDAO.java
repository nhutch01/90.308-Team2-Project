package team2.sandwichorder.Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IngredientGroupDAO - data access object for retrieving and creating IngredientGroup objects
 * from parsing an XML file of ingredients for the Subway Sandwich order system
 * @author Nicki Hutchens
 * @since 2/18/13
 */
public class IngredientGroupDAO implements ProcessXMLFileData{
    IngredientGroup ingredientGroup = null;

    public IngredientGroupDAO(){
        ingredientGroup = new IngredientGroup();
    }


    /**
     * parseXMLFile
     * Returns the Document object from the XML file
     * @param fileName
     * @return  Document object from XML file
     */
    public static Document parseXmlFile(File fileName){
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        Document dDocument;
        try {

            //Using factory get an instance of document builder
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            dDocument = docBuilder.parse(fileName);


        }catch(ParserConfigurationException pce) {
            pce.printStackTrace();
            return null;
        }catch(SAXException se) {
            se.printStackTrace();
            return null;
        }catch(IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
        return dDocument;
    }

    /**
     * parseDocumentForElements
     * Parse the ingredient group data from the XML file, create IngredientGroup objects, and
     *   add them to the List of IngredientGroup objects
     * @param dDocument
     * @param tagName
     * @return List of IngredientGroup objects from XML document
     */
    public List<IngredientGroup> parseDocumentForElements(Document dDocument, String tagName){
        List<IngredientGroup> allIngredientGroups = new ArrayList<IngredientGroup>();
        IngredientGroup buildGroup = new IngredientGroup();
        //get the root element
        dDocument.getDocumentElement().normalize();
        NodeList groupNodes = dDocument.getElementsByTagName(tagName);
        for (int i = 0; i < groupNodes.getLength(); i++)
        {
            buildGroup = new IngredientGroup();
            //Node node = groupNodes.item(i);
            Element groupElement = (Element)groupNodes.item(i); // <group> element
            NodeList typeNodes = groupElement.getElementsByTagName("type");  // <type> node
            Element typeElement = (Element)typeNodes.item(0);
            String elementValue = typeElement.getTextContent();
            buildGroup.setGroupType(elementValue);
            NodeList nameNodes = groupElement.getElementsByTagName("name");  // <type> node
            Element nameElement = (Element)nameNodes.item(0);
            elementValue = nameElement.getTextContent();
            buildGroup.setGroupName(elementValue);
            NodeList choiceNodes = groupElement.getElementsByTagName("choice");
            for (int choice = 0; choice < choiceNodes.getLength(); choice++) {
                Element authorElement = (Element)choiceNodes.item(choice);
                elementValue = authorElement.getTextContent();
                buildGroup.addChoice(elementValue);
            }

            allIngredientGroups.add(buildGroup);
        }
        return allIngredientGroups;
}

     /**
      * returnAllIngredientGroups
     * Return the List of IngredientGroup objects from the XML file with the filename and
     *   tag name passed in as parameters
     * @param fileName
     * @param tagName
     * @return  List of IngredientGroup objects created from XML file output
     */
      public static List<IngredientGroup> returnAllIngredientGroups(String fileName, String tagName)  {
        Document dDocument;
        List<IngredientGroup> groupsFromXML;
        File fXmlFile = new File(fileName);
        dDocument = parseXmlFile(fXmlFile);
        IngredientGroupDAO ingredientData = new IngredientGroupDAO();
        groupsFromXML = ingredientData.parseDocumentForElements(dDocument, tagName);
        return groupsFromXML;
    }

}
