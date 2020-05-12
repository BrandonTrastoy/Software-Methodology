
/**
 * The ProjectManager class creates an instance of the team class 
 * and allows users to add, remove, and print elements. Using the 
 * scanner, users can enter commands into the command prompt and 
 * receive different outputs based on commands entered.
 * 
 * @author Kyle VanWageninge
 * @author Brandon Trastoy
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class ProjectManager {
	Scanner stdin;
	Team cs213;

	/**
	 * This method accepts input from the user, which is then parsed into a command,
	 * name and date. It reject all foreign commands, the commands executed and
	 * either store or output the result.
	 */
	public void run() {

		cs213 = new Team();

		boolean done = false;
		while (!done) {

			stdin = new Scanner(System.in);
			String command = stdin.nextLine();

			StringTokenizer tokenizedCommand = new StringTokenizer(command, " ");

			String option, name, date;

			if (tokenizedCommand.hasMoreTokens()) { // 1st choice, Sets option string

				option = tokenizedCommand.nextToken();

				// Invalid Commands
				if (!option.equals("A") && !option.equals("R") && !option.equals("P") && !option.equals("Q")) {

					System.out.println("Command '" + option + "' not supported!");

					// Setting values as empty string
					option = "";
					name = "";
					date = "";
				}

				// Only Runs for valid commands
				else {

					// Sets Name string if has more tokens
					if (tokenizedCommand.hasMoreTokens()) {

						// If P or Q has more arguments, invalid sequence
						if (option.equals("P") || option.equals("Q")) {
							System.out.println("Command '" + option
									+ "' requires no additional arguments. Re-enter using correct ammount");

							// Setting values as empty string
							option = "";
							name = "";
							date = "";
						}

						// Not P or Q, continue setting values
						else {

							name = tokenizedCommand.nextToken();

							// Sets Date string
							if (tokenizedCommand.hasMoreTokens()) {

								date = tokenizedCommand.nextToken();

								// Too many arguments
								if (tokenizedCommand.hasMoreTokens()) {

									// System.out.println("Too many arguments");

									// Setting values as empty string
									option = "";
									name = "";
									date = "";
								}

								// Correct number of arguments
								// else
								// System.out.println("Perfect");

							}

							else {
								// Too few arguments
								// System.out.println("Too few arguments");
								// Setting values as empty string
								option = "";
								name = "";
								date = "";
							}
						}
					}

					// No more tokens
					else {

						// If P or Q has more arguments, invalid sequence
						if (option.equals("P") || option.equals("Q")) {

							// P or Q, correct sequence
							// System.out.println("Perfect");

							// Setting values as empty string
							name = "";
							date = "";
						} else {
							// A or R, invalid sequence
							// System.out.println("Too few arguments");
							// Setting values as empty string
							option = "";
							name = "";
							date = "";
						}
					}
				}
			}

			else {
				// There are litterally no arguments
				// System.out.println("There are litterally no arguments");
				// Setting values as empty string
				option = "";
				name = "";
				date = "";

			}

			switch (option) // Not sure if this is well written or not
			{
			case "A":
				add(name, date);
				break;
			case "R":
				remove(name, date);
				break;
			case "P":
				print();
				break;
			case "Q": // This should do the same as P, but needs an additional print statement
				print();
				done = true; // Will end the program
				System.out.println("The team is ready to go!");
				break;
			default: // deal with bad command here
			}
		}
		// write java code before you terminate the program
	} // run()

	/**
	 * This method adds a new member to the cs213 array. It checks to see if the
	 * date is valid and then checks if the member is not already in the array. If
	 * true, it adds a new member.
	 * 
	 * @param name, name to be added
	 * @param date, date to be added
	 */
	private void add(String name, String date) {

		// must check if the date is valid
		Date startDate = new Date(date);

		if (!startDate.isValid()) {
			System.out.println(date + " is not a valid date.");
			return;
		}

		// must call the contains() method to check if a given
		TeamMember newMember = new TeamMember(name, startDate);

		cs213.add(newMember);

	}

	/**
	 * This method removes a member from the cs213 array. It checks to see if the
	 * date is valid and if the member exists. If both are true, it will remove the
	 * member.
	 * 
	 * @param name, name to be removed
	 * @param Date, date to be removed
	 */
	private void remove(String name, String date) {

		Date startDate = new Date(date);

		if (!startDate.isValid()) {
			System.out.println(date + " is not a valid date.");
			return;
		}

		// must call the contains() method to check if a given
		TeamMember newMember = new TeamMember(name, startDate);

		cs213.remove(newMember);

	}

	/**
	 * Calls the print method from the team class
	 */
	private void print() {

		cs213.print();

	}
} // ProjectManager