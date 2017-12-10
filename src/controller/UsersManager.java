package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.User;

public class UsersManager {

	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		loopWhile: while (true) {
			showAllUsers();
			showMenu();
			switch (Interact.scanCommand()) {
			case "add":
				addUser();
				break;
			case "edit":
				editUser();
				break;
			case "delete":
				deleteUser();
				break;
			case "quit":
				break loopWhile;
			default:
				Interact.tryAgainMessage();
			}
		}
		System.out.println("Manager closed");
		scan.close();
	}

	public static void showMenu() {
		System.out.println("Choose an option:");
		System.out.println("add - add user");
		System.out.println("edit - edit user");
		System.out.println("delete - delete user");
		System.out.println("quit - exit manager");
	}

	public static void showAllUsers() {
		System.out.println("All users:");
		ArrayList<User> allUsersList = User.loadAll();
		if (allUsersList.isEmpty()) {
			System.out.println("No users in database!");
		} else {
			for (User user : allUsersList) {
				System.out.println(user);
			}
		}
		System.out.println();
	}

	public static void addUser() {
		System.out.println("Enter username:");
		String username = Interact.scanCommand();
		System.out.println("Enter email:");
		String email = Interact.scanCommand();
		System.out.println("Enter password:");
		String password = Interact.scanCommand();
		System.out.println("Enter person_group_id:");
		int person_group_id = Interact.scanIntNumber();
		User user = new User(person_group_id, username, email, password);
		user.saveToDB();
	}

	public static void editUser() {
		long id = Interact.getNotNullId();
		System.out.println("Enter username:");
		String username = Interact.scanCommand();
		System.out.println("Enter email:");
		String email = Interact.scanCommand();
		System.out.println("Enter password:");
		String password = Interact.scanCommand();
		System.out.println("Enter person_group_id:");
		int person_group_id = Interact.scanIntNumber();
		User user = User.loadById(id);
		user.edit(person_group_id, username, email, password);
		user.saveToDB();
	}

	public static void deleteUser() {
		long id = Interact.getNotNullId();
		User user = User.loadById(id);
		user.delete();
	}
}
