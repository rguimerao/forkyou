package backend;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DB_controllers.DataBaseController;

/**
 * Class rater
 * Rater implements VisitorRating
 * A rater rates an object given an object to rate, rating and user ID
 * @author rguimerao
 *
 */
public class Rater implements VisitorRating {

	private static DataBaseController dbController = null;
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void rate(final Brand brand, final int rating, final int userID) 
			throws ClassNotFoundException, SQLException {
		dbController = dbController.getInstance();
		dbController.rateBrand(brand.getID(), rating, userID);
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
	public void rate(final Food food, final int rating, final int userID) {
		// TODO -> visitor id obtainer obtain food id
		LOGGER.log(Level.INFO, "A food has been rated");
	}
}
