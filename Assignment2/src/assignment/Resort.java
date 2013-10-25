/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #2
 * 
 * @author Matthew Wallace
 */

package assignment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Resort extends Element {
	private String name;
	private String state;
	private String attractions;

	private static Scanner input = new Scanner(System.in);

	/**
	 * Creates a new Resort object with all blank fields.
	 */

	public Resort() {
		name = "";
		state = "";
		attractions = "";
	}

	/**
	 * Creates a new Resort object with just a name.
	 * 
	 * @param name
	 */

	public Resort(String name) {
		this.name = name;
		state = "";
		attractions = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAttractions() {
		return attractions;
	}

	public void setAttractions(String attractions) {
		this.attractions = attractions;
	}

	public void readIn() {
		System.out.print("Enter the name of the Resort: ");
		name = input.nextLine().toUpperCase();

		System.out.print("Enter the name of the state: ");
		state = input.nextLine().toUpperCase();

		System.out.print("Enter the number of attractions for this resort: ");
		int numNu = Integer.parseInt(input.nextLine());

		System.out.print("Enter the attractions when prompted: \n");
		attractions = "";

		for (int i = 0; i < numNu; i++) {
			System.out.print((i + 1) + ") ");
			attractions += input.nextLine().toUpperCase();
			if (i != numNu - 1)
				attractions += ",";
		}
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("State: " + state);
		System.out.println("Attractions: ");
		StringTokenizer token = new StringTokenizer(attractions, ",");
		while (token.hasMoreTokens()) {
			System.out.println("  " + token.nextToken());
		}
	}

	public boolean equals(Element dobj) {
		if (dobj.getClass().getName().contains("Resort"))
			if (getName().equals(((Resort) dobj).getName()))
				return true;

		if (dobj.getClass().getName().contains("Airline"))
			if (getName().equals(((Airline) dobj).getName()))
				return true;

		return false;
	}

	public Element clone() {
		Resort clone = new Resort();

		clone.setName(getName());
		clone.setState(getState());
		clone.setAttractions(getAttractions());

		return clone;
	}
}