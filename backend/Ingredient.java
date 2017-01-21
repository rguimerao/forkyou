package backend;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class ingredient.
 * An ingredient is a food, a dish is composed by foods, mostly ingredients.
 * An apple is an ingredient, a fruit salad a dish.
 * @author rguimerao
 *
 */
public class Ingredient extends Food {

	private static final Logger LOGGER = Logger.getLogger("Ingredient");
	
	/**
	 * Constructor of ingredient
	 * @param name name of the ingredient
	 * @param category category of the ingredient
	 * @param forSell is this ingredient for sell?
	 * @param price price of the ingredient
	 * @param creator creator of the ingredient
	 */
	public Ingredient(
		final String name, 
		final Category category, 
		final boolean forSell, 
		final float price, 
		final FoodCreator creator) {

		super(name, category, forSell, price, creator);
		LOGGER.log(Level.INFO, "A new ingredient with name: " + name + " has been created");
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 */
	public void acceptRate(final Rater rater, final int rating, final int userID) {
		rater.rate(this, rating, userID);
		LOGGER.log(Level.INFO, "An ingredient has accepted a rating");
	}
}
