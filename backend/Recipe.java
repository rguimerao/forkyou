package backend;

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
	 * @return name of the recipe
	 */
	public final String getName() {
		return this.name;
	}

	/**
	 * Updates recipe's name
	 * @param newName new name the recipe will have
	 */
	public final void updateName(final String newName) {
		this.name = newName;
		updateLastUpdate();
		DataBaseController.getInstance().updateRecipeName(getID(), newName);
	}

	/**
	 * Getter of description
	 * @return description of the recipe
	 */
	public final String getDescription() {
		return this.description;
	}

	/**
	 * Updates recipe's description
	 * @param newDescription new description the recipe will have
	 */
	public final void updateDescription(final String newDescription) {
		this.description = newDescription;
		updateLastUpdate();
		DataBaseController.getInstance().updateRecipeDescription(getID(), newDescription);
	}

	/**
	 * Getter of last update
	 * @return last update the recipe was updated
	 */
	public final Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * Updates the last update date
	 */
	private final void updateLastUpdate() {
		this.lastUpdate = new Date();
		DataBaseController.getInstance().updateRecipeLastUpdate(getID(), this.lastUpdate);
	}

	/**
	 * Getter of food creator
	 * @return recipe's food creator
	 */
	public final FoodCreator getFoodCreator() {
		return this.creator;
	}
	
	/**
	 * Gets the dish this recipe creates
	 * @return dish this recipe creates
	 */
	public final Dish getDish() {
		return this.dish;
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 */
	public void acceptRate(final int rating, final int userID) {
		Rater.rate(this, rating, userID);
	}
}
