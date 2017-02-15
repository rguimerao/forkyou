package DB_controllers;

import DB.DataBase;
import backend.Brand;
import backend.Category;
import backend.ContactInfo;
import backend.Dish;
import backend.Drink;
import backend.Food;
import backend.FoodCreator;
import backend.Ingredient;
import backend.Location;
import backend.Recipe;
import backend.User;
import testing.MyLogger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Class DataBaseController
 * Controles the querys to be done by the DB
 * Singleton
 * @author rguimerao
 *
 */
public class DataBaseController implements VisitorIDObtainer {

    private static DataBaseController instance;
    private static DataBase db = null;
	
	/**
	 * Constructor - Singleton
	 * Obtains the instance of the DB
	 * @throws SQLException if the connection cannot be done
	 * @throws ClassNotFoundException if the driver is not found
	 */
	private DataBaseController() 
			throws ClassNotFoundException, SQLException {
		db = DataBase.getInstance();
		MyLogger.info("DataBaseController created");
	}
	
	/**
	 * Returns the instance of itself
	 * @return instance of this object
	 */
	public final static DataBaseController getInstance()  {
	    MyLogger.info("Get instance DBController");
		if (instance == null) {
			try {
                instance = new DataBaseController();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
			MyLogger.info("Instance was null, new created");
		}
		return instance;
	}

	/**
	 * Obtains the ID of the given category
	 * @param category category to be given the ID
	 * @throws SQLException if a DB error occurs
	 */
	public int obtainID(final Category category) 
			throws SQLException {
	    MyLogger.info("DataBaseController obtaining ID");
	    String query = "SELECT id FROM `category` ORDER BY 1 DESC LIMIT 1;";
	    MyLogger.info(query);
        return db.obtainID(query);
	}
	
	/**
	 * Obtains the ID of the given Contact Info
	 * @param contactInfo contact info to be given the ID
	 * @throws SQLEception if a DB error occurs
	 */
	public int obtainID(final ContactInfo contactInfo) 
			throws SQLException {
	    MyLogger.info("DataBaseController obtaining ID");
	    String query = "SELECT id FROM `contact_info` ORDER BY 1 DESC LIMIT 1;";
	    MyLogger.info(query);
	    return db.obtainID(query);
	}
    
    /**
     * Obtains the ID of the given food
     * @param food food to be given the ID
     * @throws SQLException if a DB error occurs
     */
    public int obtainID(final Food food) 
            throws SQLException {
        MyLogger.info("DataBaseController obtaining ID");
        String query = "SELECT id FROM `food` ORDER BY 1 DESC LIMIT 1;";
        MyLogger.info(query);
        return db.obtainID(query);
    }
    
    /**
     * Obtains the ID of the given recipe
     * @param recipe recipe to be given the ID
     * @throws SQLException if a DB error occurs
     */
    public int obtainID(final Recipe recipe) 
            throws SQLException {
        MyLogger.info("DataBaseController obtaining ID");
        String query = "SELECT id FROM `recipe` ORDER BY 1 DESC LIMIT 1;";
        MyLogger.info(query);
        return db.obtainID(query);
    }
	
	/**
	 * Inserts a new category into the DB
	 * @param newCategory category to be inserted
	 * @throws SQLException if a DB error occurs
	 */
	public final void createNewCategory(final Category newCategory) 
			throws SQLException {
	    MyLogger.info("DataBaseController creating new category");
	    String query = 
	            "INSERT INTO "
	            + "`category`(`name`) "
	            + "VALUES ('" + newCategory.getName() + "');";
	    MyLogger.info(query);
	    db.executeInsert(query);
	}
	
	/**
     * Inserts a new brand into the DB
     * @param newCategory category to be inserted
     * @throws SQLException if a DB error occurs
     */
    public final void createNewBrand(final Brand newBrand) 
            throws SQLException {
        MyLogger.info("DataBaseController creating new brand");
        String query = 
                "INSERT INTO "
                + "`brand`(`id`, `website`) "
                + "VALUES ('" + newBrand.getID() + "', '" + newBrand.getWebsite() + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
	
	/**
	 * Inserts a new contact info into the DB
	 * @param newContactInfo new contact info to be inserted
	 * @throws SQLException if a DB error occurs
	 */
	public final void createNewContactInfo(final ContactInfo newContactInfo) 
			throws SQLException {
	    MyLogger.info("DataBaseController creating new contact info");
	    String query = 
	    		"INSERT INTO "
	    		+ "`contact_info`(`name`, `description`, `street`, `area_code`, `city`, `country`, `phone`, `email`) "
	    		+ "VALUES ('" + newContactInfo.getName() + "', '" + newContactInfo.getDescription() 
	    		+ "', '" + newContactInfo.getStreet() + "', '" + newContactInfo.getAreaCode()
	    		+ "', '" + newContactInfo.getCity() + "', '" + newContactInfo.getCountry()
	    		+ "', '" + newContactInfo.getPhone() + "', '" + newContactInfo.getEmail() + "');";
	    MyLogger.info(query);
	    db.executeInsert(query);
	}
	
	/**
	 * Inserts a new location into the DB
	 * @param newLocation new location to be inserted
	 * @throws SQLException if a DB error occurs
	 */
	public final void createNewLocation(final Location newLocation) 
			throws SQLException {
	    MyLogger.info("DataBaseController creating new location");
	    String query = 
	    		"INSERT INTO "
	    		+ "`location`(`id`, `id_owner`) "
	    		+ "VALUES ('" + newLocation.getID() + "', '" + newLocation.getOwner().getID() + "');";
	    MyLogger.info(query);
	    db.executeInsert(query);
	}
	
	/**
	 * Inserts a new Food Creator into the DB
	 * @param newFoodCreator food creator to be inserted
	 * @param hashPassword hash of the food creator password
	 * @throws SQLException if a DB error occurs
	 */
	public final void createNewFoodCreator(final FoodCreator newFoodCreator, final String hashPassword) 
	        throws SQLException {
	    String query = 
	            "INSERT INTO "
	            + "`food_creator`(`id`, `password`) "
	            + "VALUES ('" + newFoodCreator.getID() + "', '" + hashPassword + "');";
	    db.executeInsert(query);
	}
	
	/**
     * Inserts a new User into de DB
     * @param user new user to be inserted
     * @throws SQLException if a DB error occurs
     */
    public final void createNewUser(final User user) 
            throws SQLException {
        String query = 
                "INSERT INTO "
                + "`user`(`id`, `nickname`) "
                + "VALUES ('" + user.getID() + "', '" + user.getNickName() + "');";
        db.executeInsert(query);
    }
    
	/**
	 * Inserts a new food into the DB
	 * @param newFood new food to insert
	 * @throws SQLException if a DB error occurs
	 */
    public final void createNewFood(final Food newFood) 
            throws SQLException {
        String query = 
                "INSERT INTO "
                + "`food`(`name`, `for_sell`, `price`, `id_creator`, `id_category`) "
                + "VALUES ('" + newFood.getName() + "', '" + (newFood.isForSell() ? 1 : 0) + "'"
                + ", '" + newFood.getPrice() + "', '" + newFood.getCreator().getID() +"'"
                + ", '" + newFood.getCategory().getID() + "');";
        db.executeInsert(query);
    }
    
    /**
     * Inserts a new ingredient into the DB
     * @param newIngredient new ingredient to insert
     * @throws SQLException if a DB error occurs
     */
    public final void createNewIngredient(final Ingredient newIngredient) 
            throws SQLException {
        String query = 
                "INSERT INTO "
                + "`ingredient`(`id`) "
                + "VALUES ('" + newIngredient.getID() + "');";
        db.executeInsert(query);
    }
	
    /**
     * Inserts a new dish into the DB
     * @param newDish new dish to insert
     * @throws SQLException if a DB error occurs
     */
    public final void createNewDish(final Dish newDish) 
            throws SQLException {
        
        String query = 
                "INSERT INTO "
                + "`dish`(`id`, `id_recipe`) "
                + "VALUES ('" + newDish.getID() + "', '" 
                + ((newDish.getRecipe() == null) ? -1 : newDish.getRecipe().getID()) + "');";
        db.executeInsert(query);
    }
    
    /**
     * Inserts a new drink into the DB
     * @param newDrink new drink to insert
     * @throws SQLException if a DB error occurs
     */
    public final void createNewDrink(final Drink newDrink) 
            throws SQLException {
        String query = 
                "INSERT INTO "
                + "`dish`(`id`) "
                + "VALUES ('" + newDrink.getID() + "');";
        db.executeInsert(query);
    }
    
    /**
     * Inserts a new recipe into the DB
     * @param newRecipe new recipe to insert
     * @throws SQLException if a DB error occurs
     */
    public final void createNewRecipe(final Recipe newRecipe) 
            throws SQLException {
        String query = 
                "INSERT INTO "
                + "`recipe`(`name`, `description`, `last_update`, `id_creator`, `id_dish`) "
                + "VALUES ('" + newRecipe.getName() + "', '" + newRecipe.getDescription() + "', "
                + "'" + newRecipe.getLastUpdate() + "', '" + newRecipe.getFoodCreator().getID() + "', "
                + "'" + newRecipe.getDish().getID() + "');";
        db.executeInsert(query);
    }
    
	/**
	 * Gets the drink category for drink objects
	 * @return Category drinks
	 * @throws SQLException if a DB error occurs
	 */
	public Category getDrinksCategory() 
			throws SQLException {
		
		int id      = -1;
		String name = "";
		
		Statement stmt = null;
	    String query   = 
	            "SELECT id, name "
	            + "FROM `category` "
	            + "WHERE name=\'Drinks\' ORDER BY 1 DESC LIMIT 1;";
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            id   = rs.getInt("id");
		            name = rs.getString("name");
		        }
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
	        	}
		        db.closeConnection();
		    }
	    } 
	    
	    Category drinks = new Category(name);
	    drinks.setID(id);
	    
	    return drinks;
	}
	
	/**
	 * Gets a user by its nickname/username
	 * @param nickname nickname of the user to search
	 * @return User user found
	 * @throws SQLException if a DB error occurs
	 */
    public final User getUserByNickname(final String nickname) 
            throws SQLException {
        int id             = -1;
        String name        = "";
        String description = "";
        String street      = "";
        int areaCode       = -1;
        String city        = "";
        String country     = "";
        int phone          = -1;
        String email       = "";
        
        Statement stmt = null;
        String query   = 
                "SELECT id, name, description, street, area_code, city, country, phone, email "
                + "FROM Contact_Info, Food_Creator, User "
                + "WHERE User.nickname = '" + nickname + "' LIMIT 1;";
        if (!db.isConnectionClosed()) {
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    id          = rs.getInt("id");
                    name        = rs.getString("password");
                    description = rs.getString("description");
                    street      = rs.getString("street");
                    areaCode    = rs.getInt("area_code");
                    city        = rs.getString("city");
                    country     = rs.getString("country");
                    phone       = rs.getInt("phone");
                    email       = rs.getString("email");
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                db.closeConnection();
            }
        }
        
        User newUser = new User(name, description, street, areaCode, city, country, phone, email, nickname);
        newUser.setID(id);
        
        return newUser;
    }
    
	/**
	 * Check if the password of a food creator is correct or not
	 * @param submitedPassword hash of password submited
	 * @param foodCreator food creator entering the password
	 * @return true if it is correct, false otherwise
	 * @throws SQLException if a DB error occurs
	 */
	public boolean checkHash(final String submitedPassword, final FoodCreator foodCreator) 
			throws SQLException {
		
		String password = "";
		Statement stmt  = null;
	    String query    = 
	            "SELECT password "
	            + "FROM `Food_Creator` "
	            + "WHERE id=\'" + foodCreator.getID() + "\' ORDER BY 1 DESC LIMIT 1;";
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	password = rs.getString("password");
		        }
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
	        	}
		        db.closeConnection();
		    }
	    } 
	    
	    return (password == submitedPassword);
	}
	
	/**
     * Rates a brand
     * @param brandID id of the brand
     * @param rating rating given
     * @param userID user rater
     * @throws SQLException if a DB error occurs
     */
    public final void rateBrand(final int brandID, final int rating, final int userID) 
            throws SQLException {
        MyLogger.info("DataBaseController rating brand");
        String query = 
                "INSERT INTO "
                + "`User_rates_Brand`(`id_user`, `id_brand`, `rating`) "
                + "VALUES ('" + userID + "', '" + brandID + "', '" + rating + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
    
    /**
     * Rates a brand
     * @param brandID id of the brand
     * @param rating rating given
     * @param userID user rater
     * @throws SQLException if a DB error occurs
     */
    public final void rateFood(final int foodID, final int rating, final int userID) 
            throws SQLException {
        MyLogger.info("DataBaseController rating food");
        String query = 
                "INSERT INTO "
                + "`User_rates_Food`(`id_user`, `id_food`, `rating`) "
                + "VALUES ('" + userID + "', '" + foodID + "', '" + rating + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
    
    /**
     * Rates a location
     * @param locationID id of the location
     * @param rating rating given
     * @param userID user rater
     * @throws SQLException if a DB error occurs
     */
    public final void rateLocation(final int locationID, final int rating, final int userID) 
            throws SQLException {
        MyLogger.info("DataBaseController rating location");
        String query = 
                "INSERT INTO "
                + "`User_rates_Location`(`id_user`, `id_location`, `rating`) "
                + "VALUES ('" + userID + "', '" + locationID + "', '" + rating + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
    
    /**
     * Rates a recipe
     * @param recipeID id of the recipe
     * @param rating rating given
     * @param userID user rater
     * @throws SQLException if a DB error occurs
     */
    public final void rateRecipe(final int recipeID, final int rating, final int userID) 
            throws SQLException {
        MyLogger.info("DataBaseController rating recipe");
        String query = 
                "INSERT INTO "
                + "`User_rates_Recipe`(`id_user`, `id_recipe`, `rating`) "
                + "VALUES ('" + userID + "', '" + recipeID + "', '" + rating + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
	
	/**
	 * Updates brand website
	 * @param brandID id of the brand
	 * @param newWebsite new website to be updated
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateBrandWebsite(final int brandID, final String newWebsite) 
			throws SQLException {
	    MyLogger.info("DataBaseController updating brand website");
	    String query = 
	            "UPDATE `brand` "
	            + "SET `website`=\'" + newWebsite + "\' "
	            + "WHERE id=\'" + brandID + "\';";
	    MyLogger.info(query);
	    db.executeUpdate(query);
	}
	
	/**
     * Updates the user nickname
     * @param userID id of the user
     * @param newNickName new nickname to be updated
     * @throws SQLException if a DB error occurs
     */
    public final void updateUserNickName(final int userID, final String newNickName) 
            throws SQLException {
        MyLogger.info("DataBaseController updating user nickname");
        String query = 
                "UPDATE `user` "
                + "SET `nickname`=\'" + newNickName + "\' "
                + "WHERE id=\'" + userID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
	
	/**
	 * Updates the location owner
	 * @param locationID id of the location
	 * @param brandID id of the new owner
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateLocationOwner(final int locationID, final int brandID) 
			throws SQLException {
	    MyLogger.info("DataBaseController updating brand website");
	    String query = 
	            "UPDATE `location` "
	            + "SET `id_owner`=\'" + brandID + "\' "
	            + "WHERE id=\'" + locationID + "\';";
	    MyLogger.info(query);
	    db.executeUpdate(query);
	}
	
	/**
	 * Updates the name of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newName new name to be set
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateNameContactInfo(final int contactInfoID, final String newName) 
	        throws SQLException {
	    MyLogger.info("DataBaseController updating contact info name");
        String query = 
                "UPDATE `contact_info` "
                + "SET `name`=\'" + newName + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
	}
	
	/**
	 * Updates the description of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newDescription new description to be set
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateDescriptionContactInfo(final int contactInfoID, final String newDescription) 
            throws SQLException {
	    MyLogger.info("DataBaseController updating contact info description");
        String query = 
                "UPDATE `contact_info` "
                + "SET `description`=\'" + newDescription + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
	
	/**
	 * Updates the street of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newStreet new street to be set
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateStreetContactInfo(final int contactInfoID, final String newStreet) 
            throws SQLException {
	    MyLogger.info("DataBaseController updating contact info street");
        String query = 
                "UPDATE `contact_info` "
                + "SET `street`=\'" + newStreet + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
	
	/**
	 * Updates the area code of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newAreaCode new area code to be set
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateAreaCodeContactInfo(final int contactInfoID, final int newAreaCode) 
            throws SQLException {
	    MyLogger.info("DataBaseController updating contact info area code");
        String query = 
                "UPDATE `contact_info` "
                + "SET `area_code`=\'" + newAreaCode + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
	
	/**
	 * Updates the city of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newCity new city to be set
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateCityContactInfo(final int contactInfoID, final String newCity) 
            throws SQLException {
	    MyLogger.info("DataBaseController updating contact info city");
        String query = 
                "UPDATE `contact_info` "
                + "SET `city`=\'" + newCity + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
	
	/**
	 * Updates the country of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newCountry new country to be set
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateCountryContactInfo(final int contactInfoID, final String newCountry) 
            throws SQLException {
	    MyLogger.info("DataBaseController updating contact info country");
        String query = 
                "UPDATE `contact_info` "
                + "SET `country`=\'" + newCountry + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
	
	/**
	 * Updates the phone of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newPhone new phone to be set
	 * @throws SQLException if a DB error occurs
	 */
	public final void updatePhoneContactInfo(final int contactInfoID, final int newPhone) 
            throws SQLException {
	    MyLogger.info("DataBaseController updating contact info phone");
        String query = 
                "UPDATE `contact_info` "
                + "SET `phone`=\'" + newPhone + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
	
	/**
	 * Updates the email of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newEmail new email to be set
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateEmailContactInfo(final int contactInfoID, final String newEmail) 
            throws SQLException {
	    MyLogger.info("DataBaseController updating contact info email");
        String query = 
                "UPDATE `contact_info` "
                + "SET `email`=\'" + newEmail + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
	
	/**
	 * Updates the category of a food
	 * @param foodID ID of the food to update
	 * @param categoryID ID of the new category
	 * @throws SQLException if a DB error occurs
	 */
	public final void updateFoodCategory(final int foodID, final int categoryID) 
	        throws SQLException {
	    MyLogger.info("DataBaseController updating category of food");
        String query = 
                "UPDATE `food` "
                + "SET `id_category`=\'" + categoryID + "\' "
                + "WHERE id=\'" + foodID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
	}
	
	/**
	 * Updates a food's name
	 * @param foodID id of the food to be updated
	 * @param newName new name to set
	 * @throws SQLException if a DB error occurs
	 */
    public final void updateFoodName(final int foodID, final String newName) 
            throws SQLException {
        MyLogger.info("DataBaseController updating name of food");
        String query = 
                "UPDATE `food` "
                + "SET `name`=\'" + newName + "\' "
                + "WHERE id=\'" + foodID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
    
    /**
     * Updates a recipe's name
     * @param recipeID id of the recipe to be updated
     * @param newName new name to set
     * @throws SQLException if a DB error occurs
     */
    public final void updateRecipeName(final int recipeID, final String newName) 
            throws SQLException {
        MyLogger.info("DataBaseController updating name of recipe");
        String query = 
                "UPDATE `recipe` "
                + "SET `name`=\'" + newName + "\' "
                + "WHERE id=\'" + recipeID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
    
    /**
     * Updates a recipe's description
     * @param recipeID id of the recipe to be updated
     * @param newDescription new description to set
     * @throws SQLException if a DB error occurs
     */
    public final void updateRecipeDescription(final int recipeID, final String newDescription) 
            throws SQLException {
        MyLogger.info("DataBaseController updating description of recipe");
        String query = 
                "UPDATE `recipe` "
                + "SET `description`=\'" + newDescription + "\' "
                + "WHERE id=\'" + recipeID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
    
    /**
     * Updates a recipe las update date
     * @param recipeID id of the recipe to be updated
     * @param lastUpdate date of last update
     * @throws SQLException if a DB error occurs
     */
    public final void updateRecipeLastUpdate(final int recipeID, final Date lastUpdate) 
            throws SQLException {
        MyLogger.info("DataBaseController updating description of recipe");
        String query = 
                "UPDATE `recipe` "
                + "SET `last_update`=\'" + lastUpdate + "\' "
                + "WHERE id=\'" + recipeID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
    
    /**
     * Inserts a food id and location id into the table Location_sells_food
     * @param foodID id of the food to add
     * @param locationID id of the location to add
     * @throws SQLException if a DB error occurs
     */
    public final void addFoodToLocation(final int foodID, final int locationID) 
            throws SQLException {
        MyLogger.info("DataBaseController add food to location");
        String query = 
                "INSERT INTO "
                + "`Location_sells_Food`(`id_location`, `id_food`) "
                + "VALUES ('" + locationID + "', '" + foodID + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
    
    /**
     * Follows a food creator
     * @param userID id of the user following
     * @param foodCreatorID id of the food creator followed
     * @throws SQLException if a DB error occurs
     */
    public final void followFoodCreator(final int userID, final int foodCreatorID) 
            throws SQLException {
        MyLogger.info("DataBaseController following");
        String query = 
                "INSERT INTO "
                + "`Followers`(`id_user`, `id_followed`) "
                + "VALUES ('" + userID + "', '" + foodCreatorID + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
    
    /**
     * Unfollows a food creator
     * @param userID id of the user following
     * @param foodCreatorID id of the food creator followed
     * @throws SQLException if a DB error occurs
     */
    public final void unFollowFoodCreator(final int userID, final int foodCreatorID) 
            throws SQLException {
        MyLogger.info("DataBaseController unfollowing");
        String query = 
                "DELETE FROM Followers "
                + "WHERE id_user=\'" + userID + " AND id_followed=\'" + foodCreatorID;
        MyLogger.info(query);
        db.executeDelete(query);
    }
    
    /**
     * Updates if a food is for sell or not
     * @param foodID ID of the food to update
     * @param isForSell boolean where true means this food is for sell
     * @throws SQLException if a DB error occurs
     */
    public final void updateFoodForSell(final int foodID, final boolean isForSell) 
            throws SQLException {
        MyLogger.info("DataBaseController updating for_sell of food");
        String query = 
                "UPDATE `food` "
                + "SET `for_sell`=\'" + (isForSell ? 1 : 0) + "\' "
                + "WHERE id=\'" + foodID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
    
    /**
     * Updates the price of a food
     * @param foodID ID of the food to update
     * @param newPrice new price to be set
     * @throws SQLException if a DB error occurs
     */
    public final void updateFoodPrice(final int foodID, final float newPrice) 
            throws SQLException {
        MyLogger.info("DataBaseController updating price of food");
        String query = 
                "UPDATE `food` "
                + "SET `price`=\'" + newPrice + "\' "
                + "WHERE id=\'" + foodID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
    
    /**
     * Updates the price of a food
     * @param foodID ID of the food to update
     * @param newPrice new price to be set
     * @throws SQLException if a DB error occurs
     */
    public final void updateDishRecipe(final int dishID, final float recipeID) 
            throws SQLException {
        MyLogger.info("DataBaseController updating recipe of dish");
        String query = 
                "UPDATE `dish` "
                + "SET `id_recipe`=\'" + recipeID + "\' "
                + "WHERE id=\'" + dishID + "\';";
        MyLogger.info(query);
        db.executeUpdate(query);
    }
    
    /**
     * Adds a food to a dish
     * @param dishID id of the dish
     * @param foodID id of the food to add
     * @throws SQLException if a DB error occurs
     */
    public final void addFoodToDish(final int dishID, final int foodID) 
            throws SQLException {
        MyLogger.info("DataBaseController add food to dish");
        String query = 
                "INSERT INTO "
                + "`Dish_has_Food`(`id_dish`, `id_food`) "
                + "VALUES ('" + dishID + "', '" + foodID + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
    
    /**
     * Inserts a food id and user id to the wish list of user
     * @param foodID id of the food to add
     * @param userID id of the user to add
     * @throws SQLException if a DB error occurs
     */
    public final void addUserWantingFood(final int foodID, final int userID) 
            throws SQLException {
        MyLogger.info("DataBaseController rating brand");
        String query = 
                "INSERT INTO "
                + "`User_Wishlist`(`id_user`, `id_food`) "
                + "VALUES ('" + userID + "', '" + foodID + "');";
        MyLogger.info(query);
        db.executeInsert(query);
    }
    
    /**
     * Deletes a user and food from the wish list
     * @param foodID id of the food to remove
     * @param userID id of the user to remove
     * @throws SQLException if a DB error occurs
     */
    public final void deleteUserWantingFood(final int foodID, final int userID) 
            throws SQLException {
        MyLogger.info("DataBaseController rating brand");
        String query = 
                "DELETE FROM User_Wishlist"
                + "WHERE id_food=\'" + foodID + " AND id_user=\'" + userID;
        MyLogger.info(query);
        db.executeDelete(query);
    }
}
