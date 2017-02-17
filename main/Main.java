package main;

import testing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) 
            throws SQLException, ClassNotFoundException {
		
        //tester.userRemoveItemFromList();
        //tester.foodAddedToCategoryInFoodCreator();
        Tester.testDBConnection();
        //tester.testDBSelect();
        //tester.testDBInsertCategory();
        //tester.testFullInsertCategory();
    }
}
