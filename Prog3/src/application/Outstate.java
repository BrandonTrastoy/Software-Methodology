package application;

/**
 * The Outstate class is a child class of the Student class. It implements the
 * abstract class tuitionDue and overrides the toString method.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class Outstate extends Student {
	private boolean tristate;
	private final int TUITION = 756;
	private final int DISCOUNT = 200;

	/**
	 * Constructor for Outstate class
	 * 
	 * @param fname    first name to be stored
	 * @param lname    last name to be stored
	 * @param credit   amount of credits to be stored
	 * @param tristate if student lives in the tristate area or not
	 */
	public Outstate(String fname, String lname, int credit, boolean tristate) {
		super(fname, lname, credit);
		this.tristate = tristate;
	}

	/**
	 * Calculates the tuition due for an out-state student.
	 * 
	 * @return int tuition for a student.
	 */
	public int tuitionDue() {
		int tuitionDue = 0;

		if (super.credit >= Student.CREDIT_DECIDER) {
			if (super.credit >= Student.MAX_CREDIT) {
				if (!tristate) {
					tuitionDue += (Student.MAX_CREDIT * TUITION);
				} else {
					tuitionDue += (Student.MAX_CREDIT * (TUITION - DISCOUNT));

				}

			} else {

				if (!tristate) {
					tuitionDue += (super.credit * TUITION);
				} else {
					tuitionDue += (super.credit * (TUITION - DISCOUNT));

				}

			}
			tuitionDue = tuitionDue + Student.FULL_TIME;

		} else {
			if (!tristate) {
				tuitionDue += (super.credit * TUITION);
			} else {

				tuitionDue += (super.credit * (TUITION - DISCOUNT));

			}

			tuitionDue += Student.PART_TIME;
		}

		return tuitionDue;
	}

	/**
	 * Overrides the toString method and adds an additional information to return.
	 * 
	 * @return String adds "Out-State" to the front of string and tristate
	 */
	@Override
	public String toString() {
		return "Out-State, " + super.toString() + "; Tristate: " + tristate + "; ";
	}

	public static void main(String[] args) {

		//Initialize students for testing
		Outstate newStudent = new Outstate("Joe", "Banana", 11, false);
		Outstate newStudent2 = new Outstate("George", "Washington", 14, true);

		// Compare To
		System.out.println(newStudent.compareTo(newStudent));
		System.out.println(newStudent.compareTo(newStudent2));
		System.out.println(newStudent2.compareTo(newStudent));
		System.out.println(newStudent2.compareTo(newStudent2));

		// Tuition Due
		System.out.println(newStudent.tuitionDue());
		System.out.println(newStudent2.tuitionDue());

		// To string
		System.out.println(newStudent.toString());
		System.out.println(newStudent2.toString());
	}

}
