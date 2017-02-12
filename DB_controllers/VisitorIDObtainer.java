package DB_controllers;

import backend.Category;
import backend.ContactInfo;
import backend.Food;
import backend.Recipe;
import java.sql.SQLException;

/**
 * Interface VisitorIDObtainer
 * Here we find every function to implement for object which need to obtain an ID
 * @author rguimerao
 *
 */
public interface VisitorIDObtainer {

    int obtainID(final Category category) throws SQLException;
    int obtainID(final ContactInfo contactInfo) throws SQLException;
    int obtainID(final Food food) throws SQLException;
    int obtainID(final Recipe recipe) throws SQLException;
}
