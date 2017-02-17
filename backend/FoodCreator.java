package backend;

import DB_controllers.DataBaseController;
import java.sql.SQLException;
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
    private ArrayList<User> followers;

    /**
     * Constructor of food creator
     * @param name Name of the food creator
     * @param description description of the food creator
     * @param street street of the food creator
     * @param areaCode area code of the food creator
     * @param city city of the food creator
     * @param country country of the food creator
     * @param phone phone number of the food creator
     * @param email email of the food creator
     */
    public FoodCreator(
            final String name,
            final String description,
            final String street,
            final int areaCode,
            final String city, 
            final String country,
            final int phone,
            final String email) {

        super(name, description, street, areaCode, city, country, phone, email);
        this.foodsCreated   = new ArrayList<Food>();
        this.recipesCreated = new ArrayList<Recipe>();
        this.followers      = new ArrayList<User>();
    }
	
    /**
     * Getter of foods created
     * @return foods created by the food creator
     */
    public final ArrayList<Food> getFoodsCreated() {
        return this.foodsCreated;
    }

    /**
     * Adds a food to the foods created array
     * @param foodToAdd food to add to the array
     */
    private final void addFood(final Food foodToAdd) {
        this.foodsCreated.add(foodToAdd);
    }

    /**
     * Getter of recipes created
     * @return recipes created by the food creator
     */
    public final ArrayList<Recipe> getRecipesCreated() {
        return this.recipesCreated;
    }

    /**
     * Adds a recipe to the recipes created array
     * @param recipeToAdd recipe to add to the array
     */
    private final void addRecipe(final Recipe recipeToAdd) {
        this.recipesCreated.add(recipeToAdd);
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
        
        Ingredient newIngredient = new Ingredient(name, category, forSell, price, this);
        DataBaseController.getInstance().createNewFood(newIngredient);
        newIngredient.obtainID();
        DataBaseController.getInstance().createNewIngredient(newIngredient);
        addFood(newIngredient);
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
        
        Dish newDish = new Dish(name, category, forSell, price, this);
        DataBaseController.getInstance().createNewFood(newDish);
        newDish.obtainID();
        DataBaseController.getInstance().createNewDish(newDish);
        addFood(newDish);
    }
	
    /**
     * Creates a drink and adds it to the foods created array
     * @param name name of the drink
     * @param forSell is the drink for sell?
     * @param price price of the drink
     * @throws SQLException if a DB error occurs
     */
    public final void createDrink(
            final String name, 
            final Category category, 
            final boolean forSell,
            final float price) 
                    throws SQLException {

        Drink newDrink = new Drink(name, forSell, price, this);
        DataBaseController.getInstance().createNewFood(newDrink);
        newDrink.obtainID();
        DataBaseController.getInstance().createNewDish(newDrink);
        DataBaseController.getInstance().createNewDrink(newDrink);
        addFood(newDrink);
    }

    /**
     * Adds a food to a dish.
     * For example, french fries (foodToAdd) to burger with fries (dish)
     * @param dish dish where the food will be added
     * @param foodToAdd food to add to the dish
     */
    public final void addFoodToDish(final Dish dish, final Food foodToAdd) {
        dish.addFood(foodToAdd);
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

        Recipe newRecipe = new Recipe(name, description, this, dish);
        DataBaseController.getInstance().createNewRecipe(newRecipe);
        newRecipe.obtainID();
        newRecipe.getDish().setRecipe(newRecipe);
        addRecipe(newRecipe);
    }

    /**
     * Creates a category
     * @param name name of the new category
     */
    public final void createCategory(final String name) {
        Category newCategory = new Category(name);
        DataBaseController.getInstance().createNewCategory(newCategory);
        newCategory.obtainID();
    }

    /**
     * Creates a new location
     * @param name name of the location
     * @param description a little description of it
     * @param street the street of the location
     * @param areaCode area code of the location
     * @param city city of the location
     * @param country country of the location
     * @param phone phone of the location
     * @param email email of the location
     * @param owner brand owner of the location
     */
    public void createLocation(
            final String name,
            final String description,
            final String street,
            final int areaCode,
            final String city,
            final String country,
            final int phone,
            final String email,
            final Brand owner) {

        Location newLocation = 
                new Location(
                        name, 
                        description, 
                        street, 
                        areaCode, 
                        city, 
                        country, 
                        phone, 
                        email, 
                        owner);
        
        DataBaseController.getInstance().createNewContactInfo(newLocation);
        newLocation.obtainID();
        DataBaseController.getInstance().createNewLocation(newLocation);
    }
	
    /**
     * Getter of followers list
     * @return array of users
     */
    public final ArrayList<User> getFollowers() {
        return this.followers;
    }
	
    /**
     * Adds a user to the followers list
     * @param followerUserToAdd user to add to the followers list
     */
    protected final void addFollower(final User followerUserToAdd) {
        this.followers.add(followerUserToAdd);
    }
	
    /**
     * Removes user from followers list
     * @param userToRemove user to remove from the followers list
     */
    protected final void removeFollower(final User userToRemove) {
        this.followers.remove(userToRemove);
    }

    /**
     * Check if a password hash entered is correct
     * @param password password hash to check
     * @return true if the hash is equal, false otherwise
     * @throws SQLException if a DB error occurs
     */
    public final boolean checkPassword(final String password) 
            throws SQLException {
        return DataBaseController.getInstance().checkHash(password, this);
    }
}
