package backend;

import java.util.ArrayList;

/**
 * TODO
 */
public class Food extends Identifier {

	// TODO -> ratings
	private String name;
	private Category category;
	private ArrayList<Location> purchaseLocations;
	private boolean forSell;
	private float price;
	private FoodCreator creator;

	/**
	 * TODO
	 */
  public Food(String name, Category category, boolean forSell, float price, FoodCreator creator) {

		super();
		this.name     = name;
		this.category = category;
		this.category.addFood(this); // TODO -> ??? possible?
		this.purchaseLocations = new ArrayList<Location>();
		this.forSell  = forSell;
		this.price    = price;
		this.creator  = creator;
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
			this.purchaseLocations.add(newPurchaseLocation);
		}
	}

	/**
	 * TODO
	 */
	public boolean isForSell() {
		return this.forSell;
	}

	/**
	 * TODO
	 */
	public void setForSell() {
		this.forSell = !this.forSell; // TODO -> possible?
	}

	/**
	 * TODO
	 */
	public float getPrice() {
		return this.price;
	}

	/**
	 * TODO
	 */
	public void setPrice(float newPrice) {
		this.price = newPrice;
	}

	/**
	 * TODO
	 */
	public FoodCreator getCreator() {
		return this.creator;
	}

	/**
	 * TODO
	 */
	public void obtainRating() {
		// TODO -> call DB controller to obtain ratings
	}

}
