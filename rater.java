package backend;

public class Rater implements VisitorRating {

	// object BD controller here
	
	public Rater() {

		// TODO -> here we initiallize the object BD controller
		// in order to insert data into the BD
	}

	public void rate(Brand brand, int rating, int userID) {
		// passar a BD
		brand.getID();
		userID;
		reting;
	}

	public void rate(Dish dish, int rating, int userID) {
		// passar a BD
		dish.getID();
		userID;
		rating;
	}

	public void rate(Ingredient ingredient, int rating, int userID) {
		// passar a BD
		ingredient.getID();
		userID;
		rating;
	}

	public void rate(Location location, int rating, int userID) {
		// passar a BD
		location.getID();
		userID;
		rating;
	}

	public void rate(Recipe recipe, int rating, int userID) {
		// passar a BD
		recipe.getID();
		userID;
		rating;
	}
}
