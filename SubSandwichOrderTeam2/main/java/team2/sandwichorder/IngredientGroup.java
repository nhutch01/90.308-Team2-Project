package team2.sandwichorder;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Nicki
 * Date: 2/17/13
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 * Class that represents a group of Ingredients for Subway Sandwich order system
 *   that will be displayed as choices on the GUI
 *   groupType   // single-select or multi-select; Single-select means only one selection from the group of ingredients can be made by the user; multi-select means
 *     multiple selections from the group of ingredients can be made by the user.
 *   groupName  // name of ingredient group such as Bread-type, Cheese, Meats, etc.
 *   choices  // list of ingredients
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

    public void setGroupType(String groupType){
        this.groupType = groupType;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public void addChoice(String choice){
        this.choices.add(choice);
    }

    public String getGroupType(){
        return this.groupType;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public ArrayList<String> getChoices(){
        return this.choices;
    }
}
