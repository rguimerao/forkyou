package DB_controllers;

import DB.DataBase;
import backend.Brand;
import backend.Category;
import backend.ContactInfo;
import backend.FoodCreator;
import backend.Location;
import backend.User;
import testing.myLogger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		myLogger.getInstance().info("DataBaseController created");
	}
	
	/**
	 * Returns the instance of itself
	 * @return instance of this object
	 */
	public final static DataBaseController getInstance()  {
	    myLogger.getInstance().info("Get instance DBController");
		if (instance == null) {
			try {
                instance = new DataBaseController();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
			myLogger.getInstance().info("Instance was null, new created");
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
	    myLogger.getInstance().info("DataBaseController obtaining ID");
	    String query = "SELECT id FROM `category` ORDER BY 1 DESC LIMIT 1;";
	    myLogger.getInstance().info(query);
        return db.obtainID(query);
	}
	
	/**
	 * Obtains the ID of the given brand
	 * @param brand brand to be given the ID
	 * @throws SQLEception if a DB error occurs
	 */
	public int obtainID(final Brand brand) 
			throws SQLException {
	    myLogger.getInstance().info("DataBaseController obtaining ID");
	    String query = "SELECT id FROM `brand` ORDER BY 1 DESC LIMIT 1;";
	    myLogger.getInstance().info(query);
        return db.obtainID(query);
	}
	
	/**
	 * Obtains the ID of the given location
	 * @param location location to be given the ID
	 * @throws SQLEception if a DB error occurs
	 */
	public int obtainID(final Location location) 
			throws SQLException {
	    myLogger.getInstance().info("DataBaseController obtaining ID");
	    String query = "SELECT id FROM `location` ORDER BY 1 DESC LIMIT 1;";
	    myLogger.getInstance().info(query);
        return db.obtainID(query);
	}
	
	/**
	 * Obtains the ID of the given Contact Info
	 * @param contactInfo contact info to be given the ID
	 * @throws SQLEception if a DB error occurs
	 */
	public int obtainID(final ContactInfo contactInfo) 
			throws SQLException {
	    myLogger.getInstance().info("DataBaseController obtaining ID");
	    String query = "SELECT id FROM `contact_info` ORDER BY 1 DESC LIMIT 1;";
	    myLogger.getInstance().info(query);
	    return db.obtainID(query);
	}
	
	/**
     * Obtains the ID of the given Contact Info
     * @param contactInfo contact info to be given the ID
     * @throws SQLEception if a DB error occurs
     */
    public int obtainID(final FoodCreator foodCreator) 
            throws SQLException {
        myLogger.getInstance().info("DataBaseController obtaining ID");
        String query = "SELECT id FROM `food_creator` ORDER BY 1 DESC LIMIT 1;";
        myLogger.getInstance().info(query);
        return db.obtainID(query);
    }
	
	/**
	 * Inserts a new category into the DB
	 * @param newCategory category to be inserted
	 * @throws SQLException if a DB error occurs
	 */
	public final void createNewCategory(final Category newCategory) 
			throws SQLException {
	    myLogger.getInstance().info("DataBaseController creating new category");
	    String query = 
	            "INSERT INTO "
	            + "`category`(`name`) "
	            + "VALUES ('" + newCategory.getName() + "');";
	    myLogger.getInstance().info(query);
	    db.executeInsert(query);
	}
	
	/**
	 * Inserts a new contact info into the DB
	 * @param newContactInfo new contact info to be inserted
	 * @throws SQLException if a DB error occurs
	 */
	public final void createNewContactInfo(final ContactInfo newContactInfo) 
			throws SQLException {
	    myLogger.getInstance().info("DataBaseController creating new contact info");
	    String query = 
	    		"INSERT INTO "
	    		+ "`contact_info`(`name`, `description`, `street`, `postal_code`, `city`, `country`, `phone_number`, `email`) "
	    		+ "VALUES ('" + newContactInfo.getName() + "', '" + newContactInfo.getDescription() 
	    		+ "', '" + newContactInfo.getStreet() + "', '" + newContactInfo.getAreaCode()
	    		+ "', '" + newContactInfo.getCity() + "', '" + newContactInfo.getCountry()
	    		+ "', '" + newContactInfo.getPhone() + "', '" + newContactInfo.getEmail() + "');";
	    myLogger.getInstance().info(query);
	    db.executeInsert(query);
	}
	
	/**
	 * Inserts a new location into the DB
	 * @param newLocation new location to be inserted
	 * @throws SQLException if a DB error occurs
	 */
	public final void createNewLocation(final Location newLocation) 
			throws SQLException {
	    myLogger.getInstance().info("DataBaseController creating new location");
	    String query = 
	    		"INSERT INTO "
	    		+ "`location`(`id`, `id_owner`) "
	    		+ "VALUES ('" + newLocation.getID() + "', '" + newLocation.getOwner().getID() + "');";
	    myLogger.getInstance().info(query);
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
                    areaCode    = rs.getInt("postal_code");
                    city        = rs.getString("city");
                    country     = rs.getString("country");
                    phone       = rs.getInt("phone_number");
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
        myLogger.getInstance().info("DataBaseController rating brand");
        String query = 
                "INSERT INTO "
                + "`User_rates_Brand`(`id_user`, `id_brand`, `rating`) "
                + "VALUES ('" + userID + "', '" + brandID + "', '" + rating + "');";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updateing brand website");
	    String query = 
	            "UPDATE `brand` "
	            + "SET `website`=\'" + newWebsite + "\' "
	            + "WHERE id=\'" + brandID + "\';";
	    myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating brand website");
	    String query = 
	            "UPDATE `location` "
	            + "SET `id_owner`=\'" + brandID + "\' "
	            + "WHERE id=\'" + locationID + "\';";
	    myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating contact info name");
        String query = 
                "UPDATE `contact_info` "
                + "SET `name`=\'" + newName + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating contact info description");
        String query = 
                "UPDATE `contact_info` "
                + "SET `description`=\'" + newDescription + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating contact info street");
        String query = 
                "UPDATE `contact_info` "
                + "SET `street`=\'" + newStreet + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating contact info area code");
        String query = 
                "UPDATE `contact_info` "
                + "SET `area_code`=\'" + newAreaCode + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating contact info city");
        String query = 
                "UPDATE `contact_info` "
                + "SET `city`=\'" + newCity + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating contact info country");
        String query = 
                "UPDATE `contact_info` "
                + "SET `country`=\'" + newCountry + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating contact info phone");
        String query = 
                "UPDATE `contact_info` "
                + "SET `phone`=\'" + newPhone + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating contact info email");
        String query = 
                "UPDATE `contact_info` "
                + "SET `email`=\'" + newEmail + "\' "
                + "WHERE id=\'" + contactInfoID + "\';";
        myLogger.getInstance().info(query);
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
	    myLogger.getInstance().info("DataBaseController updating category of food");
        String query = 
                "UPDATE `food` "
                + "SET `id_category`=\'" + categoryID + "\' "
                + "WHERE id=\'" + foodID + "\';";
        myLogger.getInstance().info(query);
        db.executeUpdate(query);
	}
}
