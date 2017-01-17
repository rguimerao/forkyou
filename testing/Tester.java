package testing;

import backend.*;
import DB.*;

/**
 * Class tester.
 * Used to test stuff around the project.
 * It is singleton
 * @author rguimerao
 *
 */
public class Tester {

	public Tester() {
	}
	
	/**
	 * Remove item from wish list
	 */
	public void userRemoveItemFromList() {
		
		System.out.println("Creating user");
		User user = 
				new User(
						"juan", 
						"desc", 
						"", 
						0, 
						"city", 
						"country", 
						0, 
						"email"
						);
		
		System.out.println("creating and adding ingredients");
		user.addFoodToWishlist(
				new Ingredient("ing 1", 
						new Category("first cat"), 
						false, 
						0, 
						user)
				);
		Ingredient ingredientTwo = 
				new Ingredient(
						"ing 2", 
						new Category("first cat"), 
						false, 
						0, 
						user);
		user.addFoodToWishlist(ingredientTwo);
		user.addFoodToWishlist(
				new Ingredient("ing 3", 
						new Category("first cat"), 
						false, 
						0, 
						user)
				);
		
		System.out.println("showing ingredients name");
		for(Food food : user.getWishlist()) {
			System.out.println(food.getName());
		}
		
		System.out.println("Removing item from wishlist");
		user.removeFoodFromWishlist(ingredientTwo);

		
		System.out.println("showing ingredients again");
		for(Food food : user.getWishlist()) {
			
			System.out.println(food.getName());
		}
	}
}
