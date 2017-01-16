package backend;

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
	public Recipe(String name, String description, FoodCreator creator, Dish dish) {

		super();
		this.name        = name;
		this.description = description;
		this.lastUpdate  = new Date();
		this.creator     = creator;
		this.dish        = dish;
	}

	/**
	 * Getter of name
	 * @return name of the recipe
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Updates recipe's name
	 * @param newName new name the recipe will have
	 */
	public void updateName(String newName) {
		this.name = newName;
		updateLastUpdate();
	}

	/**
	 * Getter of description
	 * @return description of the recipe
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Updates recipe's description
	 * @param newDescription new description the recipe will have
	 */
	public void updateDescription(String newDescription) {
		this.description = newDescription;
		updateLastUpdate();
	}

	/**
	 * Getter of last update
	 * @return last update the recipe was updated
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * Updates the last update date
	 */
	private void updateLastUpdate() {
		this.lastUpdate = new Date();
	}

	/**
	 * Getter of food creator
	 * @return recipe's food creator
	 */
	public FoodCreator getFoodCreator() {
		return this.creator;
	}
	
	/**
	 * Gets the dish this recipe creates
	 * @return dish this recipe creates
	 */
	public Dish getDish() {
		return this.dish;
	}
}
