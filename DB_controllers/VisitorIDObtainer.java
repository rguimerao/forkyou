package DB_controllers;

import java.sql.SQLException;

import backend.Category;

/**
 * Interface VisitorIDObtainer
 * Here we find every function to implement for object which need to obtain an ID
 * @author rguimerao
 *
 */
public interface VisitorIDObtainer {

	int obtainID(Category category) throws SQLException, ClassNotFoundException;
}
