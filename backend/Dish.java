package backend;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class dish.
 * A dish is food composed by more foods
 * @author rguimerao
 *
 */
public class Dish extends Food {

	private Recipe recipe;
	protected ArrayList<Food> composedFoods;
	private static final Logger LOGGER = Logger.getLogger("Dish");

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
		final FoodCreator creator) {

		super(name, category, forSell, price, creator);
		this.composedFoods = new ArrayList<Food>();
		LOGGER.log(Level.INFO, "A dish has been created");
	}

	/**
	 * Getter of recipe
	 * @return recipe of the dish
	 */
	public final Recipe getRecipe() {
		LOGGER.log(Level.INFO, "Recipe of dish has been getted");
		return this.recipe;
	}

	/**
	 * Setter of recipe
	 * @param newRecipe new recipe the dish will have
	 */
	public final void setRecipe(Recipe newRecipe) {
		this.recipe = newRecipe;
		LOGGER.log(Level.INFO, "Recipe of dish has been setted");
	}
	
	/**
	 * Updates dish recipe's name
	 * @param newName new name dish recipe will have
	 */
	public final void updateRecipeName(String newName) {
		this.recipe.updateName(newName);
		LOGGER.log(Level.INFO, "Recipe's name of dish has been updated");
	}
	
	/**
	 * Updates dish recipe's description
	 * @param newDescription new description dish recipe will have
	 */
	public final void updateRecipeDescription(String newDescription) {
		this.recipe.updateDescription(newDescription);
		LOGGER.log(Level.INFO, "Recipe's description of dish has been updated");
	}

	/**
	 * Getter of composed foods
	 * @return array list containing the foods the dish is made of
	 */
	public final ArrayList<Food> getComposedFoods() {
		LOGGER.log(Level.INFO, "ComposedFoods of dish has been getted");
		return this.composedFoods;
	}

	/**
	 * Adds a food to the dish
	 * @param foodToAdd food to add to the dish
	 */
	public void addFood(final Food foodToAdd) {
		this.composedFoods.add(foodToAdd);
		LOGGER.log(Level.INFO, "A food has been added to the composed foods of dish");
	}
}
