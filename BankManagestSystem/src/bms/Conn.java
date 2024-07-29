package bms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	
	Connection con;
	Statement stmt;
	
	public Conn() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "1234");
			stmt = con.createStatement();
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
