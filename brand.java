package backend;

public class Brand extends FoodCreator {

	private ArrayList<Location> sellLocations;

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

	public void obtainRating() {
		// TODO -> call DB controller to obtain ratings
	}
}
