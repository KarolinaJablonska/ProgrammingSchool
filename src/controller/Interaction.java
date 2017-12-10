package controller;

import java.util.Scanner;

public class Interaction {

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

	public static int getIdInt() {
		int id = scanIntNumber();

		while (id <= 0) {
			System.out.println("Id has to be integer number greater than 0!");
			id = scanIntNumber();
		}
		return id;
	}

	public static long getIdLong() {
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

	public static java.sql.Date getCurrentDateSql() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		return date;
	}
}
