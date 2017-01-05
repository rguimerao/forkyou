package backend;

public class Food {

	// ratings
	protected Category category;
	protected Recipe recipe;
	protected ArrayList<Location> purchaseLocations;

  public Food(Location purchaseLocation, Recipe recipe, Category category) {

		this.purchaseLocation = purchaseLocation;
		this.recipe           = recipe;
		this.category         = category;
		this.category.addFood(this); // ??? possible?
	}

	public Category getCategory() {
		return this.category;
	}

	public void resetCategory(Category newCategory) {
		this.category = newCategory;
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

}
