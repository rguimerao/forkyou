package backend;

/**
 * TODO
 */
public class Brand extends FoodCreator {

	private ArrayList<Location> sellLocations;

	/**
	 * TODO
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
	 * TODO
	 */
	public ArrayList<Location> getSellLocations() {
		return this.sellLocations;
	}

	/**
	 * TODO
	 */
	public void addSellLocation(Location newLocation) {
		this.sellLocations.add(newLocation, this.sellLocations.size());
	}

	/**
	 * TODO
	 */
	public void obtainRating() {
		// TODO -> call DB controller to obtain ratings
	}
}
