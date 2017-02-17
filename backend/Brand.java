package backend;

import DB_controllers.DataBaseController;
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
		DataBaseController.getInstance().updateBrandWebsite(getID(), newWebsite);
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
	 * Creates a new location where food is bought and sold of this brand
	 * @param name name of the location
	 * @param description description of the location
	 * @param street street of the location
	 * @param areaCode area code of the location
	 * @param city city of the location
	 * @param country country of the location
	 * @param phone phone number of the location
	 * @param email email of the location
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
		final Brand owner) {
		
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
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 */
	public final void acceptRate(final int rating, final int userID) {
		Rater.rate(this, rating, userID);
	}
}
