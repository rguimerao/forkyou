package backend;

import DB_controllers.DataBaseController;
import testing.myLogger;
import java.sql.SQLException;

/**
 * Class rater
 * Rater implements VisitorRating
 * A rater rates an object given an object to rate, rating and user ID
 * @author rguimerao
 *
 */
public class Rater implements VisitorRating {

    private static DataBaseController dbController = null;

    /**
     * Constructor of Rater
     * @throws SQLException if a DB error occurs
     */
    public Rater() 
            throws SQLException {

        dbController = DataBaseController.getInstance();
        myLogger.getInstance().info("A rater has been created");
    }

    // TODO -> rater should be singleton
    // TODO -> rater.getdbcontrllerinstance and not param
    /**
     * Rates a brand
     * @param brand brand to be rated
     * @param rating rating given to the brand
     * @param userID userID rating
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public void rate(final Brand brand, final int rating, final int userID) 
            throws SQLException {
        //dbController = dbController.getInstance();
        dbController.rateBrand(brand.getID(), rating, userID);
        myLogger.getInstance().info("A brand has been rated");
    }

    /**
     * Rates a location
     * @param location location to be rated
     * @param rating rating given to the location
     * @param userID userID rating
     */
    public void rate(final Location location, final int rating, final int userID) {
        // TODO
        myLogger.getInstance().info("A location has been rated");
    }

    /**
     * Rates a recipe
     * @param recipe recipe to be rated
     * @param rating rating given to the recipe
     * @param userID userID rating
     */
    public void rate(final Recipe recipe, final int rating, final int userID) {
        // TODO
        myLogger.getInstance().info("A recipe has been rated");
    }
	
    /**
     * Rates a dish
     * @param dish dish to be rated
     * @param rating rating given to the drink
     * @param userID userID rating
     */
    public void rate(final Food food, final int rating, final int userID) {
        // TODO -> visitor id obtainer obtain food id
        myLogger.getInstance().info("A food has been rated");
    }
}
