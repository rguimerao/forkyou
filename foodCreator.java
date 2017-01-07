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

	private void addFood(Food newFood) {
		this.foodsCreated.add(newFood, this.foodsCreated.size());
	}

	public ArrayList<Recipe> getRecipesCreated() {
		return this.recipesCreated;
	}

	private void addRecipe(Food newRecipe) {
		this.recipesCreated.add(newRecipe, this.recipesCreated.size());
	}

	public void createRecipe(String name, String description, Date lastUpdate, FoodCreator creator) {

		// neeeds BD + controller
		Recipe newRecipe = new Recipe(name, description, lastUpdate, creator);
		addRecipe(newRecipe);
	}

	public void createCategory(String name) {

		// needs BD + controller
		Category newCategory = new Category(name);
	}

	public void createLocation(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		int phoneNumber,
		String email) {

			// needs BD + controller
			Location newLocation = new Location(name, description, street, postalCode, city, phoneNumber, email);
	}

	public void createIngredient(String name, Category category) {

		// needs BD + controller
		Food newIngredient = new Ingredient(name, category);
		addFood(newIngredient);
	}

	public void createDish(String name, Category category) {

		// needs BD + controller
		Food newDish = new Dish(name, category);
		addFood(newDish);
	}

	public void addFoodToDish(Dish dish, Food foodToAdd) {

		// needs BD + controller
		dish.addFood(foodToAdd);
	}
}
