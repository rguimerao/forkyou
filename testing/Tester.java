package testing;

import backend.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * Creates a user to test
	 * @return Testing user
	 */
	public User createUser() {
		return new User("John Silver", "I am a pirate", "Treasure Island, num 19", 0, "City", "Caribean", 0, "johnsilver@treasureisland.com");
	}
	
	/**
	 * Remove item from wish list
	 */
	public void userRemoveItemFromList() {
		
		System.out.println("Creating user");
		User user = createUser();
		
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
	
	public void foodAddedToCategoryInFoodCreator() {
		User user         = createUser();
		Category category = new Category("category num 1");
		Food food         = new Food("Food Name", category, false, 0, user);
		
		System.out.println(category.getFoods().size());
	}
	
	public void testDBConnection() 
			throws SQLException, ClassNotFoundException {
		
		System.out.println("Testing DB connection");
		DataBase db = null;
		db = db.getInstance();
		System.out.println("Success!!");
	}
	

	public void testDBSelect() 
			throws ClassNotFoundException, SQLException {
		
		DataBase db = null;
		db = db.getInstance();
		
		Statement stmt = null;
	    String query = "SELECT name FROM Contact_Info";
	    
	    if (!db.isConnectionClosed()) {
	    	Connection con = db.getConnection();
	    	try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        
		        while (rs.next()) {
		            String name = rs.getString("name");
		            System.out.println(name);
		        }
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
	    }
	}
	
}
