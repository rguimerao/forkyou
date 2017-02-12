package backend;

import testing.myLogger;
import java.sql.SQLException;

/**
 * Class ingredient.
 * An ingredient is a food, a dish is composed by foods, mostly ingredients.
 * An apple is an ingredient, a fruit salad a dish.
 * @author rguimerao
 *
 */
public class Ingredient extends Food {
	
    /**
     * Constructor of ingredient
     * @param name name of the ingredient
     * @param category category of the ingredient
     * @param forSell is this ingredient for sell?
     * @param price price of the ingredient
     * @param creator creator of the ingredient
     * @throws SQLException 
     */
    public Ingredient(
            final String name, 
            final Category category, 
            final boolean forSell, 
            final float price, 
            final FoodCreator creator) throws SQLException {

        super(name, category, forSell, price, creator);
        myLogger.getInstance().info("A new ingredient with name: " + name + " has been created");
	}
}
