package backend;

import DB_controllers.DataBaseController;
import testing.MyLogger;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class location.
 * A location is where you buy and/or sell food
 * @author rguimera
 *
 */
public class Location extends ContactInfo {

    private ArrayList<Food> foodsSelling;
    private Brand owner;
	
    /**
     * Constructor of location
     * @param name name of the location
     * @param description description of the location
     * @param street street of the location
     * @param areaCode area code of the location
     * @param city city of the location
     * @param country country of the location
     * @param phone phone number of the location
     * @param email email of the location
     * @param owner brand owner of this location
     */
    public Location(
            final String name,
            final String description,
            final String street,
            final int areaCode,
            final String city,
            final String country,
            final int phone,
            final String email,
            final Brand owner) {

        super(name, description, street, areaCode, city, country, phone, email);
        this.foodsSelling = new ArrayList<Food>();
        this.owner        = owner;
        MyLogger.info("A new location has been created");
    }
	
    /**
     * Getter of foods selling
     * @return array of the foods being sold in this location
     */
    public final ArrayList<Food> getFoodsSelling() {
        MyLogger.info("Foods selling in this location getted");
        return this.foodsSelling;
    }
	
    /**
     * Adds a food to the selling foods array
     * @param foodToAdd food to add
     */
    protected final void addFood(final Food foodToAdd) {
        this.foodsSelling.add(foodToAdd);
        MyLogger.info("A new food has been added to foods selling in this location");
    }
	
    /**
     * Gets the location owner
     * @return brand owner of this location
     */
    public final Brand getOwner() {
        MyLogger.info("Owner from location getted");
        return this.owner;
    }
	
    /**
     * Sets a new brand owner for this location
     * @param newOwner new brand owner for the location
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public final void setOwner(final Brand newOwner) 
            throws ClassNotFoundException, SQLException {
        this.owner = newOwner;
        MyLogger.info("New owner from location setted");
        DataBaseController.getInstance().updateLocationOwner(getID(), newOwner.getID());
    }
	
    /**
     * Accepts a rate by telling the rater to rate myself
     * @param rater rater to execute the rate
     * @param rating rating given
     * @param userID userId rating
     * @throws SQLException if a DB error occurs
     */
    public void acceptRate(final int rating, final int userID) 
            throws SQLException {
        Rater.rate(this, rating, userID);
        MyLogger.info("A location has accepted a rating");
    }
}
