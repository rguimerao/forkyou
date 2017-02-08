package backend;

import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Class brand
 * A brand is a food creator. A brand represents "legal" food creator.
 * @author rguimerao
 *
 */
public class Brand extends FoodCreator {

	private ArrayList<Location> sellLocations;
	private String website;
	private static final Logger LOGGER = Logger.getLogger("Brand");

	/**
	 * Constructor of brand.
	 * @param name name of the brand
	 * @param description description of the brand
	 * @param street street of the brand
	 * @param postalCode postal code of the brand
	 * @param city city of the brand
	 * @param country country of the brand
	 * @param phoneNumber phone number of the brand
	 * @param email email of the brand
	 */
	public Brand(
		final String name,
        final String description,
        final String street,
        final int postalCode,
        final String city,
        final String country,
        final int phoneNumber,
        final String email,
        final String website) {

		super(name, description, street, postalCode, city, country, phoneNumber, email);
		this.sellLocations = new ArrayList<Location>();
		this.website       = website;
		LOGGER.log(Level.INFO, "A new brand has been created with name: " + name);
	}
	
	/**
	 * Obtains the ID from the DB
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void obtainID(DataBaseController dbController) 
			throws ClassNotFoundException, SQLException {
		
		LOGGER.log(Level.INFO, "obtainID in Brand");
		setID(dbController.obtainID(this));
	}
	
	/**
	 * Gets brand website
	 * @return website of the brand
	 */
	public final String getWebsite() {
		LOGGER.log(Level.INFO, "Website of brand getted");
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
		LOGGER.log(Level.INFO, "Website of brand setted");
		DataBaseController.getInstance().updateBrandWebsite(getID(), newWebsite);
	}

	/**
	 * Getter of sell locations
	 * @return location where the brand sells food
	 */
	public final ArrayList<Location> getSellLocations() {
		LOGGER.log(Level.INFO, "Sell locations from brand: " + getName() + " has been getted");
		return this.sellLocations;
	}

	/**
	 * Add a new location to the sellLocations array
	 * @param newLocation new location to add to the array
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void addSellLocation(final Location newLocation) 
			throws ClassNotFoundException, SQLException {
		this.sellLocations.add(newLocation);
		if (newLocation.getOwner() != this) {
			newLocation.setOwner(this);
		}
		LOGGER.log(Level.INFO, "A new location has been added to the brand");
	}
	
	/**
	 * Creates a new location where food is bought and sold of this brand
	 * @param name name of the location
	 * @param description description of the location
	 * @param street street of the location
	 * @param postalCode postal code of the location
	 * @param city city of the location
	 * @param country country of the location
	 * @param phoneNumber phone number of the location
	 * @param email email of the location
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public final void createLocation(
		final String name,
		final String description,
		final String street,
		final int postalCode,
		final String city,
		final String country,
		final int phoneNumber,
		final String email,
		final Brand owner) 
				throws ClassNotFoundException, SQLException {
		
		ContactInfo newLocation = 
				new Location(
						name, 
						description, 
						street, 
						postalCode, 
						city, 
						country, 
						phoneNumber, 
						email, 
						this);
		
		DataBaseController dbController = DataBaseController.getInstance();
		dbController.createNewContactInfo(newLocation);
		newLocation.setID(dbController.obtainID(newLocation));
		dbController.createNewLocation((Location) newLocation);
		
		LOGGER.log(Level.INFO, "Location created on brand");
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void acceptRate(final Rater rater, final int rating, final int userID) 
			throws ClassNotFoundException, SQLException {
		rater.rate(this, rating, userID);
		LOGGER.log(Level.INFO, "A brand has accepted a rating");
	}
}
