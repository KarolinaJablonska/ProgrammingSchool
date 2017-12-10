package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import sql.DbManager;

public class User {

	private long id;
	private int person_group_id;
	private String username;
	private String email;
	private String password;

	public User() {

	}

	public User(int person_group_id, String username, String email, String password) {
		setAttributes(person_group_id, username, email, password);
	}

	public void setAttributes(int person_group_id, String username, String email, String password) {
		this.person_group_id = person_group_id;
		this.username = username;
		this.email = email;
		setPassword(password);
	}

	public void setPassword(String password) {
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());
		this.password = hash;
	}

	public static ArrayList<User> loadAll() {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Users");
			return createUsersListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static User loadById(long id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Users WHERE id=?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.id = resultSet.getLong("id");
				user.person_group_id = resultSet.getInt("person_group_id");
				user.email = resultSet.getString("email");
				user.username = resultSet.getString("username");
				user.password = resultSet.getString("password");
				return user;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public void delete() {
		try {
			if (this.id != 0) {
				PreparedStatement statement = DbManager.getPreparedStatement("DELETE FROM Users WHERE id = ?");
				statement.setLong(1, this.id);
				statement.executeUpdate();
				this.id = 0;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void saveToDB() {
		if (this.id == 0) {
			try {
				String[] generatedColumns = { "id" };
				PreparedStatement statement = DbManager.getPreparedStatement(
						"INSERT INTO Users(username, email, password, person_group_id) VALUES(?,?,?,?)",
						generatedColumns);
				statement.setString(1, this.username);
				statement.setString(2, this.email);
				statement.setString(3, this.password);
				statement.setInt(4, this.person_group_id);
				statement.executeUpdate();
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					this.id = resultSet.getLong(1);
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			try {
				PreparedStatement statement = DbManager.getPreparedStatement(
						"UPDATE Users SET username = ?, email = ?, person_group_id = ?, password = ? WHERE id = ?");
				statement.setString(1, this.username);
				statement.setString(2, this.email);
				statement.setInt(3, this.person_group_id);
				statement.setString(4, this.password);
				statement.setLong(5, this.id);
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static ArrayList<User> loadAllByGroupId(int person_group_id) {
		try {
			PreparedStatement statement = DbManager
					.getPreparedStatement("SELECT * FROM Users WHERE person_group_id = ?");
			statement.setInt(1, person_group_id);
			return createUsersListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<User> createUsersListFromStatement(PreparedStatement statement) throws SQLException {
		ArrayList<User> usersList = new ArrayList<>();
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			User user = new User();
			user.id = resultSet.getLong("id");
			user.person_group_id = resultSet.getInt("person_group_id");
			user.email = resultSet.getString("email");
			user.username = resultSet.getString("username");
			user.password = resultSet.getString("password");
			usersList.add(user);
		}
		return usersList;
	}

	public String toString() {
		return "id: " + this.id + " | " + "person_group_id: " + this.person_group_id + " | " + "username: "
				+ this.username + " | " + "email: " + this.email;
	}
}