package backend;

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

		this.name  = name;
		this.foods = new ArrayList<Food>();
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
		this.foods.add(newFood, this.foods.size());
	}
}
