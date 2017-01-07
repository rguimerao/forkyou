package backend;

public class Identifier {

	private static int maxID; // TODO -> review/test this
	protected int ID;

  public Identifier() {

		if(maxID == null) {
			maxID = new Integer();
		}

		maxID++;
		this.ID = maxID;
	}

	public int getID() {
		return this.ID;
	}

}
