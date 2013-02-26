package team2.sandwichorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

abstract class AbstractPane extends JPanel {
	private JLabel bannerJLabel;
	JButton nextButton;
	JButton backButton;
	JButton homeButton;

	List<String> ingredientsList;
	JList<String> displayIngredientsJList;

	/*
	 * Constructor to be inherited by every Pane which will extend this abstract
	 * class. This will receive a String for the title/banner of the pane. This
	 * will receive an ActionListener which is the MainFrame class it'self
	 * because it implements ActionListener. This will also receive a
	 * Lis<String> with the list of ingredients available to display
	 */
	public AbstractPane(String bannerMessage,
			ActionListener mainFrameActionListener, List<String> ingredientsList) {

		this.setList(ingredientsList);

		this.setLayout(new GridBagLayout());
		GridBagConstraints bc = new GridBagConstraints();

		// adding homeButton to the pane
		homeButton = new JButton("Start Over");
		bc.gridy = 0;
		bc.gridx = 0;
		bc.anchor = GridBagConstraints.FIRST_LINE_START;

		this.add(homeButton, bc);
		homeButton.addActionListener(mainFrameActionListener);

		// adding bannerJLable to the pane
		bannerJLabel = new JLabel("Choose your " + bannerMessage);

		bc.gridy = 1;
		bc.gridx = 0;

		bc.gridwidth = 2;
		bc.weightx = 2;
		bc.weighty = 1;
		bc.anchor = GridBagConstraints.CENTER;
		this.add(bannerJLabel, bc);
		System.out.println(bannerMessage);
		// ///////////////////////////////////////////////

		// adding JList to pane
		bc.gridy = 2;
		bc.gridx = 0;

		bc.gridwidth = 2;
		bc.gridheight = 1;
		bc.insets = new Insets(30, 0, 0, 0);
		bc.anchor = GridBagConstraints.CENTER;

		this.add(new JScrollPane(displayIngredientsJList), bc);
		System.out.println(displayIngredientsJList.getSize());
		// ///////////////////////////////////////////////////

		// adding backBreadsButton to pane
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(100, 25));

		bc.gridy = 4;
		bc.gridx = 0;

		bc.gridwidth = 1;
		bc.weighty = 1;
		bc.insets = new Insets(100, 0, 10, 0);
		bc.anchor = GridBagConstraints.CENTER;
		this.add(backButton, bc);
		backButton.addActionListener(mainFrameActionListener);
		// ///////////////////////////////////////////////

		// adding nextBreadsButton to pane
		nextButton = new JButton("Next");
		nextButton.setPreferredSize(new Dimension(100, 25));

		bc.gridy = 4;
		bc.gridx = 1;
		bc.insets = new Insets(100, 0, 10, 0);

		bc.gridwidth = 1;
		bc.anchor = GridBagConstraints.CENTER;
		this.add(nextButton, bc);
		nextButton.addActionListener(mainFrameActionListener);

		// ///////////////////////////////////////////////

	}// ends BreadsPane constructor

	// creates a String Array to add elements from the List<String>
	// ingredientsList to
	private void setList(List<String> ingredientsList) {

		String[] listDataArray = new String[ingredientsList.size()];
		ingredientsList.toArray(listDataArray);

		displayIngredientsJList = new JList<String>();
		displayIngredientsJList.setListData(listDataArray);
		displayIngredientsJList.setPreferredSize(new Dimension(200, 200));
	};

	public void deselectList() {
		displayIngredientsJList.clearSelection();
	}

	public List<String> getSelections() {
		return this.displayIngredientsJList.getSelectedValuesList();

	}// ends getSelections Method

}// /ends BreadsPane class
