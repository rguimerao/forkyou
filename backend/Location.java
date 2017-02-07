package backend;

import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class location.
 * A location is where you buy and/or sell food
 * @author rguimera
 *
 */
public class Location extends ContactInfo {

    private ArrayList<Food> foodsSelling;
    private Brand owner;
    private static final Logger LOGGER = Logger.getLogger("Location");
	
    /**
     * Constructor of location
     * @param name name of the location
     * @param description description of the location
     * @param street street of the location
     * @param postalCode postal code of the location
     * @param city city of the location
     * @param country country of the location
     * @param phoneNumber phone number of the location
     * @param email email of the location
     * @param owner brand owner of this location
     */
    public Location(
            final String name,
            final String description,
            final String street,
            final int postalCode,
            final String city,
            final String country,
            final int phoneNumber,
            final String email,
            final Brand owner) {

        super(name, description, street, postalCode, city, country, phoneNumber, email);
        this.foodsSelling = new ArrayList<Food>();
        this.owner = owner;
        LOGGER.log(Level.INFO, "A new location has been created");
    }
	
    /**
     * Obtains the ID from the DB
     */
    @Override
    public void obtainID(final DataBaseController dbController) {
        LOGGER.log(Level.INFO, "obtainID in Location");
        // TODO -> DB
    }
	
    /**
     * Getter of foods selling
     * @return array of the foods being sold in this location
     */
    public final ArrayList<Food> getFoodsSelling() {
        LOGGER.log(Level.INFO, "Foods selling in this location getted");
        return this.foodsSelling;
    }
	
    /**
     * Adds a food to the selling foods array
     * @param foodToAdd food to add
     */
    public final void addFood(final Food foodToAdd) {
        this.foodsSelling.add(foodToAdd);
        LOGGER.log(Level.INFO, "A new food has been added to foods selling in this location");
        // TODO -> DB
    }
	
    /**
     * Gets the location owner
     * @return brand owner of this location
     */
    public final Brand getOwner() {
        LOGGER.log(Level.INFO, "Owner from location getted");
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
        LOGGER.log(Level.INFO, "New owner from location setted");
        DataBaseController dbController = null;
        dbController = dbController.getInstance();
        dbController.updateLocationOwner(this.ID, newOwner.getID());
    }
	
    /**
     * Accepts a rate by telling the rater to rate myself
     * @param rater rater to execute the rate
     * @param rating rating given
     * @param userID userId rating
     */
    public void acceptRate(final Rater rater, final int rating, final int userID) {
        rater.rate(this, rating, userID);
        LOGGER.log(Level.INFO, "A location has accepted a rating");
        // TODO -> DB
    }
}
