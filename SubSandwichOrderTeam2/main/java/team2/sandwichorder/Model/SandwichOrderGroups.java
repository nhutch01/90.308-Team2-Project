package team2.sandwichorder.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * SandwichOrderGroups class  - running list of sandwich order data (ingredient) groups - represents the sandwich order
 * @author Nicki Hutchens
 * @since 3/24/2013
 */
public class SandwichOrderGroups {
    List<SandwichOrderData> sandwichOrders = new ArrayList<SandwichOrderData> ();
    String customerName;
    BigDecimal grandTotal;
    /**
     * add SandwichOrderData
     * @param sandwichOrderData
     * add sandwich order data to the list
     */
    public void addSandwichOrderData(SandwichOrderData sandwichOrderData){
        this.sandwichOrders.add(sandwichOrderData);
    }

    /**
     * setCustomerName - set the customer name for the entire order
     * @param customerName
     */
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    /**
     * getCustomerName - return the customer name
     * @return String customerName
     */
    public String getCustomerName(){
        return this.customerName;
    }

    /**
     *   getSandwichOrders
     * @return  List of SandwichOrderData
     */
    public List<SandwichOrderData> getSandwichOrders(){
        return sandwichOrders;
    }

    /**
     * setGrandTotalOrderPrice - set the grand total price for all the sandwich ingredients
     * @param grandTotal
     */
    public void setGrandTotalOrderPrice(BigDecimal grandTotal){
        this.grandTotal = grandTotal;
    }

    /**
     * getGrandTotalOrderPrice - return the grand total price of the sandwich
     * @return BigDecimal grandTotal
     */
    public BigDecimal getGrandTotalOrderPrice(){
        return this.grandTotal;
    }

    /**
     * toString - returns the formatted string of the sandwich ingredients by group, the order data, and price of the sandwich
     * @return   String sandwich data
     */
    public String toString(){
        StringBuilder orderString = new StringBuilder();
        List<SandwichOrderData> sandwichOrderData = this.getSandwichOrders();
        if (this.customerName != null)
            orderString.append("Customer Name: " + this.customerName + "\n");
        for (int i=0; i<sandwichOrderData.size();i++){
            SandwichOrderData sandwichOrderInstance = sandwichOrderData.get(i);
            String type = sandwichOrderInstance.getType();
            String name = sandwichOrderInstance.getName();
            if (name != null)
                if (name.equals("Sandwich-type"))
                    orderString.append("Sandwich Type: ");
                else
                    orderString.append("Ingredient Group:  " + name + "\n");
            if (type != null){
                orderString.append("Order Type:  " + type + "\n") ;
                continue;         // order type should only be not null for Menu-items group which is top-level sandwich type
            }
            List<String> choices = sandwichOrderInstance.getChoices();
            for (int j = 0; j < choices.size(); j++)  {
                orderString.append("\t" + choices.get(j) + "\n");
            }
        }
        orderString.append("Total price: $" + this.getGrandTotalOrderPrice().toString());
        return orderString.toString();
    }
}
