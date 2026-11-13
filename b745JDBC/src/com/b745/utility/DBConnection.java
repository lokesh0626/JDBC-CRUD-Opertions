package com.b745.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con=null;

	public static Connection getConnection() {
		try {
			// Loading / registering the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection Establishment
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b745", "root", "root");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
