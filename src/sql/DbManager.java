package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManager {

	static Connection connection;

	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "ProgrammingSchool";
		String userName = "root";
		String password = "coderslab";
		if (connection == null) {
			connection = DriverManager.getConnection(url + dbName + "?useSSL=false", userName, password);
		} else if (connection.isClosed()) {
			connection = DriverManager.getConnection(url + dbName + "?useSSL=false", userName, password);
		}
		return connection;
	}

	public static PreparedStatement getPreparedStatement(String sqlQuery) {
		try {
			return getConnection().prepareStatement(sqlQuery);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static PreparedStatement getPreparedStatement(String sqlQuery, String[] generatedColumns) {
		try {
			return getConnection().prepareStatement(sqlQuery, generatedColumns);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
