package team2.sandwichorder;

public interface WelcomeFrameInterface {
	/*
	 * This pane will show the options so the user may sign in online to retrieve
	 * their sandwiches options.
	 * It will have controls to allow customers to log-in.
	 */
	
	public void orderAsGuest();//will move customer right to the order options
	
	public OrderInterface signIn();//will move the customer to the sign-in screen
	
	
	
}//ends WelcomePaneInterface
