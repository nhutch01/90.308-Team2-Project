package team2.sandwichorder.GUI;

import team2.sandwichorder.Model.IngredientGroup;
import team2.sandwichorder.Model.IngredientGroupDAO;
import team2.sandwichorder.Model.SandwichOrderData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame
        implements ActionListener {

	private List<IngredientGroup> ingredientGroup;
    private SandwichOrderData orderData;
	private WelcomePane welcomePane;// pane in which customers will be welcomed
	private AbstractPane menuItemsPane; // order pane for breads customers
	private AbstractPane sandwichTypePane; // order Pane for Toasted or Not
	private AbstractPane breadPane;// order pane to choose the bread
	private AbstractPane cheesePane; // where cheeses will be selected
	private AbstractPane meatPane; // here customers choose meats
	private AbstractPane toppingsPane; // to choose toppings
	private AbstractPane saucesPane; // the sauces choice display
	private SummaryPane selectionSummaryPane; // pane were summary will be
												// displayed
	private List<String> selectedIngredients;// the list of all customer
    private String fileName = ".\\Ingredients.xml" ;

	public MainFrame(String title) {
		super(title);

        // IngredientGroupDAO works

        String tagName = "group";
        ingredientGroup = IngredientGroupDAO.returnAllIngredientGroups(fileName, tagName) ;

		initializeAllPanes();// method declared within this class to initialize
								// all frames

		// method created/declared within this class
		setUpWelcomePane();

		/*
		 * sets the borderLayout and also adds all panes to this MainFrame after
		 * the initializeAllPanes() method has been called and initializes all
		 * the panes
		 */
		this.setLayout(new BorderLayout());
		this.add(welcomePane, BorderLayout.NORTH);
		this.add(menuItemsPane, BorderLayout.NORTH);
		this.add(sandwichTypePane, BorderLayout.NORTH);
		this.add(breadPane, BorderLayout.NORTH);
		this.add(cheesePane, BorderLayout.NORTH);
		this.add(meatPane, BorderLayout.NORTH);
		this.add(toppingsPane, BorderLayout.NORTH);
		this.add(saucesPane, BorderLayout.NORTH);
		this.add(selectionSummaryPane, BorderLayout.NORTH);
		this.setResizable(false);

	}// ends MainFrame constructor

	// /////////////////////////////////////////////////////////////////////
	private void setUpWelcomePane() {

		welcomePane.setSize(new Dimension(600, 400));
		welcomePane.setMinimumSize(new Dimension(600, 400));
		welcomePane.setMaximumSize(new Dimension(600, 400));
		welcomePane.setPreferredSize(new Dimension(600, 400));
		welcomePane.setBorder(BorderFactory.createEtchedBorder());

	}// ends method setUpWelcomePane
		// /////////////////////////////////////////////////////////////////////

	private void setAllPanesVisibleToFalse() {
		welcomePane.setVisible(false);
		menuItemsPane.setVisible(false);
		sandwichTypePane.setVisible(false);
		breadPane.setVisible(false);
		cheesePane.setVisible(false);
		meatPane.setVisible(false);
		toppingsPane.setVisible(false);
		saucesPane.setVisible(false);
		selectionSummaryPane.setVisible(false);

	}// ends setAllPanesVisibleToFalse
		// /////////////////////////////////////////////////////////////////////

	@Override
	/*
	 * actionListener method which will be used to listen to the events coming
	 * from the buttons inside the different panels
	 */
	public void actionPerformed(ActionEvent event) {
		JButton eventButton = (JButton) event.getSource();

		/*
		 * if (eventButton == menuItemsPane.backButton) {
		 * System.out.println("Back from BreadPane");
		 * System.out.println(menuItemsPane.getSize());
		 * setAllPanesVisibleToFalse(); welcomePane.setVisible(true); } else
		 */if (eventButton == welcomePane.orderAsGuestButton) {
			setAllPanesVisibleToFalse();
            orderData = new SandwichOrderData();
            orderData.setGroupName("Guest");
			menuItemsPane.setVisible(true);

		} else if (eventButton == menuItemsPane.nextButton) {
			setAllPanesVisibleToFalse();
			sandwichTypePane.setVisible(true);
		} else if (eventButton == sandwichTypePane.backButton) {
			setAllPanesVisibleToFalse();
			menuItemsPane.setVisible(true);
		} else if (eventButton == sandwichTypePane.nextButton) {
			setAllPanesVisibleToFalse();
			breadPane.setVisible(true);
		} else if (eventButton == breadPane.backButton) {
			setAllPanesVisibleToFalse();
			sandwichTypePane.setVisible(true);
		} else if (eventButton == breadPane.nextButton) {
			setAllPanesVisibleToFalse();
			cheesePane.setVisible(true);
		} else if (eventButton == cheesePane.backButton) {
			setAllPanesVisibleToFalse();
			breadPane.setVisible(true);
		} else if (eventButton == cheesePane.nextButton) {
			setAllPanesVisibleToFalse();
			meatPane.setVisible(true);
		} else if (eventButton == meatPane.backButton) {
			setAllPanesVisibleToFalse();
			cheesePane.setVisible(true);
		} else if (eventButton == meatPane.nextButton) {
			setAllPanesVisibleToFalse();
			toppingsPane.setVisible(true);
		} else if (eventButton == toppingsPane.backButton) {
			setAllPanesVisibleToFalse();
			meatPane.setVisible(true);
		} else if (eventButton == toppingsPane.nextButton) {
			setAllPanesVisibleToFalse();
			saucesPane.setVisible(true);
		} else if (eventButton == saucesPane.backButton) {
			setAllPanesVisibleToFalse();
			toppingsPane.setVisible(true);
		} else if (eventButton == saucesPane.nextButton) {
			runSummary();
			setAllPanesVisibleToFalse();
			selectionSummaryPane.setVisible(true);
		} else if (eventButton == selectionSummaryPane.backButton) {
			setAllPanesVisibleToFalse();
			saucesPane.setVisible(true);
		} else if (eventButton == selectionSummaryPane.completeButton) {
			int answer = JOptionPane.showConfirmDialog(selectionSummaryPane,
					"Are you sure you want to submit?", "Confirm submit",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (answer == 0) {
				JOptionPane
						.showMessageDialog(
								selectionSummaryPane,
								"Your order has been submitted. Thank You for your business!",
								"Order Submitted",
								JOptionPane.INFORMATION_MESSAGE);

				startOver();
			}// ends if-statment for JOptionPane question

		} else if (eventButton.getText().equalsIgnoreCase("Start Over")) {
			startOver();
		}// ends if-else statements
	}// ends ActionPerformed method

	private void startOver() {
		// sets the selection of the panes to false
		menuItemsPane.deselectList();
		sandwichTypePane.deselectList();
		breadPane.deselectList();
		cheesePane.deselectList();
		meatPane.deselectList();
		toppingsPane.deselectList();
		saucesPane.deselectList();
		selectionSummaryPane.clearDisplayArea();

		this.setAllPanesVisibleToFalse();
		// first pane to be seen therefore
		// setVisible from start
		welcomePane.setVisible(true);

	}

    /**
     * @author Nicki Hutchens
     * @since 3/10/2013
     * Changes the runSummary Method to use the SandwichOrderData object to build the sandwich order
     * information.  Use the toString method of SandwichOrderData to output the summary of the order.
     */
	private void runSummary() {

		selectedIngredients = new ArrayList<String>();
		//this.menuItemsPane.displayIngredientsJList.getSelectedValuesList();

        // The menu item indicates the type of sandwich
        orderData.setGroupType(this.menuItemsPane.displayIngredientsJList.getSelectedValue());

		// selectedIngredients.addAll(this.menuItemsPane.displayIngredientsJList.getSelectedValuesList());

        // sandwich type such as toasted, non-toasted
        orderData.addAllChoices(this.sandwichTypePane.displayIngredientsJList.getSelectedValuesList());

		//selectedIngredients.addAll(this.sandwichTypePane.displayIngredientsJList.getSelectedValuesList());
        orderData.addAllChoices(this.breadPane.displayIngredientsJList.getSelectedValuesList());
		//selectedIngredients.addAll(this.breadPane.displayIngredientsJList.getSelectedValuesList());
		orderData.addAllChoices(this.cheesePane.displayIngredientsJList.getSelectedValuesList());
        //selectedIngredients.addAll(this.cheesePane.displayIngredientsJList.getSelectedValuesList());
        orderData.addAllChoices(this.toppingsPane.displayIngredientsJList.getSelectedValuesList());
		//selectedIngredients.addAll(this.toppingsPane.displayIngredientsJList.getSelectedValuesList());
        orderData.addAllChoices(this.saucesPane.displayIngredientsJList.getSelectedValuesList());
		//selectedIngredients.addAll(this.saucesPane.displayIngredientsJList.getSelectedValuesList());

		//selectionSummaryPane.setDisplayArea(this.selectedIngredients);
        selectionSummaryPane.setDisplayArea(orderData.toString());
	}// ends runSummary method

	/*
	 * used to initialize all panes, and also to reset all their values
	 * selections to zero when customer presses the start-over button
	 */
	private void initializeAllPanes() {

		welcomePane = new WelcomePane("Welcome to Subway!", this);
		menuItemsPane = new MenuItemsPane(ingredientGroup, this, 0);
		sandwichTypePane = new SandwichTypePane(ingredientGroup, this, 1);
		breadPane = new BreadPane(ingredientGroup, this, 2);
		cheesePane = new CheesePane(ingredientGroup, this, 3);
		meatPane = new MeatPane(ingredientGroup, this, 4);
		toppingsPane = new ToppingsPane(ingredientGroup, this, 5);
		saucesPane = new SaucesPane(ingredientGroup, this, 6);
		selectionSummaryPane = new SummaryPane(this);
		setAllPanesVisibleToFalse();

		// first pane to be seen therefore
		// setVisible from start
		welcomePane.setVisible(true);
	}// ends initializedAllPanes

}// Ends MainFrame Class
