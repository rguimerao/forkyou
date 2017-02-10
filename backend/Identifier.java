package backend;

import testing.myLogger;

/**
 * Class to obtain ID of the object and know its position inside the DB
 * @author rguimerao
 *
 */
public class Identifier {

    private int ID;

    /**
     * Constructor of class
     * Starts the id with -1
     * After that, the obtain ID must be called from controller
     */
    public Identifier() {
        this.ID = -1;
        myLogger.getInstance().info("An identifier has been created");
    }

    /**
     * Getter of ID
     * @return ID of the object inside the DB
     */
    public int getID() {
        myLogger.getInstance().info("ID of identifier with ID = " + this.ID + " has been getted");
        return this.ID;
    }
	
    /**
     * Sets the new ID for this object
     * @param newID new ID to be updated
     */
    public void setID(int newID) {
        this.ID = newID;
        myLogger.getInstance().info("ID of identifier setted, new ID is: " + newID);
    }
	
    /**
     * Obtains the ID from the DB
     * It is overridden
     */
    public void obtainID() {
        myLogger.getInstance().severe("obtainID in Identifier");
    }
}
