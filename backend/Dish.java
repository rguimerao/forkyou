package backend;

import java.util.ArrayList;

/**
 * TODO
 */
public class Dish extends Food {

	private Recipe recipe;
	private ArrayList<Food> composedFoods;

	/**
	 * TODO
	 */
  public Dish(String name, Category category, boolean forSell, float price, FoodCreator creator) {

		super(name, category, forSell, price, creator);
		this.composedFoods = new ArrayList<Food>();
	}

	/**
	 * TODO
	 */
	public Recipe getRecipe() {
		return this.recipe;
	}

	/**
	 * TODO
	 */
	public void setRecipe(Recipe newRecipe) {
		this.recipe = newRecipe;
	}

	/**
	 * TODO
	 */
	public ArrayList<Food> getComposedFoods() {
		return this.composedFoods;
	}

	/**
	 * TODO
	 */
	public void addFood(Food newFood) {
		this.composedFoods.add(newFood);
	}
}
