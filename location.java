package backend;

/**
 * TODO
 */
public class Location extends ContactInfo {

	// TODO -> ratings attribute

  /**
   * TODO
   */
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

  /**
   * TODO
   */
  public void obtainRating() {
    // TODO -> call DB controller to obtain ratings
  }

}
