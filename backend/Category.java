package backend;

import DB_controllers.DataBaseController;
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
        this.foods = new ArrayList<>();
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
    }
	
    /**
     * Getter of name
     * @return name of the category
     */
    public final String getName() {
        return name;
    }

    /**
     * Getter of foods in category
     * @return array list with the foods in the category
     */
    public final ArrayList<Food> getFoods() {
        if  (this.foods.isEmpty()) {
            try {
                DataBaseController.getInstance().getFoodsFromCategory(this, this.foods);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.foods;
    }

    /**
     * Adds a food to the array of foods inside the category
     * @param foodToAdd food to add to the category
     */
    protected final void addFood(final Food foodToAdd) {
        this.foods.add(foodToAdd);
    }
    
    /**
     * Removes a food from this category
     * @param foodToRemove food to remove from the category
     */
    protected final void removeFood(final Food foodToRemove) {
        this.foods.remove(foodToRemove);
    }
}
