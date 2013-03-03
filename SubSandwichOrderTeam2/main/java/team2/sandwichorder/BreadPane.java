package team2.sandwichorder;

import java.awt.event.ActionListener;
import java.util.List;

import team2.sandwichorder.IngredientGroup;

public class BreadPane extends AbstractPane {

	public BreadPane(List<IngredientGroup> ingredientGroup,
			ActionListener mainFrameActionListener, int ArrayListPosition) {

		super(ingredientGroup, mainFrameActionListener, ArrayListPosition);
	}//ends BreadPane constructor
}//ends BreadPane Class
