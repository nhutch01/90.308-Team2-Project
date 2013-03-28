package team2.sandwichorder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import team2.sandwichorder.Model.SandwichOrderData;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.Assert.assertEquals;
/**
 * @author: Nicki Hutchens
 * @since: 3/10/13
 * JUnit Test for SandwichOrderData class
 */

public class SandwichOrderDataTest {

    private SandwichOrderData sandwichOrder = new SandwichOrderData();

    @Before
    public void setUp() throws Exception {
        sandwichOrder.setName("Nicki's Order");
        sandwichOrder.setType("Foot Long");
        BigDecimal totalPrice = new BigDecimal(7.95)   ;
        sandwichOrder.setTotalOrderPrice(totalPrice);
        sandwichOrder.addChoice("Toasted");
        sandwichOrder.addChoice("Wheat");
        sandwichOrder.addChoice("American");
        sandwichOrder.addChoice("Turkey");
        sandwichOrder.addChoice("Lettuce");
        sandwichOrder.addChoice("Tomatoes");
        sandwichOrder.addChoice("Brown Mustard");
    }

    @Test
    /**
     * Tests getters and setters of the SandwichOrderData class
     */
    public void testSandwichOrderData() throws Exception {
        String choice;
        assertEquals("Nicki's Order", sandwichOrder.getName());
        assertEquals("Foot Long", sandwichOrder.getType());
        BigDecimal totalPrice = new BigDecimal(7.95);
        assertEquals(totalPrice, sandwichOrder.getTotalPrice());
        List<String> choices = sandwichOrder.getChoices();
        for (int i = 0; i < choices.size(); i++)  {

            if (i+1 == 1){
                choice = choices.get(i);
                assertEquals("Toasted",choice );
            }
            if (i+1 == 2){
                choice = choices.get(i);
                assertEquals("Wheat",choice );
            }
            if (i+1 == 3){
                choice = choices.get(i);
                assertEquals("American",choice );
            }
            if (i+1 == 4){
                choice = choices.get(i);
                assertEquals("Turkey",choice );
            }
            if (i+1 == 5){
                choice = choices.get(i);
                assertEquals("Lettuce",choice );
            }
            if (i+1 == 6){
                choice = choices.get(i);
                assertEquals("Tomatoes",choice );
            }
            if (i+1 == 7){
                choice = choices.get(i);
                assertEquals("Brown Mustard",choice );
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        sandwichOrder = null;
    }
}

