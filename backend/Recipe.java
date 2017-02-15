package backend;

import testing.MyLogger;
import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.Date;

/**
 * Class recipe.
 * A dish has a recipe of how to cook it
 * @author rguimerao
 *
 */
public class Recipe extends Identifier {

	private String name;
	private String description;
	private Date lastUpdate;
	private FoodCreator creator;
	private Dish dish;

	/**
	 * Constructor of recipe
	 * @param name name of the recipe
	 * @param description description and steps of the recipe
	 * @param creator who created this recipe?
	 * @param dish the dish this recipe creates
	 */
	public Recipe(
		final String name, 
		final String description, 
		final FoodCreator creator, 
		final Dish dish) {

		super();
		this.name        = name;
		this.description = description;
		this.lastUpdate  = new Date();
		this.creator     = creator;
		this.dish        = dish;
		MyLogger.info("A new recipe has been created");
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID() {
	    MyLogger.info("obtainID in Recipe");
		try {
            setID(DataBaseController.getInstance().obtainID(this));
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Getter of name
	 * @return name of the recipe
	 */
	public final String getName() {
	    MyLogger.info("Name of recipe has been getted");
		return this.name;
	}

	/**
	 * Updates recipe's name
	 * @param newName new name the recipe will have
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateName(final String newName) 
	        throws SQLException {
		this.name = newName;
		updateLastUpdate();
		MyLogger.info("Name of recipe updated");
		DataBaseController.getInstance().updateRecipeName(getID(), newName);
	}

	/**
	 * Getter of description
	 * @return description of the recipe
	 */
	public final String getDescription() {
	    MyLogger.info("Description of recipe has been getted");
		return this.description;
	}

	/**
	 * Updates recipe's description
	 * @param newDescription new description the recipe will have
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateDescription(final String newDescription) 
	        throws SQLException {
		this.description = newDescription;
		updateLastUpdate();
		MyLogger.info("Description of recipe updated");
		DataBaseController.getInstance().updateRecipeDescription(getID(), newDescription);
	}

	/**
	 * Getter of last update
	 * @return last update the recipe was updated
	 */
	public final Date getLastUpdate() {
	    MyLogger.info("Last update of recipe getted");
		return this.lastUpdate;
	}

	/**
	 * Updates the last update date
	 * @throws SQLException if a DB error occurs 
	 */
	private final void updateLastUpdate() 
	        throws SQLException {
		this.lastUpdate = new Date();
		MyLogger.info("Recipe updated!");
		DataBaseController.getInstance().updateRecipeLastUpdate(getID(), this.lastUpdate);
	}

	/**
	 * Getter of food creator
	 * @return recipe's food creator
	 */
	public final FoodCreator getFoodCreator() {
	    MyLogger.info("Creator of recipe getted");
		return this.creator;
	}
	
	/**
	 * Gets the dish this recipe creates
	 * @return dish this recipe creates
	 */
	public final Dish getDish() {
	    MyLogger.info("Dish of recipe getted");
		return this.dish;
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 * @throws SQLException if a DB error occurs 
	 */
	public void acceptRate(final int rating, final int userID) 
	        throws SQLException {
		Rater.rate(this, rating, userID);
		MyLogger.info("A recipe has accepted a rating");
	}
}
