package backend;

import DB_controllers.DataBaseController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class drink.
 * A drink is a type of dish made of ingredients and only ingredients.
 * @author rguimerao
 *
 */
public class Drink extends Dish {
	
    private static final Logger LOGGER = Logger.getLogger("Drink");
	
    /**
     * Constructor of drink
     * @param name name of the drink
     * @param category category drinks
     * @param forSell is this drink for sell?
     * @param price price of the drink
     * @param creator creator of this drink
     */
    public Drink(
            final String name, 
            final Category category,
            final boolean forSell,
            final float price, 
            final FoodCreator creator) {
		
        // TODO -> controller get category drinks
        super(name, category, forSell, price, creator);
        LOGGER.log(Level.INFO, "A drink has been created");
    }

    /**
     * Obtains the ID from the DB
     */
    @Override
    public void obtainID() {
        LOGGER.log(Level.INFO, "obtainID in Drink");
        // TODO -> DB
    }
	
    /**
     * Adds an ingredient to the drink
     * If it is not an ingredient, it won't be added
     * @param ingredientToAdd ingredient to add to the drink
     */
    @Override
    public final void addFood(final Food ingredientToAdd) {
        if (ingredientToAdd instanceof Ingredient) {
            this.composedFoods.add(ingredientToAdd);
            LOGGER.log(Level.INFO, "An ingredient has been added to a drink");
        } else {
            LOGGER.log(Level.WARNING, "A non-ingredient food has tried to be added to a drink!");
        }
        // TODO -> DB
    }
}
