package backend;

/**
 * TODO
 */
public class Identifier {

	private static int maxID; // TODO -> review/test this
	protected int ID;

	/**
	 * TODO
	 */
  public Identifier() {

		if(maxID == null) {
			maxID = 0; // TODO -> review
			// maxID = new Integer();
		}

		maxID++;
		this.ID = maxID;
	}

	/**
	 * TODO
	 */
	public int getID() {
		return this.ID;
	}

}
