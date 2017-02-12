package backend;

import testing.myLogger;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class user.
 * A user is a food creator and the main actioner of the app.
 * @author rguimerao
 *
 */
public class User extends FoodCreator {

    private ArrayList<Food> foodWishlist;
    private ArrayList<FoodCreator> following;
    private String nickname;
    
    /**
     * Constructor of user
     * @param name name of the user
     * @param description description of the user
     * @param street street of the user
     * @param areaCode area code of the user
     * @param city city of the user
     * @param country country of the user
     * @param phone phone number of the user
     * @param email email of the user
     */
	public User(
		final String name,
		final String description,
		final String street,
		final int areaCode,
		final String city,
		final String country,
		final int phone,
		final String email,
		final String nickname) {
	
		super(name, description, street, areaCode, city, country, phone, email);
		this.foodWishlist = new ArrayList<Food>();
		this.following    = new ArrayList<FoodCreator>();
		this.nickname     = nickname;
		myLogger.getInstance().info("A new user has been created with name: " + name);
	}
	
	/**
	 * Gets the nickname of this user
	 * @return nickname of the user
	 */
	public String getNickName() {
	    return this.nickname;
	}
	
	/**
	 * Sets the new nickname of the user
	 * @param newNickName new nickname the user will have
	 */
	public void setNickName(final String newNickName) {
	    this.nickname = newNickName;
	}

	/**
	 * Getter of wish list
	 * @return array of foods
	 */
	public final ArrayList<Food> getWishlist() {
	    myLogger.getInstance().info("Food wishlist getted");
		return this.foodWishlist;
	}
	
	/**
	 * Adds food to the user's wish list
	 * @param foodToAdd food to add
	 * @throws SQLException 
	 */
	public final void addFoodToWishlist(final Food foodToAdd) 
	        throws SQLException {
		this.foodWishlist.add(foodToAdd);
		foodToAdd.addUserToUsersWantingMe(this);
		myLogger.getInstance().info("A food with name: " + foodToAdd.getName() + " has been added to the wishlist");
	}

	/**
	 * Removes food from wish list
	 * @param foodToRemove food to remove
	 * @throws SQLException 
	 */
	public final void removeFoodFromWishlist(final Food foodToRemove) 
	        throws SQLException {
		foodToRemove.removeUserFromUsersWantingMe(this);
		this.foodWishlist.remove(foodToRemove);
		myLogger.getInstance().info(foodToRemove.getName() + " has been removed from user wishlist");
	}
	
	/**
	 * Getter of following users
	 * @return array of following users
	 */
	public final ArrayList<FoodCreator> getFollowing() {
	    myLogger.getInstance().info("Followig users of users getted");
		return this.following;
	}
	
	/**
	 * Adds a user to the following list only if its different than itself
	 * @param userToAdd user to add to the following list
	 */
	public final void followFoodCreator(final FoodCreator foodCreatorToAdd) {
		if (foodCreatorToAdd != this) { // TODO by id?
			this.following.add(foodCreatorToAdd);
			foodCreatorToAdd.addFollower(this);
			myLogger.getInstance().info("User added to following users");
		} else {
		    myLogger.getInstance().warning("ERROR addFollowing user tried to follow youself");
		}
		// TODO -> DB
	}
	
	/**
	 * Removes user from the following list
	 * @param userToRemove user to remove from the following list
	 */
	public final void removeFollowing(final FoodCreator foodCreatorToRemove) {
		this.following.remove(foodCreatorToRemove);
		foodCreatorToRemove.removeFollower(this);
		myLogger.getInstance().info("User removed from following users");
		// TODO -> DB
	}
	
	/**
	 * Creates a new brand
	 * @param name name of the new brand
	 * @param description description of the new brand
	 * @param street street of the new brand
	 * @param areaCode area code of the new brand
	 * @param city city of the new brand
	 * @param country country of the new brand
	 * @param phone phone number  of the new brand
	 * @param email email of the new brand
	 */
	public final void createBrand(
		final String name,
		final String description,
		final String street,
		final int areaCode,
		final String city,
		final String country,
		final int phone,
		final String email) {
		
		/* Brand newBrand = 
				new Brand(
						name, 
						description, 
						street, 
						areaCode, 
						city, 
						country, 
						phone, 
						email
						);
		db controller -> add new brand */
		// TODO -> LOGGER
		// TODO -> DB
	    myLogger.getInstance().info("A user has created a brand");
	}
}
