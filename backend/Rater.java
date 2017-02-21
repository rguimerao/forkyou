package backend;

import DB_controllers.DataBaseController;

/**
 * Class rater - Singleton
 * Rater implements VisitorRating
 * A rater rates an object, given the object to rate, the rating and the user ID
 * @author rguimerao
 *
 */
public final class Rater {

    /**
     * Rates a location
     * @param location location to be rated
     * @param rating rating given to the location
     * @param userID id of the user rating
     */
    public final static void rate(final Location location, final int rating, final int userID) {
        DataBaseController.getInstance().rateLocation(location.getID(), rating, userID);
    }

    /**
     * Rates a recipe
     * @param recipe recipe to be rated
     * @param rating rating given to the recipe
     * @param userID id of the user rating
     */
    public final static void rate(final Recipe recipe, final int rating, final int userID) {
        DataBaseController.getInstance().rateRecipe(recipe.getID(), rating, userID);
    }
	
    /**
     * Rates a food
     * @param food food to be rated
     * @param rating rating given to the food
     * @param userID id of the user rating
     */
    public final static void rate(final Food food, final int rating, final int userID) {
        DataBaseController.getInstance().rateFood(food.getID(), rating, userID);
    }
}
