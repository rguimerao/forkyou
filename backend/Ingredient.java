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
     * Obtains the ID from the DB
     */
    @Override
    public void obtainID() {
        LOGGER.log(Level.INFO, "obtainID in Ingredient");
        // TODO -> DB
    }
}
