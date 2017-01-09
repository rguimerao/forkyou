package DB;

/**
 * TODO
 */
public class DB {
	// TODO -> JDBC API
	// TODO -> java.sql

	/**
	 * TODO
	 */
  public DB() {
		// TODO -> singleton
		/* EXAMPLE
		Connection con = DriverManager.getConnection(
                         "jdbc:myDriver:myDatabase",
                         username,
                         password);

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");

    while (rs.next()) {
        int x = rs.getInt("a");
        String s = rs.getString("b");
        float f = rs.getFloat("c");
    } */

	}

	/**
	 *	TODO
	 */
	public boolean connect() {

	}

	/**
	 *	TODO
	 */
	public void disconnect() { // return boolean?

	}

	/**
	 *	TODO
	 */
	public void executeQuery(String query) { // TODO -> return type? -> review java.sql?
		if (this.DB.connect()) {
			this.DB.executeQuery(query);
			this.DB.disconnect();
		}
	}
}
