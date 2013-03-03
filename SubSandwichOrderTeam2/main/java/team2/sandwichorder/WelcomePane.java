package team2.sandwichorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WelcomePane extends JPanel {

    JButton signInButton;
	JButton orderAsGuestButton;
	

	public WelcomePane(String bannerMessage, ActionListener mainFrameActionListener) {

		this.setLayout(new GridBagLayout());
		GridBagConstraints bc = new GridBagConstraints();

		// adding bannerJLable to the WelcomePane
        JLabel bannerJLabel;
        bannerJLabel = new JLabel(bannerMessage);

        bc.gridy = 0;
		bc.gridx = 0;
		
		bc.gridwidth = 2;
		bc.weightx = 2;
		bc.weighty = 2;
		bc.anchor = GridBagConstraints.CENTER;
		this.add(bannerJLabel, bc);
		// ///////////////////////////////////////////////

		// adding signInButton to WelcomePane
		signInButton = new JButton("Sign-In");
		signInButton.setEnabled(false);
		signInButton.setPreferredSize(new Dimension(200, 50));

		bc.gridy = 1;
		bc.gridx = 0;

		bc.gridwidth = 1;
		bc.anchor = GridBagConstraints.CENTER;
		this.add(signInButton, bc);
		// ///////////////////////////////////////////////

		// adding orderAsGuestButton to WelcomePane
		orderAsGuestButton = new JButton("Order As Guest");
		orderAsGuestButton.setPreferredSize(new Dimension(200, 50));

		bc.gridy = 1;
		bc.gridx = 1;

		bc.gridwidth = 1;
		bc.weighty = 1;
		bc.anchor = GridBagConstraints.CENTER;
		this.add(orderAsGuestButton, bc);
		// ///////////////////////////////////////////////
		
		///sets the actionListener to the MainFrame which implements ActionListener
		orderAsGuestButton.addActionListener(mainFrameActionListener);		
		

	}// ends WelcomePane Constructor

	
	
	
	
}// ends WelcomePane
