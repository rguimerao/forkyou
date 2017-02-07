package backend;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DB_controllers.DataBaseController;

/**
 * Class user.
 * A user is a food creator and the main actioner of the app.
 * @author rguimerao
 *
 */
public class User extends FoodCreator {

    private ArrayList<Food> foodWishlist;
    private ArrayList<User> followingUsers;
    private ArrayList<Brand> followingBrands;
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
		this.foodWishlist    = new ArrayList<Food>();
		this.followingUsers  = new ArrayList<User>();
		this.followingBrands = new ArrayList<Brand>();
		LOGGER.log(Level.INFO, "A new user has been created with name: " + name);
	}
	
	/**
	 * Obtains the ID from the DB
	 */
	@Override
	public void obtainID(final DataBaseController dbController) {
		LOGGER.log(Level.INFO, "obtainID in User");
		// TODO -> DB
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
		// TODO -> DB
	}

	/**
	 * Removes food from wish list
	 * @param foodToRemove food to remove
	 */
	public final void removeFoodFromWishlist(final Food foodToRemove) {
		foodToRemove.removeUserFromUsersWantingMe(this);
		this.foodWishlist.remove(foodToRemove);
		LOGGER.log(Level.INFO, foodToRemove.getName() + " has been removed from user wishlist");
		// TODO -> DB
	}
	
	/**
	 * Getter of following users
	 * @return array of following users
	 */
	public final ArrayList<User> getFollowingUsers() {
		LOGGER.log(Level.INFO, "Followig users of users getted");
		return this.followingUsers;
	}
	
	/**
	 * Adds a user to the following list only if its different than itself
	 * @param userToAdd user to add to the following list
	 */
	public final void followUser(final User userToAdd) {
		if (userToAdd != this) { // TODO by id?
			this.followingUsers.add(userToAdd);
			userToAdd.addFollower(this);
			LOGGER.log(Level.INFO, "User added to following users");
		} else {
			LOGGER.log(Level.WARNING, "ERROR addFollowing user tried to follow youself");
		}
		// TODO -> DB
	}
	
	/**
	 * Removes user from the following list
	 * @param userToRemove user to remove from the following list
	 */
	public final void removeFollowingUser(final User userToRemove) {
		this.followingUsers.remove(userToRemove);
		userToRemove.removeFollower(this);
		LOGGER.log(Level.INFO, "User removed from following users");
		// TODO -> DB
	}
	
	/**
	 * Gets an array list with all the brands this user follows
	 * @return array list of type brand
	 */
	public final ArrayList<Brand> getFollowingBrands() {
		LOGGER.log(Level.INFO, "Following brands of users getted");
		return this.followingBrands;
	}
	
	/**
	 * Adds a brand to the following brands array
	 * @param brandToFollow brand to follow
	 */
	public final void followBrand(final Brand brandToFollow) {
		this.followingBrands.add(brandToFollow);
		brandToFollow.addFollower(this);
		LOGGER.log(Level.INFO, "A brand has been followed");
		// TODO -> DB
	}
	
	/**
	 * Removes a brand from the following list
	 * @param brandToUnfollow brand to be removed
	 */
	public final void removeFollowingBrand(final Brand brandToUnfollow) {
		this.followingBrands.remove(brandToUnfollow);
		brandToUnfollow.removeFollower(this);
		LOGGER.log(Level.INFO, "A brand has been unfollowed");
		// TODO -> DB
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
		// TODO -> DB
		LOGGER.log(Level.INFO, "A user has created a brand");
	}
}
