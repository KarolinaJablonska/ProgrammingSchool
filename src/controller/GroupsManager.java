package controller;

import java.util.ArrayList;

import model.Group;

public class GroupsManager {

	public static void main(String[] args) {
		loopWhile: while (true) {
			showAllGroups();
			showMenu();
			switch (Interaction.scanCommand()) {
			case "add":
				addGroup();
				break;
			case "edit":
				editGroup();
				break;
			case "delete":
				deleteGroup();
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
		System.out.println("add - add group");
		System.out.println("edit - edit group");
		System.out.println("delete - delete group");
		System.out.println("quit - exit manager");
	}

	public static void showAllGroups() {
		System.out.println("All users:");
		ArrayList<Group> allGroupsList = Group.loadAll();
		if (allGroupsList.isEmpty()) {
			System.out.println("No groups in database!");
		} else {
			for (Group group : allGroupsList) {
				System.out.println(group);
			}
		}
		System.out.println();
	}

	public static void addGroup() {
		System.out.println("Enter name:");
		String name = Interaction.scanCommand();
		Group group = new Group(name);
		group.saveToDB();
	}

	public static void editGroup() {
		int id = Interaction.getIdInt();
		System.out.println("Enter name:");
		String name = Interaction.scanCommand();
		Group group = Group.loadById(id);
		group.setAttributes(name);
		group.saveToDB();
	}

	public static void deleteGroup() {
		int id = Interaction.getIdInt();
		Group group = Group.loadById(id);
		group.delete();
	}
}
