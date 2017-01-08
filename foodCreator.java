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

		// TODO -> neeeds DB + controller
		Recipe newRecipe = new Recipe(name, description, lastUpdate, creator);
		addRecipe(newRecipe);
	}

	public void createCategory(String name) {

		// TODO -> needs DB + controller
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

			// TODO -> needs DB + controller
			Location newLocation = new Location(name, description, street, postalCode, city, phoneNumber, email);
	}

	public void createIngredient(String name, Category category, boolean forSell) {

		// TODO -> needs DB + controller
		Food newIngredient = new Ingredient(name, category, forSell);
		addFood(newIngredient);
	}

	public void createDish(String name, Category category, boolean forSell) {

		// TODO -> needs DB + controller
		Food newDish = new Dish(name, category, forSell);
		addFood(newDish);
	}

	public void addFoodToDish(Dish dish, Food foodToAdd) {

		// TODO -> needs DB + controller
		dish.addFood(foodToAdd);
	}
}
