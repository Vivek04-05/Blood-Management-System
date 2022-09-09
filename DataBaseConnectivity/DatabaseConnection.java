package DataBaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection con;
	
	//Function for closing the database connection
	public static void closeConnecttion() {
		try {
			if(con!=null) {
				con.close();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	// Function for creating a Datavase connection
	public static Connection createConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddatabase","root","root");
	}
	catch(SQLException | ClassNotFoundException cse) {
		cse.printStackTrace();
	}
	return con;
	}

}
