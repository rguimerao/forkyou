package backend;

public class FoodCreator extends ContactInfo {

	protected ArrayList<Food> foodsCreated;

  public FoodCreator(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
		int phoneNumber,
		String email) {

		super(name, description, street, postalCode, city, phoneNumber, email);
		this.foodCreated = new ArrayList<food>();
	}

	public ArrayList<food> getFoodsCreated() {
		return this.foodCreated;
	}

	public void addFood(Food newFood) {
		this.foodsCreated.add(newFood, this.foodsCreated.size());
	}

}
