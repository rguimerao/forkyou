package backend;

import java.util.ArrayList;

/**
 * Class user.
 * A user is a food creator and the main actioner of the app.
 * @author rguimerao
 *
 */
public class User extends FoodCreator {

    private ArrayList<Food> foodWishlist;
    private ArrayList<User> friendList;

    /**
     * Constructor of user
     * @param name name of the user
     * @param description description of the user
     * @param street street of the user
     * @param postalCode postal code of the user
     * @param city city of the user
     * @param country country of the user
     * @param phoneNumber phone number of the user
     * @param email email of the user
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
		this.friendList   = new ArrayList<User>();
	}

	/**
	 * Rates objects
	 * @param objectToRate object to rate
	 * @param rating rating
	 */
	public void rate(Object objectToRate, int rating) {

		/*Rater rater = new Rater();
		rater.rate(objectToRate, rating, getID());*/
	}

	/**
	 * Getter of wish list
	 * @return array of foods
	 */
	public ArrayList<Food> getWishlist() {
		return this.foodWishlist;
	}
	
	/**
	 * Adds food to the user's wish list
	 * @param foodToAdd food to add
	 */
	public void addFoodToWishlist(Food foodToAdd) {
		this.foodWishlist.add(foodToAdd);
	}

	/**
	 * Removes food from wish list
	 * @param position position of the food inside the array
	 */
	public void removeFoodFromWishlist(int position) {
		this.foodWishlist.remove(position);
	}
	
	/**
	 * Getter of friend list
	 * @return array of users
	 */
	public ArrayList<User> getFriendList() {
		return this.friendList;
	}
	
	/**
	 * Adds a user to the friend list
	 * @param userToAdd user to add to the friends list
	 */
	public void addUserToFriendList(User userToAdd) {
		this.friendList.add(userToAdd);
	}
	
	/**
	 * Removes user from friend list
	 * @param position position of the friend inside the array
	 */
	public void removeFriend(int position) {
		this.friendList.remove(position);
	}
	
	/**
	 * Creates a new brand
	 * @param name name of the new brand
	 * @param description description of the new brand
	 * @param street street of the new brand
	 * @param postalCode postal code of the new brand
	 * @param city city of the new brand
	 * @param country country of the new brand
	 * @param phoneNumber phone number  of the new brand
	 * @param email email of the new brand
	 */
	public void createBrand(
			String name,
			String description,
			String street,
			int postalCode,
			String city,
			String country,
			int phoneNumber,
			String email) {
		
		/* Brand newBrand = 
				new Brand(
						name, 
						description, 
						street, 
						postalCode, 
						city, 
						country, 
						phoneNumber, 
						email
						);
		db controller -> add new brand */
	}
}
