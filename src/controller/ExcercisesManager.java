package controller;

import java.util.ArrayList;

import model.Excercise;

public class ExcercisesManager {

	public static void main(String[] args) {
		loopWhile: while (true) {
			showAllExcercises();
			showMenu();
			switch (Interaction.scanCommand()) {
			case "add":
				addExcercise();
				break;
			case "edit":
				editExcercise();
				break;
			case "delete":
				deleteExcercise();
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
		System.out.println("add - add excercise");
		System.out.println("edit - edit excercise");
		System.out.println("delete - delete excercise");
		System.out.println("quit - exit manager");
	}

	public static void showAllExcercises() {
		System.out.println("All excercises:");
		ArrayList<Excercise> allExcercisesList = Excercise.loadAll();
		if (allExcercisesList.isEmpty()) {
			System.out.println("No excercises in database!");
		} else {
			for (Excercise excercise : allExcercisesList) {
				System.out.println(excercise);
			}
		}
		System.out.println();
	}

	public static void addExcercise() {
		System.out.println("Enter title:");
		String title = Interaction.scanCommand();
		System.out.println("Enter description:");
		String description = Interaction.scanCommand();
		Excercise excercise = new Excercise(title, description);
		excercise.saveToDB();
	}

	public static void editExcercise() {
		System.out.println("Enter excercise id:");
		int id = Interaction.getIdInt();
		System.out.println("Enter title:");
		String title = Interaction.scanCommand();
		System.out.println("Enter description:");
		String description = Interaction.scanCommand();
		Excercise excercise = Excercise.loadById(id);
		excercise.setAttributes(title, description);
		excercise.saveToDB();
	}

	public static void deleteExcercise() {
		System.out.println("Enter excercise id:");
		int id = Interaction.getIdInt();
		Excercise excercise = Excercise.loadById(id);
		excercise.delete();
	}
}
