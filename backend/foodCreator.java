package backend;

/**
 * TODO
 */
public class FoodCreator extends ContactInfo {

	private ArrayList<Food> foodsCreated;
	private ArrayList<Recipe> recipesCreated;

	/**
	 * TODO
	 */
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

	/**
	 * TODO
	 */
	public ArrayList<food> getFoodsCreated() {
		return this.foodCreated;
	}

	/**
	 * TODO
	 */
	private void addFood(Food newFood) {
		this.foodsCreated.add(newFood, this.foodsCreated.size());
	}

	/**
	 * TODO
	 */
	public ArrayList<Recipe> getRecipesCreated() {
		return this.recipesCreated;
	}

	/**
	 * TODO
	 */
	private void addRecipe(Food newRecipe) {
		this.recipesCreated.add(newRecipe, this.recipesCreated.size());
	}

	/**
	 * TODO
	 */
	public void createRecipe(String name, String description, Date lastUpdate, FoodCreator creator) {

		// TODO -> neeeds DB + controller
		Recipe newRecipe = new Recipe(name, description, lastUpdate, creator);
		addRecipe(newRecipe);
	}

	/**
	 * TODO
	 */
	public void createCategory(String name) {

		// TODO -> needs DB + controller
		Category newCategory = new Category(name);
	}

	/**
	 * TODO
	 */
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

	/**
	 * TODO
	 */
	public void createIngredient(String name, Category category, boolean forSell, float price) {

		// TODO -> needs DB + controller
		Food newIngredient = new Ingredient(name, category, forSell, this);
		addFood(newIngredient);
	}

	/**
	 * TODO
	 */
	public void createDish(String name, Category category, boolean forSell, float price) {

		// TODO -> needs DB + controller
		Food newDish = new Dish(name, category, forSell, this);
		addFood(newDish);
	}

	/**
	 * TODO
	 */
	public void addFoodToDish(Dish dish, Food foodToAdd) {

		// TODO -> needs DB + controller
		dish.addFood(foodToAdd);
	}
}
