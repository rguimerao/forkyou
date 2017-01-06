package backend;

public class FoodCreator extends ContactInfo {

	protected ArrayList<Food> foodsCreated;
	protected ArrayList<Recipe> recipesCreated;

  public FoodCreator(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		int phoneNumber,
		String email) {

		super(name, description, street, postalCode, city, phoneNumber, email);
		this.foodsCreated   = new ArrayList<food>();
		this.recipesCreated = new ArrayList<Recipe>();
	}

	public ArrayList<food> getFoodsCreated() {
		return this.foodCreated;
	}

	public void addFood(Food newFood) {
		this.foodsCreated.add(newFood, this.foodsCreated.size());
	}

	public ArrayList<Recipe> getRecipesCreated() {
		return this.recipesCreated;
	}

	public void addRecipe(Food newRecipe) {
		this.recipesCreated.add(newRecipe, this.recipesCreated.size());
	}

	// TODO -> create recipe, create food, create location, create category
}
