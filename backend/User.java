package backend;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class user.
 * A user is a food creator and the main actioner of the app.
 * @author rguimerao
 *
 */
public class User extends FoodCreator {

    private ArrayList<Food> foodWishlist;
    private ArrayList<User> following;
    private ArrayList<User> followers;
    private static final Logger LOGGER = Logger.getLogger("User");
    
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
		final String name,
		final String description,
		final String street,
		final int postalCode,
		final String city,
		final String country,
		final int phoneNumber,
		final String email) {
	
		super(name, description, street, postalCode, city, country, phoneNumber, email);
		this.foodWishlist = new ArrayList<Food>();
		this.following    = new ArrayList<User>();
		this.followers    = new ArrayList<User>();
		LOGGER.log(Level.INFO, "A new user has been created with name: " + name);
	}

	/**
	 * Getter of wish list
	 * @return array of foods
	 */
	public final ArrayList<Food> getWishlist() {
		LOGGER.log(Level.INFO, "Food wishlist getted");
		return this.foodWishlist;
	}
	
	/**
	 * Adds food to the user's wish list
	 * @param foodToAdd food to add
	 */
	public final void addFoodToWishlist(final Food foodToAdd) {
		this.foodWishlist.add(foodToAdd);
		foodToAdd.addUserToUsersWantingMe(this);
		LOGGER.log(Level.INFO, "A food with name: " + foodToAdd.getName() + " has been added to the wishlist");
	}

	/**
	 * Removes food from wish list
	 * @param foodToRemove food to remove
	 */
	public final void removeFoodFromWishlist(final Food foodToRemove) {
		foodToRemove.removeUserFromUsersWantingMe(this);
		this.foodWishlist.remove(foodToRemove);
		LOGGER.log(Level.INFO, foodToRemove.getName() + " has been removed from user wishlist");
	}
	
	/**
	 * Getter of following users
	 * @return array of following users
	 */
	public final ArrayList<User> getFollowing() {
		LOGGER.log(Level.INFO, "Followig of users getted");
		return this.following;
	}
	
	/**
	 * Adds a user to the following list only if its different than itself
	 * @param userToAdd user to add to the following list
	 */
	public final void addFollowing(final User userToAdd) {
		if (userToAdd != this) { // TODO by id?
			this.following.add(userToAdd);
			userToAdd.addFollower(this);
			LOGGER.log(Level.INFO, "User added to following");
		} else {
			LOGGER.log(Level.WARNING, "ERROR addFollowing user tried to follow youself");
		}
	}
	
	/**
	 * Removes user from the following list
	 * @param userToRemove user to remove from the following list
	 */
	public final void removeFollowing(final User userToRemove) {
		this.following.remove(userToRemove);
		userToRemove.removeFollower(this);
		LOGGER.log(Level.INFO, "User removed from following");
	}
	
	/**
	 * Getter of friend list
	 * @return array of users
	 */
	public final ArrayList<User> getFollowers() {
		LOGGER.log(Level.INFO, "Followers list getted");
		return this.followers;
	}
	
	/**
	 * Adds a user to the friend list
	 * @param userToAdd user to add to the friends list
	 */
	private final void addFollower(final User followerToAdd) {
		this.followers.add(followerToAdd);
		LOGGER.log(Level.INFO, "A user is now following you");
	}
	
	/**
	 * Removes user from friend list
	 * @param position position of the friend inside the array
	 */
	private final void removeFollower(final User userToRemove) {
		this.followers.remove(userToRemove);
		LOGGER.log(Level.INFO, "A user has removed you from its following list");
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
	public final void createBrand(
		final String name,
		final String description,
		final String street,
		final int postalCode,
		final String city,
		final String country,
		final int phoneNumber,
		final String email) {
		
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
		// TODO -> LOGGER
	}
}
