package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sql.DbManager;

public class Excercise {

	private int id;
	private String title;
	private String description;

	public Excercise() {

	}

	public Excercise(String title, String description) {
		setAttributes(title, description);
	}

	public void setAttributes(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public static ArrayList<Excercise> loadAll() {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Excercise");
			return createExcercisesListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Excercise loadById(int id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Excercise WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Excercise excercise = new Excercise();
				excercise.id = resultSet.getInt("id");
				excercise.title = resultSet.getString("title");
				excercise.description = resultSet.getString("description");
				return excercise;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public void delete() {
		try {
			if (this.id != 0) {
				PreparedStatement statement = DbManager.getPreparedStatement("DELETE FROM Excercise WHERE id = ?");
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
						"INSERT INTO Excercise(title, description) VALUES(?, ?)", generatedColumns);
				statement.setString(1, this.title);
				statement.setString(2, this.description);
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
						.getPreparedStatement("UPDATE Excercise SET title = ?, description = ? WHERE id = ?");
				statement.setString(1, this.title);
				statement.setString(2, this.description);
				statement.setInt(3, this.id);
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static ArrayList<Excercise> loadUnsolvedOfUser(long userId) {
		try {
			PreparedStatement statement = DbManager
					.getPreparedStatement("SELECT Excercise.id, Excercise.title, Excercise.description "
							+ "FROM Excercise JOIN Solution ON Excercise.id = Solution.excercise_id "
							+ " WHERE Solution.users_id = ? AND Solution.updated IS NULL;");
			statement.setLong(1, userId);
			return createExcercisesListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Excercise> loadSolvedOfUser(long userId) {
		try {
			PreparedStatement statement = DbManager
					.getPreparedStatement("SELECT Excercise.id, Excercise.title, Excercise.description "
							+ "FROM Excercise JOIN Solution ON Excercise.id = Solution.excercise_id "
							+ " WHERE Solution.users_id = ? AND Solution.updated IS NOT NULL;");
			statement.setLong(1, userId);
			return createExcercisesListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Integer> getIndexesUnsolvedOfUser(long userId) {
		try {
			ArrayList<Integer> indexesOfUnsolved = new ArrayList<>();
			PreparedStatement statement = DbManager
					.getPreparedStatement("SELECT Excercise.id, Excercise.title, Excercise.description "
							+ "FROM Excercise JOIN Solution ON Excercise.id = Solution.excercise_id "
							+ " WHERE Solution.users_id = ? AND Solution.updated IS NULL;");
			statement.setLong(1, userId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				indexesOfUnsolved.add(resultSet.getInt("id"));
			}
			return indexesOfUnsolved;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Excercise> createExcercisesListFromStatement(PreparedStatement statement)
			throws SQLException {
		ArrayList<Excercise> excercisesList = new ArrayList<>();
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			Excercise excercise = new Excercise();
			excercise.id = resultSet.getInt("id");
			excercise.title = resultSet.getString("title");
			excercise.description = resultSet.getString("description");
			excercisesList.add(excercise);
		}
		return excercisesList;
	}

	public String toString() {
		return "id: " + this.id + " | " + "title: " + this.title + " | " + "description: " + this.description;
	}
}
