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
	private static final Logger LOGGER = Logger.getLogger("DataBaseController");
	
	/**
	 * TODO
	 */
	private DataBaseController() {
		LOGGER.log(Level.INFO, "DataBaseController created");
	}
	
	/**
	 * TODO
	 * @return
	 */
	public final static DataBaseController getInstance() {
		LOGGER.log(Level.INFO, "Get instance DBController");
		instance = new DataBaseController();
		return instance;
	}
	
	/**
	 * TODO
	 * @param newCategory
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public final void createNewCategory(Category newCategory) 
			throws ClassNotFoundException, SQLException {
		LOGGER.log(Level.INFO, "DataBaseController creating new category");
		DataBase db = null;
		db = db.getInstance();
		
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
		        if (stmt != null) { stmt.close(); }
		    }
	    }
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public int obtainID(Category category) 
			throws SQLException, ClassNotFoundException {
		
		DataBase db = null;
		db          = db.getInstance();
		int id      = -1;
		
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
		        if (stmt != null) { stmt.close(); }
		    }
	    }
	    
	    return id;
	}
}
