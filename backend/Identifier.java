package backend;

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
    }

    /**
     * Getter of ID
     * @return ID of the object inside the DB
     */
    public int getID() {
        return this.ID;
    }
	
    /**
     * Sets the new ID for this object
     * @param newID new ID to be updated
     */
    public void setID(int newID) {
        this.ID = newID;
    }
	
    /**
     * Obtains the ID from the DB
     * It is overridden
     */
    public void obtainID() {
    }
}
