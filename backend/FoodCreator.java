package backend;

import java.util.ArrayList;

/**
 * Class food creator
 * A food creator can create food, recipes, etc. typically a brand or user
 * @author rguimerao
 *
 */
public class FoodCreator extends ContactInfo {

	private ArrayList<Food> foodsCreated;
	private ArrayList<Recipe> recipesCreated;

	/**
	 * Constructor of food creator
	 * @param name Name of the food creator
	 * @param description description of the food creator
	 * @param street street of the food creator
	 * @param postalCode postal code of the food creator
	 * @param city city of the food creator
	 * @param country country of the food creator
	 * @param phoneNumber phone number of the food creator
	 * @param email email of the food creator
	 */
	public FoodCreator(
		String name,
		String description,
		String street,
		int postalCode,
		String city, 
		String country,
		int phoneNumber,
		String email) {

		super(name, description, street, postalCode, city, country, phoneNumber, email);
		this.foodsCreated   = new ArrayList<Food>();
		this.recipesCreated = new ArrayList<Recipe>();
	}

	/**
	 * Getter of foods created
	 * @return foods created by the food creator
	 */
	public ArrayList<Food> getFoodsCreated() {
		return this.foodsCreated;
	}

	/**
	 * Adds a food to the foods created array
	 * @param foodToAdd food to add to the array
	 */
	private void addFood(Food foodToAdd) {
		this.foodsCreated.add(foodToAdd);
	}

	/**
	 * Getter of recipes created
	 * @return recipes created by the food creator
	 */
	public ArrayList<Recipe> getRecipesCreated() {
		return this.recipesCreated;
	}

	/**
	 * Adds a recipe to the recipes created array
	 * @param recipeToAdd recipe to add to the array
	 */
	private void addRecipe(Recipe recipeToAdd) {
		this.recipesCreated.add(recipeToAdd);
	}

	/**
	 * Creates an ingredient and adds it to the foods created array
	 * @param name name of the ingredient
	 * @param category category which the ingredient belongs to
	 * @param forSell is the ingredient for sell?
	 * @param price price of the ingredient
	 */
	public void createIngredient(String name, Category category, boolean forSell, float price) {

		// TODO -> needs DB + controller
		Food newIngredient = new Ingredient(name, category, forSell, price, this);
		addFood(newIngredient);
	}

	/**
	 * Creates a dish and adds it to the foods created array
	 * @param name name of the dish
	 * @param category category which the dish belongs to
	 * @param forSell is this dish for sell?
	 * @param price price of the dish
	 */
	public void createDish(String name, Category category, boolean forSell, float price) {

		// TODO -> needs DB + controller
		Food newDish = new Dish(name, category, forSell, price, this);
		addFood(newDish);
	}

	/**
	 * Adds a food to a dish.
	 * For example, french fries (foodToAdd) to burger with fries (dish)
	 * @param dish dish where the food will be added
	 * @param foodToAdd food to add to the dish
	 */
	public void addFoodToDish(Dish dish, Food foodToAdd) {

		// TODO -> needs DB + controller
		dish.addFood(foodToAdd);
	}
	
	/**
	 * Creates a recipe and adds it to the recipes created array
	 * @param name name of the recipe
	 * @param description description and steps of the recipe
	 * @param dish dish this new recipe will create
	 */
	public void createRecipe(String name, String description, Dish dish) {

		// TODO -> needs DB + controller
		Recipe newRecipe = new Recipe(name, description, this, dish);
		addRecipe(newRecipe);
	}

	/**
	 * Creates a category
	 * @param name name of the new category
	 */
	public void createCategory(String name) {

		// TODO -> needs DB + controller
		//Category newCategory = new Category(name);
	}

	/**
	 * Creates a new location where food is bought and sold
	 * @param name name of the location
	 * @param description description of the location
	 * @param street street of the location
	 * @param postalCode postal code of the location
	 * @param city city of the location
	 * @param country country of the location
	 * @param phoneNumber phone number of the location
	 * @param email email of the location
	 */
	public void createLocation(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		String country,
		int phoneNumber,
		String email,
		Brand owner) {

			// TODO -> needs DB + controller
			//Location newLocation = new Location(name, description, street, postalCode, city, country, phoneNumber, email, owner);
	}
}
