package team2.sandwichorder.GUI;

import team2.sandwichorder.Model.IngredientGroup;

import java.awt.event.ActionListener;
import java.util.List;

public class SandwichTypePane extends AbstractPane {

	public SandwichTypePane(List<IngredientGroup> ingredientGroup,
			ActionListener mainFrameActionListener, int ArrayListPosition) {

		super(ingredientGroup, mainFrameActionListener, ArrayListPosition);
}

}// ends SandwichTyePane class
