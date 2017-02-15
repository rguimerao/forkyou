package backend;

import testing.MyLogger;
import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.ArrayList;

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
		this.price    = (price >= 0 ? price : -1);
		this.usersWantingMe    = new ArrayList<User>();
		this.purchaseLocations = new ArrayList<Location>();
		this.category.addFood(this);
		MyLogger.info("A new food with name: " + name + " has been created");
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID() {
	    MyLogger.info("obtainID in Food");
		try {
            setID(DataBaseController.getInstance().obtainID(this));
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Getter of name
	 * @return name of the food
	 */
	public final String getName() {
	    MyLogger.info("Name of food has been requested");
		return this.name;
	}

	/**
	 * Setter of name
	 * @param newName new name the food will have
	 * @throws SQLException if a DB error occurs
	 */
	public final void setName(final String newName) 
	        throws SQLException {
		this.name = newName;
		MyLogger.info("Name of food setted");
		DataBaseController.getInstance().updateFoodName(getID(), newName);
	}

	/**
	 * Getter of category
	 * @return category the food is in
	 */
	public final Category getCategory() {
	    MyLogger.info("Category of food getted");
		return this.category;
	}

	/**
	 * Setter of category
	 * @param newCategory new category the food will be in
	 * @throws SQLException if a DB error occurs
	 */
	public final void setCategory(final Category newCategory) 
	        throws SQLException {
	    this.category.removeFood(this);
		this.category = newCategory;
		this.category.addFood(this);
		MyLogger.info("Category of food setted");
		DataBaseController.getInstance().updateFoodCategory(getID(), newCategory.getID());
	}

	/**
	 * Getter of purchase locations
	 * @return array of location containing the locations where this food can be bought
	 */
	public final ArrayList<Location> getPurchaseLocations() {
	    MyLogger.info("Purchase locations of food getted");
		return this.purchaseLocations;
	}

	/**
	 * Adds a purchase location to the food's purchase locations
	 * @param purchaseLocationToAdd purchase location to add
	 * @throws SQLException if a DB error occurs
	 */
	public final void addPurchaseLocation(final Location purchaseLocationToAdd) 
	        throws SQLException {
		if(forSell) {
		    MyLogger.info("Purchase location added to food");
			this.purchaseLocations.add(purchaseLocationToAdd);
			purchaseLocationToAdd.addFood(this);
			DataBaseController.getInstance().addFoodToLocation(getID(), purchaseLocationToAdd.getID());
		} else {
		    MyLogger.warning("A purchase location has tried to be added to a not for sell food!");
		}
	}

	/**
	 * Getter of is for sell
	 * @return true is the food is for sell, false otherwise
	 */
	public final boolean isForSell() {
	    MyLogger.info("isForSell of food getted");
		return this.forSell;
	}

	/**
	 * Inverter of for sell.
	 * Changes the value of forSell attribute to the opposite
	 * @throws SQLException if a DB error occurs
	 */
	public final void invertForSell() 
	        throws SQLException {
		this.forSell = !this.forSell;
		MyLogger.info("isForSell of food inverted. Now it is: " + this.forSell);
		DataBaseController.getInstance().updateFoodForSell(getID(), this.forSell);
	}

	/**
	 * Getter of price
	 * @return price the food has
	 */
	public final float getPrice() {
	    MyLogger.info("Price of food getted");
		return this.price;
	}

	/**
	 * Setter of price
	 * @param newPrice new price the food will have
	 * @throws SQLException if a DB error occurs
	 */
	public final void setPrice(final float newPrice) 
	        throws SQLException {
	    if (this.forSell) {
	        this.price = newPrice;
	        DataBaseController.getInstance().updateFoodPrice(getID(), newPrice);
	    }
		MyLogger.info("Price of food setted");
	}

	/**
	 * Getter of creator
	 * @return creator of this food
	 */
	public final FoodCreator getCreator() {
	    MyLogger.info("Creator of food getted");
		return this.creator;
	}
	
	/**
	 * Gets an array list of users wanting this food
	 * @return array list of users wanting this food
	 */
	public final ArrayList<User> getUsersWantingMe() {
	    MyLogger.info("Users wanting food of food getted");
		return this.usersWantingMe;
	}
	
	/**
	 * Adds a user to the users wanting this food array
	 * @param userToAdd user to be added to the list
	 * @throws SQLException if a DB error occurs
	 */
	public final void addUserToUsersWantingMe(final User userToAdd) 
	        throws SQLException {
		this.usersWantingMe.add(userToAdd);
		MyLogger.info("User added to list of users wanting this food");
		DataBaseController.getInstance().addUserWantingFood(getID(), userToAdd.getID());
	}
	
	/**
	 * Removes a user from the users wanting this food
	 * @param userToRemove user to be removed
	 * @throws SQLException 
	 */
	public final void removeUserFromUsersWantingMe(final User userToRemove) 
	        throws SQLException {
		this.usersWantingMe.remove(userToRemove);
		MyLogger.info("User removed from user wanting this food");
		DataBaseController.getInstance().deleteUserWantingFood(getID(), userToRemove.getID());
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 * @throws SQLException 
	 */
	public void acceptRate(final int rating, final int userID) 
	        throws SQLException {
		Rater.rate(this, rating, userID);
		MyLogger.info("A food has accepted a rating");
	}
}
