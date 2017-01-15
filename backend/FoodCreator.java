package backend;

import java.sql.Date;
import java.util.ArrayList;

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
		String country,
		int phoneNumber,
		String email) {

		super(name, description, street, postalCode, city, country, phoneNumber, email);
		this.foodsCreated   = new ArrayList<Food>();
		this.recipesCreated = new ArrayList<Recipe>();
	}

	/**
	 * TODO
	 */
	public ArrayList<Food> getFoodsCreated() {
		return this.foodsCreated;
	}

	/**
	 * TODO
	 */
	private void addFood(Food newFood) {
		this.foodsCreated.add(newFood);
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
	private void addRecipe(Recipe newRecipe) {
		this.recipesCreated.add(newRecipe);
	}

	/**
	 * TODO
	 */
	public void createRecipe(String name, String description, Date lastUpdate, FoodCreator creator) {

		// TODO -> needs DB + controller
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
		String country,
		int phoneNumber,
		String email) {

			// TODO -> needs DB + controller
			Location newLocation = new Location(name, description, street, postalCode, city, country, phoneNumber, email);
	}

	/**
	 * TODO
	 */
	public void createIngredient(String name, Category category, boolean forSell, float price) {

		// TODO -> needs DB + controller
		Food newIngredient = new Ingredient(name, category, forSell, price, this);
		addFood(newIngredient);
	}

	/**
	 * TODO
	 */
	public void createDish(String name, Category category, boolean forSell, float price) {

		// TODO -> needs DB + controller
		Food newDish = new Dish(name, category, forSell, price, this);
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
