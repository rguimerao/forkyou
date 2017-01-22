package backend;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB_controllers.DataBaseController;

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
	public Food(
		final String name, 
		final Category category, 
		final boolean forSell, 
		final float price, 
		final FoodCreator creator) {

		super();
		this.name     = name;
		this.category = category;
		this.forSell  = forSell;
		this.creator  = creator;
		
		if (price >= 0) {
			this.price = price;
		} else {
			this.price = -1;
			LOGGER.log(Level.WARNING, "Price of new food is negative!");
		}

		this.usersWantingMe    = new ArrayList<User>();
		this.purchaseLocations = new ArrayList<Location>();
		this.category.addFood(this);
		LOGGER.log(Level.INFO, "A new food with name: " + name + " has been created");
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID(final DataBaseController dbController) {
		LOGGER.log(Level.INFO, "obtainID in Food");
		// TODO -> DB
	}

	/**
	 * Getter of name
	 * @return name of the food
	 */
	public final String getName() {
		LOGGER.log(Level.INFO, "Name of food has been requested");
		return this.name;
	}

	/**
	 * Setter of name
	 * @param newName new name the food will have
	 */
	public final void setName(final String newName) {
		this.name = newName;
		LOGGER.log(Level.INFO, "Name of food setted");
		// TODO -> DB
	}

	/**
	 * Getter of category
	 * @return category the food is in
	 */
	public final Category getCategory() {
		LOGGER.log(Level.INFO, "Category of food getted");
		return this.category;
	}

	/**
	 * Setter of category
	 * @param newCategory new category the food will be in
	 */
	public final void setCategory(final Category newCategory) {
		this.category = newCategory;
		LOGGER.log(Level.INFO, "Category of food setted");
		// TODO -> DB
	}

	/**
	 * Getter of purchase locations
	 * @return array of location containing the locations where this food can be bought
	 */
	public final ArrayList<Location> getPurchaseLocations() {
		LOGGER.log(Level.INFO, "Purchase locations of food getted");
		return this.purchaseLocations;
	}

	/**
	 * Adds a purchase location to the food's purchase locations
	 * @param purchaseLocationToAdd purchase location to add
	 */
	public final void addPurchaseLocation(final Location purchaseLocationToAdd) {
		if(forSell) {
			LOGGER.log(Level.INFO, "Purchase location added to food");
			this.purchaseLocations.add(purchaseLocationToAdd);
			purchaseLocationToAdd.addFood(this);
		} else {
			LOGGER.log(Level.WARNING, "A purchase location has tried to be added to a not for sell food!");
		}
		// TODO -> DB
	}

	/**
	 * Getter of is for sell
	 * @return true is the food is for sell, false otherwise
	 */
	public final boolean isForSell() {
		LOGGER.log(Level.INFO, "isForSell of food getted");
		return this.forSell;
	}

	/**
	 * Inverter of for sell.
	 * Changes the value of forSell attribute to the opposite
	 */
	public final void invertForSell() {
		this.forSell = !this.forSell;
		LOGGER.log(Level.INFO, "isForSell of food inverted. Now it is: " + this.forSell);
		// TODO -> DB
	}

	/**
	 * Getter of price
	 * @return price the food has
	 */
	public final float getPrice() {
		LOGGER.log(Level.INFO, "Price of food getted");
		return this.price;
	}

	/**
	 * Setter of price
	 * @param newPrice new price the food will have
	 */
	public final void setPrice(final float newPrice) {
		this.price = newPrice;
		LOGGER.log(Level.INFO, "Price of food setted");
		// TODO -> DB
	}

	/**
	 * Getter of creator
	 * @return creator of this food
	 */
	public final FoodCreator getCreator() {
		LOGGER.log(Level.INFO, "Creator of food getted");
		return this.creator;
	}
	
	/**
	 * Gets an array list of users wanting this food
	 * @return array list of users wanting this food
	 */
	public final ArrayList<User> getUsersWantingMe() {
		LOGGER.log(Level.INFO, "Users wanting food of food getted");
		return this.usersWantingMe;
	}
	
	/**
	 * Adds a user to the users wanting this food array
	 * @param userToAdd user to be added to the list
	 */
	public final void addUserToUsersWantingMe(final User userToAdd) {
		this.usersWantingMe.add(userToAdd);
		LOGGER.log(Level.INFO, "User added to list of users wanting this food");
		// TODO -> DB
	}
	
	/**
	 * Removes a user from the users wanting this food
	 * @param userToRemove user to be removed
	 */
	public final void removeUserFromUsersWantingMe(final User userToRemove) {
		this.usersWantingMe.remove(userToRemove);
		LOGGER.log(Level.INFO, "User removed from user wanting this food");
		// TODO -> DB
	}
}
