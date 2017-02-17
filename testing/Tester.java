package testing;

import backend.*;
import DB.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class tester.
 * Used to test stuff around the project.
 * It is singleton
 * @author rguimerao
 *
 */
public final class Tester {
	
    public static User createUser() {
        return new User(
                "John Silver", 
                "I am a pirate", 
                "Treasure Island, num 19", 
                0, 
                "City", 
                "Caribean", 
                0, 
                "johnsilver@treasureisland.com",
                "thepirate");
    }
	
    public static void userRemoveItemFromList() throws SQLException {
		
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
        for (Food food : user.getWishlist()) {
            System.out.println(food.getName());
        }
		
        System.out.println("Removing item from wishlist");
        user.removeFoodFromWishlist(ingredientTwo);
		
        System.out.println("showing ingredients again");
        for (Food food : user.getWishlist()) {	
            System.out.println(food.getName());
        }
    }
	
	public static void foodAddedToCategoryInFoodCreator() 
	        throws SQLException {
	    User user         = createUser();
	    Category category = new Category("category num 1");
	    Food food         = new Food("Food Name", category, false, 0, user);
		
	    System.out.println(category.getFoods().size());
	}
	
	public static void testDBConnection() 
	        throws SQLException, ClassNotFoundException {
		
	    System.out.println("Testing DB connection");
	    DataBase.getInstance();
	    System.out.println("Success!!");
	}
	
	public static void testDBSelect() 
			throws ClassNotFoundException, SQLException {
		
	    DataBase db = DataBase.getInstance();
		
	    Statement stmt = null;
	    String query = "SELECT id FROM Contact_Info";
	    
	    if (!db.isConnectionClosed()) {
	        Connection con = db.getConnection();
	        try {
	            stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
		        
	            while (rs.next()) {
	                String id = rs.getString("id");
	                System.out.println(id);
	            }
	        } catch (SQLException e ) {
	            e.printStackTrace();
	        } finally {
	            if (stmt != null) { stmt.close(); }
	        }
	    }
	}

	public static void testDBInsertCategory() 
			throws ClassNotFoundException, SQLException {
		
	    User user = createUser();
	    user.createCategory("Drinks");
	}

	public static void testFullInsertCategory() 
			throws ClassNotFoundException, SQLException {
	    User user = createUser();
	    user.createCategory("Pizzas");
	}
}
