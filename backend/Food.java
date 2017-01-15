package backend;

import java.util.ArrayList;

/**
 * Class food
 * @author rguimerao
 *
 */
public class Food extends Identifier {

	private String name;
	private Category category;
	private ArrayList<Location> purchaseLocations;
	private boolean forSell;
	private float price;
	private FoodCreator creator;

	/**
	 * Constructor of food
	 * @param name name of the food
	 * @param category category of the food
	 * @param forSell is this food for sell?
	 * @param price price of the food
	 * @param creator creator of the food
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
	 * Getter of name
	 * @return name of the food
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter of name
	 * @param newName new name the food will have
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Getter of category
	 * @return category the food is in
	 */
	protected Category getCategory() {
		return this.category;
	}

	/**
	 * Setter of category
	 * @param newCategory new category the food will be in
	 */
	protected void setCategory(Category newCategory) {
		this.category = newCategory;
	}

	/**
	 * Getter of purchase locations
	 * @return array of location containing the locations where this food can be bought
	 */
	protected ArrayList<Location> getPurchaseLocations() {
		return this.purchaseLocations;
	}

	/**
	 * Adds a purchase location to the food's purchase locations
	 * @param purchaseLocationToAdd purchase location to add
	 */
	protected void addPurchaseLocation(Location purchaseLocationToAdd) {
		if(forSell) {
			this.purchaseLocations.add(purchaseLocationToAdd);
			purchaseLocationToAdd.addFood(this);
		}
	}

	/**
	 * Getter of is for sell
	 * @return true is the food is for sell, false otherwise
	 */
	protected boolean isForSell() {
		return this.forSell;
	}

	/**
	 * Inverter of for sell.
	 * Changes the value of forSell attribute to the opposite
	 */
	protected void invertForSell() {
		this.forSell = !this.forSell;
	}

	/**
	 * Getter of price
	 * @return price the food has
	 */
	protected float getPrice() {
		return this.price;
	}

	/**
	 * Setter of price
	 * @param newPrice new price the food will have
	 */
	protected void setPrice(float newPrice) {
		this.price = newPrice;
	}

	/**
	 * Getter of creator
	 * @return creator of this food
	 */
	protected FoodCreator getCreator() {
		return this.creator;
	}
}
