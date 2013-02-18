package gui_interfaces;

public interface ScreenPanel {

	
	/*
	 * This the implementing class will extend JPanel and be added to MainFrame and have a private
	 * JTextArea used to display a list of the selected
	 * ingredients by the customer it will create
	 */

	public void addText();//adds to the list of current chosen ingredients
	
	public void refreshText();//updates the list of current chose ingredients
	
}// ends interface
