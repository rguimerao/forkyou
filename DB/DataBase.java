package DB;

import testing.myLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private static Connection connection;
    private static final String url = "jdbc:mysql://127.0.0.1:3306/fork_you_db";
    private static final String username = "root";
    private static final String password = "";
    
    /**
     * Constructor of DataBase - singleton
     * @throws SQLException if the connection can not be done
     * @throws ClassNotFoundException if the driver is not found
     */
    private DataBase() 
            throws SQLException, ClassNotFoundException {
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
            myLogger.getInstance().info("Driver com.mysql.jdbc.Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
    	
        try {
            connection = DriverManager.getConnection(url, username, password);
            
            if (!isConnectionClosed()) {
                myLogger.getInstance().info("Connection to DB successful!");
            } else {
                myLogger.getInstance().severe("ERROR! CONNECTION IS CLOSED");
            }
            
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    /**
     * Gets instance - singleton
     * @return instance of the database
     * @throws SQLException if the connection can not be done
     * @throws ClassNotFoundException if the driver is not found
     */
    public final static DataBase getInstance() 
            throws SQLException, ClassNotFoundException {
    	
        if (instance == null) {
            myLogger.getInstance().info("Instance of DB is null, creating new one");
            instance = new DataBase();
        } else if (instance.getConnection().isClosed()) {
            myLogger.getInstance().info("Connection is closed, creating new one");
            instance = new DataBase();
        } else {
            myLogger.getInstance().info("Instance of DB is not null and it is opened, returning current instance");
        }

        return instance;
    }
    
    /**
     * Returns current connection
     * @return current connection
     */
    public final Connection getConnection() {
        myLogger.getInstance().info("Connection of DB returned");
        return connection;
    }
    
    /**
     * Gets the connection status if it is closed or not
     * @return true if the connection is closed, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public final boolean isConnectionClosed() 
            throws SQLException {
        try {
            myLogger.getInstance().info("Status of DB getted");
            return connection.isClosed();
        } catch (SQLException e) {
            throw new SQLException("Database error access ocurred", e);
        }
    }
    
    /**
     * Closes the current connection
     * @throws SQLException if a database access error occurs
     */
    public final void closeConnection() 
            throws SQLException {
        try {
            instance.getConnection().close();
            myLogger.getInstance().info("DB connection closed");
        } catch (SQLException e) {
            throw new SQLException("Database error access ocurred", e);
        }
    }

    /**
     * Executes and INSERT query
     * @param query INSERT query to be executed
     * @throws SQLException if a DB error occurs
     */
    public final void executeInsert(final String query) 
            throws SQLException {
        myLogger.getInstance().info("Query received is:\n" + query);
        Statement stmt = null;
        if (!isConnectionClosed()) {
            try {
                stmt = getConnection().createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                closeConnection();
            }
        }
    }
    
    /**
     * Executes an UPDATE query
     * @param query UPDATE query to be executed
     * @throws SQLException if a DB error occurs
     */
    public final void executeUpdate(final String query) 
            throws SQLException {
        myLogger.getInstance().info("Query received is:\n" + query);
        Statement stmt = null;
        if (!isConnectionClosed()) {
            try {
                stmt = getConnection().createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                closeConnection();
            }
        }
    }
    
    /**
     * Executes a SELECT query for only the ID param
     * @param query SELECT query to be executed, only for ID
     * @return ID obtained
     * @throws SQLException if a DB error occurs
     */
    public final int obtainID(final String query) 
            throws SQLException  {
        myLogger.getInstance().info("Query received is:\n" + query);
        int id = -1;
        Statement stmt = null;
        if (!isConnectionClosed()) {
            try {
                stmt = getConnection().createStatement();
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
                closeConnection();
            }
        }
        myLogger.getInstance().info("ID sent is: " + id);
        return id;
    }
}
