package backend;

import java.util.ArrayList;

/**
 * TODO
 */
public class Category extends Identifier {

	private String name;
	private ArrayList<Food> foods;

	/**
	 * TODO
	 */
	public Category(String name) {

		super();
		this.setName(name);
		this.foods = new ArrayList<Food>();
	}

	/**
	 * TODO
	 */
	public String getName() {
		return name;
	}

	/**
	 * TODO
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * TODO
	 */
	public ArrayList<Food> getFoods() {
		return this.foods;
	}

	/**
	 * TODO
	 */
	public void addFood(Food newFood) {
		this.foods.add(newFood);
	}
}
