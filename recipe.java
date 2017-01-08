package backend;

public class Recipe extends Identifier {

	// ratings
	public String name;
	private String description;
	private Date lastUpdate; // TODO -> review Date java type
	private FoodCreator creator;

  public Recipe(String name, String description, Date lastUpdate, FoodCreator creator) {

		this.name        = name;
		this.description = description;
		this.lastUpdate  = lastUpdate;
		this.creator     = creator;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void updateLastUpdate(Date newLastUpdate) {
		this.lastUpdate = newLastUpdate;
	}

	public FoodCreator getFoodCreator() {
		return this.creator;
	}

}
