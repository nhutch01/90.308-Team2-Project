package team2.sandwichorder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Nicki
 * Date: 2/17/13
 * Time: 9:44 AM
 *
 * Interfaces to define methods necessary to parse XML files
 */
public interface ProcessXMLFileData {
    /* returns the Document object from the XML File */
    public Document parseXmlFile(String fileName);
    /* parse the Document object for the specified XML tag and return list of elements*/
    public ArrayList parseDocumentForElements(Document dom, String tagName);
    /* for a document element, get the text value based on the tag name*/
    public String getTextValueFromElement(Element element, String tagName);
    /* get the attribute of an Element based on the tag's attribute value name */
    public String getAttributeValueFromElement(Element element, String tagName);
}
