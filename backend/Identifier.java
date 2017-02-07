package backend;

import DB_controllers.DataBaseController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to obtain ID of the object and know its position inside the DB
 * @author rguimerao
 *
 */
public class Identifier {

    protected int ID;
    private static final Logger LOGGER = Logger.getLogger("Identifier");

    /**
     * Constructor of class
     * Starts the id with -1
     * After that, the obtain ID must be called from controller
     */
    public Identifier() {
        this.ID = -1;
        LOGGER.log(Level.INFO, "An identifier has been created");
    }

    /**
     * Getter of ID
     * @return ID of the object inside the DB
     */
    public int getID() {
        LOGGER.log(Level.INFO, "ID of identifier with ID = " + this.ID + " has been getted");
        return this.ID;
    }
	
    /**
     * Sets the new ID for this object
     * @param newID new ID to be updated
     */
    public void setID(int newID) {
        this.ID = newID;
        LOGGER.log(Level.INFO, "ID of identifier setted, new ID is: " + newID);
    }
	
    /**
     * Obtains the ID from the DB
     * It is overrided
     */
    public void obtainID(final DataBaseController dbController) 
            throws ClassNotFoundException, SQLException {
        LOGGER.log(Level.SEVERE, "obtainID in Identifier");
    }
}
