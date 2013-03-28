package team2.sandwichorder.BusinessLogic;

import team2.sandwichorder.Model.SandwichOrderData;
import team2.sandwichorder.Model.SandwichOrderGroups;

import java.math.BigDecimal;
import java.util.List;

/**
 * CalculateSandwichOrderPrice
 * @author Nicki Hutchens
 * Class to calculate the sandwich order price based on the SandwichOrderData object and the price map
 */
public class CalculateSandwichOrderPrice {
    SandwichOrderGroups orderDataGroups = new SandwichOrderGroups();
    ItemPriceMap itemPriceMap = new ItemPriceMap();

    /**
     * Calculate SandwichOrderPrice constructor
     * @param orderDataGroups
     * @param itemPriceMap
     * uses the order data and the price map passed into the constructor to calculate the order price
     */
    public CalculateSandwichOrderPrice(SandwichOrderGroups orderDataGroups, ItemPriceMap itemPriceMap){
        this.orderDataGroups = orderDataGroups;
        this.itemPriceMap = itemPriceMap;
    }

    /**
     * calculateTotalOrderPrice
     * @return  BigDecimal total price for the order
     * calculate the order total price by getting the price data from the hash map based on the item name
     */
    public BigDecimal calculateTotalOrderPrice(){
        List<SandwichOrderData> orderDataGroupsLocal = this.orderDataGroups.getSandwichOrders();
        BigDecimal grandTotal = new BigDecimal(0.0);
        // for each group in the list, calculate the total
        for (int i=0; i<orderDataGroupsLocal.size();i++){
            SandwichOrderData orderData = orderDataGroupsLocal.get(i);

            List<String> choiceNames = orderData.getChoices();
            BigDecimal total = new BigDecimal(0.0);
            for(int j=0; j < choiceNames.size(); j++){
                String name = choiceNames.get(j);
                BigDecimal price;
                if (itemPriceMap.getPrice(name) != null){
                    price = (BigDecimal)(itemPriceMap.getPrice(name));
                    total = total.add(price);
                }
            }
            orderData.setTotalOrderPrice(total);
            grandTotal = grandTotal.add(total);
        }
        return grandTotal;
    }

}
