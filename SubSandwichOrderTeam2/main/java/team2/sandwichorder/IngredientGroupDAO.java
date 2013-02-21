package team2.sandwichorder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
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
    public Document parseXmlFile(File fileName){
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
    public ArrayList parseDocumentForElements(Document dom, String tagName){
        ArrayList<String> elementNames = new ArrayList<String>();
        //get the root element
        dom.getDocumentElement().normalize();
        NodeList nodes = dom.getElementsByTagName(tagName);
        for (int i = 0; i < nodes.getLength(); i++)
        {
            Node node = nodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                String elementValue = getTextValueFromElement(element, "type");
                System.out.println("Element " + elementValue);
                elementNames.add(elementValue);
            }
        }
        return elementNames;
}

    /* for a document element, get the text value based on the tag name*/
    public String getTextValueFromElement(Element element, String tagName){
        String textVal = null;
        System.out.println("Element Tag Name: " + element.getTagName());
        NodeList nl = element.getElementsByTagName(tagName);
        System.out.println(nl.toString());
        //Element el = (Element) nl.item(0);
        if(nl != null && nl.getLength() > 0) {
            Element elmt = (Element)nl.item(0);
            System.out.println("NodeList: " + nl.toString());
            textVal = elmt.getFirstChild().getNodeValue();
        }
        else
            textVal = "Not Found";
        return textVal;
    }

    /* get the attribute of an Element based on the tag's attribute value name */
    public String getAttributeValueFromElement(Element element, String tagName){
        return null;
    }

    /* build the ingredient group object from the parsed XML data */
    private IngredientGroup buildIngredientGroup (){
        return null;
    }

    // return the arraylist of ingredient groups of the type passed in through the parameter
    // single-select or multi-select
    public ArrayList<IngredientGroup> returnIngredientGroup(String type)  {
        return null;
    }
}
