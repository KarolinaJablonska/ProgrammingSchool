package pl.coderslab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Excercise;
import sql.DbManager;

public class ExcerciseDao {

	private static final String FIND_ALL_EXCERCISES_QUERY = "SELECT * FROM Excercise";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM Excercise WHERE id = ?";
	private static final String DELETE_BY_ID_QUERY = "DELETE FROM Excercise WHERE id = ?";
	private static final String ADD_NEW_QUERY = "INSERT INTO Excercise(title, description) VALUES(?, ?)";
	private static final String UPDATE_QUERY = "UPDATE Excercise SET title = ?, description = ? WHERE id = ?";
	private static final String FIND_UNSOLVED_BY_USER_ID_QUERY = "SELECT Excercise.id, Excercise.title, Excercise.description "
			+ "FROM Excercise JOIN Solution ON Excercise.id = Solution.excercise_id "
			+ " WHERE Solution.users_id = ? AND Solution.updated IS NULL;";

	private static final String FIND_SOLVED_BY_USER_ID_QUERY = "SELECT Excercise.id, Excercise.title, Excercise.description "
			+ "FROM Excercise JOIN Solution ON Excercise.id = Solution.excercise_id "
			+ " WHERE Solution.users_id = ? AND Solution.updated IS NOT NULL;";

	private static final String FIND_INDEXES_UNSOLVED_BY_USER_ID_QUERY = "SELECT Excercise.id, Excercise.title, Excercise.description "
			+ "FROM Excercise JOIN Solution ON Excercise.id = Solution.excercise_id "
			+ " WHERE Solution.users_id = ? AND Solution.updated IS NULL;";

	public static ArrayList<Excercise> findAll() {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_ALL_EXCERCISES_QUERY);
			return createExcercisesListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Excercise findById(int id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_BY_ID_QUERY);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Excercise excercise = getExcerciseFromResultSet(resultSet);
				return excercise;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static void delete(Excercise excercise) {
		try {
			if (excercise.getId() != 0) {
				PreparedStatement statement = DbManager.getPreparedStatement(DELETE_BY_ID_QUERY);
				statement.setLong(1, excercise.getId());
				statement.executeUpdate();
				excercise.setId(0);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void saveToDB(Excercise excercise) {
		if (excercise.getId() == 0) {
			try {
				String[] generatedColumns = { "id" };
				PreparedStatement statement = DbManager.getPreparedStatement(ADD_NEW_QUERY, generatedColumns);
				statement.setString(1, excercise.getTitle());
				statement.setString(2, excercise.getDescription());
				statement.executeUpdate();
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					excercise.setId(resultSet.getInt(1));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			try {
				PreparedStatement statement = DbManager.getPreparedStatement(UPDATE_QUERY);
				statement.setString(1, excercise.getTitle());
				statement.setString(2, excercise.getDescription());
				statement.setInt(3, excercise.getId());
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static ArrayList<Excercise> findUnsolvedByUserId(long userId) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_UNSOLVED_BY_USER_ID_QUERY);
			statement.setLong(1, userId);
			return createExcercisesListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Excercise> findSolvedByUserId(long userId) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_SOLVED_BY_USER_ID_QUERY);
			statement.setLong(1, userId);
			return createExcercisesListFromStatement(statement);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Integer> findIndexesUnsolvedByUserId(long userId) {
		try {
			ArrayList<Integer> indexesOfUnsolved = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_INDEXES_UNSOLVED_BY_USER_ID_QUERY);
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
			Excercise excercise = getExcerciseFromResultSet(resultSet);
			excercisesList.add(excercise);
		}
		return excercisesList;
	}

	private static Excercise getExcerciseFromResultSet(ResultSet resultSet) throws SQLException {
		Excercise excercise = new Excercise();
		excercise.setId(resultSet.getInt("id"));
		excercise.setTitle(resultSet.getString("title"));
		excercise.setDescription(resultSet.getString("description"));
		return excercise;
	}

}
