package team2.sandwichorder.GUI;

import team2.sandwichorder.Ingredients.GroupType;

import java.awt.event.ActionListener;
import java.util.List;

public class ToppingsPane extends AbstractPane {

	public ToppingsPane(List<GroupType> ingredientGroup,
			ActionListener mainFrameActionListener, int ArrayListPosition) {
		super(ingredientGroup, mainFrameActionListener, ArrayListPosition);
	}

}
