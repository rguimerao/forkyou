package backend;

import DB_controllers.DataBaseController;
import testing.MyLogger;
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
        MyLogger.info("A new category has been created with name: " + name);
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
        MyLogger.info("obtainID in Category with result: " + getID());
    }
	
    /**
     * Getter of name
     * @return name of the category
     */
    public final String getName() {
        MyLogger.info("Name of category has been requested");
        return name;
    }

    /**
     * Getter of foods in category
     * @return array list with the foods in the category
     */
    public final ArrayList<Food> getFoods() {
        MyLogger.info("Array of foods in category has been requested");
        return this.foods;
    }

    /**
     * Adds a food to the array of foods inside the category
     * @param foodToAdd food to add to the category
     */
    protected final void addFood(final Food foodToAdd) {
        this.foods.add(foodToAdd);
        MyLogger.info("A food with name: " + foodToAdd.getName() + " has been added to a category");
    }
    
    /**
     * Removes a food from this category
     * @param foodToRemove food to remove from the category
     * @throws SQLException if a DB error occurs
     */
    protected final void removeFood(final Food foodToRemove) 
            throws SQLException {
        this.foods.remove(foodToRemove);
        MyLogger.info("A food with name: " + foodToRemove.getName() + " has been removed to a category");
    }
}
