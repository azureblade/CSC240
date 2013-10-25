/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #2
 * 
 * @author Matthew Wallace
 */

package assignment;

import java.util.Scanner;

public class application {
	static Scanner input = new Scanner(System.in);

	private static ElementSet list = new ElementSet();

	public static void main(String[] args) {
		menu();
	}

	/**
	 * Prompts the user if he wants to quit.
	 * 
	 * @return false if user does not want to quit, else returns true
	 */

	private static boolean getQuit() {
		System.out.println("Do you want to quit?\nY)es\nN)o");
		if (input.next().toUpperCase().charAt(0) == 'N')
			return false;
		else
			return true;
	}

	/**
	 * Presents the user with a menu, prompts for input, and then executes the
	 * user's choice.
	 */

	private static void menu() {
		boolean validChoice = false;
		char menuChoice;
		String[] options = { "Add a Resort  ", "Add a Airline  ",
				"Display names of all Resorts", "Display names of all Airlines",
				"Display data for a Resort  ", "Display data for an Airline  ",
				"Remove a Resort", "Remove an Airline ", "Quit" };

		do {
			System.out.println("\nFantastic Travel Agency Data Menu:");
			for (int i = 0; i < 9; i++)
				System.out.println((i + 1) + ") " + options[i]);

			System.out.print("Please select an option: ");
			menuChoice = input.next().charAt(0);

			if (menuChoice <= '9' && menuChoice >= '0')
				validChoice = true;
			else
				System.out.println("Sorry, that is not a valid choice. Try again.");

		} while (!validChoice);

		switch (menuChoice) {
		case '1':
			addResort();
			break;
		case '2':
			addAirline();
			break;
		case '3':
			displayResortNames();
			break;
		case '4':
			displayAirlineNames();
			break;
		case '5':
			displayResortData();
			break;
		case '6':
			displayAirlineData();
			break;
		case '7':
			removeResort();
			break;
		case '8':
			removeAirline();
			break;
		default:
			break;
		}

		if (menuChoice != '9')
			menu();
		else if (!getQuit())
			menu();
	}

	/**
	 * Menu 1): Add a new Resort to the ElementSet list.
	 */

	private static void addResort() {
		Resort temp = new Resort();
		temp.readIn();
		int outcome = list.add(temp);

		// Feedback
		if (outcome == 1)
			System.out.println("This Resort was added successfully!");
		else if (outcome == -1)
			System.out.println("This Resort is already in the list.");
		else if (outcome == 0)
			System.out.println("The list is full!");
	}

	/**
	 * Menu 2): Add a new Airline to the ElementSet list.
	 */

	private static void addAirline() {
		Airline temp = new Airline();
		temp.readIn();
		int outcome = list.add(temp);

		// Feedback
		if (outcome == 1)
			System.out.println("This Airline was added successfully!");
		else if (outcome == -1)
			System.out.println("This Airline is already in the list.");
		else if (outcome == 0)
			System.out.println("The list is full!");
	}

	/**
	 * Menu 3): Display the names of all Resorts in the ElementSet
	 * list.
	 */

	private static void displayResortNames() {
		// If list is empty, there can be no Resorts in the list
		if (list.isEmpty())
			System.out.println("There are no Resorts.");
		else {
			// Counter for number of Resorts in the list
			int c = 0;
			for (int i = 0; i < list.size(); i++) {
				Element e = list.getCurrent();
				if (e.getClassName().equals("Resort")) {
					System.out.println(((Resort) e).getName());
					c++;
				}
			}
			// If the counter is still zero, no Resorts were found
			if (c == 0)
				System.out.println("There are no Resorts.");
		}
	}

	/**
	 * Menu 4): Display the names of all Airlines in the ElementSet
	 * list.
	 */

	private static void displayAirlineNames() {
		// If list is empty, there can be no Airlines in the list
		if (list.isEmpty())
			System.out.println("There are no Airlines.");
		else {
			// Counter for number of Airlines in the list
			int c = 0;
			for (int i = 0; i < list.size(); i++) {
				Element e = list.getCurrent();
				if (e.getClassName().equals("Airline")) {
					System.out.println(((Airline) e).getName());
					c++;
				}
			}
			// If the counter is still zero, no Airlines were found
			if (c == 0)
				System.out.println("There are no Airlines.");
		}
	}

	/**
	 * Menu 5): Display the data of a specified Resort  in the
	 * ElementSet list.
	 */

	private static void displayResortData() {
		boolean result = false;

		System.out.print("Enter the name of a Resort : ");
		String name = input.next().toUpperCase();

		if (list.isMemberOf(new Resort(name))) {
			Resort temp = new Resort(name);
			result = list.displayAnObject(temp);
		}

		if (!result)
			System.out.println("Not a valid option.");
	}

	/**
	 * Menu 6): Display the data of a specified Airline in the
	 * ElementSet list.
	 */

	private static void displayAirlineData() {
		boolean result = false;

		System.out.print("Enter the name of an Airline : ");
		String name = input.next().toUpperCase();

		if (list.isMemberOf(new Airline(name))) {
			Airline temp = new Airline(name);
			result = list.displayAnObject(temp);
		}

		if (!result)
			System.out.println("Not a valid option.");
	}

	/**
	 * Menu 7): Edit the data of a specified Resort in the
	 * ElementSet list.
	 */

	private static void removeResort() {
		boolean result = false;

		System.out.print("Enter the name of a Resort: ");
		String name = input.next().toUpperCase();

		if (list.isMemberOf(new Resort(name))) {
			Resort temp = new Resort(name);
			result = list.removeAnObject(temp);
		}

		if (result)
			System.out.println("This Resort was successfully removed.");
		else
			System.out.println("Not a valid option.");
	}

	/**
	 * Menu 8): Edit the data of a specified Airline in the
	 * ElementSet list.
	 */

	private static void removeAirline() {
		boolean result = false;

		System.out.print("Enter the name of a Airline: ");
		String name = input.next().toUpperCase();

		if (list.isMemberOf(new Airline(name))) {
			Airline temp = new Airline(name);
			result = list.removeAnObject(temp);
		}

		if (result)
			System.out.println("This Airline was successfully removed.");
		else
			System.out.println("Not a valid option.");
	}
}