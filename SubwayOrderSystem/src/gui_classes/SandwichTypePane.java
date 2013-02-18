package gui_classes;

import java.awt.event.ActionListener;
import java.util.List;

public class SandwichTypePane extends AbstractPane {

	public SandwichTypePane(String bannerMessage,
			ActionListener mainFrameActionListener, List<String> ingredientsList) {
		super(bannerMessage, mainFrameActionListener, ingredientsList);
		
		this.backButton.setEnabled(false);
		
	}//ends breadPane Constructor

}//ends breadPane class
