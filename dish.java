package backend;

public class Dish extends Food {

	private Recipe recipe;
	private ArrayList<Food> composedFoods;

  public Dish(Recipe recipe, Category category) {

		super(recipe, category);
		this.composedFoods = new ArrayList<Food>();
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe newRecipe) {
		this.recipe = newRecipe;
	}

	public ArrayList<Food> getComposedFoods() {
		return this.composedFoods;
	}

	public void addFood(Food newFood) {
		this.composedFoods.add(newFood, this.composedFoods.size());
	}
}
