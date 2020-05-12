package application;

/**
 * The student class stores the first name, last name, and credit of a student.
 * It also implements a compareTo methods, toString method, and an abstract
 * tuitionDue method, that is to be implemented in a child class.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public abstract class Student implements Comparable {
	private String fname;
	private String lname;
	protected int credit;
	public static final int PART_TIME = 846;
	public static final int FULL_TIME = 1441;
	public static final int CREDIT_DECIDER = 12;
	public static final int MAX_CREDIT = 15;
	/**
	 * Constructor for student class.
	 * 
	 * @param fname  first name of student
	 * @param lname  last name of student
	 * @param credit amount of credits student will be taking
	 */
	public Student(String fname, String lname, int credit) {
		this.fname = fname;
		this.lname = lname;
		this.credit = credit;

	}

	/**
	 * This method takes two objects of the student class and compares the value of
	 * their first and last names and outputs a result based on their values.
	 * 
	 * @param obj is the object to be compared to
	 * @return int value; Outputs 0 on success, -1 if less than, 1 if greater than
	 */
	public int compareTo(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof Student)) {
			return -1;
		}

		Student student = (Student) obj;

		// Compare the data members and return accordingly
		if (fname.compareTo(student.fname) == 0) {
			if (lname.compareTo(student.lname) == 0) {
				return 0;
			} else if (lname.compareTo(student.lname) < 0) {
				return -1;
			} else {
				return 1;
			}
		} else if (fname.compareTo(student.fname) < 0) {
			return -1;
		} else {
			return 1;
		}

	}

	/**
	 * Returns a string with student class values
	 * 
	 * @return string composed of fname, lname, and credit hours
	 */
	public String toString() {
		return fname + " " + lname + ", " + credit + " credits";
	}

	/**
	 * Computes the tuition due; To be implemented in child classes
	 * 
	 * @return int
	 */
	public abstract int tuitionDue();

}
