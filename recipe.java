package backend;

/**
 * TODO
 */
public class Recipe extends Identifier {

	// ratings
	public String name;
	private String description;
	private Date lastUpdate; // TODO -> review Date java type (dateformat / calendar)
	private FoodCreator creator;

	/**
	 * TODO
	 */
  public Recipe(String name, String description, Date lastUpdate, FoodCreator creator) {

		super();
		this.name        = name;
		this.description = description;
		this.lastUpdate  = lastUpdate;
		this.creator     = creator;
	}

	/**
	 * TODO
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * TODO
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * TODO
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * TODO
	 */
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	/**
	 * TODO
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * TODO
	 */
	public void updateLastUpdate(Date newLastUpdate) {
		this.lastUpdate = newLastUpdate;
	}

	/**
	 * TODO
	 */
	public FoodCreator getFoodCreator() {
		return this.creator;
	}

}
