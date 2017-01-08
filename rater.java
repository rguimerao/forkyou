package backend;

public class Rater implements VisitorRating {

	// TODO -> object DB controller here

	public Rater() {

		// TODO -> here we initiallize the object DB controller
		// in order to insert data into the DB
	}

	public void rate(Brand brand, int rating, int userID) {
		// TODO -> to DB
		/* brand.getID();
		userID;
		rating; */
	}

	public void rate(Dish dish, int rating, int userID) {
		// TODO -> to DB
		/* dish.getID();
		userID;
		rating; */
	}

	public void rate(Ingredient ingredient, int rating, int userID) {
		// TODO -> to DB
		/* ingredient.getID();
		userID;
		rating; */
	}

	public void rate(Location location, int rating, int userID) {
		// TODO -> to DB
		/* location.getID();
		userID;
		rating; */
	}

	public void rate(Recipe recipe, int rating, int userID) {
		// TODO -> to DB
		/* recipe.getID();
		userID;
		rating; */
	}
}
