package backend;

import DB_controllers.DataBaseController;
import java.sql.SQLException;

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

	/**
	 * Constructor of contact info
	 * @param name Name of the contact
	 * @param description Description of the contact
	 * @param street Street where the contact lives
	 * @param areaCode Area code of the street
	 * @param city City of the contact
	 * @param country Country of the contact
	 * @param phone Phone number of the contact
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
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID() {
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
		return this.name;
	}

	/**
	 * Setter of name
	 * @param newName new name the contact will have
	 */
	public final void setName(final String newName) {
		this.name = newName;
		DataBaseController.getInstance().updateNameContactInfo(getID(), newName);
	}

	/**
	 * Getter of description
	 * @return description of the contact
	 */
	public final String getDescription() {
		return this.description;
	}

	/**
	 * Setter of description
	 * @param newDescription new description the contact will have
	 */
	public final void setDescription(final String newDescription) {
		this.description = newDescription;
		DataBaseController.getInstance().updateDescriptionContactInfo(getID(), newDescription);
	}

	/**
	 * Getter of street
	 * @return street of the contact
	 */
	public final String getStreet() {
		return this.street;
	}

	/**
	 * Setter of street
	 * @param newStreet new street the contact will have
	 */
	public final void setStreet(final String newStreet) {
		this.street = newStreet;
		DataBaseController.getInstance().updateStreetContactInfo(getID(), newStreet);
	}

	/**
	 * Getter of area code
	 * @return area code of the contact
	 */
	public final int getAreaCode() {
		return this.areaCode;
	}

	/**
	 * Setter of area code
	 * @param newAreaCode new area code the contact will have
	 */
	public final void setAreaCode(final int newAreaCode) {
		this.areaCode = newAreaCode;
		DataBaseController.getInstance().updateAreaCodeContactInfo(getID(), newAreaCode);
	}

	/**
	 * Getter of city
	 * @return city of the contact
	 */
	public final String getCity() {
		return this.city;
	}

	/**
	 * Setter of city
	 * @param newCity new city the contact will have
	 */
	public final void setCity(final String newCity) {
		this.city = newCity;
		DataBaseController.getInstance().updateCityContactInfo(getID(), newCity);
	}

	/**
	 * Getter of country
	 * @return country of the contact
	 */
	public final String getCountry() {
		return this.country;
	}

	/**
	 * Setter of country
	 * @param newCountry new country of the contact
	 */
	public final void setCountry(final String newCountry) {
		this.city = newCountry;
		DataBaseController.getInstance().updateCountryContactInfo(getID(), newCountry);
	}

	/**
	 * Getter of phone number
	 * @return phone number of the contact
	 */
	public final int getPhone() {
		return this.phone;
	}

	/**
	 * Setter of phone
	 * @param newPhone new phone number the contact will have
	 */
	public final void setPhone(final int newPhone) {
		this.phone = newPhone;
		DataBaseController.getInstance().updatePhoneContactInfo(getID(), newPhone);
	}

	/**
	 * Getter of email
	 * @return email of the contact
	 */
	public final String getEmail() {
		return this.email;
	}

	/**
	 * Setter of email
	 * @param newEmail new email the contact will have
	 */
	public final void setEmail(final String newEmail) {
		this.email = newEmail;
		DataBaseController.getInstance().updateEmailContactInfo(getID(), newEmail);
	}
}
