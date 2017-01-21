package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class DataBase
 * Lets the user connect to a DB
 * It is only made for tests, not commercial distribution
 * Only localhost connection
 * @author rguimerao
 *
 */
public class DataBase{
	
	private static DataBase instance;
    private Connection connection;
    private static final String url      = "jdbc:mysql://127.0.0.1:3306/fork_you_db";
    private static final String username = "root";
    private static final String password = "";
    private static final Logger LOGGER = Logger.getLogger("DataBase");
    
    /**
     * Constructor of DataBase - singleton
     * @throws SQLException if the connection can not be done
     * @throws ClassNotFoundException if the driver is not found
     */
    private DataBase() throws SQLException, ClassNotFoundException {
    	try {
    	    Class.forName("com.mysql.jdbc.Driver");
    	    LOGGER.log(Level.INFO, "Loading com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    	    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
    	}
    	
    	try (Connection connection = DriverManager.getConnection(url, username, password)) {
    		LOGGER.log(Level.INFO, "Connection to DB");
    	} catch (SQLException e) {
    	    throw new IllegalStateException("Cannot connect the database!", e);
    	}
    }
    
    /**
     * Returns current connection
     * @return current connection
     */
    public Connection getConnection() {
    	LOGGER.log(Level.INFO, "Connection of DB returned");
        return this.connection;
    }

    /**
     * Gets instance - singleton
     * @return instance of the database
     * @throws SQLException if the connection can not be done
     * @throws ClassNotFoundException if the driver is not found
     */
    public static DataBase getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DataBase();
            LOGGER.log(Level.INFO, "Instance of DB was null, new created");
        } else if (instance.getConnection().isClosed()) {
        	LOGGER.log(Level.INFO, "Instance of DB was closed, new created");
            instance = new DataBase();
        } else {
        	LOGGER.log(Level.SEVERE, "CRITICAL ERROR! GETTING INSTANCE OF DATABASE!");
        }

        return instance;
    }
}
