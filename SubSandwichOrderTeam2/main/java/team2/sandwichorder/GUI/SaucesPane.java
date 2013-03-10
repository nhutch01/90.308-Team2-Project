package team2.sandwichorder.GUI;

import team2.sandwichorder.Model.IngredientGroup;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SaucesPane extends AbstractPane {

	public SaucesPane(List<IngredientGroup> ingredientGroup,
			ActionListener mainFrameActionListener, int ArrayListPosition) {
		super(ingredientGroup, mainFrameActionListener, ArrayListPosition);
		// TODO Auto-generated constructor stub
	
		this.nextButton.setText("Finish Selections");
		this.nextButton.setSize(new Dimension(100,100));
		this.nextButton.setPreferredSize(new Dimension(150, 25));
	}//ends SaucesPane constructor
	

}//ends SaucesPane
