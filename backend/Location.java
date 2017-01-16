package backend;

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
	 * @param postalCode postal code of the location
	 * @param city city of the location
	 * @param country country of the location
	 * @param phoneNumber phone number of the location
	 * @param email email of the location
	 * @param owner brand owner of this location
	 */
	public Location(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		String country,
		int phoneNumber,
		String email,
		Brand owner) {

		super(name, description, street, postalCode, city, country, phoneNumber, email);
		this.foodsSelling = new ArrayList<Food>();
		this.owner = owner;
	}
	
	/**
	 * Getter of foods selling
	 * @return array of the foods being sold in this location
	 */
	public ArrayList<Food> getFoodsSelling() {
		return this.foodsSelling;
	}
	
	/**
	 * Adds a food to the selling foods array
	 * @param foodToAdd food to add
	 */
	public void addFood(Food foodToAdd) {
		this.foodsSelling.add(foodToAdd);
	}
	
	/**
	 * Gets the location owner
	 * @return brand owner of this location
	 */
	public Brand getOwner() {
		return this.owner;
	}
	
	/**
	 * Sets a new brand owner for this location
	 * @param newOwner new brand owner for the location
	 */
	public void setOwner(Brand newOwner) {
		this.owner = newOwner;
	}
}
