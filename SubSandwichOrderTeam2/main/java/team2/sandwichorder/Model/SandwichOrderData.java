package team2.sandwichorder.Model;

import java.util.List;

/**
 * @author Nicki Hutchens
 * @since 3/10/13
 * Class that represents a sandwich order
 * Sandwich order inherits from Ingredient Group and uses the members provided by the
 * IngredientGroup class to describe a Sandwich Order.
 * The name (group name) element of the parent class is the name of the Order, such as the customer name
 * The type (group type) element of the parent class is the type of sandwich selected from the Menu-item group
 * The choices array list is the list of ingredients chosen by the customer
 * The new element for this class is the total price which is the total price for the order which is
 *   calculated during order selection process
 */
public class SandwichOrderData extends IngredientGroup{
   private double totalPrice;

    public SandwichOrderData(){
        super();
        totalPrice = 0.00;
    }

    /**
     * setTotalPrice
     * Set the total price for the order
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    /**
     * getTotalPrice
     * Return the total Price for the Order
     * @return
     */
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * toString
     * Return a string representation of the order data in the format desired for the order summary
     * @return
     */
    public String toString(){
        StringBuilder orderString = new StringBuilder();
        orderString.append("Order Name: " + this.getGroupName() + "\n");
        orderString.append("Order Type: " + this.getGroupType() + "\n") ;
        orderString.append("Ingredients: \n");
        List<String> choices = this.getChoices();
        for (int i = 0; i < choices.size(); i++)  {
            orderString.append(String.valueOf(i+1) + ":  " + choices.get(i) + "\n");
        }

        orderString.append("Total price: $" + this.getTotalPrice());
        return orderString.toString();
    }
}
