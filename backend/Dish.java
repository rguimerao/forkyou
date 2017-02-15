package backend;

import testing.MyLogger;
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
        MyLogger.info("A dish has been created");
    }
	
    /**
     * Getter of recipe
     * @return recipe of the dish
     */
    public final Recipe getRecipe() {
        MyLogger.info("Recipe of dish has been getted");
        return this.recipe;
    }

    /**
     * Sets a recipe for this dish
     * @param newRecipe new recipe the dish will have
     * @throws SQLException if a DB error occurs
     */
    public final void setRecipe(final Recipe newRecipe) 
            throws SQLException {
        this.recipe = newRecipe;
        MyLogger.info("Recipe of dish has been setted");
        DataBaseController.getInstance().updateDishRecipe(getID(), newRecipe.getID());
    }
	
    /**
     * Updates dish recipe's name
     * @param newName new name dish recipe will have
     * @throws SQLException if a DB error occurs 
     */
    public final void updateRecipeName(final String newName) 
            throws SQLException {
        this.recipe.updateName(newName);
        MyLogger.info("Recipe's name of dish has been updated");
    }
	
    /**
     * Updates dish recipe's description
     * @param newDescription new description dish recipe will have
     * @throws SQLException if a DB error occurs
     */
    public final void updateRecipeDescription(final String newDescription) 
            throws SQLException {
        this.recipe.updateDescription(newDescription);
        MyLogger.info("Recipe's description of dish has been updated");
    }

    /**
     * Getter of composed foods
     * @return array list containing the foods the dish is made of
     */
    public final ArrayList<Food> getComposedFoods() {
        MyLogger.info("ComposedFoods of dish has been getted");
        return this.composedFoods;
    }

    /**
     * Updates the price when adding a new food
     * @param priceToAdd new price to add
     * @throws SQLException if a DB error occurs
     */
    private final void updatePrice(final float priceToAdd) 
            throws SQLException {
        this.setPrice(this.getPrice() + priceToAdd);
    }
    
    /**
     * Adds a food to the dish
     * @param foodToAdd food to add to the dish
     * @throws SQLException if a DB error occurs
     */
    public void addFood(final Food foodToAdd) 
            throws SQLException {
        this.composedFoods.add(foodToAdd);
        DataBaseController.getInstance().addFoodToDish(getID(), foodToAdd.getID());
        updatePrice(foodToAdd.getPrice());
        MyLogger.info("A food has been added to the composed foods of dish");
    }
}
