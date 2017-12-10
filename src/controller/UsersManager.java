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

			switch (scanCommand()) {
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
				tryAgainMessage();
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
		System.out.println();
		System.out.println("All users:");
		ArrayList<User> allUsersList = User.loadAll();
		for (User user : allUsersList) {
			System.out.println(user);
		}
		System.out.println();
	}

	public static void addUser() {
		System.out.println("Enter username:");
		String username = scanCommand();
		System.out.println("Enter email:");
		String email = scanCommand();
		System.out.println("Enter password:");
		String password = scanCommand();
		System.out.println("Enter person_group_id:");
		int person_group_id = scanIntNumber();

		User user = new User(person_group_id, username, email, password);
		user.saveToDB();
	}

	public static void editUser() {

		long id = validateId();

		System.out.println("Enter username:");
		String username = scanCommand();
		System.out.println("Enter email:");
		String email = scanCommand();
		System.out.println("Enter password:");
		String password = scanCommand();
		System.out.println("Enter person_group_id:");
		int person_group_id = scanIntNumber();

		User user = User.loadById(id);
		user.edit(person_group_id, username, email, password);
		user.saveToDB();
	}

	public static void deleteUser() {

		long id = validateId();

		User user = User.loadById(id);
		user.delete();
	}

	public static String scanCommand() {
		while (!scan.hasNextLine()) {
			scan.nextLine();
			tryAgainMessage();
		}
		return scan.nextLine();
	}

	public static int scanIntNumber() {
		while (true) {
			try {
				return Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				tryAgainMessage();
				continue;
			}
		}
	}

	public static long scanLongNumber() {
		while (true) {
			try {
				return Long.parseLong(scan.nextLine());
			} catch (Exception e) {
				tryAgainMessage();
				continue;
			}
		}
	}

	public static long validateId() {
		System.out.println("Enter user id:");

		long id = scanLongNumber();

		while (id <= 0) {
			System.out.println("Id cannot equal 0!");
			id = scanLongNumber();
		}
		return id;
	}

	public static void tryAgainMessage() {
		System.out.println("Try again");
	}

}
