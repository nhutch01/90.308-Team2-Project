package team2.sandwichorder;

public interface controllerInterface {
	/*
	 * This will be implemented by a class which will receive the login
	 * information from the customer and request for their saved subway
	 * preferences
	 */

	public void saveOrder(String userName, String password, OrderInterface order);

	public OrderInterface signIn(String userName, String password);
	
	
	
}//ends controllerInteface
