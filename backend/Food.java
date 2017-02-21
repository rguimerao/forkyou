package backend;

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
    private User creator;
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
            final User creator) {

        super();
        this.name     = name;
        this.category = category;
        this.forSell  = forSell;
        this.creator  = creator;
        this.price    = (price >= 0 ? price : -1);
        this.usersWantingMe    = new ArrayList<User>();
        this.purchaseLocations = new ArrayList<Location>();
        this.category.addFood(this);
    }
	
    /**
     * Obtains the ID from the DB
     */
    @Override
    public void obtainID() {
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
        return this.name;
    }

    /**
     * Setter of name
     * @param newName new name the food will have
     */
    public final void setName(final String newName) {
        this.name = newName;
        DataBaseController.getInstance().updateFoodName(getID(), newName);
    }

    /**
     * Getter of category
     * @return category the food is in
     */
    public final Category getCategory() {
        return this.category;
    }

    /**
     * Setter of category
     * @param newCategory new category the food will be in
     */
    public final void setCategory(final Category newCategory) {
        this.category.removeFood(this);
        this.category = newCategory;
        this.category.addFood(this);
        DataBaseController.getInstance().updateFoodCategory(getID(), newCategory.getID());
    }

    /**
     * Getter of purchase locations
     * @return array of location containing the locations where this food can be bought
     */
    public final ArrayList<Location> getPurchaseLocations() {
        return this.purchaseLocations;
    }

    /**
     * Adds a purchase location to the food's purchase locations
     * @param purchaseLocationToAdd purchase location to add
     */
    public final void addPurchaseLocation(final Location purchaseLocationToAdd) {
        if(forSell) {
            this.purchaseLocations.add(purchaseLocationToAdd);
            purchaseLocationToAdd.addFood(this);
            DataBaseController.getInstance().addFoodToLocation(getID(), purchaseLocationToAdd.getID());
        }
    }

    /**
     * Getter of is for sell
     * @return true is the food is for sell, false otherwise
     */
    public final boolean isForSell() {
        return this.forSell;
    }

    /**
     * Inverter of for sell.
     * Changes the value of forSell attribute to the opposite
     */
    public final void invertForSell() {
        this.forSell = !this.forSell;
        DataBaseController.getInstance().updateFoodForSell(getID(), this.forSell);
    }

    /**
     * Getter of price
     * @return price the food has
     */
    public final float getPrice() {
        return this.price;
    }

    /**
     * Setter of price
     * @param newPrice new price the food will have
     */
    public final void setPrice(final float newPrice) {
        if (this.forSell) {
            this.price = newPrice;
            DataBaseController.getInstance().updateFoodPrice(getID(), newPrice);
        }
    }

    /**
     * Getter of creator
     * @return creator of this food
     */
    public final User getCreator() {
        return this.creator;
    }
	
    /**
     * Gets an array list of users wanting this food
     * @return array list of users wanting this food
     */
    public final ArrayList<User> getUsersWantingMe() {
        return this.usersWantingMe;
    }
	
    /**
     * Adds a user to the users wanting this food array
     * @param userToAdd user to be added to the list
     */
    public final void addUserToUsersWantingMe(final User userToAdd) {
        this.usersWantingMe.add(userToAdd);
        DataBaseController.getInstance().addUserWantingFood(getID(), userToAdd.getID());
    }
	
    /**
     * Removes a user from the users wanting this food
     * @param userToRemove user to be removed
     */
    public final void removeUserFromUsersWantingMe(final User userToRemove) {
        this.usersWantingMe.remove(userToRemove);
        DataBaseController.getInstance().deleteUserWantingFood(getID(), userToRemove.getID());
    }
	
    /**
     * Accepts a rate by telling the rater to rate myself
     * @param rater rater to execute the rate
     * @param rating rating given
     * @param userID userId rating
     */
    public void acceptRate(final int rating, final int userID) {
        Rater.rate(this, rating, userID);
    }
}
