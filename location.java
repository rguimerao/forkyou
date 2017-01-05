package backend;

public class Location extends ContactInfo {

	// TODO -> ratings attribute

  public Location(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		int phoneNumber,
		String email) {

		super(name, description, street, postalCode, city, phoneNumber, email);
	}


}
