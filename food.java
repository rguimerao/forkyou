package backend;

public class Food {

	// ratings
	// food for sell or not
	protected String name;
	protected Category category;
	protected ArrayList<Location> purchaseLocations;

  public Food(String name, Category category) {

		this.name     = name;
		this.category = category;
		this.category.addFood(this); // ??? possible?
		this.purchaseLocations = new ArrayList<Location>();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category newCategory) {
		this.category = newCategory;
	}

	public ArrayList<Location> getPurchaseLocations() {
		return this.purchaseLocations;
	}

	public void addPurchaseLocation(Location newPurchaseLocation) {
		this.purchaseLocations.add(newPurchaseLocation, this.purchaseLocations.size());
	}

}
