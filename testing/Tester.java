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
		System.out.println("user created");
		
		System.out.println("creating and adding ingredients");
		user.addFoodToWishlist(
				new Ingredient("ing 1", 
				new Category("first cat"), 
				false, 
				0, user)
				);
		System.out.println("ingredient 1 done");
		user.addFoodToWishlist(
				new Ingredient("ing 2", 
				new Category("first cat"), 
				false, 
				0, user)
				);
		System.out.println("ingredient 2 done");
		user.addFoodToWishlist(
				new Ingredient("ing 3", 
				new Category("first cat"), 
				false, 
				0, user)
				);
		System.out.println("ingredient 3 done");
		
		System.out.println("showing ingredients");
		for(Food food : user.getWishlist()) {
			
			System.out.println(food.getName());
		}
		System.out.println("ingredients shown");
		
		
		user.removeFoodFromWishlist(1);
		System.out.println("ingredient 2 removed");
		
		System.out.println("showing ingredients again");
		for(Food food : user.getWishlist()) {
			
			System.out.println(food.getName());
		}
	}
}
