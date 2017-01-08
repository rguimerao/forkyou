package backend;

public class Food extends Identifier {

	// TODO -> ratings
	protected boolean forSell;
	protected String name;
	protected Category category;
	protected ArrayList<Location> purchaseLocations;

  public Food(String name, Category category, boolean forSell) {

		super();
		this.forSell  = forSell;
		this.name     = name;
		this.category = category;
		this.category.addFood(this); // TODO -> ??? possible?
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
		if(forSell) {
			this.purchaseLocations.add(newPurchaseLocation, this.purchaseLocations.size());
		}
	}

	public void obtainRating() {
		// TODO -> call DB controller to obtain ratings
	}

}
