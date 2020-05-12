/**
 * The TeamMember class stores the name and date of an individual member.
 * 
 * @author Kyle VanWageninge
 * @author Brandon Trastoy
 */

public class TeamMember {
	private String name;
	private Date startDate;

	/**
	 * Constructor. Creates TeamMember object.
	 * 
	 * @param nm   is name to be stored
	 * @param date is a date object to be stored
	 */
	public TeamMember(String nm, Date date) {
		name = nm;
		startDate = date;
	}

	/**
	 * Returns team member start date.
	 * 
	 * @return Date object
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method compares two instances of an object and determines if their
	 * values are equal. If equal returns true, else false.
	 * 
	 * @param obj to compare
	 * @return boolean value
	 */
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof TeamMember)) {
			return false;
		}

		TeamMember member = (TeamMember) obj;

		// Compare the data members and return accordingly
		return (name.compareTo(member.name) == 0 && startDate.equals(member.startDate));
	}

	/**
	 * Takes the name and startDate and returns them as a string.
	 * 
	 * @return String value
	 */
	public String toString() {
		return name + " " + startDate;
	}

	public static void main(String[] args) {

		Date today = new Date("1/2/2020");
		Date differentDay = new Date("1/1/2020");

		TeamMember member1 = new TeamMember("Brandon", today);
		TeamMember member2 = new TeamMember("Kyle", differentDay);
		
		// equals Method

		System.out.println("Test Equals Method");
		System.out.println(member1.equals(member2));
		System.out.println(member1.equals(member1));
		System.out.println(member2.equals(member2));
		System.out.println("-- End Test --");
		
		System.out.println();
		
		// toString Method

		System.out.println("Test toString Method");
		System.out.println(member1.toString());
		System.out.println(member2.toString());
		System.out.println("-- End Test --");
		
		System.out.println();
		
		// getStartDate Method
		
		System.out.println("Test getStartDate Method");
		System.out.println(member1.getStartDate());
		System.out.println(member2.getStartDate());
		System.out.println("-- End Test --");
		

	}
}