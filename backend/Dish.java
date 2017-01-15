package backend;

import java.util.ArrayList;

/**
 * Class dish.
 * A dish is food composed by more foods
 * @author rguimerao
 *
 */
public class Dish extends Food {

	private Recipe recipe;
	private ArrayList<Food> composedFoods;

	/**
	 * Constructor of dish
	 * @param name name of the dish
	 * @param category category of the dish
	 * @param forSell is this dish for sell?
	 * @param price price of the dish
	 * @param creator creator of the dish
	 */
	public Dish(String name, Category category, boolean forSell, float price, FoodCreator creator) {

		super(name, category, forSell, price, creator);
		this.composedFoods = new ArrayList<Food>();
	}

	/**
	 * Getter of recipe
	 * @return recipe of the dish
	 */
	public Recipe getRecipe() {
		return this.recipe;
	}

	/**
	 * Setter of recipe
	 * @param newRecipe new recipe the dish will have
	 */
	public void setRecipe(Recipe newRecipe) {
		this.recipe = newRecipe;
	}

	/**
	 * Getter of composed foods
	 * @return array list containing the foods the dish is made of
	 */
	public ArrayList<Food> getComposedFoods() {
		return this.composedFoods;
	}

	/**
	 * Adds a food to the dish
	 * @param foodToAdd food to add to the dish
	 */
	public void addFood(Food foodToAdd) {
		this.composedFoods.add(foodToAdd);
	}
}
