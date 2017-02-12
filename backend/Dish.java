package backend;

import testing.myLogger;
import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class dish.
 * A dish is food composed by more foods
 * @author rguimerao
 *
 */
public class Dish extends Food {

    private Recipe recipe;
    protected ArrayList<Food> composedFoods;

    /**
     * Constructor of dish
     * @param name name of the dish
     * @param category category of the dish
     * @param forSell is this dish for sell?
     * @param price price of the dish
     * @param creator creator of the dish
     * @throws SQLException 
     */
    public Dish(
            final String name, 
            final Category category, 
            final boolean forSell, 
            final float price, 
            final FoodCreator creator) throws SQLException {

        super(name, category, forSell, price, creator);
        this.composedFoods = new ArrayList<Food>();
        myLogger.getInstance().info("A dish has been created");
    }
	
    /**
     * Getter of recipe
     * @return recipe of the dish
     */
    public final Recipe getRecipe() {
        myLogger.getInstance().info("Recipe of dish has been getted");
        return this.recipe;
    }

    /**
     * TODO
     * @param newRecipe new recipe the dish will have
     * @throws SQLException 
     */
    public final void setRecipe(final Recipe newRecipe) 
            throws SQLException {
        this.recipe = newRecipe;
        myLogger.getInstance().info("Recipe of dish has been setted");
        DataBaseController.getInstance().updateDishRecipe(getID(), newRecipe.getID());
    }
	
    /**
     * Updates dish recipe's name
     * @param newName new name dish recipe will have
     */
    public final void updateRecipeName(final String newName) {
        this.recipe.updateName(newName);
        myLogger.getInstance().info("Recipe's name of dish has been updated");
        // TODO -> DB
    }
	
    /**
     * Updates dish recipe's description
     * @param newDescription new description dish recipe will have
     */
    public final void updateRecipeDescription(final String newDescription) {
        this.recipe.updateDescription(newDescription);
        myLogger.getInstance().info("Recipe's description of dish has been updated");
        // TODO -> review
    }

    /**
     * Getter of composed foods
     * @return array list containing the foods the dish is made of
     */
    public final ArrayList<Food> getComposedFoods() {
        myLogger.getInstance().info("ComposedFoods of dish has been getted");
        return this.composedFoods;
    }

    /**
     * Adds a food to the dish
     * @param foodToAdd food to add to the dish
     */
    public void addFood(final Food foodToAdd) {
        this.composedFoods.add(foodToAdd);
        myLogger.getInstance().info("A food has been added to the composed foods of dish");
        // TODO -> DB
        // TODO -> update price
    }
}
