package backend;

import testing.MyLogger;
import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class user.
 * A user is a food creator and the main character of the app.
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
		MyLogger.info("A new user has been created with name: " + name);
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
	 * @throws SQLException if a DB error occurs 
	 */
	public void setNickName(final String newNickName) 
	        throws SQLException {
	    this.nickname = newNickName;
	    DataBaseController.getInstance().updateUserNickName(getID(), newNickName);
	}

	/**
	 * Getter of wish list
	 * @return array of foods
	 */
	public final ArrayList<Food> getWishlist() {
	    MyLogger.info("Food wishlist getted");
		return this.foodWishlist;
	}
	
	/**
	 * Adds food to the user's wish list
	 * @param foodToAdd food to add
	 * @throws SQLException if a DB error occurs
	 */
	public final void addFoodToWishlist(final Food foodToAdd) 
	        throws SQLException {
		this.foodWishlist.add(foodToAdd);
		foodToAdd.addUserToUsersWantingMe(this);
		MyLogger.info("A food with name: " + foodToAdd.getName() + " has been added to the wishlist");
	}

	/**
	 * Removes food from wish list
	 * @param foodToRemove food to remove
	 * @throws SQLException if a DB error occurs
	 */
	public final void removeFoodFromWishlist(final Food foodToRemove) 
	        throws SQLException {
		foodToRemove.removeUserFromUsersWantingMe(this);
		this.foodWishlist.remove(foodToRemove);
		MyLogger.info(foodToRemove.getName() + " has been removed from user wishlist");
	}
	
	/**
	 * Getter of following users
	 * @return array of following users
	 */
	public final ArrayList<FoodCreator> getFollowing() {
	    MyLogger.info("Followig users of users getted");
		return this.following;
	}
	
	/**
	 * Adds a user to the following list only if its different than itself
	 * @param userToAdd user to add to the following list
	 * @throws SQLException if a DB error occurs
	 */
	public final void followFoodCreator(final FoodCreator foodCreatorToAdd) 
	        throws SQLException {
		if (foodCreatorToAdd.getID() != this.getID()) {
			this.following.add(foodCreatorToAdd);
			foodCreatorToAdd.addFollower(this);
		    DataBaseController.getInstance().followFoodCreator(getID(), foodCreatorToAdd.getID());
			MyLogger.info("User added to following users");
		} else {
		    MyLogger.warning("ERROR addFollowing user tried to follow youself");
		}
	}
	
	/**
	 * Removes user from the following list
	 * @param userToRemove user to remove from the following list
	 * @throws SQLException if a DB error occurs
	 */
	public final void removeFollowing(final FoodCreator foodCreatorToRemove) 
	        throws SQLException {
		this.following.remove(foodCreatorToRemove);
		foodCreatorToRemove.removeFollower(this);
	    DataBaseController.getInstance().unFollowFoodCreator(getID(), foodCreatorToRemove.getID());
		MyLogger.info("User removed from following users");
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
	 * @param website website of the brand
	 * @throws SQLException if a DB error occurs
	 */
	public final void createBrand(
		final String name,
		final String description,
		final String street,
		final int areaCode,
		final String city,
		final String country,
		final int phone,
		final String email,
		final String website,
		final String hashPassword) 
		        throws SQLException {
		
		Brand newBrand = 
				new Brand(
						name, 
						description, 
						street, 
						areaCode, 
						city, 
						country, 
						phone, 
						email,
						website);
		DataBaseController.getInstance().createNewContactInfo(newBrand);
		newBrand.obtainID();
		DataBaseController.getInstance().createNewFoodCreator(newBrand, hashPassword);
		DataBaseController.getInstance().createNewBrand(newBrand);
	    MyLogger.info("A user has created a brand");
	}
}
