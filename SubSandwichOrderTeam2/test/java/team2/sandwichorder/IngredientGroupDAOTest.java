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
    }

    @Test
    public void testReturnAllIngredientGroups() throws Exception {
        String tagName = "group";
        IngredientGroup group = new IngredientGroup();
        ArrayList<String> choices = new ArrayList<String>();
        String choice = null;
        ArrayList<IngredientGroup> groupsFromXMLFile = ingredientData.returnAllIngredientGroups(fileName, tagName);
        /* the expected result is there are 7 ingredient groups in the Ingredients.xml file, each with a
            type    (single-select or multi-select)
            name (Menu-items, Sandwich-type, Bread, Cheese, Meats, Toppings, Sauces
            choice  (multiple values of the actual choices for each group
            This test checks the first group - will add the rest by 2/24/2013
        */
        for (int i = 0; i < groupsFromXMLFile.size();i++){
           group = groupsFromXMLFile.get(i);
            if ((i+1) == 1 ){
                assertEquals("single-select", group.getGroupType()) ;
                assertEquals("Menu-items", group.getGroupName());
                choices = group.getChoices();
                for (int j = 0; j < choices.size(); j++) {
                    if ((j+1) == 1) {
                        choice = choices.get(j);
                        assertEquals("Footlong",choice );
                    }
                    if ((j+1) == 2) {
                        choice = choices.get(j);
                        assertEquals("6-inch",choice );
                    }
                    if ((j+1) == 3) {
                        choice = choices.get(j);
                        assertEquals("Mini",choice );
                    }
                    if ((j+1) == 4) {
                        choice = choices.get(j);
                        assertEquals("Salad",choice );
                    }
                }

            }
        }
    }
    @After
    public void tearDown() throws Exception {
       ingredientData = null;
    }
}
