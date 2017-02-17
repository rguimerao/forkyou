package backend;

import DB_controllers.DataBaseController;
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
	    DataBaseController.getInstance().updateUserNickName(getID(), newNickName);
	}

	/**
	 * Getter of wish list
	 * @return array of foods
	 */
	public final ArrayList<Food> getWishlist() {
		return this.foodWishlist;
	}
	
	/**
	 * Adds food to the user's wish list
	 * @param foodToAdd food to add
	 */
	public final void addFoodToWishlist(final Food foodToAdd) {
		this.foodWishlist.add(foodToAdd);
		foodToAdd.addUserToUsersWantingMe(this);
	}

	/**
	 * Removes food from wish list
	 * @param foodToRemove food to remove
	 */
	public final void removeFoodFromWishlist(final Food foodToRemove) {
		foodToRemove.removeUserFromUsersWantingMe(this);
		this.foodWishlist.remove(foodToRemove);
	}
	
	/**
	 * Getter of following users
	 * @return array of following users
	 */
	public final ArrayList<FoodCreator> getFollowing() {
		return this.following;
	}
	
	/**
	 * Adds a user to the following list only if its different than itself
	 * @param userToAdd user to add to the following list
	 */
	public final void followFoodCreator(final FoodCreator foodCreatorToAdd) {
		if (foodCreatorToAdd.getID() != this.getID()) {
			this.following.add(foodCreatorToAdd);
			foodCreatorToAdd.addFollower(this);
		    DataBaseController.getInstance().followFoodCreator(getID(), foodCreatorToAdd.getID());
		}
	}
	
	/**
	 * Removes user from the following list
	 * @param userToRemove user to remove from the following list
	 */
	public final void removeFollowing(final FoodCreator foodCreatorToRemove) {
		this.following.remove(foodCreatorToRemove);
		foodCreatorToRemove.removeFollower(this);
	    DataBaseController.getInstance().unFollowFoodCreator(getID(), foodCreatorToRemove.getID());
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
		final String hashPassword) {
		
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
	}
}
