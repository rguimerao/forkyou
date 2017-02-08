package backend;

import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class category.
 * A category has foods in it.
 * @author rguimerao
 *
 */
public class Category extends Identifier {

    private String name;
    private ArrayList<Food> foods;
    private static final Logger LOGGER = Logger.getLogger("Category");

    /**
     * Constructor of category
     * @param name name of the category
     */
    public Category(final String name) {

        super();
        this.name  = name;
        this.foods = new ArrayList<Food>();
        LOGGER.log(Level.INFO, "A new category has been created with name: " + name);
    }

    /**
     * Obtains the ID from the DB
     */
    @Override
    public void obtainID() {
        try {
            setID(DataBaseController.getInstance().obtainID(this));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "obtainID in Category with result: " + getID());
    }
	
    /**
     * Getter of name
     * @return name of the category
     */
    public final String getName() {
        LOGGER.log(Level.INFO, "Name of category has been requested");
        return name;
    }

    /**
     * Getter of foods in category
     * @return array list with the foods in the category
     */
    public final ArrayList<Food> getFoods() {
        LOGGER.log(Level.INFO, "Array of foods in category has been requested");
        return this.foods;
    }

    /**
     * Adds a food to the array of foods inside the category
     * @param foodToAdd food to add to the category
     */
    public final void addFood(final Food foodToAdd) {
        this.foods.add(foodToAdd);
        LOGGER.log(Level.INFO, "A food with name: " + foodToAdd.getName() + " has been added to a category");
        // TODO -> DB
    }
}
