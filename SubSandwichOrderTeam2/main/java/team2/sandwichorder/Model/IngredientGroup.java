package team2.sandwichorder.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicki Hutchens
 * @since 2/17/13
 * IngredientGroup:
 * Class that represents a group of Ingredients for Subway Sandwich order system
 *   that will be displayed as choices on the GUI
 *   An IngredientGroup object includes:
 *   type   // single-select or multi-select; Single-select means only one selection from the group of ingredients can be made by the user; multi-select means
 *   multiple selections from the group of ingredients can be made by the user.
 *   name  // name of ingredient group such as Bread-type, Cheese, Meats, etc.
 *   choices  // list of available ingredients in the group
 */

public class IngredientGroup {
    private ArrayList<String> choices;
    private String name;
    private String type;


    public IngredientGroup (){
        this.type = null;
        this.name = null;
        this.choices = new ArrayList<String>();

    }

    /**
     * addAllChoices
     * @param choices
     */
    public void addAllChoices(List<String> choices) {
        this.choices.addAll(choices);
    }

    public void addChoice(String choice){
        this.choices.add(choice);
    }
    /**
     * getChoices
     * @return  ArrayList of choices objects
     */
    public ArrayList<String> getChoices() {
        return this.choices;
    }

    /**
     * setGroupType
     *   Sets the Group Type of the ingredients group (single-select or multi-select)
     * @param type
     */
    public void setType(String type){
        this.type = type;
    }


    /**
     * getType
     * @return type - group type
     */
    public String getType(){
        return this.type;
    }


    /**
     * setGroupName
     * Sets the name of the ingredient Group such as Bread-type, Meats, Cheese, etc.
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * getGroupName
     * Returns the Group Name of the ingredient group
     * @return  String groupName
     */
    public String getName(){
        return this.name;
    }
}
