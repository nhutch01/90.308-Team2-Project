package team2.sandwichorder.GUI;

import javax.swing.*;
import java.awt.*;

public class SandwichOrder {
	
	
	public static void main(String[] args){
		
	MainFrame myFrame = new MainFrame("Subway Order System");
	
	myFrame.setLocation(350,200);
	myFrame.setVisible(true);
	myFrame.setSize(new Dimension(600,400));
	myFrame.setMinimumSize(new Dimension(600,400));
	myFrame.setMaximumSize(new Dimension(600,400));
	myFrame.setPreferredSize(new Dimension(600,400));
	myFrame.setAlwaysOnTop(true);
	myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	
	}//ends method main

}
