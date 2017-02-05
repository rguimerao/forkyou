package backend;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB_controllers.DataBaseController;

/**
 * Class contact info.
 * Has information about the contact to localize it.
 * @author rguimerao
 *
 */
public class ContactInfo extends Identifier {

	private String name;
	private String description;
	private String street;
	private int postalCode;
	private String city;
	private String country;
	private int phoneNumber;
	private String email;
	private static final Logger LOGGER = Logger.getLogger("ContactInfo");

	/**
	 * Constructor of contact info
	 * @param name Name of the contact
	 * @param description Description of the contact
	 * @param street Street where the contact lives
	 * @param postalCode Postal code of the street
	 * @param city City of the contact
	 * @param country Country of the contact
	 * @param phoneNumber Phone number of the contact
	 * @param email Email of the contact
	 */
	public ContactInfo(
		final String name,
		final String description,
		final String street,
		final int postalCode,
		final String city,
		final String country,
		final int phoneNumber,
		final String email) {

		super();
		this.name        = name;
		this.description = description;
		this.street      = street;
		this.postalCode  = postalCode;
		this.city        = city;
		this.country     = country;
		this.phoneNumber = phoneNumber;
		this.email       = email;
		LOGGER.log(Level.INFO, "A new contact info has been created");
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID(final DataBaseController dbController) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "obtainID in ContactInfo");
		// TODO -> DB
	}

	/**
	 * Getter of name
	 * @return name of the contact
	 */
	public final String getName() {
		LOGGER.log(Level.INFO, "Name of contact info has been getted");
		return this.name;
	}

	/**
	 * Setter of name
	 * @param newName new name the contact will have
	 */
	public final void setName(final String newName) {
		this.name = newName;
		LOGGER.log(Level.INFO, "Name of contact info has been setted");
		// TODO -> DB
	}

	/**
	 * Getter of description
	 * @return description of the contact
	 */
	public final String getDescription() {
		LOGGER.log(Level.INFO, "Description of contact info has been getted");
		return this.description;
	}

	/**
	 * Setter of description
	 * @param newDescription new description the contact will have
	 */
	public final void setDescription(final String newDescription) {
		this.description = newDescription;
		LOGGER.log(Level.INFO, "Description of contact info has been setted");
		// TODO -> DB
	}

	/**
	 * Getter of street
	 * @return street of the contact
	 */
	public final String getStreet() {
		LOGGER.log(Level.INFO, "Street of contact info has been getted");
		return this.street;
	}

	/**
	 * Setter of street
	 * @param newStreet new street the contact will have
	 */
	public final void setStreet(final String newStreet) {
		this.street = newStreet;
		LOGGER.log(Level.INFO, "Street of contact info has been setted");
		// TODO -> DB
	}

	/**
	 * Getter of postal code
	 * @return postal code of the contact
	 */
	public final int getPostalCode() {
		LOGGER.log(Level.INFO, "Postal code of contact info has been getted");
		return this.postalCode;
	}

	/**
	 * Setter of postal code
	 * @param newPostalCode new postal code the contact will have
	 */
	public final void setPostalCode(final int newPostalCode) {
		this.postalCode = newPostalCode;
		LOGGER.log(Level.INFO, "Postal code of contact info has been setted");
		// TODO -> DB
	}

	/**
	 * Getter of city
	 * @return city of the contact
	 */
	public final String getCity() {
		LOGGER.log(Level.INFO, "City of contact info has been getted");
		return this.city;
	}

	/**
	 * Setter of city
	 * @param newCity new city the contact will have
	 */
	public final void setCity(final String newCity) {
		this.city = newCity;
		LOGGER.log(Level.INFO, "City of contact info has been setted");
		// TODO -> DB
	}

	/**
	 * Getter of country
	 * @return country of the contact
	 */
	public final String getCountry() {
		LOGGER.log(Level.INFO, "Country of contact info has been getted");
		return this.country;
	}

	/**
	 * Setter of country
	 * @param newCountry new country of the contact
	 */
	public final void setCountry(final String newCountry) {
		this.city = newCountry;
		LOGGER.log(Level.INFO, "Country of contact info has been setted");
		// TODO -> DB
	}

	/**
	 * Getter of phone number
	 * @return phone number of the contact
	 */
	public final int getPhoneNumber() {
		LOGGER.log(Level.INFO, "Phone number of contact info has been getted");
		return this.phoneNumber;
	}

	/**
	 * Setter of phone number
	 * @param newPhoneNumber new phone number the contact will have
	 */
	public final void setPhoneNumber(final int newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
		LOGGER.log(Level.INFO, "Phone number of contact info has been setted");
		// TODO -> DB
	}

	/**
	 * Getter of email
	 * @return email of the contact
	 */
	public final String getEmail() {
		LOGGER.log(Level.INFO, "Email of contact info has been getted");
		return this.email;
	}

	/**
	 * Setter of email
	 * @param newEmail new email the contact will have
	 */
	public final void setEmail(final String newEmail) {
		this.email = newEmail;
		LOGGER.log(Level.INFO, "Email of contact info has been setted");
		// TODO -> DB
	}

}
