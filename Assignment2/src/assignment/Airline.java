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

public class Airline extends Element {
	private String name;
	private String phone;
	private String webURL;

	private static Scanner input = new Scanner(System.in);

	/**
	 * Creates a new Airline object with all blank fields.
	 */

	public Airline() {
		name = "";
		phone = "";
		webURL = "";
	}

	/**
	 * Creates a new Resort object with just a name.
	 * 
	 * @param name
	 */

	public Airline(String name) {
		this.name = name;
		phone = "";
		webURL = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebURL() {
		return webURL;
	}

	public void setWebURL(String webURL) {
		this.webURL = webURL;
	}

	public void readIn() {
		System.out.print("Enter the name of the Airline: ");
		name = input.nextLine().toUpperCase();

		System.out.print("Enter the phone numebr: ");
		phone = input.nextLine().toUpperCase();

		System.out.print("Enter the webURL when prompted: \n");
		webURL = "";

			webURL += input.nextLine().toUpperCase();
	
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Phone: " + phone);
		System.out.println("WebURL: ");
		StringTokenizer token = new StringTokenizer(webURL.replace(',', ' '));
		while (token.hasMoreTokens()) {
			System.out.println("  " + token.nextToken());
		}
	}

	public boolean equals(Element dobj) {
		if (dobj.getClass().getName().contains("Airline"))
			if (getName().equals(((Airline) dobj).getName()))
				return true;

		if (dobj.getClass().getName().contains("Resort"))
			if (getName().equals(((Resort) dobj).getName()))
				return true;

		return false;
	}

	public Element clone() {
		Airline clone = new Airline();

		clone.setName(getName());
		clone.setPhone(getPhone());
		clone.setWebURL(getWebURL());

		return clone;
	}
}