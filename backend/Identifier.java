package backend;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to obtain ID of the object and know its position inside the DB
 * @author rguimerao
 *
 */
public class Identifier {

	private int ID;
	private static final Logger LOGGER = Logger.getLogger("Identifier");

	/**
	 * Constructor of class
	 * TODO
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
	 * Obtains the ID from the DB
	 */
	public void obtainID() {
		/*
		 * TODO
		 * this.ID = controller.getObjectID();
		 */
		LOGGER.log(Level.INFO, "ID of identifier has been obtained with result = " + this.ID);
	}

}
