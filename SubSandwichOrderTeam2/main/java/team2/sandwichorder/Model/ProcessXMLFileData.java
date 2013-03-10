package team2.sandwichorder.Model;

import org.w3c.dom.Document;

import java.util.List;

/**
 * @author Nicki Hutchens
 * @since 2/17/13
 *
 * Interface to define method necessary to parse XML file
 */
public interface ProcessXMLFileData {
    /**
     * parseDocumentForElements
     * Parses a Document for the specified tag name and its nodes
     *
     * @param dDocument
     * @param tagName
     * @return  ArrayList of elements from the Document
     */
    public List<IngredientGroup> parseDocumentForElements(Document dDocument, String tagName);

}
