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
    private String fileName = ".\\Ingredients.xml";
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
        int groupsSize = groupsFromXMLFile.size();
        assertEquals(7, groupsSize);
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
                        assertEquals("Foot Long",choice );
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
                if ((i+1) == 2 ){
                    assertEquals("single-select", group.getGroupType()) ;
                    assertEquals("Sandwich-type", group.getGroupName());
                    choices = group.getChoices();
                    for (int j = 0; j < choices.size(); j++) {
                        if ((j+1) == 1) {
                            choice = choices.get(j);
                            assertEquals("Toasted",choice );
                        }
                        if ((j+1) == 2) {
                            choice = choices.get(j);
                            assertEquals("Non-Toasted",choice );
                        }
                    }
                }
                if ((i+1) == 3 ){
                    assertEquals("single-select", group.getGroupType()) ;
                    assertEquals("Bread", group.getGroupName());
                    choices = group.getChoices();
                    for (int j = 0; j < choices.size(); j++) {
                        if ((j+1) == 1) {
                            choice = choices.get(j);
                            assertEquals("Italian White",choice );
                        }
                        if ((j+1) == 2) {
                            choice = choices.get(j);
                            assertEquals("Wheat",choice );
                        }
                        if ((j+1) == 3) {
                            choice = choices.get(j);
                            assertEquals("Honey Oat",choice );
                        }
                        if ((j+1) == 4) {
                            choice = choices.get(j);
                            assertEquals("Italian Herbs and Cheese",choice );
                        }
                        if ((j+1) == 5) {
                            choice = choices.get(j);
                            assertEquals("Monterey Cheddar",choice );
                        }
                        if ((j+1) == 6) {
                            choice = choices.get(j);
                            assertEquals("Flatbread",choice );
                        }
                        if ((j+1) == 7) {
                            choice = choices.get(j);
                            assertEquals("Wheat Wrap",choice );
                        }
                    }
                    if ((i+1) == 4 ){
                        assertEquals("single-select", group.getGroupType()) ;
                        assertEquals("Cheese", group.getGroupName());
                        choices = group.getChoices();
                        for (int j = 0; j < choices.size(); j++) {
                            if ((j+1) == 1) {
                                choice = choices.get(j);
                                assertEquals("American",choice );
                            }
                            if ((j+1) == 2) {
                                choice = choices.get(j);
                                assertEquals("Provolone",choice );
                            }
                            if ((j+1) == 3) {
                                choice = choices.get(j);
                                assertEquals("Pepper Jack",choice );
                            }
                            if ((j+1) == 4) {
                                choice = choices.get(j);
                                assertEquals("Cheddar",choice );
                            }
                            if ((j+1) == 5) {
                                choice = choices.get(j);
                                assertEquals("Monterey Jack",choice );
                            }
                        }
                    }
                    if ((i+1) == 5 ){
                        assertEquals("multi-select", group.getGroupType()) ;
                        assertEquals("Meat", group.getGroupName());
                        choices = group.getChoices();
                        for (int j = 0; j < choices.size(); j++) {
                            if ((j+1) == 1) {
                                choice = choices.get(j);
                                assertEquals("Turkey",choice );
                            }
                            if ((j+1) == 2) {
                                choice = choices.get(j);
                                assertEquals("Black Forest Ham",choice );
                            }
                            if ((j+1) == 3) {
                                choice = choices.get(j);
                                assertEquals("Sliced Chicken",choice );
                            }
                            if ((j+1) == 4) {
                                choice = choices.get(j);
                                assertEquals("Teriyaki Chicken",choice );
                            }
                            if ((j+1) == 5) {
                                choice = choices.get(j);
                                assertEquals("Steak",choice );
                            }
                            if ((j+1) == 6) {
                                choice = choices.get(j);
                                assertEquals("Roast Beef",choice );
                            }
                            if ((j+1) == 7) {
                                choice = choices.get(j);
                                assertEquals("Tuna",choice );
                            }
                            if ((j+1) == 8) {
                                choice = choices.get(j);
                                assertEquals("Bologna",choice );
                            }
                            if ((j+1) == 9) {
                                choice = choices.get(j);
                                assertEquals("Salami",choice );
                            }
                            if ((j+1) == 10) {
                                choice = choices.get(j);
                                assertEquals("Genoa Salami",choice );
                            }
                            if ((j+1) == 11) {
                                choice = choices.get(j);
                                assertEquals("Meatball Marinara",choice );
                            }
                            if ((j+1) == 12) {
                                choice = choices.get(j);
                                assertEquals("Pepperoni",choice );
                            }
                            if ((j+1) == 13) {
                                choice = choices.get(j);
                                assertEquals("Bacon",choice );
                            }
                            if ((j+1) == 14) {
                                choice = choices.get(j);
                                assertEquals("Veggie Pattie",choice );
                            }
                        }
                    }
                    if ((i+1) == 6 ){
                        assertEquals("multi-select", group.getGroupType()) ;
                        assertEquals("Toppings", group.getGroupName());
                        choices = group.getChoices();
                        for (int j = 0; j < choices.size(); j++) {
                            if ((j+1) == 1) {
                                choice = choices.get(j);
                                assertEquals("Lettuce",choice );
                            }
                            if ((j+1) == 2) {
                                choice = choices.get(j);
                                assertEquals("Tomatoes",choice );
                            }
                            if ((j+1) == 3) {
                                choice = choices.get(j);
                                assertEquals("Cucumbers",choice );
                            }
                            if ((j+1) == 4) {
                                choice = choices.get(j);
                                assertEquals("Green Peppers",choice );
                            }
                            if ((j+1) == 5) {
                                choice = choices.get(j);
                                assertEquals("Spinach",choice );
                            }
                            if ((j+1) == 6) {
                                choice = choices.get(j);
                                assertEquals("Onions",choice );
                            }
                            if ((j+1) == 7) {
                                choice = choices.get(j);
                                assertEquals("Pickles",choice );
                            }
                            if ((j+1) == 8) {
                                choice = choices.get(j);
                                assertEquals("Olives",choice );
                            }
                            if ((j+1) == 9) {
                                choice = choices.get(j);
                                assertEquals("Banana Peppers",choice );
                            }
                            if ((j+1) == 10) {
                                choice = choices.get(j);
                                assertEquals("Grated Parmesan",choice );
                            }
                            if ((j+1) == 11) {
                                choice = choices.get(j);
                                assertEquals("Jalapenos",choice );
                            }
                            if ((j+1) == 12) {
                                choice = choices.get(j);
                                assertEquals("Salt",choice );
                            }
                            if ((j+1) == 13) {
                                choice = choices.get(j);
                                assertEquals("Pepper",choice );
                            }
                            if ((j+1) == 14) {
                                choice = choices.get(j);
                                assertEquals("Oregano",choice );
                            }
                        }
                    }
                    if ((i+1) == 7 ){
                        assertEquals("multi-select", group.getGroupType()) ;
                        assertEquals("Sauces", group.getGroupName());
                        choices = group.getChoices();
                        for (int j = 0; j < choices.size(); j++) {
                            if ((j+1) == 1) {
                                choice = choices.get(j);
                                assertEquals("Yellow Mustard",choice );
                            }
                            if ((j+1) == 2) {
                                choice = choices.get(j);
                                assertEquals("Brown Mustard",choice );
                            }
                            if ((j+1) == 3) {
                                choice = choices.get(j);
                                assertEquals("Honey Mustard",choice );
                            }
                            if ((j+1) == 4) {
                                choice = choices.get(j);
                                assertEquals("Sweet Onion",choice );
                            }
                            if ((j+1) == 5) {
                                choice = choices.get(j);
                                assertEquals("Red Wine Vinegar",choice );
                            }
                            if ((j+1) == 6) {
                                choice = choices.get(j);
                                assertEquals("Light Mayo",choice );
                            }
                            if ((j+1) == 7) {
                                choice = choices.get(j);
                                assertEquals("Chipolte Southwest",choice );
                            }
                            if ((j+1) == 8) {
                                choice = choices.get(j);
                                assertEquals("Ranch",choice );
                            }
                            if ((j+1) == 9) {
                                choice = choices.get(j);
                                assertEquals("Mayo",choice );
                            }
                            if ((j+1) == 10) {
                                choice = choices.get(j);
                                assertEquals("Oil",choice );
                            }
                        }
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
