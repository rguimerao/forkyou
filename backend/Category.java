package backend;

import java.util.ArrayList;

/**
 * Class category.
 * A category has foods in it.
 * @author rguimerao
 *
 */
public class Category extends Identifier {

	private String name;
	private ArrayList<Food> foods;

	/**
	 * Constructor of category
	 * @param name name of the category
	 */
	public Category(String name) {

		super();
		this.name  = name;
		this.foods = new ArrayList<Food>();
	}

	/**
	 * Getter of name
	 * @return name of the category
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter of foods in category
	 * @return array list with the foods in the category
	 */
	public ArrayList<Food> getFoods() {
		return this.foods;
	}

	/**
	 * Adds a food to the array of foods inside the category
	 * @param foodToAdd food to add to the category
	 */
	public void addFood(Food foodToAdd) {
		this.foods.add(foodToAdd);
	}
}
