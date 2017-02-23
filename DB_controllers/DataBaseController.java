package DB_controllers;

import DB.DataBase;
import backend.Category;
import backend.ContactInfo;
import backend.Dish;
import backend.Drink;
import backend.Food;
import backend.Ingredient;
import backend.Location;
import backend.Recipe;
import backend.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class DataBaseController
 * Controles the querys to be done by the DB
 * Singleton
 * @author rguimerao
 *
 */
public class DataBaseController {

    private static DataBaseController instance = null;
    private static DataBase db = null;
	
	/**
	 * Constructor - Singleton
	 * Obtains the instance of the DB
	 * @throws SQLException if the connection cannot be done
	 * @throws ClassNotFoundException if the driver is not found
	 */
	private DataBaseController() 
			throws ClassNotFoundException, SQLException {
		db = DataBase.getInstance();
	}
	
	/**
	 * Returns the instance of itself
	 * @return instance of this object
	 */
	public final static DataBaseController getInstance()  {
		if (instance == null) {
		    try {
		        instance = new DataBaseController();
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
		}
		return instance;
	}

	/*
	 * OBTAIN ID
	 */
	
	/**
	 * Obtains the ID of the given category
	 * @param category category to be given the ID
	 * @throws SQLException if a DB error occurs
	 */
	public int obtainID(final Category category) 
	        throws SQLException {
        String query = "SELECT id FROM `category` ORDER BY 1 DESC LIMIT 1;";
        return db.obtainID(query);
	}
	
	/**
	 * Obtains the ID of the given Contact Info
	 * @param contactInfo contact info to be given the ID
	 * @throws SQLEception if a DB error occurs
	 */
	public int obtainID(final ContactInfo contactInfo) 
			throws SQLException {
	    String query = "SELECT id FROM `contact_info` ORDER BY 1 DESC LIMIT 1;";
	    return db.obtainID(query);
	}
    
    /**
     * Obtains the ID of the given food
     * @param food food to be given the ID
     * @throws SQLException if a DB error occurs
     */
    public int obtainID(final Food food) 
            throws SQLException {
        String query = "SELECT id FROM `food` ORDER BY 1 DESC LIMIT 1;";
        return db.obtainID(query);
    }
    
    /**
     * Obtains the ID of the given recipe
     * @param recipe recipe to be given the ID
     * @throws SQLException if a DB error occurs
     */
    public int obtainID(final Recipe recipe) 
            throws SQLException {
        String query = "SELECT id FROM `recipe` ORDER BY 1 DESC LIMIT 1;";
        return db.obtainID(query);
    }
	
    /*
     * CREATORS
     */
    
	/**
	 * Inserts a new category into the DB
	 * @param newCategory category to be inserted
	 */
	public final void createNewCategory(final Category newCategory) {
	    try {
	        String query = 
	                "INSERT INTO `category`(`name`) "
	                + "VALUES ('" + newCategory.getName() + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Inserts a new contact info into the DB
	 * @param newContactInfo new contact info to be inserted
	 */
	public final void createNewContactInfo(final ContactInfo newContactInfo) {
	    try {
	        String query = 
	                "INSERT INTO "
	                + "`contact_info`(`name`, `description`, `street`, `area_code`, `city`, `country`, `phone`, `email`) "
	                + "VALUES ('" + newContactInfo.getName() + "', '" + newContactInfo.getDescription() 
	                + "', '" + newContactInfo.getStreet() + "', '" + newContactInfo.getAreaCode()
	                + "', '" + newContactInfo.getCity() + "', '" + newContactInfo.getCountry()
	                + "', '" + newContactInfo.getPhone() + "', '" + newContactInfo.getEmail() + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Inserts a new location into the DB
	 * @param newLocation new location to be inserted
	 */
	public final void createNewLocation(final Location newLocation) {
	    try {
	        String query = 
	                "INSERT INTO `location`(`id`, `id_owner`) "
	                + "VALUES ('" + newLocation.getID() + "', '" + newLocation.getOwner().getID() + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
     * Inserts a new User into the DB
     * @param user new user to be inserted
     */
    public final void createNewUser(final User user, final String hashPassword) {
        try {
            String query = 
                    "INSERT INTO `user`(`id`, `nickname`, `password`, `website`) "
                    + "VALUES ('" + user.getID() + "', '" + user.getNickName() 
                    + "', '" + hashPassword + "', '" + user.getWebsite() + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * Inserts a new food into the DB
	 * @param newFood new food to insert
	 */
    public final void createNewFood(final Food newFood) {
        try {
            String query = 
                    "INSERT INTO `food`(`name`, `for_sell`, `price`, `id_creator`, `id_category`) "
                    + "VALUES ('" + newFood.getName() + "', '" + (newFood.isForSell() ? 1 : 0)
                    + "', '" + newFood.getPrice() + "', '" + newFood.getCreator().getID()
                    + "', '" + newFood.getCategory().getID() + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Inserts a new ingredient into the DB
     * @param newIngredient new ingredient to insert
     */
    public final void createNewIngredient(final Ingredient newIngredient) {
        try {
            String query = 
                    "INSERT INTO `ingredient`(`id`) "
                    + "VALUES ('" + newIngredient.getID() + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    /**
     * Inserts a new dish into the DB
     * @param newDish new dish to insert
     */
    public final void createNewDish(final Dish newDish) {
        try {
            String query = 
                    "INSERT INTO `dish`(`id`, `id_recipe`) "
                    + "VALUES ('" + newDish.getID() + "', '" 
                    + ((newDish.getRecipe() == null) ? -1 : newDish.getRecipe().getID()) + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Inserts a new drink into the DB
     * @param newDrink new drink to insert
     */
    public final void createNewDrink(final Drink newDrink) {
        try {
            String query = 
                    "INSERT INTO `drink`(`id`) "
                    + "VALUES ('" + newDrink.getID() + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Inserts a new recipe into the DB
     * @param newRecipe new recipe to insert
     */
    public final void createNewRecipe(final Recipe newRecipe) {
        try {
            String query = 
                    "INSERT INTO `recipe`(`name`, `description`, `last_update`, `id_creator`, `id_dish`) "
                    + "VALUES ('" + newRecipe.getName() + "', '" + newRecipe.getDescription() 
                    + "', '" + newRecipe.getLastUpdate() + "', '" + newRecipe.getFoodCreator().getID() 
                    + "', '" + newRecipe.getDish().getID() + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * GET
     */
    
	/**
	 * Gets the drink category for drink objects
	 * @return Category drinks
	 * @throws SQLException if a DB error occurs
	 */
	public Category getDrinksCategory() 
			throws SQLException {
		
		int id      = -1;
		String name = "";
	    
	    if (!db.isConnectionClosed()) {
	        String query = 
	                "SELECT id, name "
	                + "FROM `category` "
	                + "WHERE name=\'Drinks\' ORDER BY 1 DESC LIMIT 1;";
	        Statement stmt = null;
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            id   = rs.getInt("id");
		            name = rs.getString("name");
		        }
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
	        	}
		        db.closeConnection();
		    }
	    } 
	    
	    Category drinks = new Category(name);
	    drinks.setID(id);
	    
	    return drinks;
	}
	
	/**
	 * Gets a user by its nickname
	 * @param nickname nickname of the user to search
	 * @return User user found
	 * @throws SQLException if a DB error occurs
	 */
    public final User getUserByNickname(final String nickname) 
            throws SQLException {
        int id             = -1;
        String name        = "";
        String description = "";
        String street      = "";
        int areaCode       = -1;
        String city        = "";
        String country     = "";
        int phone          = -1;
        String email       = "";
        String website    = "";
        if (!db.isConnectionClosed()) {
            Statement stmt = null;
            String query   = 
                    "SELECT ci.id, ci.name, ci.description, ci.street, ci.area_code, ci.city, ci.country, ci.phone, ci.email, u.website "
                    + "FROM Contact_Info ci, User u "
                    + "WHERE u.nickname = '" + nickname + " AND ci.id = u.id' LIMIT 1;";
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    id          = rs.getInt("id");
                    name        = rs.getString("password");
                    description = rs.getString("description");
                    street      = rs.getString("street");
                    areaCode    = rs.getInt("area_code");
                    city        = rs.getString("city");
                    country     = rs.getString("country");
                    phone       = rs.getInt("phone");
                    email       = rs.getString("email");
                    website     = rs.getString("website");
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                db.closeConnection();
            }
        }
        
        User newUser = new User(name, description, street, areaCode, city, country, phone, email, nickname, website);
        newUser.setID(id);
        
        return newUser;
    }
    
    /**
     * TODO
     * @param nickname nickname of the user to search
     * @return User user found
     * @throws SQLException if a DB error occurs
     */
    public final User getUserByID(final int userID) 
            throws SQLException {
        String name        = "";
        String description = "";
        String street      = "";
        int areaCode       = -1;
        String city        = "";
        String country     = "";
        int phone          = -1;
        String email       = "";
        String website     = "";
        String nickname    = "";
        if (!db.isConnectionClosed()) {
            Statement stmt = null;
            String query   = 
                    "SELECT ci.name, ci.description, ci.street, ci.area_code, ci.city, ci.country, ci.phone, ci.email, u.website, u.nickname "
                    + "FROM Contact_Info ci, User u "
                    + "WHERE u.id = '" + userID + " AND ci.id = u.id' LIMIT 1;";
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    name        = rs.getString("ci.name");
                    description = rs.getString("ci.description");
                    street      = rs.getString("ci.street");
                    areaCode    = rs.getInt("ci.area_code");
                    city        = rs.getString("ci.city");
                    country     = rs.getString("ci.country");
                    phone       = rs.getInt("ci.phone");
                    email       = rs.getString("ci.email");
                    website     = rs.getString("u.website");
                    nickname    = rs.getString("u.nickname");
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                db.closeConnection();
            }
        }
        
        User newUser = new User(name, description, street, areaCode, city, country, phone, email, nickname, website);
        newUser.setID(userID);
        
        return newUser;
    }
    
    /**
     * TODO
     * @return
     * @throws SQLException
     */
    public ArrayList<User> getUserFollowing(final int userID) 
            throws SQLException {
        
        ArrayList<User> following = new ArrayList<>();
        User followed = null;
        
        if (!db.isConnectionClosed()) {
            String query = 
                    "SELECT f.id, ci.name, ci.description, ci.street, ci.area_code, ci.city, ci.country, ci.phone, ci.email, u.nickname, u.website "
                    + "FROM Contact_info ci, User u, Followers f "
                    + "WHERE u.id='" + userID + "' AND u.id=ci.id AND u.id = f.id_follower;";
            Statement stmt = null;
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    followed = 
                            new User(
                                    rs.getString("ci.name"), 
                                    rs.getString("ci.description"),
                                    rs.getString("ci.street"),
                                    rs.getInt("ci.area_code"),
                                    rs.getString("ci.city"),
                                    rs.getString("ci.country"),
                                    rs.getInt("ci.phone"),
                                    rs.getString("ci.email"),
                                    rs.getString("u.nickname"),
                                    rs.getString("u.website")
                                    );
                    followed.setID(rs.getInt("f.id"));
                    following.add(followed);
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                db.closeConnection();
            }
        } 
        return following;
    }
    
    /**
     * TODO
     * @return
     * @throws SQLException
     */
    public ArrayList<Food> getUserFoods(final User user) 
            throws SQLException {
        
        ArrayList<Food> foodsCreated = new ArrayList<>();
        Food foodCreated = null;
        
        if (!db.isConnectionClosed()) {
            String query = 
                    "SELECT f.id, f.name, f.for_sell, f.price, f.id_category "
                    + "FROM User u, Foood f "
                    + "WHERE u.id='" + user.getID() + "' AND f.id_creator='" + user.getID() + "';";
            Statement stmt = null;
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    foodCreated = 
                            new Food(
                                    rs.getString("f.name"),
                                    getCategoryFromID(rs.getInt("f.id_category")),
                                    (rs.getInt("f.for_sell") == 1 ? true : false),
                                    rs.getFloat("f.price"),
                                    user
                                    );
                    foodCreated.setID(rs.getInt("f.id"));
                    foodsCreated.add(foodCreated);
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                db.closeConnection();
            }
        } 
        return foodsCreated;
    }
    
    /**
     * TODO
     * @return
     * @throws SQLException
     */
    public ArrayList<Category> getCategories(ArrayList<Category> categories) 
            throws SQLException {
        Category category = null;
        
        if (!db.isConnectionClosed()) {
            String query = 
                    "SELECT c.id, c.name "
                    + "FROM Category c;";
            Statement stmt = null;
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    category = new Category(rs.getString("c.name"));
                    category.setID(rs.getInt("c.id"));
                    categories.add(category);
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                db.closeConnection();
            }
        } 
        return categories;
    }
    
    /**
     * TODO
     * @return
     * @throws SQLException
     */
    public ArrayList<Food> getFoodsFromCategory(final Category category, ArrayList<Food> foodsInCategory) 
            throws SQLException {
        Food food = null;
        
        if (!db.isConnectionClosed()) {
            String query = 
                    "SELECT f.id, f.name, f.for_sell, f.price, f.id_creator "
                            + "FROM Foood f, Category c "
                            + "WHERE c.id='" + category.getID() + "' AND f.id_category='" + category.getID() + "';";
            Statement stmt = null;
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    food = 
                            new Food(
                                    rs.getString("f.name"),
                                    category,
                                    (rs.getInt("f.for_sell") == 1 ? true : false),
                                    rs.getFloat("f.price"),
                                    getUserByID(rs.getInt("f.id_creator"))
                                    );
                    food.setID(rs.getInt("f.id"));
                    foodsInCategory.add(food);
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                db.closeConnection();
            }
        } 
        return foodsInCategory;
    }
    
    /**
     * TODO
     * @return
     * @throws SQLException
     */
    public Category getCategoryFromID(final int categoryID) 
            throws SQLException {
        Category category = null;
        
        if (!db.isConnectionClosed()) {
            String query = 
                    "SELECT c.name, "
                            + "FROM Category c "
                            + "WHERE c.id='" + categoryID + "';";
            Statement stmt = null;
            try {
                stmt = db.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    category = new Category(rs.getString("c.name"));
                    category.setID(categoryID);
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                db.closeConnection();
            }
        } 
        return category;
    }
    
    /*
     * CHECKER
     */
    
	/**
	 * Check if the password of a food creator is correct or not
	 * @param submitedPassword hash of password submited
	 * @param foodCreator food creator entering the password
	 * @return true if it is correct, false otherwise
	 * @throws SQLException if a DB error occurs
	 */
	public boolean checkHash(final String submitedPassword, final User user) 
			throws SQLException {
		
		String password = "";

	    if (!db.isConnectionClosed()) {
	        Statement stmt = null;
	        String query   = 
	                "SELECT password "
	                + "FROM `User` "
	                + "WHERE id=\'" + user.getID() + "\' ORDER BY 1 DESC LIMIT 1;";
	    	try {
		        stmt = db.getConnection().createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	password = rs.getString("password");
		        }
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) {
		        	stmt.close();
	        	}
		        db.closeConnection();
		    }
	    } 
	    
	    return (password == submitedPassword);
	}
	
	/*
	 * RATES
	 */
    
    /**
     * Rates a food
     * @param foodID id of the food
     * @param rating rating given
     * @param userID user rater
     */
    public final void rateFood(final int foodID, final int rating, final int userID) {
        try {
            String query = 
                    "INSERT INTO `User_rates_Food`(`id_user`, `id_food`, `rating`) "
                    + "VALUES ('" + userID + "', '" + foodID + "', '" + rating + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Rates a location
     * @param locationID id of the location
     * @param rating rating given
     * @param userID user rater
     */
    public final void rateLocation(final int locationID, final int rating, final int userID) {
        try {
            String query = 
                    "INSERT INTO "
                    + "`User_rates_Location`(`id_user`, `id_location`, `rating`) "
                    + "VALUES ('" + userID + "', '" + locationID + "', '" + rating + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Rates a recipe
     * @param recipeID id of the recipe
     * @param rating rating given
     * @param userID user rater
     */
    public final void rateRecipe(final int recipeID, final int rating, final int userID) {
        try {
            String query = 
                    "INSERT INTO `User_rates_Recipe`(`id_user`, `id_recipe`, `rating`) "
                    + "VALUES ('" + userID + "', '" + recipeID + "', '" + rating + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    /*
     * UPDATES
     */
    
	/**
	 * Updates brand website
	 * @param brandID id of the brand
	 * @param newWebsite new website to be updated
	 */
	public final void updateUserWebsite(final int userID, final String newWebsite) {
	    try {
	        String query = 
	                "UPDATE `user` "
	                + "SET `website`=\'" + newWebsite + "\' "
	                + "WHERE id=\'" + userID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
     * Updates the user nickname
     * @param userID id of the user
     * @param newNickName new nickname to be updated
     */
    public final void updateUserNickName(final int userID, final String newNickName) {
        try {
            String query = 
                    "UPDATE `user` "
                    + "SET `nickname`=\'" + newNickName + "\' "
                    + "WHERE id=\'" + userID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Updates the location owner
	 * @param locationID id of the location
	 * @param brandID id of the new owner
	 */
	public final void updateLocationOwner(final int locationID, final int brandID) {
	    try {
	        String query = 
	                "UPDATE `location` "
	                + "SET `id_owner`=\'" + brandID + "\' "
	                + "WHERE id=\'" + locationID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Updates the name of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newName new name to be set
	 */
	public final void updateNameContactInfo(final int contactInfoID, final String newName) {
        try {
            String query = 
                    "UPDATE `contact_info` "
                    + "SET `name`=\'" + newName + "\' "
                    + "WHERE id=\'" + contactInfoID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Updates the description of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newDescription new description to be set
	 */
	public final void updateDescriptionContactInfo(final int contactInfoID, final String newDescription) {
        try {
            String query = 
                    "UPDATE `contact_info` "
                    + "SET `description`=\'" + newDescription + "\' "
                    + "WHERE id=\'" + contactInfoID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Updates the street of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newStreet new street to be set
	 */
	public final void updateStreetContactInfo(final int contactInfoID, final String newStreet) {
        try {
            String query = 
                    "UPDATE `contact_info` "
                    + "SET `street`=\'" + newStreet + "\' "
                    + "WHERE id=\'" + contactInfoID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Updates the area code of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newAreaCode new area code to be set
	 */
	public final void updateAreaCodeContactInfo(final int contactInfoID, final int newAreaCode) {
        try {
            String query = 
                    "UPDATE `contact_info` "
                    + "SET `area_code`=\'" + newAreaCode + "\' "
                    + "WHERE id=\'" + contactInfoID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Updates the city of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newCity new city to be set
	 */
	public final void updateCityContactInfo(final int contactInfoID, final String newCity) {
        try {
            String query = 
                    "UPDATE `contact_info` "
                    + "SET `city`=\'" + newCity + "\' "
                    + "WHERE id=\'" + contactInfoID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Updates the country of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newCountry new country to be set
	 */
	public final void updateCountryContactInfo(final int contactInfoID, final String newCountry) {
        try {
            String query = 
                    "UPDATE `contact_info` "
                    + "SET `country`=\'" + newCountry + "\' "
                    + "WHERE id=\'" + contactInfoID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Updates the phone of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newPhone new phone to be set
	 */
	public final void updatePhoneContactInfo(final int contactInfoID, final int newPhone) {
        try {
            String query = 
                    "UPDATE `contact_info` "
                    + "SET `phone`=\'" + newPhone + "\' "
                    + "WHERE id=\'" + contactInfoID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Updates the email of a contact info
	 * @param contactInfoID ID of the contact info
	 * @param newEmail new email to be set
	 */
	public final void updateEmailContactInfo(final int contactInfoID, final String newEmail) {
        try {
            String query = 
                    "UPDATE `contact_info` "
                    + "SET `email`=\'" + newEmail + "\' "
                    + "WHERE id=\'" + contactInfoID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Updates the category of a food
	 * @param foodID ID of the food to update
	 * @param categoryID ID of the new category
	 */
	public final void updateFoodCategory(final int foodID, final int categoryID) {
        try {
            String query = 
                    "UPDATE `food` "
                    + "SET `id_category`=\'" + categoryID + "\' "
                    + "WHERE id=\'" + foodID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Updates a food's name
	 * @param foodID id of the food to be updated
	 * @param newName new name to set
	 */
    public final void updateFoodName(final int foodID, final String newName) {
        try {
            String query = 
                    "UPDATE `food` "
                    + "SET `name`=\'" + newName + "\' "
                    + "WHERE id=\'" + foodID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates a recipe's name
     * @param recipeID id of the recipe to be updated
     * @param newName new name to set
     */
    public final void updateRecipeName(final int recipeID, final String newName) {
        try {
            String query = 
                    "UPDATE `recipe` "
                    + "SET `name`=\'" + newName + "\' "
                    + "WHERE id=\'" + recipeID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates a recipe's description
     * @param recipeID id of the recipe to be updated
     * @param newDescription new description to set
     */
    public final void updateRecipeDescription(final int recipeID, final String newDescription) {
        try {
            String query = 
                    "UPDATE `recipe` "
                    + "SET `description`=\'" + newDescription + "\' "
                    + "WHERE id=\'" + recipeID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates a recipe las update date
     * @param recipeID id of the recipe to be updated
     * @param lastUpdate date of last update
     */
    public final void updateRecipeLastUpdate(final int recipeID, final Date lastUpdate) {
        try {
            String query = 
                    "UPDATE `recipe` "
                    + "SET `last_update`=\'" + lastUpdate + "\' "
                    + "WHERE id=\'" + recipeID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates if a food is for sell or not
     * @param foodID ID of the food to update
     * @param isForSell boolean where true means this food is for sell
     */
    public final void updateFoodForSell(final int foodID, final boolean isForSell) {
        try {
            String query = 
                    "UPDATE `food` "
                    + "SET `for_sell`=\'" + (isForSell ? 1 : 0) + "\' "
                    + "WHERE id=\'" + foodID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates the price of a food
     * @param foodID ID of the food to update
     * @param newPrice new price to be set
     */
    public final void updateFoodPrice(final int foodID, final float newPrice) {
        try {
            String query = 
                    "UPDATE `food` "
                    + "SET `price`=\'" + newPrice + "\' "
                    + "WHERE id=\'" + foodID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates the price of a food
     * @param foodID ID of the food to update
     * @param newPrice new price to be set
     */
    public final void updateDishRecipe(final int dishID, final float recipeID) {
        try {
            String query = 
                    "UPDATE `dish` "
                    + "SET `id_recipe`=\'" + recipeID + "\' "
                    + "WHERE id=\'" + dishID + "\';";
            db.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * ADD INFO
     */
    
    /**
     * Inserts a food id and location id into the table Location_sells_food
     * @param foodID id of the food to add
     * @param locationID id of the location to add
     */
    public final void addFoodToLocation(final int foodID, final int locationID) {
        try {
            String query = 
                    "INSERT INTO `Location_sells_Food`(`id_location`, `id_food`) "
                    + "VALUES ('" + locationID + "', '" + foodID + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Adds a food to a dish
     * @param dishID id of the dish
     * @param foodID id of the food to add
     */
    public final void addFoodToDish(final int dishID, final int foodID) {
        try {
            String query = 
                    "INSERT INTO "
                    + "`Dish_has_Food`(`id_dish`, `id_food`) "
                    + "VALUES ('" + dishID + "', '" + foodID + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Follows
     */
    
    /**
     * Inserts a food id and user id to the wish list of user
     * @param foodID id of the food to add
     * @param userID id of the user to add
     */
    public final void addUserWantingFood(final int foodID, final int userID) {
        try {
            String query = 
                    "INSERT INTO `Wishlist`(`id_user`, `id_food`) "
                    + "VALUES ('" + userID + "', '" + foodID + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Deletes a user and food from the wish list
     * @param foodID id of the food to remove
     * @param userID id of the user to remove
     */
    public final void deleteUserWantingFood(final int foodID, final int userID) {
        try {
            String query = 
                    "DELETE FROM Wishlist"
                    + "WHERE id_food=\'" + foodID + " AND id_user=\'" + userID;
            db.executeDelete(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Follows a food creator
     * @param userID id of the user following
     * @param foodCreatorID id of the food creator followed
     */
    public final void followFoodCreator(final int userID, final int followedID) {
        try {
            String query = 
                    "INSERT INTO `Followers`(`id_follower`, `id_followed`) "
                    + "VALUES ('" + userID + "', '" + followedID + "');";
            db.executeInsert(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Unfollows a food creator
     * @param userID id of the user following
     * @param foodCreatorID id of the food creator followed
     */
    public final void unFollowFoodCreator(final int userID, final int followedID) {
        try {
            String query = 
                    "DELETE FROM Followers "
                    + "WHERE id_follower=\'" + userID + " AND id_followed=\'" + followedID;
            db.executeDelete(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
