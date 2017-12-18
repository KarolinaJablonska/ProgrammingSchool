package pl.coderslab.console;

import java.util.ArrayList;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Interaction;
import pl.coderslab.model.User;

public class UsersManager {

	public static void main(String[] args) {
		loopWhile: while (true) {
			showAllUsers();
			showMenu();
			switch (Interaction.scanCommand()) {
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
				Interaction.tryAgainMessage();
			}
		}
		System.out.println("Manager closed");
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
		ArrayList<User> allUsersList = UserDao.findAll();
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
		String username = Interaction.scanCommand();
		System.out.println("Enter email:");
		String email = Interaction.scanCommand();
		System.out.println("Enter password:");
		String password = Interaction.scanCommand();
		System.out.println("Enter person_group_id:");
		int person_group_id = Interaction.scanIntNumber();
		User user = new User(person_group_id, username, email, password);
		UserDao.saveToDB(user);
	}

	public static void editUser() {
		System.out.println("Enter user id:");
		long id = Interaction.getIdLong();
		System.out.println("Enter username:");
		String username = Interaction.scanCommand();
		System.out.println("Enter email:");
		String email = Interaction.scanCommand();
		System.out.println("Enter password:");
		String password = Interaction.scanCommand();
		System.out.println("Enter person_group_id:");
		int person_group_id = Interaction.scanIntNumber();
		User user = UserDao.findById(id);
		user.setAttributes(person_group_id, username, email, password);
		UserDao.saveToDB(user);
	}

	public static void deleteUser() {
		System.out.println("Enter user id:");
		long id = Interaction.getIdLong();
		User user = UserDao.findById(id);
		UserDao.delete(user);
	}
}
