import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import sql.DbManager;

public class User {

	private int id;
	private int person_group_id;
	private String username;
	private String email;
	private String password;

	public User() {

	}

	public User(int person_group_id, String username, String email, String password) {
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
			ArrayList<User> users = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Users");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.id = resultSet.getInt("id");
				user.person_group_id = resultSet.getInt("person_group_id");
				user.email = resultSet.getString("email");
				user.username = resultSet.getString("username");
				user.password = resultSet.getString("password");
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static User loadById(int id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Users WHERE id=?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.id = resultSet.getInt("id");
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
					this.id = resultSet.getInt(1);
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			try {
				PreparedStatement statement = DbManager.getPreparedStatement(
						"UPDATE Users SET username = ?, email = ?, person_group_id = ?, password = ?, id = ?");
				statement.setString(1, this.username);
				statement.setString(2, this.email);
				statement.setInt(3, this.person_group_id);
				statement.setString(4, this.password);
				statement.setInt(5, this.id);
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}