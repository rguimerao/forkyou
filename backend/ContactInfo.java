package backend;

import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private int areaCode;
	private String city;
	private String country;
	private int phone;
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
		final int areaCode,
		final String city,
		final String country,
		final int phone,
		final String email) {

		super();
		this.name        = name;
		this.description = description;
		this.street      = street;
		this.areaCode    = areaCode;
		this.city        = city;
		this.country     = country;
		this.phone       = phone;
		this.email       = email;
		LOGGER.log(Level.INFO, "A new contact info has been created");
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID() {
		LOGGER.log(Level.INFO, "obtainID in ContactInfo");
		try {
            setID(DataBaseController.getInstance().obtainID(this));
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setName(final String newName) 
	        throws SQLException {
		this.name = newName;
		LOGGER.log(Level.INFO, "Name of contact info has been setted");
		DataBaseController.getInstance().updateNameContactInfo(getID(), newName);
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setDescription(final String newDescription) 
	        throws SQLException {
		this.description = newDescription;
		LOGGER.log(Level.INFO, "Description of contact info has been setted");
		DataBaseController.getInstance().updateDescriptionContactInfo(getID(), newDescription);
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setStreet(final String newStreet) 
	        throws SQLException {
		this.street = newStreet;
		LOGGER.log(Level.INFO, "Street of contact info has been setted");
		DataBaseController.getInstance().updateStreetContactInfo(getID(), newStreet);
	}

	/**
	 * Getter of postal code
	 * @return postal code of the contact
	 */
	public final int getAreaCode() {
		LOGGER.log(Level.INFO, "Postal code of contact info has been getted");
		return this.areaCode;
	}

	/**
	 * Setter of postal code
	 * @param newPostalCode new postal code the contact will have
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setAreaCode(final int newAreaCode) 
	        throws SQLException {
		this.areaCode = newAreaCode;
		LOGGER.log(Level.INFO, "Postal code of contact info has been setted");
		DataBaseController.getInstance().updateAreaCodeContactInfo(getID(), newAreaCode);
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setCity(final String newCity) 
	        throws SQLException {
		this.city = newCity;
		LOGGER.log(Level.INFO, "City of contact info has been setted");
		DataBaseController.getInstance().updateCityContactInfo(getID(), newCity);
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setCountry(final String newCountry) 
	        throws SQLException {
		this.city = newCountry;
		LOGGER.log(Level.INFO, "Country of contact info has been setted");
		DataBaseController.getInstance().updateCountryContactInfo(getID(), newCountry);
	}

	/**
	 * Getter of phone number
	 * @return phone number of the contact
	 */
	public final int getPhone() {
		LOGGER.log(Level.INFO, "Phone number of contact info has been getted");
		return this.phone;
	}

	/**
	 * Setter of phone number
	 * @param newPhoneNumber new phone number the contact will have
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setPhone(final int newPhone) 
	        throws SQLException {
		this.phone = newPhone;
		LOGGER.log(Level.INFO, "Phone number of contact info has been setted");
		DataBaseController.getInstance().updatePhoneContactInfo(getID(), newPhone);
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final void setEmail(final String newEmail)
	        throws SQLException {
		this.email = newEmail;
		LOGGER.log(Level.INFO, "Email of contact info has been setted");
		DataBaseController.getInstance().updateEmailContactInfo(getID(), newEmail);
	}

}
