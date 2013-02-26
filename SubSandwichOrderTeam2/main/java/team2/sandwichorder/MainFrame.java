package team2.sandwichorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class MainFrame extends JFrame implements MainFrameInterface,
		ActionListener {

	private WelcomePane welcomePane;// pane in which customers will be welcomed
	private AbstractPane menuItemsPane; // order pane for breads customers

	public MainFrame(String title) {
		super(title);

		initializeAllPanes();// method declared in this class

		// method created in this file
		setUpWelcomePane();

		this.setLayout(new BorderLayout());
		this.add(welcomePane, BorderLayout.NORTH);
		this.add(menuItemsPane, BorderLayout.NORTH);
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

	private void setUpSanwhichTypePane() {

		menuItemsPane.setSize(new Dimension(600, 400));
		menuItemsPane.setMinimumSize(new Dimension(600, 400));
		menuItemsPane.setMaximumSize(new Dimension(600, 400));
		menuItemsPane.setPreferredSize(new Dimension(600, 400));
		menuItemsPane.setBorder(BorderFactory.createEtchedBorder());

	}// ends setUpSandwhichTypePane method
		// /////////////////////////////////////////////////////////////////////

	private void setAllPanesVisibleToFalse() {
		welcomePane.setVisible(false);
		menuItemsPane.setVisible(false);

	}// ends setAllPanesVisibleToFalse
		// /////////////////////////////////////////////////////////////////////

	@Override
	/*
	 * actionListener method which will be used to listen to the events coming
	 * from the buttons inside the different panels
	 */
	public void actionPerformed(ActionEvent event) {
		JButton eventButton = (JButton) event.getSource();

		System.out.println(eventButton);

		if (eventButton == menuItemsPane.backButton) {
			System.out.println("Back from BreadPane");
			System.out.println(menuItemsPane.getSize());
			setAllPanesVisibleToFalse();
			welcomePane.setVisible(true);
		} else if (eventButton == menuItemsPane.nextButton) {
			System.out.println("Next");
			setAllPanesVisibleToFalse();
			// .setVisible(true);

		} else if (eventButton == welcomePane.orderAsGuestButton) {
			System.out.println("Next from WelcomePane");
			setAllPanesVisibleToFalse();
			menuItemsPane.setVisible(true);

		} else if (eventButton.getText().equalsIgnoreCase("Start Over")) {
			System.out.println("From Start Over");

			// sets the selection of the pane to false
			menuItemsPane.deselectList();

			this.setAllPanesVisibleToFalse();
			// first pane to be seen therefore
			// setVisible from start
			welcomePane.setVisible(true);

		}// ends if-else statements
	}//ends ActionPerformed method

	/*
	 * used to initialize all panes, and also to reset all their values
	 * selections to zero when customer presses the start-over button
	 */
	private void initializeAllPanes() {

		List<String> breadList = Arrays.asList("Foot-Long", "6-Inch", "Mini",
				"Salad");
		menuItemsPane = new SandwichTypePane("Sandwhich-Type", this, breadList);
		welcomePane = new WelcomePane("Welcome to Subway!", this);

		setAllPanesVisibleToFalse();
		// first pane to be seen therefore
		// setVisible from start
		welcomePane.setVisible(true);
	}// ends initializedAllPanes

}// Ends MainFrame Class
