package backend;

import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class user.
 * A user is the main character of the app.
 * @author rguimerao
 *
 */
public class User extends ContactInfo {

    private ArrayList<Food> foodWishlist;
    private ArrayList<User> following;
    private String nickname;
    private ArrayList<Food> foodsCreated;
    private ArrayList<Recipe> recipesCreated;
    private ArrayList<User> followers;
    private ArrayList<Location> sellLocations;
    private String website;
    
    /**
     * Constructor of user
     * @param name name of the user
     * @param description description of the user
     * @param street street of the user
     * @param areaCode area code of the user
     * @param city city of the user
     * @param country country of the user
     * @param phone phone number of the user
     * @param email email of the user
     */
	public User(
		final String name,
		final String description,
		final String street,
		final int areaCode,
		final String city,
		final String country,
		final int phone,
		final String email,
		final String nickname,
		final String website) {
	
		super(name, description, street, areaCode, city, country, phone, email);
	    this.website        = website;
	    this.nickname       = nickname;
		this.foodWishlist   = new ArrayList<Food>();
		this.following      = new ArrayList<User>();
		this.foodsCreated   = new ArrayList<Food>();
	    this.recipesCreated = new ArrayList<Recipe>();
	    this.followers      = new ArrayList<User>();
	    this.sellLocations  = new ArrayList<Location>();
	}
	
    /**
     * Gets brand website
     * @return website of the brand
     */
    public final String getWebsite() {
        return this.website;
    }
    
    /**
     * Sets a new website of the brand
     * @param newWebsite new website of the brand
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public final void setWebsite(final String newWebsite) {
        this.website = newWebsite;
        DataBaseController.getInstance().updateUserWebsite(getID(), newWebsite);
    }
    
    /**
     * Gets the nickname of this user
     * @return nickname of the user
     */
    public String getNickName() {
        return this.nickname;
    }
       /**
     * Sets the new nickname of the user
     * @param newNickName new nickname the user will have
     */
    public void setNickName(final String newNickName) {
        this.nickname = newNickName;
        DataBaseController.getInstance().updateUserNickName(getID(), newNickName);
    }
    
    /**
     * Getter of foods created
     * @return foods created by the food creator
     */
    public final ArrayList<Food> getFoodsCreated() {
        if (this.foodsCreated.isEmpty()) {
            try {
                this.foodsCreated = DataBaseController.getInstance().getUserFoods(this);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
            final User owner) {

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
     * Check if a password hash entered is correct
     * @param password password hash to check
     * @return true if the hash is equal, false otherwise
     * @throws SQLException if a DB error occurs
     */
    public final boolean checkPassword(final String password) 
            throws SQLException {
        return DataBaseController.getInstance().checkHash(password, this);
    }
	
	/**
     * Getter of sell locations
     * @return location where the brand sells food
     */
    public final ArrayList<Location> getSellLocations() {
        return this.sellLocations;
    }

    /**
     * Add a new location to the sellLocations array
     * @param newLocation new location to add to the array
     */
    public final void addSellLocation(final Location newLocation) {
        if (newLocation.getOwner().getID() != getID()) {
            this.sellLocations.add(newLocation);
            newLocation.setOwner(this);
        }
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
	 * Getter of wish list
	 * @return array of foods
	 */
	public final ArrayList<Food> getWishlist() {
		return this.foodWishlist;
	}
	
	/**
	 * Adds food to the user's wish list
	 * @param foodToAdd food to add
	 */
	public final void addFoodToWishlist(final Food foodToAdd) {
		this.foodWishlist.add(foodToAdd);
		foodToAdd.addUserToUsersWantingMe(this);
	}

	/**
	 * Removes food from wish list
	 * @param foodToRemove food to remove
	 */
	public final void removeFoodFromWishlist(final Food foodToRemove) {
		foodToRemove.removeUserFromUsersWantingMe(this);
		this.foodWishlist.remove(foodToRemove);
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
	 * Getter of following users
	 * @return array of following users
	 */
	public final ArrayList<User> getFollowing() {
	    if (this.following.isEmpty()) {
	        try {
                this.following = DataBaseController.getInstance().getUserFollowing(getID());
            } catch (SQLException e) {
                e.printStackTrace();
            }
	    }
		return this.following;
	}
	
	/**
	 * Adds a user to the following list only if its different than itself
	 * @param userToAdd user to add to the following list
	 */
	public final void followUser(final User foodCreatorToAdd) {
		if (foodCreatorToAdd.getID() != this.getID()) {
			this.following.add(foodCreatorToAdd);
			foodCreatorToAdd.addFollower(this);
		    DataBaseController.getInstance().followFoodCreator(getID(), foodCreatorToAdd.getID());
		}
	}
	
	/**
	 * Removes user from the following list
	 * @param userToRemove user to remove from the following list
	 */
	public final void removeFollowing(final User foodCreatorToRemove) {
		this.following.remove(foodCreatorToRemove);
		foodCreatorToRemove.removeFollower(this);
	    DataBaseController.getInstance().unFollowFoodCreator(getID(), foodCreatorToRemove.getID());
	}
}
