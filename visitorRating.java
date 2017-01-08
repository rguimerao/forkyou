package backend;

/**
 * TODO
 */
public interface VisitorRating {

	void rate(Brand brand, int rating, int userID);
	void rate(Dish dish, int rating, int userID);
	void rate(Ingredient ingredient, int rating, int userID);
	void rate(Location location, int rating, int userID);
	void rate(Recipe recipe, int rating, int userID);
}
