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
	 * TODO
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
	 * Obtains the ID from the DB
	 */
	protected void obtainID() {
		/*
		 * TODO
		 * this.ID = controller.getObjectID();
		 */
	}

}
