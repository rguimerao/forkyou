package backend;

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
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		String country,
		int phoneNumber,
		String email) {

		super();
		this.name        = name;
		this.description = description;
		this.street      = street;
		this.postalCode  = postalCode;
		this.city        = city;
		this.country     = country;
		this.phoneNumber = phoneNumber;
		this.email       = email;
	}

	/**
	 * Getter of name
	 * @return name of the contact
	 */
	protected String getName() {
		return this.name;
	}

	/**
	 * Setter of name
	 * @param newName new name the contact will have
	 */
	protected void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Getter of description
	 * @return description of the contact
	 */
	protected String getDescription() {
		return this.description;
	}

	/**
	 * Setter of description
	 * @param newDescription new description the contact will have
	 */
	protected void setDescription(String newDescription) {
		this.description = newDescription;
	}

	/**
	 * Getter of street
	 * @return street of the contact
	 */
	protected String getStreet() {
		return this.street;
	}

	/**
	 * Setter of street
	 * @param newStreet new street the contact will have
	 */
	protected void setStreet(String newStreet) {
		this.street = newStreet;
	}

	/**
	 * Getter of postal code
	 * @return postal code of the contact
	 */
	protected int getPostalCode() {
		return this.postalCode;
	}

	/**
	 * Setter of postal code
	 * @param newPostalCode new postal code the contact will have
	 */
	protected void setPostalCode(int newPostalCode) {
		this.postalCode = newPostalCode;
	}

	/**
	 * Getter of city
	 * @return city of the contact
	 */
	protected String getCity() {
		return this.city;
	}

	/**
	 * Setter of city
	 * @param newCity new city the contact will have
	 */
	protected void setCity(String newCity) {
		this.city = newCity;
	}

	/**
	 * Getter of country
	 * @return country of the contact
	 */
	protected String getCountry() {
		return this.country;
	}

	/**
	 * Setter of country
	 * @param newCountry new country of the contact
	 */
	protected void setCountry(String newCountry) {
		this.city = newCountry;
	}

	/**
	 * Getter of phone number
	 * @return phone number of the contact
	 */
	protected int getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Setter of phone number
	 * @param newPhoneNumber new phone number the contact will have
	 */
	protected void setPhoneNumber(int newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	/**
	 * Getter of email
	 * @return email of the contact
	 */
	protected String getEmail() {
		return this.email;
	}

	/**
	 * Setter of email
	 * @param newEmail new email the contact will have
	 */
	protected void setEmail(String newEmail) {
		this.email = newEmail;
	}

}
