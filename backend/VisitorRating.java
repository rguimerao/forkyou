package backend;

import java.sql.SQLException;

/**
 * Interface VisitorRating
 * Here we find every function to implement for object which receive a rating
 * @author rguimerao
 *
 */
public interface VisitorRating {

    void rate(final Brand brand, final int rating, final int userID) throws SQLException;
    void rate(final Location location, final int rating, final int userID);
    void rate(final Recipe recipe, final int rating, final int userID);
    void rate(final Food food, final int rating, final int userID);
}
