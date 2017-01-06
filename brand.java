package backend;

public class Brand extends FoodCreator {

	private ArrayList<Location> sellLocations;

	// TODO -> actions a brand can do

  public Brand(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		int phoneNumber,
		String email) {

		super(name, description, street, postalCode, city, phoneNumber, email);
		sellLocations = new ArrayList<Location>();
	}

	public ArrayList<Location> getSellLocations() {
		return this.sellLocations;
	}

	public void addSellLocation(Location newLocation) {
		this.sellLocations.add(newLocation, this.sellLocations.size());
	}

}
