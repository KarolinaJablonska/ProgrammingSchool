package pl.coderslab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Solution;
import sql.DbManager;

public class SolutionDao {

	private static final String FIND_ALL_SOLUTUIONS_QUERY = "SELECT * FROM Solution";
	private static final String FIND_ALL_BY_USER_ID_QUERY = "SELECT * FROM Solution WHERE users_id = ?";
	private static final String FIND_ALL_BY_EXCERCISE_ID_NEWEST_QUERY = "SELECT * FROM Solution WHERE excercise_id = ? ORDER BY updated DESC";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM Solution WHERE id = ?";
	private static final String FIND_BY_EXCERCISE_ID_QUERY = "SELECT * FROM Solution WHERE excercise_id = ?";
	private static final String FIND_BY_EXCERCISE_AND_USER_ID_QUERY = "SELECT * FROM Solution WHERE excercise_id = ? AND users_id = ?";
	private static final String DELETE_BY_ID_QUERY = "DELETE FROM Solution WHERE id = ?";
	private static final String ADD_NEW_QUERY = "INSERT INTO Solution(created, updated, description, excercise_id, users_id) VALUES(?, ?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE Solution SET created = ?, updated = ?, description = ?, excercise_id = ?, users_id = ? WHERE id = ?";

	public static ArrayList<Solution> findAll() {
		try {
			ArrayList<Solution> solutions = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_ALL_SOLUTUIONS_QUERY);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Solution solution = getSolutionFromResultSet(resultSet);
				solutions.add(solution);
			}
			return solutions;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Solution findById(int id) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_BY_ID_QUERY);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getSolutionFromResultSet(resultSet);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Solution findByExcerciseId(int excerciseId) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_BY_EXCERCISE_ID_QUERY);
			statement.setInt(1, excerciseId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getSolutionFromResultSet(resultSet);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Solution findByExcerciseAndUserId(int excerciseId, long userId) {
		try {
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_BY_EXCERCISE_AND_USER_ID_QUERY);
			statement.setInt(1, excerciseId);
			statement.setLong(2, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return getSolutionFromResultSet(resultSet);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Solution> findAllByUserId(long users_id) {
		try {
			ArrayList<Solution> userSolutions = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_ALL_BY_USER_ID_QUERY);
			statement.setLong(1, users_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Solution solution = getSolutionFromResultSet(resultSet);
				userSolutions.add(solution);
			}
			return userSolutions;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Solution> findAllByExcerciseIdNewest(int excercise_id) {
		try {
			ArrayList<Solution> userSolutions = new ArrayList<>();
			PreparedStatement statement = DbManager.getPreparedStatement(FIND_ALL_BY_EXCERCISE_ID_NEWEST_QUERY);
			statement.setLong(1, excercise_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Solution solution = getSolutionFromResultSet(resultSet);
				userSolutions.add(solution);
			}
			return userSolutions;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static void delete(Solution solution) {
		try {
			if (solution.getId() != 0) {
				PreparedStatement statement = DbManager.getPreparedStatement(DELETE_BY_ID_QUERY);
				statement.setLong(1, solution.getId());
				statement.executeUpdate();
				solution.setId(0);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void saveToDB(Solution solution) {
		if (solution.getId() == 0) {
			try {
				String[] generatedColumns = { "id" };
				PreparedStatement statement = DbManager.getPreparedStatement(ADD_NEW_QUERY, generatedColumns);
				statement.setDate(1, solution.getCreated());
				statement.setDate(2, solution.getUpdated());
				statement.setString(3, solution.getDescription());
				statement.setInt(4, solution.getExcercise_id());
				statement.setLong(5, solution.getUsers_id());
				statement.executeUpdate();
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					solution.setId(resultSet.getInt(1));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			try {
				PreparedStatement statement = DbManager.getPreparedStatement(UPDATE_QUERY);
				statement.setDate(1, solution.getCreated());
				statement.setDate(2, solution.getUpdated());
				statement.setString(3, solution.getDescription());
				statement.setInt(4, solution.getExcercise_id());
				statement.setLong(5, solution.getUsers_id());
				statement.setInt(6, solution.getId());
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	private static Solution getSolutionFromResultSet(ResultSet resultSet) throws SQLException {
		Solution solution = new Solution();
		solution.setId(resultSet.getInt("id"));
		solution.setCreated(resultSet.getDate("created"));
		solution.setUpdated(resultSet.getDate("updated"));
		solution.setDescription(resultSet.getString("description"));
		solution.setExcercise_id(resultSet.getInt("excercise_id"));
		solution.setUsers_id(resultSet.getInt("users_id"));
		return solution;
	}
}
