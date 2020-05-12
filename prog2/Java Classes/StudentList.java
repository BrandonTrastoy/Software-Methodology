/**
 * The StudentList class creates an array list of type Student. It also allows
 * for the array to grow, add, remove, and print the content within the array.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class StudentList {
	private Student[] sList;
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4; // initial and grow size
	private int numStudents;

	/*
	 * Default Constructor for StudentList
	 */
	public StudentList() {

	}

	/*
	 * Checks if the student list is null
	 * 
	 * @return boolean true if list is null, else false
	 */
	public boolean isEmpty() {

		if (sList == null)
			return true;

		return false;
	}

	/**
	 * Locates the index of the Student s in the student list and returns the
	 * location. If student not in list return NOT_FOUND.
	 * 
	 * @param s instance of student to find
	 * @return int index of student, if DNE return NOT_FOUND
	 */
	public int find(Student s) {

		if (isEmpty())
			return NOT_FOUND;

		int i = 0;
		// goes through array checking if TeamMembers are the same returns either -1 for
		// not found or the index
		for (i = 0; i < numStudents; i++) {
			if (s.compareTo(sList[i]) == 0) {
				return i;
			}
		}
		return NOT_FOUND;

	}

	/**
	 * Increases the size of student list by GROW_SIZE
	 */
	public void grow() {

		if (isEmpty()) {
			sList = new Student[GROW_SIZE];
		} else {
			Student[] teamhold = new Student[sList.length + GROW_SIZE];
			System.arraycopy(sList, 0, teamhold, 0, sList.length);
			sList = teamhold;
		}
	}

	/**
	 * Checks if student in student list, returns true if exists, else false.
	 * 
	 * @param s instance of Student to find
	 * @return boolean returns true if student s in list, else false
	 */
	public boolean contains(Student s) {

		if (isEmpty())
			return false;

		int i = 0;
		// checks to see if the TeamMember is already in the team array
		for (i = 0; i < sList.length; i++) {
			if (s.compareTo(sList[i]) == 0) { // Need to change this to
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a student s to the student list if it does not already contain that
	 * student.
	 * 
	 * @param s instance of Student to add
	 */
	public void add(Student s) {

		// check if team array is 0
		if (isEmpty() == true) {
			grow();
			sList[0] = s;
			numStudents += 1;
			System.out.println("Student added to list.");
		} else if (sList[0] == null) {

			sList[0] = s;
			numStudents += 1;
			System.out.println("Student added to list.");
		} else {

			// Check if member already exists before adding
			if (contains(s)) {
				System.out.println("Student already in list.");
				return;
			}

			int i = 0;
			// find next open space to enter the TeamMember into
			for (i = 0; i < sList.length; i++) {
				if (sList[i] == null) {
					sList[i] = s;
					numStudents += 1;
					break;
				}
			}
			// if team array is full grow its size and add in the TeamMember into the first
			// spot
			if (i == sList.length) {
				grow();
				sList[i] = s;
				numStudents += 1;
			}

			System.out.println("Student added to list.");

		}
	}

	/**
	 * Removes student s from student list if they exist.
	 * 
	 * @param s instance of Student to remove
	 */
	public void remove(Student s) {

		int index;
		int i = 0;
		// finds the index of the TeamMember in the team array then overwrites the spot
		// with the last spot and sets it to null
		index = find(s);

		if (index == NOT_FOUND) {
			System.out.println("Student Not Found");
			return;
		}

		// finds the last spot in the array that holds a TeamMember
		while (i < sList.length && sList[i] != null)
			i++;

		sList[index] = sList[i - 1];

		sList[i - 1] = null;

		numStudents -= 1;

		System.out.println("Student Removed");

	}

	/**
	 * Prints all students within the student list
	 */
	public void print() {

		int i = 0;

		if (isEmpty() || sList[i] == null) {

			System.out.println("No students enrolled!");
			return;
		}

		System.out.println("We have the following students:");

		for (i = 0; i < sList.length; i++) {
			if (sList[i] != null)
				System.out.println(sList[i].toString() + "Tuition Due = $" + sList[i].tuitionDue());
		}

		System.out.println("-- end of the list --");
	}

	public static void main(String[] args) {

		Instate newStudent = new Instate("Bran", "T", 15, 0);
		Outstate newStudent2 = new Outstate("Ice", "T", 15, true);
		International newStudent3 = new International("Ice", "Cube", 8, false);

		StudentList list = new StudentList();

		list.add(newStudent);
		list.add(newStudent2);
		list.add(newStudent3);
		list.add(newStudent2);
		
		list.print();

		// System.out.println(newStudent.tuitionDue());
		// System.out.println(newStudent2.tuitionDue());

	}

}
