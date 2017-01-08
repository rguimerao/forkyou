package backend;

/**
 * TODO
 */
public class Food extends Identifier {

	// TODO -> ratings
	protected boolean forSell; // TODO -> getter + setter
	protected String name;
	protected Category category;
	protected ArrayList<Location> purchaseLocations;

	/**
	 * TODO
	 */
  public Food(String name, Category category, boolean forSell) {

		super();
		this.forSell  = forSell;
		this.name     = name;
		this.category = category;
		this.category.addFood(this); // TODO -> ??? possible?
		this.purchaseLocations = new ArrayList<Location>();
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
	public Category getCategory() {
		return this.category;
	}

	/**
	 * TODO
	 */
	public void setCategory(Category newCategory) {
		this.category = newCategory;
	}

	/**
	 * TODO
	 */
	public ArrayList<Location> getPurchaseLocations() {
		return this.purchaseLocations;
	}

	/**
	 * TODO
	 */
	public void addPurchaseLocation(Location newPurchaseLocation) {
		if(forSell) {
			this.purchaseLocations.add(newPurchaseLocation, this.purchaseLocations.size());
		}
	}

	/**
	 * TODO
	 */
	public void obtainRating() {
		// TODO -> call DB controller to obtain ratings
	}

}
