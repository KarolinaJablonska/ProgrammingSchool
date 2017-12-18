package pl.coderslab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Group;
import sql.DbManager;

public class GroupDao {

	private static final String FIND_ALL_GROUPS_QUERY = "SELECT * FROM User_group";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM User_group WHERE id = ?";
	private static final String DELETE_BY_ID_QUERY = "DELETE FROM User_group WHERE id = ?";
	private static final String ADD_NEW_QUERY = "INSERT INTO User_group(name) VALUES(?)";
	private static final String UPDATE_QUERY = "UPDATE User_group SET name = ? WHERE id = ?";

	public static ArrayList<Group> findAll() {
		try {
			ArrayList<Group> groups = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_ALL_GROUPS_QUERY);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Group group = getGroupFromResultSet(resultSet);
				groups.add(group);
			}
			return groups;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Group findById(int id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_BY_ID_QUERY);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Group group = getGroupFromResultSet(resultSet);
				return group;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static void delete(Group group) {
		try {
			if (group.getId() != 0) {
				PreparedStatement statement = DbManager.getPreparedStatement(DELETE_BY_ID_QUERY);
				statement.setLong(1, group.getId());
				statement.executeUpdate();
				group.setId(0);
				;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void saveToDB(Group group) {
		if (group.getId() == 0) {
			try {
				String[] generatedColumns = { "id" };
				PreparedStatement statement = DbManager.getPreparedStatement(ADD_NEW_QUERY, generatedColumns);
				statement.setString(1, group.getName());
				statement.executeUpdate();
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					group.setId(resultSet.getInt(1));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			try {
				PreparedStatement statement = DbManager.getPreparedStatement(UPDATE_QUERY);
				statement.setString(1, group.getName());
				statement.setInt(2, group.getId());
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	private static Group getGroupFromResultSet(ResultSet resultSet) throws SQLException {
		Group group = new Group();
		group.setId(resultSet.getInt("id"));
		group.setName(resultSet.getString("name"));
		return group;
	}

}
