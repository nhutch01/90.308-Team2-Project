package team2.sandwichorder;

import org.junit.Before;
import org.junit.Test;
import team2.sandwichorder.Pricing.PriceItemType;
import team2.sandwichorder.Pricing.PricingJAXBDAO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * PricingJAXBDAOTest
 * @author Nicki Hutchens
 * @since 3/24/2013
 * Tests the Pricing JAXB Data Access Object - reads the XML file and verifies the number of groups
 */
public class PricingJAXBDAOTest {
    private String fileName = ".\\Pricing.xml";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testRetrievePricingData() throws Exception {
        List<PriceItemType> priceItemTypeGroup;
        priceItemTypeGroup = new ArrayList<PriceItemType>();
        try{
            priceItemTypeGroup = PricingJAXBDAO.processXmlFile(fileName);
        }catch (FileNotFoundException e){
            e.toString();
            System.exit(0);
        }
        int groupsSize = priceItemTypeGroup.size();
        assertEquals(20, groupsSize);
    }
}
