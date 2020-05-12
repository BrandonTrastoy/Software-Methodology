/**
 * The International class is a child class of the Student class. It implements
 * the abstract class tuitionDue and overrides the toString method.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class International extends Student {
	private boolean exchange;
	private final int TUITION = 945;
	private final int STUDENT_FEE = 350;

	/**
	 * Constructor for International class
	 * 
	 * @param fname    first name to be stored
	 * @param lname    last name to be stored
	 * @param credit   credit amount of credits to be stored
	 * @param exchange if the student is an exchange student or not
	 */
	public International(String fname, String lname, int credit, boolean exchange) {
		super(fname, lname, credit);
		this.exchange = exchange;
	}

	/**
	 * Calculates the tuition due for an international student.
	 * 
	 * @return int tuition for a student.
	 */
	public int tuitionDue() {
		int tuitionDue = 0;

		if (exchange) {
			tuitionDue += Student.FULL_TIME;
		} else {
			if (super.credit >= Student.CREDIT_DECIDER) {
				if (super.credit >= Student.MAX_CREDIT) {
					tuitionDue += (Student.MAX_CREDIT * TUITION);
				} else {
					tuitionDue += (super.credit * TUITION);
				}
				tuitionDue = tuitionDue + Student.FULL_TIME;
			} else {
				tuitionDue += (super.credit * TUITION);
				tuitionDue += Student.PART_TIME;
			}
		}

		tuitionDue += STUDENT_FEE;

		return tuitionDue;
	}

	/**
	 * Overrides the toString method and adds an additional information to return.
	 * 
	 * @return String adds "International" to the front of string and exchange
	 *         student to the end
	 */
	@Override
	public String toString() {
		return "International, " + super.toString() + "; Exchange Student: " + exchange + "; ";
	}

	public static void main(String[] args) {

		//Initialize students for testing
		International newStudent = new International("Mark", "Yung", 10, true);
		International newStudent2 = new International("Raphael", "Hernandez", 10, false);

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
