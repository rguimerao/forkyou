package testing;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class myLogger - Singleton
 * Used to log information into the console and 
 * not to use an attribute for each class
 * @author rguimerao
 *
 */
public class myLogger {

    private static final Logger LOGGER = Logger.getLogger("My Logger");
    private static myLogger instance;
    
    /**
     * Constructor
     */
    private myLogger() {
    }
    
    /**
     * Gets instance of myLogger
     * @return
     */
    public final static myLogger getInstance() {
        if (instance == null) {
            instance = new myLogger();
        }
        
        return instance;
    }
    
    /**
     * Logs information
     * @param message message to log
     */
    public final void info(final String message) {
        LOGGER.log(Level.INFO, message);
    }
    
    /**
     * Logs SEVERE information
     * @param message message to log
     */
    public final void severe(final String message) {
        LOGGER.log(Level.SEVERE, message);
    }
    
    /**
     * Logs warnings
     * @param message message to log
     */
    public final void warning(final String message) {
        LOGGER.log(Level.WARNING, message);
    }
}
