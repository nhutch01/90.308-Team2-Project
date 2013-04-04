package team2.sandwichorder.GUI;

import team2.sandwichorder.BusinessLogic.CalculateSandwichOrderPrice;
import team2.sandwichorder.BusinessLogic.ItemPriceMap;
import team2.sandwichorder.Ingredients.GroupType;
import team2.sandwichorder.Ingredients.IngredientGroupJAXBDAO;
import team2.sandwichorder.Model.*;
import team2.sandwichorder.Pricing.PriceItemType;
import team2.sandwichorder.Pricing.PricingJAXBDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class MainFrame extends JFrame
        implements ActionListener {

	private List<GroupType> ingredientGroup;
    private List<PriceItemType> priceItemTypeGroup;
    private ItemPriceMap itemPriceMap;
    private SandwichOrderData orderData;
    private SandwichOrderGroups orderDataGroups;
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
    private String fileName = ".\\Ingredients.xml" ;

	public MainFrame(String title) {
		super(title);
        // read the ingredients from the Ingredients xml using the ingredient group JAXB DAO - data access object
        try{
            ingredientGroup = IngredientGroupJAXBDAO.processXmlFile(fileName);
        }catch (FileNotFoundException e){
            e.toString();
            System.exit(0);
        }

        // then read the pricing from the Pricing xml using the pricing JAXB DAO
        fileName = ".\\Pricing.xml" ;
        try{
            priceItemTypeGroup = PricingJAXBDAO.processXmlFile(fileName);
        }catch (FileNotFoundException e){
            e.toString();
            System.exit(0);
        }

        // create the item price map to be used for total
        itemPriceMap = new ItemPriceMap(priceItemTypeGroup);

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

        if (eventButton == welcomePane.orderAsGuestButton) {
			setAllPanesVisibleToFalse();
            orderDataGroups = new SandwichOrderGroups();
            orderDataGroups.setCustomerName("Guest");
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
            int answer = JOptionPane.showConfirmDialog(selectionSummaryPane,
                    "Selecting the Back Button from the Summary Screen will clear your order.", "Do you want to proceed?",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (answer == 0) {
                setAllPanesVisibleToFalse();
			    saucesPane.setVisible(true);
                startOver();
            }
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
        this.clearOrder();
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
        orderData = new SandwichOrderData();
        // Get the selected, calculate the price, and  display the summary
        orderData.setType((String) this.menuItemsPane.displayIngredientsJList.getSelectedValue());
        orderData.addAllChoices(this.menuItemsPane.getSelections());
        orderDataGroups.addSandwichOrderData(orderData);

        orderData = new SandwichOrderData();
        orderData.setName(this.sandwichTypePane.currentGroup.getName());
        orderData.addAllChoices(this.sandwichTypePane.getSelections());
        orderDataGroups.addSandwichOrderData(orderData);

        orderData = new SandwichOrderData();
        orderData.setName(this.breadPane.currentGroup.getName());
        orderData.addAllChoices(this.breadPane.getSelections());
        orderDataGroups.addSandwichOrderData(orderData);

        orderData = new SandwichOrderData();
        orderData.setName(this.cheesePane.currentGroup.getName());
		orderData.addAllChoices(this.cheesePane.getSelections());
        orderDataGroups.addSandwichOrderData(orderData);

        orderData = new SandwichOrderData();
        orderData.setName(meatPane.currentGroup.getName());
        orderData.addAllChoices(this.meatPane.getSelections());
        orderDataGroups.addSandwichOrderData(orderData);

        orderData = new SandwichOrderData();
        orderData.setName(toppingsPane.currentGroup.getName());
        orderData.addAllChoices(this.toppingsPane.getSelections());
        orderDataGroups.addSandwichOrderData(orderData);

        orderData = new SandwichOrderData();
        orderData.setName(saucesPane.currentGroup.getName());
        orderData.addAllChoices(this.saucesPane.getSelections());
        orderDataGroups.addSandwichOrderData(orderData);

        // calculate the total price
        CalculateSandwichOrderPrice calculatePrice = new CalculateSandwichOrderPrice(orderDataGroups,itemPriceMap);
        BigDecimal totalOrderPrice =  calculatePrice.calculateTotalOrderPrice();
        orderDataGroups.setGrandTotalOrderPrice(totalOrderPrice);
        selectionSummaryPane.setDisplayArea(orderDataGroups.toString());
	}// ends runSummary method

    /**
     * clearOrder - clear the order data - used when starting over or when back button is selected from summary screen
     * @author Nicki Hutchens
     * @since 4/3/2013
     */
    private void clearOrder(){
       orderDataGroups = new SandwichOrderGroups();
    }
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
