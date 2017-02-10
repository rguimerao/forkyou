package DB_controllers;

import backend.Brand;
import backend.Category;
import backend.ContactInfo;
import backend.FoodCreator;
import backend.Location;
import java.sql.SQLException;

/**
 * Interface VisitorIDObtainer
 * Here we find every function to implement for object which need to obtain an ID
 * @author rguimerao
 *
 */
public interface VisitorIDObtainer {

    int obtainID(final Category category) throws SQLException;
    int obtainID(final Brand brand) throws SQLException;
    int obtainID(final Location location) throws SQLException;
    int obtainID(final ContactInfo contactInfo) throws SQLException;
    int obtainID(final FoodCreator foodCreator) throws SQLException;
}
