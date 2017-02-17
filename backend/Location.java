package backend;

import DB_controllers.DataBaseController;
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
    }
	
    /**
     * Getter of foods selling
     * @return array of the foods being sold in this location
     */
    public final ArrayList<Food> getFoodsSelling() {
        return this.foodsSelling;
    }
	
    /**
     * Adds a food to the selling foods array
     * @param foodToAdd food to add
     */
    protected final void addFood(final Food foodToAdd) {
        this.foodsSelling.add(foodToAdd);
    }
	
    /**
     * Gets the location owner
     * @return brand owner of this location
     */
    public final Brand getOwner() {
        return this.owner;
    }
	
    /**
     * Sets a new brand owner for this location
     * @param newOwner new brand owner for the location
     */
    public final void setOwner(final Brand newOwner) {
        if (newOwner.getID() != this.owner.getID()) {
            this.owner = newOwner;
            DataBaseController.getInstance().updateLocationOwner(getID(), newOwner.getID());   
        }
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
