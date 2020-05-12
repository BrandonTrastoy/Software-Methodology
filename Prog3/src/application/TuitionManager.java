package application;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The TutitionManager class allows the user to enter a string command that is
 * then parsed and executed.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class TuitionManager {
	Scanner stdin;
	StudentList cs213;

	/**
	 * Accepts a string from the console, parses it, and then calls the respective
	 * method.
	 */
	public void run() {
		cs213 = new StudentList();
		String command;
		String fname;
		String lname;
		int credit;
		String data;

		System.out.println("Let's Get Started:");

		boolean done = false;
		while (!done) {
			stdin = new Scanner(System.in);
			String line = stdin.nextLine();

			if (line.charAt(0) == 'I' || line.charAt(0) == 'O' || line.charAt(0) == 'N') {

				StringTokenizer tokenizedCommand = new StringTokenizer(line, " ");

				if (tokenizedCommand.countTokens() == 5) {

					command = tokenizedCommand.nextToken();
					fname = tokenizedCommand.nextToken();
					lname = tokenizedCommand.nextToken();
					credit = Integer.parseInt(tokenizedCommand.nextToken());
					data = tokenizedCommand.nextToken();

					if (command.compareTo("N") == 0 && credit < 9) {
						System.out.println("Student Not Added:");
						System.out.println("International Student Credit Below Threshold.");
					} else if (credit <= 0) {
						System.out.println("Student Not Added:");
						System.out.println("Credit must be greater than '0'.");
					} else {
						add(command, fname, lname, credit, data);
					}

				} else {
					System.out.println("Too many or to few parameters.");
					// return;
				}

			} else if (line.charAt(0) == 'R') {

				StringTokenizer tokenizedCommand = new StringTokenizer(line, " ");

				if (tokenizedCommand.countTokens() == 3) {

					command = tokenizedCommand.nextToken();
					fname = tokenizedCommand.nextToken();
					lname = tokenizedCommand.nextToken();
					credit = 0;
					data = "F";

					remove(command, fname, lname, credit);

				} else {
					System.out.println("Too many or to few parameters.");
					// return;
				}

			} else if (line.charAt(0) == 'P') {

				StringTokenizer tokenizedCommand = new StringTokenizer(line, " ");

				if (tokenizedCommand.countTokens() == 1) {

					command = tokenizedCommand.nextToken();
					fname = " ";
					lname = " ";
					credit = 0;
					data = " ";

					print();

				} else {
					System.out.println("Too many parameters.");
					// return;
				}

			} else if (line.charAt(0) == 'Q') {

				StringTokenizer tokenizedCommand = new StringTokenizer(line, " ");

				if (tokenizedCommand.countTokens() == 1) {

					command = tokenizedCommand.nextToken();
					fname = " ";
					lname = " ";
					credit = 0;
					data = " ";

					// Terminate program
					System.out.println("Program Terminated.");
					done = true;

				} else {
					System.out.println("Too many parameters.");
					// return;
				}
			} else {
				// incorrect command
				StringTokenizer tokenizedCommand = new StringTokenizer(line, " ");
				if (tokenizedCommand.countTokens() >= 1) {

					command = tokenizedCommand.nextToken();
					fname = " ";
					lname = " ";
					credit = 0;
					data = " ";

					System.out.println("Command '" + command + "' not supported!");
				} else {
					System.out.println("No Arguments");
				}

			}

		}

	}

	/**
	 * Checks command for the type of student and then calls add using the
	 * respective classes.
	 * 
	 * @param command type of student
	 * @param fname   first name of student
	 * @param lname   last name of student
	 * @param credit  amount of credits to be taken
	 * @param data    string containing an integer or T or F
	 */
	public void add(String command, String fname, String lname, int credit, String data) {

		int funds = 0;
		boolean status = false;

		if (command.compareTo("I") == 0) {

			if (data.matches("[0-9]+")) {
				funds = Integer.parseInt(data);
			} else {
				System.out.println("Invalid sequence for 'funds' entered.");
				return;
			}
		} else {
			if (data.compareTo("F") == 0) {
				status = false;
			} else if (data.compareTo("T") == 0) {
				status = true;
			} else {
				System.out.println("Invalid sequence for 'status' entered.");
				return;
			}
		}

		if (command.compareTo("I") == 0) {

			Instate newStudent = new Instate(fname, lname, credit, funds);
			cs213.add(newStudent);
			// System.out.println("I");

		} else if (command.compareTo("O") == 0) {

			Outstate newStudent = new Outstate(fname, lname, credit, status);
			cs213.add(newStudent);
			// System.out.println("O");

		} else {

			International newStudent = new International(fname, lname, credit, status);
			cs213.add(newStudent);
			// System.out.println("N");

		}
	}

	/**
	 * Checks command for the type of student and then calls remove using the
	 * respective classes.
	 * 
	 * @param command type of student
	 * @param fname   first name of student
	 * @param lname   last name of student
	 * @param credit  amount of credits
	 */
	public void remove(String command, String fname, String lname, int credit) {

		int funds = 0;
		boolean status = false;

		if (command.compareTo("I") == 0) {

			Instate newStudent = new Instate(fname, lname, credit, funds);
			cs213.remove(newStudent);
			// System.out.println("I");

		} else if (command.compareTo("O") == 0) {

			Outstate newStudent = new Outstate(fname, lname, credit, status);
			cs213.remove(newStudent);
			// System.out.println("O");

		} else {

			International newStudent = new International(fname, lname, credit, status);
			cs213.remove(newStudent);
			// System.out.println("N");
		}
	}

	/**
	 * Calls the print method from StudentList class
	 */
	public void print() {
		cs213.print();
	}

	public static void main(String[] args) {

		new TuitionManager().run();
	}
}
