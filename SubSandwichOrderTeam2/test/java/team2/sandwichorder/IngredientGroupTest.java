package team2.sandwichorder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Nicki
 * Date: 2/18/13
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class IngredientGroupTest {

    private IngredientGroup group;
    @Before
    public void setUp() throws Exception {
        group = new IngredientGroup();
        group.setGroupName("Cheese");
        group.setGroupType("single-select");
        group.addChoice("American");
    }

    @Test
    public void testGetGroupType() throws Exception {
        String groupType = group.getGroupType();
        assertEquals("single-select", groupType);

    }


    @Test
    public void testGetGroupName() throws Exception {
        String groupName = group.getGroupName();
        assertEquals("Cheese", groupName);
    }

    @Test
    public void testGetChoices() throws Exception {
        ArrayList<String> choices = group.getChoices();
        for (String s : choices)
            assertEquals("American", s);

    }

    @Test
    public void testAddChoice() throws Exception {
        group.addChoice("Cheddar");
        ArrayList<String> choices = group.getChoices();
        int i = choices.indexOf("Cheddar");
        String s = choices.get(i);
        assertEquals("Cheddar", s);
    }

    @Test
    public void testSetGroupType() throws Exception {
        group.setGroupType("multi-select");
        String groupType = group.getGroupType();
        assertEquals("multi-select", groupType);
    }

    @Test
    public void testSetGroupName() throws Exception {
        group.setGroupName("New");
        String groupName = group.getGroupName();
        assertEquals("New", groupName);
    }



    public void tearDown() throws Exception {
        group = null;
    }
}
