package pl.coderslab.console;

import java.util.ArrayList;

import pl.coderslab.console.ExcercisesManager;
import pl.coderslab.console.UsersManager;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Interaction;
import pl.coderslab.model.Solution;

public class ExcerciseAssignment {

	public static void main(String[] args) {
		loopWhile: while (true) {
			showMenu();
			switch (Interaction.scanCommand()) {
			case "add":
				assignExcercise();
				break;
			case "view":
				viewUserSolutions();
				break;
			case "quit":
				break loopWhile;
			default:
				Interaction.tryAgainMessage();
			}
		}
		System.out.println("Manager closed");
	}

	public static void showMenu() {
		System.out.println("Choose an option:");
		System.out.println("add - assign excercise to user");
		System.out.println("view - look in user's excercises");
		System.out.println("quit - exit manager");
	}

	public static void assignExcercise() {
		UsersManager.showAllUsers();
		System.out.println("Enter user id:");
		long userId = Interaction.getIdLong();
		ExcercisesManager.showAllExcercises();
		System.out.println("Enter excercise id:");
		int excerciseId = Interaction.getIdInt();
		Solution solution = new Solution(Interaction.getCurrentDateSql(), null, "", excerciseId, userId);
		SolutionDao.saveToDB(solution);
	}

	public static void viewUserSolutions() {
		UsersManager.showAllUsers();
		System.out.println("Enter user id:");
		long userId = Interaction.getIdLong();
		ArrayList<Solution> allUserSolutions = SolutionDao.findAllByUserId(userId);
		if (allUserSolutions.isEmpty()) {
			System.out.println("No solutions for user (id=" + userId + ")!");
		} else {
			for (Solution solution : allUserSolutions) {
				System.out.println(solution);
			}
		}
		System.out.println();
	}
}
