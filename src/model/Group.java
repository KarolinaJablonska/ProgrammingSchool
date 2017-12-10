package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sql.DbManager;

public class Group {

	private int id;
	private String name;

	public Group() {

	}

	public Group(String name) {
		setAttributes(name);
	}

	public void setAttributes(String name) {
		this.name = name;
	}

	public static ArrayList<Group> loadAll() {
		try {
			ArrayList<Group> groups = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM User_group");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Group group = new Group();
				group.id = resultSet.getInt("id");
				group.name = resultSet.getString("name");
				groups.add(group);
			}
			return groups;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Group loadById(int id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM User_group WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Group group = new Group();
				group.id = resultSet.getInt("id");
				group.name = resultSet.getString("name");
				return group;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public void delete() {
		try {
			if (this.id != 0) {
				PreparedStatement statement = DbManager.getPreparedStatement("DELETE FROM User_group WHERE id = ?");
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
				PreparedStatement statement = DbManager.getPreparedStatement("INSERT INTO User_group(name) VALUES(?)",
						generatedColumns);
				statement.setString(1, this.name);
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
				PreparedStatement statement = DbManager
						.getPreparedStatement("UPDATE User_group SET name = ? WHERE id = ?");
				statement.setString(1, this.name);
				statement.setInt(2, this.id);
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
