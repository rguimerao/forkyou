package DB_controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import backend.*;
import DB.DataBase;

/**
 * TODO
 * @author rguimerao
 *
 */
public class DataBaseController implements VisitorIDObtainer {

	private static DataBaseController instance;
	private static DataBase db = null;
	private static final Logger LOGGER = Logger.getLogger("DataBaseController");
	
	/**
	 * TODO
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private DataBaseController() 
			throws ClassNotFoundException, SQLException {
		db = db.getInstance();
		LOGGER.log(Level.INFO, "DataBaseController created");
	}
	
	/**
	 * TODO
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public final static DataBaseController getInstance() 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "Get instance DBController");
		instance = new DataBaseController();
		return instance;
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public int obtainID(final Category category) 
			throws SQLException, ClassNotFoundException {
		
		int id = -1;
		
		Statement stmt = null;
	    String query   = "SELECT id FROM `category` ORDER BY 1 DESC LIMIT 1";
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            id = rs.getInt("id");
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
	    
	    return id;
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public int obtainID(final Brand brand) 
			throws SQLException, ClassNotFoundException {
		
		int id = -1;
		
		Statement stmt = null;
	    String query   = "SELECT id FROM `brand` ORDER BY 1 DESC LIMIT 1";
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            id = rs.getInt("id");
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
	    
	    return id;
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public int obtainID(final Location location) 
			throws SQLException, ClassNotFoundException {
		
		int id = -1;
		
		Statement stmt = null;
	    String query   = "SELECT id FROM `location` ORDER BY 1 DESC LIMIT 1";
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            id = rs.getInt("id");
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
	    
	    return id;
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public int obtainID(final ContactInfo contactInfo) 
			throws SQLException, ClassNotFoundException {
		
		int id = -1;
		
		Statement stmt = null;
	    String query   = "SELECT id FROM `contact_info` ORDER BY 1 DESC LIMIT 1";
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            id = rs.getInt("id");
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
	    
	    return id;
	}
	
	/**
	 * TODO
	 * @param newCategory
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewCategory(final Category newCategory) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController creating new category");
		
		Statement stmt = null;
	    String query   = "INSERT INTO `category`(`name`) VALUES ('" + newCategory.getName() + "')";
	    LOGGER.log(Level.INFO, query);
	    
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        stmt.executeUpdate(query);
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
		        }
		        db.closeConnection();
		    }
	    }
	}
	
	/**
	 * TODO
	 * @param newContactInfo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewContactInfo(final ContactInfo newContactInfo) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController creating new contact info");
		
		Statement stmt = null;
	    String query   = 
	    		"INSERT INTO "
	    		+ "`contact_info`(`name`, `description`, `street`, `postal_code`, `city`, `country`, `phone_number`, `email`) "
	    		+ "VALUES ('" + newContactInfo.getName() + "', '" + newContactInfo.getDescription() 
	    		+ "', '" + newContactInfo.getStreet() + "', '" + newContactInfo.getPostalCode()
	    		+ "', '" + newContactInfo.getCity() + "', '" + newContactInfo.getCountry()
	    		+ "', '" + newContactInfo.getPhoneNumber() + "', '" + newContactInfo.getEmail() + "')";
	    LOGGER.log(Level.INFO, query);
	    
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        stmt.executeUpdate(query);
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
		        }
		        db.closeConnection();
		    }
	    }
	}
	
	/**
	 * TODO
	 * @param newLocation
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewLocation(final Location newLocation) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController creating new location");
		
		Statement stmt = null;
	    String query   = 
	    		"INSERT INTO "
	    		+ "`location`(`id`, `id_owner`) "
	    		+ "VALUES ('" + newLocation.getID() + "', '" + newLocation.getOwner().getID() + "')";
	    LOGGER.log(Level.INFO, query);
	    
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        stmt.executeUpdate(query);
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
		        }
		        db.closeConnection();
		    }
	    }
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Category getDrinksCategory() 
			throws SQLException {
		
		int id      = -1;
		String name = "";
		
		Statement stmt = null;
	    String query   = "SELECT id, name FROM `category` WHERE name=\'Drinks\' ORDER BY 1 DESC LIMIT 1";
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
	 * @param submitedPassword
	 * @param foodCreator
	 * @return
	 * @throws SQLException
	 */
	public boolean checkHash(final String submitedPassword, final FoodCreator foodCreator) 
			throws SQLException {
		
		String password = "";
		
		Statement stmt = null;
	    String query   = "SELECT password FROM `Food_Creator` WHERE id=\'" + foodCreator.getID() + "\' ORDER BY 1 DESC LIMIT 1";
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
	 * 
	 * @param brandID
	 * @param newWebsite
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void updateBrandWebsite(final int brandID, final String newWebsite) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController updateing brand website");
		
		Statement stmt = null;
	    String query   = "UPDATE `brand` SET `website`=\'" + newWebsite + "\' WHERE id=\'" + brandID + "\'";
	    LOGGER.log(Level.INFO, query);
	    
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        stmt.executeUpdate(query);
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
		        }
		        db.closeConnection();
		    }
	    }
	}
	
	/**
	 * 
	 * @param brandID
	 * @param newWebsite
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void updateLocationOwner(final int locationID, final int brandID) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController updateing brand website");
		
		Statement stmt = null;
	    String query   = "UPDATE `location` SET `id_owner`=\'" + brandID + "\' WHERE id=\'" + locationID + "\'";
	    LOGGER.log(Level.INFO, query);
	    
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        stmt.executeUpdate(query);
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
		        }
		        db.closeConnection();
		    }
	    }
	}
	
	public final void rateBrand(final int brandID, final int rating, final int userID) 
			throws SQLException {
		LOGGER.log(Level.INFO, "DataBaseController rating brand");
		
		Statement stmt = null;
	    String query   = 
	    		"INSERT INTO `User_rates_Brand`(`id_user`, `id_brand`, `rating`) "
	    		+ "VALUES ('" + userID + "', '" + brandID + "', '" + rating + "')";
	    LOGGER.log(Level.INFO, query);
	    
	    if (!db.isConnectionClosed()) {
	    	try {
		        stmt = db.getConnection().createStatement();
		        stmt.executeUpdate(query);
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
		        }
		        db.closeConnection();
		    }
	    }
	}
}
