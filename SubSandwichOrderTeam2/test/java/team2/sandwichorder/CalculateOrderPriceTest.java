package team2.sandwichorder;

import team2.sandwichorder.BusinessLogic.CalculateSandwichOrderPrice;
import team2.sandwichorder.BusinessLogic.ItemPriceMap;
import team2.sandwichorder.Model.SandwichOrderData;
import team2.sandwichorder.Model.SandwichOrderGroups;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static junit.framework.Assert.assertEquals;

/**
 * CalculateOrderPriceTest
 * @author Nicki Hutchens
 * test the CalculateSandwichOrderPrice class
 */
public class CalculateOrderPriceTest {
    ItemPriceMap itemPriceMap = new ItemPriceMap();
    SandwichOrderData sandwichOrderData = new SandwichOrderData();
    SandwichOrderGroups sandwichOrderGroups = new SandwichOrderGroups();

    @org.junit.Before
    public void setUp() throws Exception {
        itemPriceMap.addItemPrice("Foot-long", new BigDecimal(5.00));
        itemPriceMap.addItemPrice("6-inch", new BigDecimal(3.00));
        itemPriceMap.addItemPrice("Mini", new BigDecimal(2.00));
        itemPriceMap.addItemPrice("Roast Beef", new BigDecimal(0.35));
        itemPriceMap.addItemPrice("Bologna", new BigDecimal(0.10));
        itemPriceMap.addItemPrice("Pepperoni", new BigDecimal(0.10));
        itemPriceMap.addItemPrice("Salami", new BigDecimal(0.10));
        itemPriceMap.addItemPrice("Turkey", new BigDecimal(0.25));
        itemPriceMap.addItemPrice("Grilled Chicken", new BigDecimal(0.35));

        sandwichOrderData.addChoice("Foot-long");             // + 5.00
        sandwichOrderData.setType("Foot-long");
        sandwichOrderGroups.addSandwichOrderData(sandwichOrderData);

        sandwichOrderData = new SandwichOrderData();
        sandwichOrderData.setName("Meats");
        sandwichOrderData.addChoice("Roast Beef");        // +0.35
        sandwichOrderData.addChoice("Bologna") ;          // +0.10
        sandwichOrderData.addChoice("Salami");           //  +0.10
        sandwichOrderGroups.addSandwichOrderData(sandwichOrderData);
    }

    @org.junit.Test
    public void testCalculateOrderPrice()throws Exception{
        CalculateSandwichOrderPrice calculateOrderPrice = new CalculateSandwichOrderPrice(sandwichOrderGroups, itemPriceMap);
        BigDecimal price = calculateOrderPrice.calculateTotalOrderPrice().round(new MathContext(2, RoundingMode.FLOOR));
        BigDecimal expectedPrice = new BigDecimal(5.55).round(new MathContext(2, RoundingMode.FLOOR));
        assertEquals(expectedPrice,price);
    }


    @org.junit.After
    public void tearDown() throws Exception {

    }
}
