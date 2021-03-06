package pl.coderslab.console;

import java.util.ArrayList;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.Interaction;

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
		System.out.println("All groups:");
		ArrayList<Group> allGroupsList = GroupDao.findAll();
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
		GroupDao.saveToDB(group);
	}

	public static void editGroup() {
		System.out.println("Enter group id:");
		int id = Interaction.getIdInt();
		System.out.println("Enter name:");
		String name = Interaction.scanCommand();
		Group group = GroupDao.findById(id);
		group.setAttributes(name);
		GroupDao.saveToDB(group);
	}

	public static void deleteGroup() {
		System.out.println("Enter group id:");
		int id = Interaction.getIdInt();
		Group group = GroupDao.findById(id);
		GroupDao.delete(group);
	}
}
