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
 *   groupType   // single-select or multi-select; Single-select means only one selection from the group of ingredients can be made by the user; multi-select means
 *   multiple selections from the group of ingredients can be made by the user.
 *   groupName  // name of ingredient group such as Bread-type, Cheese, Meats, etc.
 *   choices  // list of available ingredients in the group
 */

public class IngredientGroup {
    private String groupType = null;  // single-select or multi-select
    private String groupName = null;  // name of ingredient group such as Bread-type, Cheese, Meats, etc.
    private ArrayList<String> choices = null;  // list of ingredients

    public IngredientGroup (){
        this.groupType = null;
        this.groupName = null;
        this.choices = new ArrayList<String>();

    }

    /**
     * setGroupType
     *   Sets the Group Type of the ingredients group (single-select or multi-select)
     * @param groupType
     */
    public void setGroupType(String groupType){
        this.groupType = groupType;
    }

    /**
     * setGroupName
     * Sets the name of the ingredient Group such as Bread-type, Meats, Cheese, etc.
     * @param groupName
     */
    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    /**
     * addChoice
     * Adds a single string value choice for the Ingredient Group to the ArrayList of choices
     * @param choice
     */
    public void addChoice(String choice){
        this.choices.add(choice);
    }

    /**
     * addAllChoices
     * Adds a list of string value choices to the ArrayList of choices
     * @param allChoices
     */
    public void addAllChoices(List<String> allChoices){
        this.choices.addAll(allChoices);
    }
    /**
     * getGroupType
     * Returns the Group Type for the ingredient group
     * @return  String groupType
     */
    public String getGroupType(){
        return this.groupType;
    }

    /**
     * getGroupName
     * Returns the Group Name of the ingredient group
     * @return  String groupName
     */
    public String getGroupName(){
        return this.groupName;
    }

    /**
     * getChoices
     *  Returns the ArrayList of choices for the ingredient group
     * @return ArrayList choices
     */
    public ArrayList<String> getChoices(){
        return this.choices;
    }
}
