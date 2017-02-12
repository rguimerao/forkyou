package backend;

import DB_controllers.DataBaseController;
import testing.myLogger;
import java.sql.SQLException;

/**
 * Class rater - Singleton
 * Rater implements VisitorRating
 * A rater rates an object, given the object to rate, the rating and the user ID
 * @author rguimerao
 *
 */
public class Rater implements VisitorRating {

    private static Rater instance;
    
    /**
     * Constructor of Rater
     */
    private Rater() {
        myLogger.getInstance().info("A new rater has been created");
    }
    
    /**
     * Get instace of type Rater
     * @return instance of Rater
     */
    public final static Rater getInstance() {
        if (instance == null) {
            myLogger.getInstance().info("Instance of rater was null, creating new one");
            instance = new Rater();
        }
        
        return instance;
    }

    /**
     * Rates a brand
     * @param brand brand to be rated
     * @param rating rating given to the brand
     * @param userID id of the user rating
     * @throws SQLException if a DB error occurs
     */
    public void rate(final Brand brand, final int rating, final int userID) 
            throws SQLException {
        DataBaseController.getInstance().rateBrand(brand.getID(), rating, userID);
        myLogger.getInstance().info("A brand has been rated");
    }

    /**
     * Rates a location
     * @param location location to be rated
     * @param rating rating given to the location
     * @param userID id of the user rating
     * @throws SQLException if a DB error occurs
     */
    public void rate(final Location location, final int rating, final int userID) 
            throws SQLException {
        DataBaseController.getInstance().rateLocation(location.getID(), rating, userID);
        myLogger.getInstance().info("A location has been rated");
    }

    /**
     * Rates a recipe
     * @param recipe recipe to be rated
     * @param rating rating given to the recipe
     * @param userID id of the user rating
     */
    public void rate(final Recipe recipe, final int rating, final int userID) {
        // TODO
        myLogger.getInstance().info("A recipe has been rated");
    }
	
    /**
     * Rates a food
     * @param food food to be rated
     * @param rating rating given to the food
     * @param userID id of the user rating
     * @throws SQLException if a DB error occurs
     */
    public void rate(final Food food, final int rating, final int userID) 
            throws SQLException {
        DataBaseController.getInstance().rateFood(food.getID(), rating, userID);
        myLogger.getInstance().info("A food has been rated");
    }
}
