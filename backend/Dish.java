package backend;

import DB_controllers.DataBaseController;
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
     */
    public Dish(
            final String name, 
            final Category category, 
            final boolean forSell, 
            final float price, 
            final User creator) {

        super(name, category, forSell, price, creator);
        this.composedFoods = new ArrayList<Food>();
    }
	
    /**
     * Getter of recipe
     * @return recipe of the dish
     */
    public final Recipe getRecipe() {
        return this.recipe;
    }

    /**
     * Sets a recipe for this dish
     * @param newRecipe new recipe the dish will have
     */
    public final void setRecipe(final Recipe newRecipe) {
        this.recipe = newRecipe;
        DataBaseController.getInstance().updateDishRecipe(getID(), newRecipe.getID());
    }
	
    /**
     * Updates dish recipe's name
     * @param newName new name dish recipe will have
     */
    public final void updateRecipeName(final String newName) {
        this.recipe.updateName(newName);
    }
	
    /**
     * Updates dish recipe's description
     * @param newDescription new description dish recipe will have
     */
    public final void updateRecipeDescription(final String newDescription) {
        this.recipe.updateDescription(newDescription);
    }

    /**
     * Getter of composed foods
     * @return array list containing the foods the dish is made of
     */
    public final ArrayList<Food> getComposedFoods() {
        return this.composedFoods;
    }

    /**
     * Updates the price when adding a new food
     * @param priceToAdd new price to add
     */
    private final void updatePrice(final float priceToAdd) {
        this.setPrice(this.getPrice() + priceToAdd);
    }
    
    /**
     * Adds a food to the dish
     * @param foodToAdd food to add to the dish
     */
    public void addFood(final Food foodToAdd) {
        this.composedFoods.add(foodToAdd);
        DataBaseController.getInstance().addFoodToDish(getID(), foodToAdd.getID());
        updatePrice(foodToAdd.getPrice());
    }
}
