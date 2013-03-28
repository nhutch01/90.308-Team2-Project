package team2.sandwichorder.GUI;

import team2.sandwichorder.Ingredients.GroupType;

import java.awt.event.ActionListener;
import java.util.List;

public class MenuItemsPane extends AbstractPane {

	public MenuItemsPane(List<GroupType> ingredientGroup,
			ActionListener mainFrameActionListener, int ArrayListPosition) {
		super(ingredientGroup, mainFrameActionListener, ArrayListPosition);
		this.backButton.setEnabled(false);
	}//ends breadPane Constructor

}//ends breadPane class
