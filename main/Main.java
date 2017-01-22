package main;

import java.sql.SQLException;

import testing.*;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
       
		Tester tester = new Tester();
		
		//tester.userRemoveItemFromList();
		//tester.foodAddedToCategoryInFoodCreator();
		//tester.testDBConnection();
		tester.testDBSelect();
    }
}
