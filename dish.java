package backend;

public class Dish extends Food {

	private ArrayList<Food> composedFoods;

  public Dish(Location purchaseLocation, Recipe recipe, Category category) {

		super(purchaseLocation, recipe, category);
		this.composedFoods = new ArrayList<Food>();
	}

}
