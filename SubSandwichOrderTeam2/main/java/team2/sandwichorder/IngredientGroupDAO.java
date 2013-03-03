package team2.sandwichorder;

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

/**
 * User: Nicki
 * Date: 2/18/13
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class IngredientGroupDAO implements ProcessXMLFileData{
    IngredientGroup ingredientGroup = null;

    public IngredientGroupDAO(){
        ingredientGroup = new IngredientGroup();
    }
    /* returns the Document object from the XML File */
    public static Document parseXmlFile(File fileName){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom;
        try {

            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            dom = db.parse(fileName);


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
        return dom;
    }
    /* parse the Document object for the specified XML tag and return list of elements*/
    public ArrayList<IngredientGroup> parseDocumentForElements(Document dom, String tagName){
        ArrayList<IngredientGroup> allIngredientGroups = new ArrayList<IngredientGroup>();
        IngredientGroup buildGroup = new IngredientGroup();
        //get the root element
        dom.getDocumentElement().normalize();
        NodeList groupNodes = dom.getElementsByTagName(tagName);
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

    // return the arraylist of ingredient groups of the type passed in through the parameter
    // single-select or multi-select
    public static ArrayList<IngredientGroup> returnAllIngredientGroups(String fileName, String tagName)  {
        Document doc;
        ArrayList<IngredientGroup> groupsFromXML;
        File fXmlFile = new File(fileName);
        doc = parseXmlFile(fXmlFile);
        IngredientGroupDAO ingredientData = new IngredientGroupDAO();
        groupsFromXML = ingredientData.parseDocumentForElements(doc, tagName);
        return groupsFromXML;
    }

    /*public static void main(String args[])  {
        String fileName = "C:\\Users\\Nicki\\Ingredients.xml";


        String tagName = "group";

        ArrayList<IngredientGroup> groupsFromXMLFile = returnAllIngredientGroups(fileName, tagName);

        for (IngredientGroup g:groupsFromXMLFile)        {
            System.out.println("type: " + g.getGroupType());
            System.out.println("name: " + g.getGroupName());
            for (String choice: g.getChoices())
                System.out.println("choice: " + choice);
        }

    }      */
}
