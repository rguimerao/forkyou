package backend;

public class ContactInfo extends Identifier {

	protected String name;
	protected String description;
	protected String street;
	protected int postalCode;
	protected String city;
	protected int phoneNumber;
	protected String email;

  public ContactInfo(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		int phoneNumber,
		String email) {

		super();
		this.name        = name;
		this.description = description;
		this.street      = street;
		this.postalCode  = postalCode;
		this.city        = city;
		this.phoneNumber = phoneNumber;
		this.email       = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String newStreet) {
		this.street = newStreet;
	}

	public int getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(int newPostalCode) {
		this.postalCode = newPostalCode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String newCity) {
		this.city = newCity;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

}
