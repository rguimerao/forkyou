package app_controllers;

import backend.Category;
import backend.Food;
import backend.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import DB_controllers.DataBaseController;

public class AppController {

    private static User currentUser = null;
    private static AppController instance = null;
    private static DataBaseController dbController = null;
    
    private AppController() 
            throws ClassNotFoundException, SQLException {
        dbController = DataBaseController.getInstance();
    }
    
    public final static AppController getInstance() {
        if (instance == null) {
            try {
                instance = new AppController();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
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
            final String password,
            final String website) {
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
                        nickname,
                        website);
        dbController.createNewContactInfo(newUser);
        newUser.obtainID();
        dbController.createNewUser(newUser, password);
    }
    
    public final boolean logInUser(final String nickname, final String password) {
        // TODO -> hash password
        User volatileUser = null;
        boolean result = false;
        try {
            volatileUser = dbController.getUserByNickname(nickname);
            if (dbController.checkHash(password, currentUser)) {
                currentUser = volatileUser;
                result      = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public final User getCurrentUser() {
        return currentUser;
    }
    
    public final ArrayList<Food> getFoodFromFollowing() {
        // TODO -> order by date (now ordered by followed)
        ArrayList<Food> foodFromFollowing = new ArrayList<>();
        for (User following : currentUser.getFollowing()) {
            for (Food foodCreated : following.getFoodsCreated()) {
                foodFromFollowing.add(foodCreated);
            }
        }
        Collections.reverse(foodFromFollowing);
        return (foodFromFollowing);
    }
    
    public final ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            DataBaseController.getInstance().getCategories(categories);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
    
    public final ArrayList<Food> getFoodFromCategory(final Category category) {
        return category.getFoods();
    }
}
