package backend;

import DB_controllers.DataBaseController;
import testing.myLogger;
import java.sql.SQLException;

/**
 * Class drink.
 * A drink is a type of dish made of ingredients and only ingredients.
 * @author rguimerao
 *
 */
public class Drink extends Dish {
	
    /**
     * Constructor of drink
     * @param name name of the drink
     * @param category category drinks
     * @param forSell is this drink for sell?
     * @param price price of the drink
     * @param creator creator of this drink
     * @throws SQLException 
     */
    public Drink(
            final String name, 
            final Category category,
            final boolean forSell,
            final float price, 
            final FoodCreator creator) throws SQLException {
		
        super(name, DataBaseController.getInstance().getDrinksCategory(), forSell, price, creator);
        myLogger.getInstance().info("A drink has been created");
    }

    /**
     * Obtains the ID from the DB
     */
    @Override
    public void obtainID() {
        myLogger.getInstance().info("obtainID in Drink");
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
            myLogger.getInstance().info("An ingredient has been added to a drink");
        } else {
            myLogger.getInstance().warning("A non-ingredient food has tried to be added to a drink!");
        }
        // TODO -> DB
    }
}
