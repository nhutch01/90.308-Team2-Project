package team2.sandwichorder;

import java.util.ArrayList;

import team2.sandwichorder.IngredientGroup;

/*This class is a temporary simulation of what the IngredientGroupDAO should do.*/

public class IngredientGroupReturner {
	static ArrayList<IngredientGroup> ingredientGroups;
	static private IngredientGroup menuItems;
	static private IngredientGroup sandwichType;
	static private IngredientGroup bread;
	static private IngredientGroup cheese;
	static private IngredientGroup meats;
	static private IngredientGroup toppings;
	static private IngredientGroup sauces;

	public static ArrayList<IngredientGroup> getIngredientGroups() {

		ingredientGroups = new ArrayList<IngredientGroup>();
		
		// adding menuItems to the ingredientGroups ArrayList
		menuItems = new IngredientGroup();
		setUpMenuItems();
		ingredientGroups.add(menuItems);

		// adding sandwhichType to the ingredientGroups ArrayList
		sandwichType = new IngredientGroup();
		setUpSandwhichType();
		ingredientGroups.add(sandwichType);	
		
		bread = new IngredientGroup();
		setUpBread();
		ingredientGroups.add(bread);

		cheese = new IngredientGroup();
		setUpCheese();
		ingredientGroups.add(cheese);
		
		meats = new IngredientGroup();
		setUpMeats();
		ingredientGroups.add(meats);
		
		toppings = new IngredientGroup();
		setUpToppings();
		ingredientGroups.add(toppings);
		
		sauces = new IngredientGroup();
		setUpSauces();
		ingredientGroups.add(sauces);
		
		return ingredientGroups;
	}

	private static void setUpSauces() {
		sauces.setGroupName("Sauces");
		sauces.setGroupType("multi-select");
		sauces.addChoice("Yellow Mustard");
		sauces.addChoice("Brown Mustard");
		sauces.addChoice("Honey Mustard");
		sauces.addChoice("Sweet Onion");
		sauces.addChoice("Red Wine Vinegar");
		
	}

	private static void setUpToppings() {
		toppings.setGroupName("Toppings");
		toppings.setGroupType("multi-select");
		toppings.addChoice("Lettuce");
		toppings.addChoice("Tomatoes");
		toppings.addChoice("Cucumbers");
		toppings.addChoice("Green Peppers");
		toppings.addChoice("Spinach");
		toppings.addChoice("Onions");
		toppings.addChoice("Pickles");		
	}

	private static void setUpMeats() {
		meats.setGroupName("Meats");
		meats.setGroupType("multi-select");
		meats.addChoice("Turkey");
		meats.addChoice("Black Forest Ham");
		meats.addChoice("Sliced Chicken");
		meats.addChoice("Grilled Chicken");
		meats.addChoice("Buffalo Chicken");
		meats.addChoice("Teriyaki Chicken");
		meats.addChoice("Steak");
		
	}

	private static void setUpCheese() {
		cheese.setGroupName("Cheese");
		cheese.setGroupType("single-select");
		cheese.addChoice("American");
		cheese.addChoice("Provolone");
		cheese.addChoice("Pepper Jack");
		cheese.addChoice("Cheddar");
		
	}

	private static void setUpSandwhichType() {
		sandwichType.setGroupName("Sandwhich-Type");
		sandwichType.setGroupType("single-select");
		sandwichType.addChoice("Toasted");
		sandwichType.addChoice("Non-Toasted");
	}// ends setUpSandwhichType

	private static void setUpMenuItems() {
		menuItems.setGroupName("Menu-Items");
		menuItems.setGroupType("single-select");
		menuItems.addChoice("Footlong");
		menuItems.addChoice("6-inch");
		menuItems.addChoice("Mini");
		menuItems.addChoice("Salad");
	}// ends setUpMenuItems
	

	private static void setUpBread() {
		bread.setGroupName("Bread");
		bread.setGroupType("single-select");
		bread.addChoice("Italian White");
		bread.addChoice("Wheat");
		bread.addChoice("Honey Oat");
		bread.addChoice("Italian Herbs and Cheese");
	}// ends setUpMenuItems

	/*public static void main(String[] args){
		
		if(getIngredientGroups() == null)
		System.out.println("This is null");
		else{
			System.out.println("It's not null");
		}
		
	}
	*/
}//ends IngredientGroupReturner Class
