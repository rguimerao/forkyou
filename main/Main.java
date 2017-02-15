package main;

import testing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) 
            throws SQLException, ClassNotFoundException {
       
        Tester tester = new Tester();
		
        //tester.userRemoveItemFromList();
        //tester.foodAddedToCategoryInFoodCreator();
        tester.testDBConnection();
        //tester.testDBSelect();
        //tester.testDBInsertCategory();
        //tester.testFullInsertCategory();
    }
}
