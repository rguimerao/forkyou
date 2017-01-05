package backend;

public class Category {

	private String name;
	private ArrayList<Food> foods;

	public Category(String name) {

		this.name  = name;
		this.foods = new ArrayList<Food>();
	}

	public ArrayList<Food> getFoods() {
		return this.foods;
	}

	public void addFood(Food newFood) {
		this.foods.add(newFood, this.foods.size());
	}
}
