package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector_test {

	public static void main(String[] args) {
		String connectionString  = "jdbc:mysql://localhost:3306/foodie";
		
		
	try {
		Connection conn = DriverManager.getConnection(connectionString, "root", "Hbq@0512");
		System.out.println("connected!!");
	} catch (SQLException e) {
		System.out.println("Not Connected!!");
		e.printStackTrace();
	}
			
	}

}
