package backend;

/**
 * TODO
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
	 * TODO
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
	 * TODO
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * TODO
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * TODO
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * TODO
	 */
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	/**
	 * TODO
	 */
	public String getStreet() {
		return this.street;
	}

	/**
	 * TODO
	 */
	public void setStreet(String newStreet) {
		this.street = newStreet;
	}

	/**
	 * TODO
	 */
	public int getPostalCode() {
		return this.postalCode;
	}

	/**
	 * TODO
	 */
	public void setPostalCode(int newPostalCode) {
		this.postalCode = newPostalCode;
	}

	/**
	 * TODO
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * TODO
	 */
	public void setCity(String newCity) {
		this.city = newCity;
	}

	/**
	 * TODO
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * TODO
	 */
	public void setCountry(String newCountry) {
		this.city = newCountry;
	}

	/**
	 * TODO
	 */
	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * TODO
	 */
	public void setPhoneNumber(int newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	/**
	 * TODO
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * TODO
	 */
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

}
