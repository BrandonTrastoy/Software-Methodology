/**
 * The Instate class is a child class of the Student class. It implements the
 * abstract class tuitionDue and overrides the toString method.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class Instate extends Student {
	private int funds;
	private final int TUITION = 433;

	/**
	 * Constructor for Instate class
	 * 
	 * @param fname  first name to be stored
	 * @param lname  last name to be stored
	 * @param credit amount of credits to be stored
	 * @param funds  amount of funds student receives
	 */
	public Instate(String fname, String lname, int credit, int funds) {
		super(fname, lname, credit);
		this.funds = funds;
	}

	/**
	 * Calculates the tuition due for an in-state student.
	 * 
	 * @return int tuition for a student.
	 */
	public int tuitionDue() {
		int tuitionDue = 0;

		if (super.credit >= Student.CREDIT_DECIDER) {
			if (super.credit >= Student.MAX_CREDIT) {
				tuitionDue += (Student.MAX_CREDIT * TUITION);
			} else {
				tuitionDue += (super.credit * TUITION);
			}
			tuitionDue = tuitionDue + Student.FULL_TIME;
			tuitionDue -= funds;
		} else {
			tuitionDue += (super.credit * TUITION);
			tuitionDue += Student.PART_TIME;
		}

		return tuitionDue;
	}

	/**
	 * Overrides the toString method and adds an additional information to return.
	 * 
	 * @return String adds "In-State" to the front of string
	 */
	@Override
	public String toString() {
		return "In-State, " + super.toString() + "; Funding: $ " + funds + "; ";
	}

	public static void main(String[] args) {

		//Initialize students for testing
		Instate newStudent = new Instate("Brandon", "T", 15, 0);
		Instate newStudent2 = new Instate("Kyle", "V", 18, 500);

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
