package team2.sandwichorder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.File;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Nicki
 * Date: 2/20/13
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class IngredientGroupDAOTest {
    private Document doc;
    private String fileName = "C:\\Users\\Nicki\\Ingredients.xml";
    private IngredientGroupDAO ingredientData = new IngredientGroupDAO();
    @Before
    public void setUp() throws Exception {
        File fXmlFile = new File(fileName);
        doc = ingredientData.parseXmlFile(fXmlFile);
    }

    @Test
    public void testParseDocumentForElements() throws Exception {
        String tagName = "group";
        ArrayList<String> elementList = new ArrayList<String>();
        elementList = ingredientData.parseDocumentForElements(doc, tagName);
        for (String sElement:elementList){
            assertEquals("multi-select", sElement);
        }
    }
    @After
    public void tearDown() throws Exception {

    }
}
