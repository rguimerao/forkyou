package backend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DB_controllers.DataBaseController;

/**
 * Class food creator
 * A food creator can create food, recipes, etc. typically a brand or user
 * @author rguimerao
 *
 */
public class FoodCreator extends ContactInfo {

	private ArrayList<Food> foodsCreated;
	private ArrayList<Recipe> recipesCreated;
    private ArrayList<User> followers;
	private static final Logger LOGGER = Logger.getLogger("Food Creator");

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
		final String name,
		final String description,
		final String street,
		final int postalCode,
		final String city, 
		final String country,
		final int phoneNumber,
		final String email) {

		super(name, description, street, postalCode, city, country, phoneNumber, email);
		this.foodsCreated   = new ArrayList<Food>();
		this.recipesCreated = new ArrayList<Recipe>();
		this.followers      = new ArrayList<User>();
		LOGGER.log(Level.INFO, "A food creator has been created");
	}

	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID() {
		LOGGER.log(Level.INFO, "obtainID in FoodCreator");
		// TODO -> DB
	}
	
	/**
	 * Getter of foods created
	 * @return foods created by the food creator
	 */
	public final ArrayList<Food> getFoodsCreated() {
		LOGGER.log(Level.INFO, "Foods created from food creator getted");
		return this.foodsCreated;
	}

	/**
	 * Adds a food to the foods created array
	 * @param foodToAdd food to add to the array
	 */
	private final void addFood(final Food foodToAdd) {
		this.foodsCreated.add(foodToAdd);
		LOGGER.log(Level.INFO, "Food added to foods created");
		// TODO -> DB
	}

	/**
	 * Getter of recipes created
	 * @return recipes created by the food creator
	 */
	public final ArrayList<Recipe> getRecipesCreated() {
		LOGGER.log(Level.INFO, "Recipes from food creator getted");
		return this.recipesCreated;
	}

	/**
	 * Adds a recipe to the recipes created array
	 * @param recipeToAdd recipe to add to the array
	 */
	private final void addRecipe(final Recipe recipeToAdd) {
		this.recipesCreated.add(recipeToAdd);
		LOGGER.log(Level.INFO, "Recipe added to food creator");
		// TODO -> DB
	}

	/**
	 * Creates a food and adds it to the foods created array
	 * @param name name of the food
	 * @param category category which the food belongs to
	 * @param forSell is the food for sell?
	 * @param price price of the food
	 */
	public final void createFood(
		final String name, 
		final Category category, 
		final boolean forSell,
		final float price) {

		// TODO -> remove this
		Food newFood = new Food(name, category, forSell, price, this);
		addFood(newFood);
		LOGGER.log(Level.INFO, "Food created and added on food creator");
	}
	
	/**
	 * Creates a dish and adds it to the foods created array
	 * @param name name of the dish
	 * @param category category which the food belongs to
	 * @param forSell is the dish for sell?
	 * @param price price of the dish
	 */
	public final void createDish(
		final String name, 
		final Category category, 
		final boolean forSell,
		final float price) {

		// TODO -> needs DB + controller
		Dish newDish = new Dish(name, category, forSell, price, this);
		addFood(newDish);
		LOGGER.log(Level.INFO, "Food created and added on food creator");
	}
	
	/**
	 * Creates an ingredient and adds it to the foods created array
	 * @param name name of the food
	 * @param category category which the ingredient belongs to
	 * @param forSell is the food for sell?
	 * @param price price of the ingredient
	 */
	public final void createIngredient(
		final String name, 
		final Category category, 
		final boolean forSell,
		final float price) {

		// TODO -> needs DB + controller
		Ingredient newIngredient = new Ingredient(name, category, forSell, price, this);
		addFood(newIngredient);
		LOGGER.log(Level.INFO, "Food created and added on food creator");
	}
	
	/**
	 * Creates a drink and adds it to the foods created array
	 * @param name name of the drink
	 * @param forSell is the drink for sell?
	 * @param price price of the drink
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void createDrink(
		final String name, 
		final Category category, 
		final boolean forSell,
		final float price) 
				throws SQLException, ClassNotFoundException {

		// TODO -> needs DB + controller
		DataBaseController dbController = DataBaseController.getInstance();
		Drink newDrink = new Drink(name, dbController.getDrinksCategory(), forSell, price, this);
		addFood(newDrink);
		LOGGER.log(Level.INFO, "Food created and added on food creator");
	}

	/**
	 * Adds a food to a dish.
	 * For example, french fries (foodToAdd) to burger with fries (dish)
	 * @param dish dish where the food will be added
	 * @param foodToAdd food to add to the dish
	 */
	public final void addFoodToDish(final Dish dish, final Food foodToAdd) {

		// TODO -> needs DB + controller
		dish.addFood(foodToAdd);
		LOGGER.log(Level.INFO, "Food added to dish on food creator");
	}
	
	/**
	 * Creates a recipe and adds it to the recipes created array
	 * @param name name of the recipe
	 * @param description description and steps of the recipe
	 * @param dish dish this new recipe will create
	 */
	public final void createRecipe(
		final String name, 
		final String description, 
		final Dish dish) {

		// TODO -> needs DB + controller
		Recipe newRecipe = new Recipe(name, description, this, dish);
		addRecipe(newRecipe);
		LOGGER.log(Level.INFO, "Recipe created and added on food creator");
	}

	/**
	 * Creates a category
	 * @param name name of the new category
	 * @throws SQLException 
	 */
	public final void createCategory(final String name) 
			throws SQLException {

		Category newCategory = new Category(name);
		DataBaseController.getInstance().createNewCategory(newCategory);
		newCategory.obtainID();
		LOGGER.log(Level.INFO, "Category created on food creator");
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
	 * @param owner brand owner of the location
	 */
	public void createLocation(
		final String name,
		final String description,
		final String street,
		final int postalCode,
		final String city,
		final String country,
		final int phoneNumber,
		final String email,
		final Brand owner) 
				throws ClassNotFoundException, SQLException {

		// TODO -> needs DB + controller
		//Location newLocation = new Location(name, description, street, postalCode, city, country, phoneNumber, email, owner);
		LOGGER.log(Level.INFO, "Location created on food creator");
	}
	
	/**
	 * Getter of followers list
	 * @return array of users
	 */
	public final ArrayList<User> getFollowers() {
		LOGGER.log(Level.INFO, "Followers list getted");
		return this.followers;
	}
	
	/**
	 * Adds a user to the followers list
	 * @param followerUserToAdd user to add to the followers list
	 */
	protected final void addFollower(final User followerUserToAdd) {
		this.followers.add(followerUserToAdd);
		LOGGER.log(Level.INFO, "A user is now following you");
		// TODO -> DB
	}
	
	/**
	 * Removes user from followers list
	 * @param userToRemove user to remove from the followers list
	 */
	protected final void removeFollower(final User userToRemove) {
		this.followers.remove(userToRemove);
		LOGGER.log(Level.INFO, "A user has removed you from its following list");
		// TODO -> DB
	}

	/**
	 * TODO
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final boolean checkPassword(final String password) 
			throws ClassNotFoundException, SQLException {
		return DataBaseController.getInstance().checkHash(password, this);
	}
}
