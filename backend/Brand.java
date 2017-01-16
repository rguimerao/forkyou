package backend;

import java.util.ArrayList;

/**
 * Class brand
 * A brand is a food creator. A brand represents "legal" food creator.
 * @author rguimerao
 *
 */
public class Brand extends FoodCreator {

	private ArrayList<Location> sellLocations;

	/**
	 * Constructor of brand
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
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		String country,
		int phoneNumber,
		String email) {

		super(name, description, street, postalCode, city, country, phoneNumber, email);
		sellLocations = new ArrayList<Location>();
	}

	/**
	 * Getter of sell locations
	 * @return location where the brand sells food
	 */
	public ArrayList<Location> getSellLocations() {
		return this.sellLocations;
	}

	/**
	 * Add a new location to the sellLocations array
	 * @param newLocation new location to add to the array
	 */
	public void addSellLocation(Location newLocation) {
		this.sellLocations.add(newLocation);
		if (newLocation.getOwner() != this) {
			newLocation.setOwner(this);
		}
	}
}
