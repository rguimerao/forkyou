package backend;

import DB_controllers.DataBaseController;
import testing.myLogger;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class brand
 * A brand is a food creator. A brand represents "legal" food creator.
 * @author rguimerao
 *
 */
public class Brand extends FoodCreator {

	private ArrayList<Location> sellLocations;
	private String website;

	/**
	 * Constructor of brand.
	 * @param name name of the brand
	 * @param description description of the brand
	 * @param street street of the brand
	 * @param areaCode area code of the brand
	 * @param city city of the brand
	 * @param country country of the brand
	 * @param phone phone number of the brand
	 * @param email email of the brand
	 */
	public Brand(
		final String name,
        final String description,
        final String street,
        final int areaCode,
        final String city,
        final String country,
        final int phone,
        final String email,
        final String website) {

		super(name, description, street, areaCode, city, country, phone, email);
		this.sellLocations = new ArrayList<Location>();
		this.website       = website;
		myLogger.getInstance().info("A new brand has been created with name: " + name);
	}
	
	/**
	 * Gets brand website
	 * @return website of the brand
	 */
	public final String getWebsite() {
	    myLogger.getInstance().info("Website of brand getted");
		return this.website;
	}
	
	/**
	 * Sets a new website of the brand
	 * @param newWebsite new website of the brand
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setWebsite(final String newWebsite) 
			throws ClassNotFoundException, SQLException {
		this.website = newWebsite;
		myLogger.getInstance().info("Website of brand setted");
		DataBaseController.getInstance().updateBrandWebsite(getID(), newWebsite);
	}

	/**
	 * Getter of sell locations
	 * @return location where the brand sells food
	 */
	public final ArrayList<Location> getSellLocations() {
	    myLogger.getInstance().info("Sell locations from brand: " + getName() + " has been getted");
		return this.sellLocations;
	}

	/**
	 * Add a new location to the sellLocations array
	 * @param newLocation new location to add to the array
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void addSellLocation(final Location newLocation) 
			throws SQLException, ClassNotFoundException {
		this.sellLocations.add(newLocation);
		if (newLocation.getOwner() != this) {
			newLocation.setOwner(this);
		}
		myLogger.getInstance().info("A new location has been added to the brand");
	}
	
	/**
	 * Creates a new location where food is bought and sold of this brand
	 * @param name name of the location
	 * @param description description of the location
	 * @param street street of the location
	 * @param areaCode area code of the location
	 * @param city city of the location
	 * @param country country of the location
	 * @param phone phone number of the location
	 * @param email email of the location
	 * @throws SQLException if a DB error occurs
	 */
	@Override
	public final void createLocation(
		final String name,
		final String description,
		final String street,
		final int areaCode,
		final String city,
		final String country,
		final int phone,
		final String email,
		final Brand owner) 
				throws SQLException {
		
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
						this);
		
		DataBaseController.getInstance().createNewContactInfo(newLocation);
		newLocation.obtainID();
		DataBaseController.getInstance().createNewLocation(newLocation);
		myLogger.getInstance().info("Location created on brand");
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 * @throws SQLException if a DB error occurs
	 */
	public final void acceptRate(final int rating, final int userID) 
			throws SQLException {
		Rater.getInstance().rate(this, rating, userID);
		myLogger.getInstance().info("A brand has accepted a rating");
	}
}
