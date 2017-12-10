package controller;

import java.util.ArrayList;

import model.Excercise;
import model.Solution;

public class UserFront {

	public static long userId;

	public static void main(String[] args) {
		userId = Long.parseLong(args[0]);
		System.out.println("Welcome user " + userId);
		loopWhile: while (true) {
			showMenu();
			switch (Interaction.scanCommand()) {
			case "add":
				addNewSolution();
				break;
			case "view":
				viewMySolutions();
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
		System.out.println("add - add solution to unsolved excercise");
		System.out.println("view - look in all my solutions");
		System.out.println("quit - exit manager");
	}

	public static void addNewSolution() {
		showUnsolved();
		ArrayList<Integer> indexesOfUnsolved = Excercise.getIndexesUnsolvedOfUser(userId);
		System.out.println("Enter id of excercise to solve:");
		Integer excerciseId = Interaction.getIdInt();
		while (!indexesOfUnsolved.contains(excerciseId)) {
			System.out.println("You are not allowed to update solution of excercise id = " + excerciseId);
			System.out.println("Enter id of excercise to solve:");
			excerciseId = Interaction.getIdInt();
		}
		System.out.println("Enter description (solution):");
		String description = Interaction.scanCommand();
		Solution solution = Solution.loadByExcerciseAndUserId(excerciseId, userId);
		solution.setTheSolution(Interaction.getCurrentDateSql(), description);
		solution.saveToDB();
	}

	public static void showUnsolved() {
		System.out.println("All unsolved excercises:");
		ArrayList<Excercise> unsolvedOfUser = Excercise.loadUnsolvedOfUser(userId);
		if (unsolvedOfUser.isEmpty()) {
			System.out.println("You have all of your excersises solved in database!");
		} else {
			for (Excercise excercise : unsolvedOfUser) {
				System.out.println(excercise);
			}
		}
		System.out.println();
	}

	public static void viewMySolutions() {
		System.out.println("All solved excercises:");
		ArrayList<Excercise> solvedOfUser = Excercise.loadSolvedOfUser(userId);
		if (solvedOfUser.isEmpty()) {
			System.out.println("You have not any excersise solved in database!");
		} else {
			for (Excercise excercise : solvedOfUser) {
				System.out.println(excercise);
			}
		}
		System.out.println();
	}

}
