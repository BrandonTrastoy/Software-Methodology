/**
 * The Team class lets a user add and remove TeamMembers to and from the array.
 * The Team class will grow an array when needed as well as check for when it is
 * empty and print the list of TeamMembers
 * 
 * @author Kyle VanWageninge
 * @author Brandon Trastoy
 */

public class Team {
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4; // initial and grow size
	private TeamMember[] team;
	private int numMembers;

	/**
	 * default Team Constructor
	 */
	public Team() {
		// this is the default constructor
	}

	/**
	 * Finds the index of the TeamMember object inside of the team array.
	 * 
	 * @param m TeamMember object to be found
	 * @return index location of the TeamMember or NOT_FOUND if the member is not in
	 *         the array
	 */
	private int find(TeamMember m) {

		if (isEmpty())
			return NOT_FOUND;

		int i = 0;
		// goes through array checking if TeamMembers are the same returns either -1 for
		// not found or the index
		for (i = 0; i < numMembers; i++) {
			if (m.equals(team[i])) {
				return i;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * Grows the size of the team array by the GROW_SIZE(4)
	 * 
	 */
	private void grow() {

		// if team is empty create it with growsize otherwise increase its size by the
		// growsize
		if (isEmpty()) {
			team = new TeamMember[GROW_SIZE];
		} else {
			TeamMember[] teamhold = new TeamMember[team.length + GROW_SIZE];
			System.arraycopy(team, 0, teamhold, 0, team.length);
			team = teamhold;
		}
	}

	/**
	 * Checks to see if the array team has yet to be instantiated
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {

		if (team == null)
			return true;

		return false;
	}

	/**
	 * Adds a TeamMember object into the team array.
	 * 
	 * @param m TeamMember object to be inserted
	 */
	public void add(TeamMember m) {

		// check if team array is 0
		if (isEmpty() == true) {
			grow();
			team[0] = m;
			numMembers += 1;
			System.out.println(m.toString() + " has joined the team.");
		} else if (team[0] == null) {

			team[0] = m;
			numMembers += 1;
		} else {

			// Check if member already exists before adding
			if (contains(m)) {
				System.out.println(m.toString() + " is already in the team.");
				return;
			}

			int i = 0;
			// find next open space to enter the TeamMember into
			for (i = 0; i < team.length; i++) {
				if (team[i] == null) {
					team[i] = m;
					numMembers += 1;
					break;
				}
			}
			// if team array is full grow its size and add in the TeamMember into the first
			// spot
			if (i == team.length) {
				grow();
				team[i] = m;
				numMembers += 1;
			}

			System.out.println(m.toString() + " has joined the team.");

		}
	}

	/**
	 * Removes a TeamMember object from the team array.
	 * 
	 * @param m TeamMember object to be removed
	 * @return boolean if remove was successful or not
	 */
	public boolean remove(TeamMember m) {

		int index;
		int i = 0;
		// finds the index of the TeamMember in the team array then overwrites the spot
		// with the last spot and sets it to null
		index = find(m);

		if (index == NOT_FOUND) {
			System.out.println(m.toString() + " is not a team member.");
			return false;
		}

		// finds the last spot in the array that holds a TeamMember
		while (i < team.length && team[i] != null)
			i++;

		team[index] = team[i - 1];

		team[i - 1] = null;

		numMembers -= 1;

		System.out.println(m.toString() + " has left the team.");

		return true;
	}

	/**
	 * Checks to see if a TeamMember object is already in the array.
	 * 
	 * @param m TeamMember object to be checked
	 * @return boolean if TeamMember is inside array or not
	 */
	public boolean contains(TeamMember m) {

		if (isEmpty())
			return false;

		int i = 0;
		// checks to see if the TeamMember is already in the team array
		for (i = 0; i < team.length; i++) {
			if (m.equals(team[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints out the array of TeamMembers in list form
	 */
	public void print() {

		int i = 0;

		if (isEmpty() || team[i] == null) {

			System.out.println("We have 0 team members!");
			return;
		}

		System.out.println("We have the following team members:");

		for (i = 0; i < team.length; i++) {
			if (team[i] != null)
				System.out.println(team[i]);
		}

		System.out.println("-- end of the list --");
	}

	public static void main(String[] args) {
		Team newTeam = new Team();

		Date today = new Date("1/2/2020");
		Date differentDay = new Date("1/1/2020");
		TeamMember member1 = new TeamMember("Brandon", today);
		TeamMember member2 = new TeamMember("Bryan", differentDay);
		TeamMember member3 = new TeamMember("Brent", today);
		TeamMember member4 = new TeamMember("Brenden", differentDay);

		// System.out.println("Test Equals Method: " + newTeam.isEmpty());

		newTeam.add(member1);
		newTeam.add(member2);
		newTeam.add(member3);
		newTeam.add(member4);

		newTeam.print();

		newTeam.add(member1);

		newTeam.remove(member4);

		System.out.println();

		// System.out.println("Team Member is in position: " + newTeam.find(member2));

		newTeam.print();
	}
}