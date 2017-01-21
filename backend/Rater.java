package backend;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class rater
 * Rater implements VisitorRating
 * A rater rates an object given an object to rate, rating and user ID
 * @author rguimerao
 *
 */
public class Rater implements VisitorRating {

	// TODO -> object DB_controller here
	private static final Logger LOGGER = Logger.getLogger("Rater");

	/**
	 * TODO
	 */
	public Rater() {

		// TODO -> here we initialize the object DB controller
		// in order to insert data into the DB
		LOGGER.log(Level.INFO, "A rater has been created");
	}

	/**
	 * Rates a brand
	 * @param brand brand to be rated
	 * @param rating rating given to the brand
	 * @param userID userID rating
	 */
	public void rate(final Brand brand, final int rating, final int userID) {
		// TODO -> to DB
		/* brand.getID();
		userID;
		rating; */
		LOGGER.log(Level.INFO, "A brand has been rated");
	}

	/**
	 * Rates a location
	 * @param location location to be rated
	 * @param rating rating given to the location
	 * @param userID userID rating
	 */
	public void rate(final Location location, final int rating, final int userID) {
		// TODO
		LOGGER.log(Level.INFO, "A location has been rated");
	}

	/**
	 * Rates a recipe
	 * @param recipe recipe to be rated
	 * @param rating rating given to the recipe
	 * @param userID userID rating
	 */
	public void rate(final Recipe recipe, final int rating, final int userID) {
		// TODO
		LOGGER.log(Level.INFO, "A recipe has been rated");
	}
	
	/**
	 * Rates a dish
	 * @param dish dish to be rated
	 * @param rating rating given to the drink
	 * @param userID userID rating
	 */
	public void rate(final Dish dish, final int rating, final int userID) {
		// TODO
		LOGGER.log(Level.INFO, "A dish has been rated");
	}
	
	/**
	 * Rates a drink
	 * @param drink drink to be rated
	 * @param rating rating given to the drink
	 * @param userID userID rating
	 */
	public void rate(final Drink drink, final int rating, final int userID) {
		// TODO
		LOGGER.log(Level.INFO, "A drink has been rated");
	}
	
	/**
	 * Rates an ingredient
	 * @param ingredient ingredient to be rated
	 * @param rating rating given to the ingredient
	 * @param userID userID rating
	 */
	public void rate(final Ingredient ingredient, final int rating, final int userID) {
		// TODO
		LOGGER.log(Level.INFO, "An ingredient has been rated");
	}
}
