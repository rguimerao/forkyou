package backend;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import DB_controllers.DataBaseController;

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
	private static final Logger LOGGER = Logger.getLogger("Recipe");

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
		LOGGER.log(Level.INFO, "A new recipe has been created");
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID(final DataBaseController dbController) {
		LOGGER.log(Level.INFO, "obtainID in Recipe");
		// TODO -> DB
	}

	/**
	 * Getter of name
	 * @return name of the recipe
	 */
	public final String getName() {
		LOGGER.log(Level.INFO, "Name of recipe has been getted");
		return this.name;
	}

	/**
	 * Updates recipe's name
	 * @param newName new name the recipe will have
	 */
	public final void updateName(final String newName) {
		this.name = newName;
		updateLastUpdate();
		LOGGER.log(Level.INFO, "Name of recipe updated");
		// TODO -> DB
	}

	/**
	 * Getter of description
	 * @return description of the recipe
	 */
	public final String getDescription() {
		LOGGER.log(Level.INFO, "Description of recipe has been getted");
		return this.description;
	}

	/**
	 * Updates recipe's description
	 * @param newDescription new description the recipe will have
	 */
	public final void updateDescription(final String newDescription) {
		this.description = newDescription;
		updateLastUpdate();
		LOGGER.log(Level.INFO, "Description of recipe updated");
		// TODO -> DB
	}

	/**
	 * Getter of last update
	 * @return last update the recipe was updated
	 */
	public final Date getLastUpdate() {
		LOGGER.log(Level.INFO, "Last update of recipe getted");
		return this.lastUpdate;
	}

	/**
	 * Updates the last update date
	 */
	private final void updateLastUpdate() {
		this.lastUpdate = new Date();
		LOGGER.log(Level.INFO, "Recipe updated!");
		// TODO -> DB
	}

	/**
	 * Getter of food creator
	 * @return recipe's food creator
	 */
	public final FoodCreator getFoodCreator() {
		LOGGER.log(Level.INFO, "Creator of recipe getted");
		return this.creator;
	}
	
	/**
	 * Gets the dish this recipe creates
	 * @return dish this recipe creates
	 */
	public final Dish getDish() {
		LOGGER.log(Level.INFO, "Dish of recipe getted");
		return this.dish;
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 */
	public void acceptRate(final Rater rater, final int rating, final int userID) {
		rater.rate(this, rating, userID);
		LOGGER.log(Level.INFO, "A recipe has accepted a rating");
		// TODO -> DB
	}
}
