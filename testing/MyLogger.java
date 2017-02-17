package testing;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class MyLogger - Singleton
 * Used to log information into the console and 
 * not to use an attribute for each class
 * @author rguimerao
 *
 */
public final class MyLogger {

    private static final Logger LOGGER = Logger.getLogger("My Logger");
    
    /**
     * Logs information
     * @param message message to log
     */
    public final static void info(final String message) {
        LOGGER.log(Level.INFO, message);
    }
    
    /**
     * Logs SEVERE information
     * @param message message to log
     */
    public final static void severe(final String message) {
        LOGGER.log(Level.SEVERE, message);
    }
    
    /**
     * Logs warnings
     * @param message message to log
     */
    public final static void warning(final String message) {
        LOGGER.log(Level.WARNING, message);
    }
}
