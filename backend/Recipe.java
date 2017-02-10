package backend;

import testing.myLogger;
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
		myLogger.getInstance().info("A new recipe has been created");
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID() {
	    myLogger.getInstance().info("obtainID in Recipe");
		// TODO -> DB
	}

	/**
	 * Getter of name
	 * @return name of the recipe
	 */
	public final String getName() {
	    myLogger.getInstance().info("Name of recipe has been getted");
		return this.name;
	}

	/**
	 * Updates recipe's name
	 * @param newName new name the recipe will have
	 */
	public final void updateName(final String newName) {
		this.name = newName;
		updateLastUpdate();
		myLogger.getInstance().info("Name of recipe updated");
		// TODO -> DB
	}

	/**
	 * Getter of description
	 * @return description of the recipe
	 */
	public final String getDescription() {
	    myLogger.getInstance().info("Description of recipe has been getted");
		return this.description;
	}

	/**
	 * Updates recipe's description
	 * @param newDescription new description the recipe will have
	 */
	public final void updateDescription(final String newDescription) {
		this.description = newDescription;
		updateLastUpdate();
		myLogger.getInstance().info("Description of recipe updated");
		// TODO -> DB
	}

	/**
	 * Getter of last update
	 * @return last update the recipe was updated
	 */
	public final Date getLastUpdate() {
	    myLogger.getInstance().info("Last update of recipe getted");
		return this.lastUpdate;
	}

	/**
	 * Updates the last update date
	 */
	private final void updateLastUpdate() {
		this.lastUpdate = new Date();
		myLogger.getInstance().info("Recipe updated!");
		// TODO -> DB
	}

	/**
	 * Getter of food creator
	 * @return recipe's food creator
	 */
	public final FoodCreator getFoodCreator() {
	    myLogger.getInstance().info("Creator of recipe getted");
		return this.creator;
	}
	
	/**
	 * Gets the dish this recipe creates
	 * @return dish this recipe creates
	 */
	public final Dish getDish() {
	    myLogger.getInstance().info("Dish of recipe getted");
		return this.dish;
	}
	
	/**
	 * Accepts a rate by telling the rater to rate myself
	 * @param rater rater to execute the rate
	 * @param rating rating given
	 * @param userID userId rating
	 */
	public void acceptRate(final int rating, final int userID) {
		Rater.getInstance().rate(this, rating, userID);
		myLogger.getInstance().info("A recipe has accepted a rating");
		// TODO -> DB
	}
}
