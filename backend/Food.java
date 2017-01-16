package backend;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class food
 * @author rguimerao
 *
 */
public class Food extends Identifier {

	private String name;
	private Category category;
	private ArrayList<Location> purchaseLocations;
	private boolean forSell;
	private float price;
	private FoodCreator creator;
	private ArrayList<User> usersWantingMe;
	private static final Logger LOGGER = Logger.getLogger("Food");

	/**
	 * Constructor of food
	 * @param name name of the food
	 * @param category category of the food
	 * @param forSell is this food for sell?
	 * @param price price of the food
	 * @param creator creator of the food
	 */
	public Food(String name, Category category, boolean forSell, float price, FoodCreator creator) {

		super();
		this.name     = name;
		this.category = category;
		this.category.addFood(this); // TODO -> ??? possible?
		this.purchaseLocations = new ArrayList<Location>();
		this.forSell  = forSell;
		this.price    = price;
		this.creator  = creator;
		this.usersWantingMe = new ArrayList<User>();
		LOGGER.log(Level.INFO, "A new food with name: " + name + " has been created");
	}

	/**
	 * Getter of name
	 * @return name of the food
	 */
	public String getName() {
		LOGGER.log(Level.INFO, "Name of food has been requested");
		return this.name;
	}

	/**
	 * Setter of name
	 * @param newName new name the food will have
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Getter of category
	 * @return category the food is in
	 */
	public Category getCategory() {
		return this.category;
	}

	/**
	 * Setter of category
	 * @param newCategory new category the food will be in
	 */
	public void setCategory(Category newCategory) {
		this.category = newCategory;
	}

	/**
	 * Getter of purchase locations
	 * @return array of location containing the locations where this food can be bought
	 */
	public ArrayList<Location> getPurchaseLocations() {
		return this.purchaseLocations;
	}

	/**
	 * Adds a purchase location to the food's purchase locations
	 * @param purchaseLocationToAdd purchase location to add
	 */
	public void addPurchaseLocation(Location purchaseLocationToAdd) {
		if(forSell) {
			this.purchaseLocations.add(purchaseLocationToAdd);
			purchaseLocationToAdd.addFood(this);
		}
	}

	/**
	 * Getter of is for sell
	 * @return true is the food is for sell, false otherwise
	 */
	public boolean isForSell() {
		return this.forSell;
	}

	/**
	 * Inverter of for sell.
	 * Changes the value of forSell attribute to the opposite
	 */
	public void invertForSell() {
		this.forSell = !this.forSell;
	}

	/**
	 * Getter of price
	 * @return price the food has
	 */
	public float getPrice() {
		return this.price;
	}

	/**
	 * Setter of price
	 * @param newPrice new price the food will have
	 */
	public void setPrice(float newPrice) {
		this.price = newPrice;
	}

	/**
	 * Getter of creator
	 * @return creator of this food
	 */
	public FoodCreator getCreator() {
		return this.creator;
	}
	
	/**
	 * Gets an array list of users wanting this food
	 * @return array list of users wanting this food
	 */
	public ArrayList<User> getUsersWantingMe() {
		return this.usersWantingMe;
	}
	
	/**
	 * Adds a user to the users wanting this food array
	 * @param userToAdd user to be added to the list
	 */
	public void addUserToUsersWantingMe(User userToAdd) {
		this.usersWantingMe.add(userToAdd);
	}
	
	/**
	 * Removes a user from the users wanting this food
	 * @param userToRemove user to be removed
	 */
	public void removeUserFromUsersWantingMe(User userToRemove) {
		this.usersWantingMe.remove(userToRemove);
	}
}
