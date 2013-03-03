package team2.sandwichorder;

import java.awt.event.ActionListener;
import java.util.List;

import team2.sandwichorder.IngredientGroup;

public class MenuItemsPane extends AbstractPane {

	public MenuItemsPane(List<IngredientGroup> ingredientGroup,
			ActionListener mainFrameActionListener, int ArrayListPosition) {
		
		super(ingredientGroup, mainFrameActionListener, ArrayListPosition);
		this.backButton.setEnabled(false);
	}//ends breadPane Constructor

}//ends breadPane class
