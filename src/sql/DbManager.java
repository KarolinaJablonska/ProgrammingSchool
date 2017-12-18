package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbManager {

	private static DataSource dataSource;
	static Connection connection;

	public static Connection getConn() throws SQLException {
		return getInstance().getConnection();
	}

	private static DataSource getInstance() {
		if (dataSource == null) {
			try {
				Context ctx = new InitialContext();
				dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/ProgrammingSchool");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return dataSource;
	}

	public static PreparedStatement getPreparedStatement(String sqlQuery) {
		try {
			return getConn().prepareStatement(sqlQuery);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static PreparedStatement getPreparedStatement(String sqlQuery, String[] generatedColumns) {
		try {
			return getConn().prepareStatement(sqlQuery, generatedColumns);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}