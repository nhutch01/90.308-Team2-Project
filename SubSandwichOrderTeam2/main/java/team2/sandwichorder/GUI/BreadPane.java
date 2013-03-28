package team2.sandwichorder.GUI;

import team2.sandwichorder.Ingredients.GroupType;

import java.awt.event.ActionListener;
import java.util.List;

public class BreadPane extends AbstractPane {

	public BreadPane(List<GroupType> ingredientGroup,
			ActionListener mainFrameActionListener, int ArrayListPosition) {
		super(ingredientGroup, mainFrameActionListener, ArrayListPosition);
	}//ends BreadPane constructor
}//ends BreadPane Class
