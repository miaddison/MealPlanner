package controller;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConn {
	String driverClassName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/mealplan";
	String dbUser = "root";
	String dbPwd = "Password";

	private static DBConn dbConn = null;

	private DBConn() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = (Connection) DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static DBConn getInstance() {
		if (dbConn == null) {
			dbConn = new DBConn();
		}
		return dbConn;
	}

}
