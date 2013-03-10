package team2.sandwichorder.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SummaryPane extends JPanel {

	private JLabel bannerJLabel;
	JButton completeButton;
	JButton backButton;
	JButton homeButton;

	List<String> ingredientsList;
	private TextArea displayArea;
	
	public SummaryPane(ActionListener mainFrameActionListener) {

		setSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(600, 400));
		setMaximumSize(new Dimension(600, 400));
		setPreferredSize(new Dimension(600, 400));
		setBorder(BorderFactory.createEtchedBorder());
		displayArea = new TextArea();
		displayArea.setEditable(false);

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
		bannerJLabel = new JLabel("Is your order summary correct?");

		bc.gridy = 1;
		bc.gridx = 0;

		bc.gridwidth = 2;
		bc.weightx = 2;
		bc.weighty = 1;
		bc.anchor = GridBagConstraints.CENTER;
		this.add(bannerJLabel, bc);
		
		// ///////////////////////////////////////////////

		// adding the displayArea to pane
		bc.gridy = 2;
		bc.gridx = 0;

		bc.gridwidth = 2;
		bc.gridheight = 1;
		bc.insets = new Insets(30, 0, 0, 0);
		bc.anchor = GridBagConstraints.CENTER;

		this.add(new JScrollPane(this.displayArea), bc);
		// ///////////////////////////////////////////////////

		// adding backBreadsButton to pane
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(100, 25));

		bc.gridy = 4;
		bc.gridx = 0;

		bc.gridwidth = 1;
		bc.weighty = 1;
		bc.insets = new Insets(0, 0, 20, 0);
		bc.anchor = GridBagConstraints.CENTER;
		this.add(backButton, bc);
		backButton.addActionListener(mainFrameActionListener);
		// ///////////////////////////////////////////////

		// adding nextBreadsButton to pane
		completeButton = new JButton("Finalize");
		completeButton.setPreferredSize(new Dimension(100, 25));

		bc.gridy = 4;
		bc.gridx = 1;
		bc.insets = new Insets(0, 0, 20, 0);

		bc.gridwidth = 1;
		bc.anchor = GridBagConstraints.CENTER;
		this.add(completeButton, bc);
		completeButton.addActionListener(mainFrameActionListener);

		// ///////////////////////////////////////////////

	}//

	// creates a String Array to add elements from the List<String>
	// ingredientsList to
	public void setDisplayArea(List<String> ingredientsList) {
			for(String ingredient: ingredientsList){
				displayArea.append(ingredient + "\n");
			}//ends for-each
	}// ends setDisplayArea method

    /**
     * Set the display area with the order string
     * @param orderString
     */
    public void setDisplayArea(String orderString) {
            displayArea.append(orderString);

    }//
	public void clearDisplayArea() {
		this.displayArea.setText(null);
	}// ends method clearDisplayArea method

}// ends SummaryPane
