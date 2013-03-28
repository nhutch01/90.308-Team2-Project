package team2.sandwichorder;

import team2.sandwichorder.BusinessLogic.ItemPriceMap;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * ItemPriceMapTest
 * @author Nicki Hutchens
 * test the ItemPriceMap class
 */
public class ItemPriceMapTest {
    ItemPriceMap itemPriceMap = new ItemPriceMap();

    @org.junit.Before
    public void setUp() throws Exception {
        itemPriceMap.addItemPrice("Foot-long", new BigDecimal(5.00));
        itemPriceMap.addItemPrice("6-inch", new BigDecimal(3.00));
        itemPriceMap.addItemPrice("Mini", new BigDecimal(2.00));
        itemPriceMap.addItemPrice("Salad", new BigDecimal(3.00));
    }

    @org.junit.Test
    public void testItemPriceMap()throws Exception{
        BigDecimal price = itemPriceMap.getPrice("Foot-long") ;
        BigDecimal expectedPrice = new BigDecimal(5.00);
        assertEquals(expectedPrice, price);

        price = itemPriceMap.getPrice("6-inch") ;
        expectedPrice = new BigDecimal(3.00);
        assertEquals(expectedPrice, price);

        price = itemPriceMap.getPrice("Mini") ;
        expectedPrice = new BigDecimal(2.00);
        assertEquals(expectedPrice, price);

        price = itemPriceMap.getPrice("Salad") ;
        expectedPrice = new BigDecimal(3.00);
        assertEquals(expectedPrice, price);

        List<String> keys = itemPriceMap.getAllKeyValues();

        for (int i=0; i<keys.size();i++) {
            String keyValue = keys.get(i);
            if ((i+1) == 1)
                assertEquals("Salad", keyValue);
            else if ((i+1) == 2)
                assertEquals("6-inch", keyValue);
            else if ((i+1) == 3)
                assertEquals("Mini", keyValue);
            else if ((i+1) == 4)
                assertEquals("Foot-long", keyValue);
        }

    }


    @org.junit.After
    public void tearDown() throws Exception {

    }
}
