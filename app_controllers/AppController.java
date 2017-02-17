package app_controllers;

import backend.Category;
import backend.Food;
import backend.FoodCreator;
import backend.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import DB_controllers.DataBaseController;

public class AppController {

    private static User currentUser;
    private static AppController instance;
    private static DataBaseController dbController = null;
    
    private AppController() 
            throws ClassNotFoundException, SQLException {
        dbController = DataBaseController.getInstance();
    }
    
    public final static AppController getInstance() 
            throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new AppController();
        }
        
        return instance;
    }
    
    public final void registerUser(
            final String name,
            final String description,
            final String street,
            final int areaCode,
            final String city,
            final String country,
            final int phone,
            final String email,
            final String nickname,
            final String password) 
                    throws ClassNotFoundException, SQLException {
        // TODO -> needs security
        User newUser = 
                new User(
                        name, 
                        description, 
                        street, 
                        areaCode, 
                        city, 
                        country, 
                        phone, 
                        email, 
                        nickname);
        dbController.createNewContactInfo(newUser);
        newUser.obtainID();
        dbController.createNewFoodCreator(newUser, password);
        dbController.createNewUser(newUser);
    }
    
    public final boolean logInUser(final String nickname, final String password) 
            throws SQLException {
        // TODO -> hash password
        User volatileUser = dbController.getUserByNickname(nickname);
        boolean result    = false;
        
        if (dbController.checkHash(password, currentUser)) {
            currentUser = volatileUser;
            result      = true;
        }
        
        return result;
    }
    
    public final User getCurrentUser() {
        return currentUser;
    }
    
    public final ArrayList<Food> getFoodFromFollowing() {
        
        // TODO -> order by date
        ArrayList<Food> foodFromFollowing = new ArrayList<Food>();
        for (FoodCreator following : currentUser.getFollowing()) {
            for (Food foodCreated : following.getFoodsCreated()) {
                foodFromFollowing.add(foodCreated);
            }
        }
        Collections.reverse(foodFromFollowing);
        return (foodFromFollowing);
    }
    
    public final ArrayList<Food> getFoodFromCategory(final Category category) {
        return category.getFoods();
    }
}
