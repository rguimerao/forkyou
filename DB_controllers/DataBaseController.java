package DB_controllers;


import DB.DataBase;
import backend.Brand;
import backend.Category;
import backend.ContactInfo;
import backend.FoodCreator;
import backend.Location;
import backend.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static final Logger LOGGER = Logger.getLogger("DataBaseController");
	
	/**
	 * Constructor - Singleton
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private DataBaseController() 
			throws ClassNotFoundException, SQLException {
		db = db.getInstance();
		LOGGER.log(Level.INFO, "DataBaseController created");
	}
	
	/**
	 * Returns an object of itself
	 * @return instance of the class
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final static DataBaseController getInstance() 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "Get instance DBController");
		if (instance == null) {
			instance = new DataBaseController();
			LOGGER.log(Level.INFO, "Instance was null, new created");
		}
		
		return instance;
	}

	/**
	 * Obtains the ID of the given category
	 * @param category category to be given the ID
	 * @throws SQLEception
	 * @throws ClassNotFoundException
	 */
	public int obtainID(final Category category) 
			throws SQLException, ClassNotFoundException {
	    LOGGER.log(Level.INFO, "DataBaseController obtaining ID");
	    String query = "SELECT id FROM `category` ORDER BY 1 DESC LIMIT 1;";
        LOGGER.log(Level.INFO, query);
        return db.obtainID(query);
	}
	
	/**
	 * Obtains the ID of the given brand
	 * @param brand brand to be given the ID
	 * @throws SQLEception
	 * @throws ClassNotFoundException
	 */
	public int obtainID(final Brand brand) 
			throws SQLException, ClassNotFoundException {
	    LOGGER.log(Level.INFO, "DataBaseController obtaining ID");
	    String query = "SELECT id FROM `brand` ORDER BY 1 DESC LIMIT 1;";
	    LOGGER.log(Level.INFO, query);
        return db.obtainID(query);
	}
	
	/**
	 * Obtains the ID of the given location
	 * @param location location to be given the ID
	 * @throws SQLEception
	 * @throws ClassNotFoundException
	 */
	public int obtainID(final Location location) 
			throws SQLException, ClassNotFoundException {
	    LOGGER.log(Level.INFO, "DataBaseController obtaining ID");
	    String query = "SELECT id FROM `location` ORDER BY 1 DESC LIMIT 1;";
	    LOGGER.log(Level.INFO, query);
        return db.obtainID(query);
	}
	
	/**
	 * Obtains the ID of the given Contact Info
	 * @param contactInfo contact info to be given the ID
	 * @throws SQLEception
	 * @throws ClassNotFoundException
	 */
	public int obtainID(final ContactInfo contactInfo) 
			throws SQLException, ClassNotFoundException {
		LOGGER.log(Level.INFO, "DataBaseController obtaining ID");
	    String query = "SELECT id FROM `contact_info` ORDER BY 1 DESC LIMIT 1;";
	    LOGGER.log(Level.INFO, query);
	    return db.obtainID(query);
	}
	
	/**
	 * Inserts a new category into the DB
	 * @param newCategory category to be inserted
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewCategory(final Category newCategory) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController creating new category");
	    String query = "INSERT INTO `category`(`name`) VALUES ('" + newCategory.getName() + "');";
	    LOGGER.log(Level.INFO, query);
	    db.executeInsert(query);
	}
	
	/**
	 * Inserts a new contact info into the DB
	 * @param newContactInfo new contact info to be inserted
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewContactInfo(final ContactInfo newContactInfo) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController creating new contact info");
	    String query = 
	    		"INSERT INTO "
	    		+ "`contact_info`(`name`, `description`, `street`, `postal_code`, `city`, `country`, `phone_number`, `email`) "
	    		+ "VALUES ('" + newContactInfo.getName() + "', '" + newContactInfo.getDescription() 
	    		+ "', '" + newContactInfo.getStreet() + "', '" + newContactInfo.getAreaCode()
	    		+ "', '" + newContactInfo.getCity() + "', '" + newContactInfo.getCountry()
	    		+ "', '" + newContactInfo.getPhone() + "', '" + newContactInfo.getEmail() + "');";
	    LOGGER.log(Level.INFO, query);
	    db.executeInsert(query);
	}
	
	/**
	 * Inserts a new location into the DB
	 * @param newLocation new location to be inserted
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewLocation(final Location newLocation) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController creating new location");
	    String query = 
	    		"INSERT INTO "
	    		+ "`location`(`id`, `id_owner`) "
	    		+ "VALUES ('" + newLocation.getID() + "', '" + newLocation.getOwner().getID() + "');";
	    LOGGER.log(Level.INFO, query);
	    db.executeInsert(query);
	}
	
	/**
	 * 
	 * @param newFoodCreator
	 * @param hashPassword
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewFoodCreator(final FoodCreator newFoodCreator, final String hashPassword) 
	        throws ClassNotFoundException, SQLException {
	    String query = 
	            "INSERT INTO `food_creator`(`id`, `password`) "
	            + "VALUES ('" + newFoodCreator.getID() + "', '" + hashPassword + "');";
	    db.executeInsert(query);
	}
	
	/**
	 * 
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewUser(final User user) 
	        throws ClassNotFoundException, SQLException {
	    String query = 
                "INSERT INTO `user`(`id`, `nickname`) "
                + "VALUES ('" + user.getID() + "', '" + user.getNickName() + "');";
        db.executeInsert(query);
	}
	
	/**
	 * Gets the drink category for drink objects
	 * @return Category drinks
	 * @throws SQLException
	 */
	public Category getDrinksCategory() 
			throws SQLException {
		
		int id      = -1;
		String name = "";
		
		Statement stmt = null;
	    String query   = "SELECT id, name FROM `category` WHERE name=\'Drinks\' ORDER BY 1 DESC LIMIT 1;";
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            id = rs.getInt("id");
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
	 * 
	 * @param nickname
	 * @return
	 * @throws SQLException
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
        String query = 
                "SELECT id, name, description, street, area_code, city, country, phone, email "
                + "FROM Contact_Info, Food_Creator, User "
                + "WHERE User.nickname = '" + nickname + "';";
        if (!db.isConnectionClosed()) {
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    id          = rs.getInt("id");
                    name        = rs.getString("password");
                    description = rs.getString("description");
                    street      = rs.getString("street");
                    areaCode  = rs.getInt("postal_code");
                    city        = rs.getString("city");
                    country     = rs.getString("country");
                    phone = rs.getInt("phone_number");
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
	 * @throws SQLException
	 */
	public boolean checkHash(final String submitedPassword, final FoodCreator foodCreator) 
			throws SQLException {
		
		String password = "";
		Statement stmt  = null;
	    String query = 
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
	 * Updates brand website
	 * @param brandID id of the brand
	 * @param newWebsite new website to be updated
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void updateBrandWebsite(final int brandID, final String newWebsite) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController updateing brand website");
	    String query = "UPDATE `brand` SET `website`=\'" + newWebsite + "\' WHERE id=\'" + brandID + "\';";
	    LOGGER.log(Level.INFO, query);
	    db.executeUpdate(query);
	}
	
	/**
	 * Updates the location owner
	 * @param locationID id of the location
	 * @param brandID id of the new owner
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void updateLocationOwner(final int locationID, final int brandID) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController updateing brand website");
	    String query = "UPDATE `location` SET `id_owner`=\'" + brandID + "\' WHERE id=\'" + locationID + "\';";
	    LOGGER.log(Level.INFO, query);
	    db.executeUpdate(query);
	}
	
	/**
	 * Rates a brand
	 * @param brandID id of the brand
	 * @param rating rating given
	 * @param userID user rater
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public final void rateBrand(final int brandID, final int rating, final int userID) 
			throws SQLException, ClassNotFoundException {
		LOGGER.log(Level.INFO, "DataBaseController rating brand");
	    String query = 
	    		"INSERT INTO `User_rates_Brand`(`id_user`, `id_brand`, `rating`) "
	    		+ "VALUES ('" + userID + "', '" + brandID + "', '" + rating + "');";
	    LOGGER.log(Level.INFO, query);
	    db.executeInsert(query);
	}
}
