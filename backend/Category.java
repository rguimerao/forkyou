package backend;

import DB_controllers.DataBaseController;
import testing.myLogger;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class category.
 * A category has foods in it.
 * @author rguimerao
 *
 */
public class Category extends Identifier {

    private String name;
    private ArrayList<Food> foods;

    /**
     * Constructor of category
     * @param name name of the category
     */
    public Category(final String name) {

        super();
        this.name  = name;
        this.foods = new ArrayList<Food>();
        myLogger.getInstance().info("A new category has been created with name: " + name);
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
        myLogger.getInstance().info("obtainID in Category with result: " + getID());
    }
	
    /**
     * Getter of name
     * @return name of the category
     */
    public final String getName() {
        myLogger.getInstance().info("Name of category has been requested");
        return name;
    }

    /**
     * Getter of foods in category
     * @return array list with the foods in the category
     */
    public final ArrayList<Food> getFoods() {
        myLogger.getInstance().info("Array of foods in category has been requested");
        return this.foods;
    }

    /**
     * Adds a food to the array of foods inside the category
     * @param foodToAdd food to add to the category
     * @throws SQLException if a DB error occurs
     */
    public final void addFood(final Food foodToAdd) 
            throws SQLException {
        this.foods.add(foodToAdd);
        myLogger.getInstance().info("A food with name: " + foodToAdd.getName() + " has been added to a category");
        DataBaseController.getInstance().updateFoodCategory(foodToAdd.getID(), getID());
    }
}
