package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO
 */
public class User extends FoodCreator {

  private ArrayList<Food> foodWishlist;

  /**
   * TODO
   */
  public User(
		String name,
		String description,
		String street,
		int postalCode,
		String city,
    String country,
		int phoneNumber,
		String email) {

			super(name, description, street, postalCode, city, country, phoneNumber, email);
      this.foodWishlist = new ArrayList<Food>();
	}

	// TODO -> actions a user can do
  // can create a brand

  /**
   * TODO + review
   */
	public void rate(Object objectToRate, int rating) {

		/* Rater rater = new Rater();
		rater.rate(objectToRate, rating, getID()); */
	}

  /**
   * TODO
   */
  public void addFoodToWishlist(Food foodToAdd) {
    this.foodWishlist.add(foodToAdd);
  }

  /**
   * TODO
   */
  public ArrayList<Food> getWishlist() {
    return this.foodWishlist;
  }

  /**
   * TODO + review
   */
  @SuppressWarnings("unchecked")
public void removeFoodFromWishList(int foodID) {

    boolean found = false;
    Iterator<Food> iterator = this.foodWishlist.iterator();
    int position = 0;

	while (iterator.hasNext() && !found) {
      position++;
      if (foodID == iterator.next().getID()) {
        found = true;
        ((Iterator<Food>) iterator.next()).remove();
      }
		}
    // TODO -> review and test
    // TODO -> review if food in position 0 and last
    for (int i = position; i < this.foodWishlist.size(); i++) {
      Food foodToMove = this.foodWishlist.get(i);
      this.foodWishlist.add(foodToMove);
      this.foodWishlist.remove(i);
    }
  }
}
