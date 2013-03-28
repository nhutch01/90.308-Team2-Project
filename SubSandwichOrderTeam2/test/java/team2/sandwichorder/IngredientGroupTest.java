package team2.sandwichorder;

import org.junit.Before;
import org.junit.Test;
import team2.sandwichorder.Model.IngredientGroup;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * IngredientGroupTest
 * @author Nicki Hutchens
 * Tests the Ingredient Group setters and getters
 */
public class IngredientGroupTest {

    private IngredientGroup group;
    @Before
    public void setUp() throws Exception {
        group = new IngredientGroup();
        group.setName("Cheese");
        group.setType("single-select");
        group.addChoice("American");
    }

    @Test
    public void testGetGroupType() throws Exception {
        String groupType = group.getType();
        assertEquals("single-select", groupType);

    }


    @Test
    public void testGetGroupName() throws Exception {
        String groupName = group.getName();
        assertEquals("Cheese", groupName);
    }

    @Test
    public void testGetChoices() throws Exception {
        List<String> choices = group.getChoices();
        for (String s : choices)
            assertEquals("American", s);

    }

    @Test
    public void testAddChoice() throws Exception {
        group.addChoice("Cheddar");
        List<String> choices = group.getChoices();
        int i = choices.indexOf("Cheddar");
        String s = choices.get(i);
        assertEquals("Cheddar", s);
    }

    @Test
    public void testSetGroupType() throws Exception {
        group.setType("multi-select");
        String groupType = group.getType();
        assertEquals("multi-select", groupType);
    }

    @Test
    public void testSetGroupName() throws Exception {
        group.setName("New");
        String groupName = group.getName();
        assertEquals("New", groupName);
    }



    public void tearDown() throws Exception {
        group = null;
    }
}
