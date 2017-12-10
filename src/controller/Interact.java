package controller;

import java.util.Scanner;

public class Interact {

	private static Scanner scan = new Scanner(System.in);

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

	public static long getNotNullId() {
		System.out.println("Enter user id:");

		long id = scanLongNumber();

		while (id <= 0) {
			System.out.println("Id has to be integer number greater than 0!");
			id = scanLongNumber();
		}
		return id;
	}

	public static void tryAgainMessage() {
		System.out.println("Try again");
	}

}
