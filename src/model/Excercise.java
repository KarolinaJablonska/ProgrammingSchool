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
			ArrayList<Excercise> excercises = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement("SELECT * FROM Excercise");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Excercise excercise = new Excercise();
				excercise.id = resultSet.getInt("id");
				excercise.title = resultSet.getString("name");
				excercise.description = resultSet.getString("description");
				excercises.add(excercise);
			}
			return excercises;
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
}
