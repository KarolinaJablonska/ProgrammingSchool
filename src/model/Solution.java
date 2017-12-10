package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sql.DbManager;

public class Solution {

	private int id;
	private String created;
	private String updated;
	private String description;
	private int excercise_id;
	private int users_id;

	public Solution() {

	}

	public Solution(String created, String updated, String description, int excercise_id, int users_id) {
		this.created = created;
		this.updated = updated;
		this.description = description;
		this.excercise_id = excercise_id;
		this.users_id = users_id;
	}

	public static ArrayList<Solution> loadAll() {
		try {
			ArrayList<Solution> solutions = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Solution");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Solution solution = new Solution();
				solution.id = resultSet.getInt("id");
				solution.created = resultSet.getString("created");
				solution.updated = resultSet.getString("updated");
				solution.description = resultSet.getString("description");
				solution.excercise_id = resultSet.getInt("excercise_id");
				solution.users_id = resultSet.getInt("users_id");
				solutions.add(solution);
			}
			return solutions;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Solution loadById(int id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Solution WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Solution solution = new Solution();
				solution.id = resultSet.getInt("id");
				solution.created = resultSet.getString("created");
				solution.updated = resultSet.getString("updated");
				solution.description = resultSet.getString("description");
				solution.excercise_id = resultSet.getInt("excercise_id");
				solution.users_id = resultSet.getInt("users_id");
				return solution;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Solution> loadAllByUserId(int users_id) {
		try {
			ArrayList<Solution> userSolutions = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Solution WHERE users_id = ?");
			statement.setLong(1, users_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Solution solution = new Solution();
				solution.id = resultSet.getInt("id");
				solution.created = resultSet.getString("created");
				solution.updated = resultSet.getString("updated");
				solution.description = resultSet.getString("description");
				solution.excercise_id = resultSet.getInt("excercise_id");
				solution.users_id = resultSet.getInt("users_id");
				userSolutions.add(solution);
			}
			return userSolutions;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Solution> loadAllByExcerciseId(int excercise_id) {
		try {
			ArrayList<Solution> userSolutions = new ArrayList<>();
			PreparedStatement statement = DbManager
					.getPreparedStatement("SELECT * FROM Solution WHERE excercise_id = ? ORDER BY updated DESC");
			statement.setLong(1, excercise_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Solution solution = new Solution();
				solution.id = resultSet.getInt("id");
				solution.created = resultSet.getString("created");
				solution.updated = resultSet.getString("updated");
				solution.description = resultSet.getString("description");
				solution.excercise_id = resultSet.getInt("excercise_id");
				solution.users_id = resultSet.getInt("users_id");
				userSolutions.add(solution);
			}
			return userSolutions;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public void delete() {
		try {
			if (this.id != 0) {
				PreparedStatement statement = DbManager.getPreparedStatement("DELETE FROM Solution WHERE id = ?");
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
						"INSERT INTO Solution(created, updated, description, excercise_id, users_id) VALUES(?, ?, ?, ?, ?)",
						generatedColumns);
				statement.setString(1, this.created);
				statement.setString(2, this.updated);
				statement.setString(3, this.description);
				statement.setInt(4, this.excercise_id);
				statement.setLong(5, this.users_id);
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
						"UPDATE Solution SET created = ?, updated = ?, description = ?, excercise_id = ?, users_id = ? WHERE id = ?");
				statement.setString(1, this.created);
				statement.setString(2, this.updated);
				statement.setString(3, this.description);
				statement.setInt(4, this.excercise_id);
				statement.setLong(5, this.users_id);
				statement.setInt(6, this.id);
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
