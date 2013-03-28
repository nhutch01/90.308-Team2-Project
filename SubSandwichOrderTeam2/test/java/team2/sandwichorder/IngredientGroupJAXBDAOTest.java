package team2.sandwichorder;

import org.junit.Before;
import org.junit.Test;
import team2.sandwichorder.Ingredients.GroupType;
import team2.sandwichorder.Ingredients.IngredientGroupJAXBDAO;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * IngredientGroupJAXBDAOTest
 *
 * @author Nicki Hutchens
 * @since 3/24/2013
 * Tests the Ingredient Group JAXB Data Access Object - reads the XML and checks the expected number of groups
 */
public class IngredientGroupJAXBDAOTest {
    private String fileName = ".\\Ingredients.xml";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testReturnAllIngredientGroups() throws Exception {
        List<GroupType> groupsFromXMLFile = IngredientGroupJAXBDAO.processXmlFile(fileName);
        int groupsSize = groupsFromXMLFile.size();
        assertEquals(7, groupsSize);
    }
}
