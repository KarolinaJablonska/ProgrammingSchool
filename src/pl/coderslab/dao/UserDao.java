package pl.coderslab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import pl.coderslab.model.User;
import sql.DbManager;

public class UserDao {

	private static final String FIND_ALL_QUERY = "SELECT * FROM Users";
	private static final String FIND_ALL_BY_GROUP_ID_QUERY = "SELECT * FROM Users WHERE person_group_id = ?";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM Users WHERE id=?";
	private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM Users WHERE email=?";
	private static final String DELETE_BY_ID_QUERY = "DELETE FROM Users WHERE id = ?";
	private static final String ADD_NEW_QUERY = "INSERT INTO Users(username, email, password, person_group_id) VALUES(?,?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE Users SET username = ?, email = ?, person_group_id = ?, password = ? WHERE id = ?";

	public static boolean passwordMatches(String candidate, long userId) {
		String password = UserDao.findById(userId).getPassword();
		return BCrypt.checkpw(candidate, password);
	}

	public static ArrayList<User> findAll() {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_ALL_QUERY);
			return createUsersListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static User findById(long id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_BY_ID_QUERY);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getUserFromQuery(resultSet);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static User findByEmail(String email) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_BY_EMAIL_QUERY);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getUserFromQuery(resultSet);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static void delete(User user) {
		try {
			if (user.getId() != 0) {
				PreparedStatement statement = DbManager.getPreparedStatement(DELETE_BY_ID_QUERY);
				statement.setLong(1, user.getId());
				statement.executeUpdate();
				user.setId(0);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void saveToDB(User user) {
		if (user.getId() == 0) {
			try {
				String[] generatedColumns = { "id" };
				PreparedStatement statement = DbManager.getPreparedStatement(ADD_NEW_QUERY, generatedColumns);
				statement.setString(1, user.getUsername());
				statement.setString(2, user.getEmail());
				statement.setString(3, user.getPassword());
				statement.setInt(4, user.getPerson_group_id());
				statement.executeUpdate();
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					user.setId(resultSet.getLong(1));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			try {
				PreparedStatement statement = DbManager.getPreparedStatement(UPDATE_QUERY);
				statement.setString(1, user.getUsername());
				statement.setString(2, user.getEmail());
				statement.setInt(3, user.getPerson_group_id());
				statement.setString(4, user.getPassword());
				statement.setLong(5, user.getId());
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static ArrayList<User> findAllByGroupId(int person_group_id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_ALL_BY_GROUP_ID_QUERY);
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
			usersList.add(getUserFromQuery(resultSet));
		}
		return usersList;
	}

	private static User getUserFromQuery(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getLong("id"));
		user.setPerson_group_id(resultSet.getInt("person_group_id"));
		user.setEmail(resultSet.getString("email"));
		user.setUsername(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		return user;
	}

}
