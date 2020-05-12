
/**
 * The Date class accepts a string, that is then parsed into three integer values: 
 * month, day, year. It is then checked to see if the date is valid. If the date 
 * is valid, then a date object is created.
 * 
 * @author Kyle VanWageninge
 * @author Brandon Trastoy
 */

import java.util.StringTokenizer;

public class Date {

	private int day;
	private int month;
	private int year;

	/**
	 * Uses StringTokenizer to parse date String and create a Date object. Does not
	 * construct if date is invalid.
	 * 
	 * @param d is a date string to be parsed
	 */
	public Date(String d) {
		StringTokenizer tokenizedDate = new StringTokenizer(d, "/");
		String holderMonth;
		String holderDay;
		String holderYear;
		// This needs to be corrected for the case where characters are input
		// Error
		if (!tokenizedDate.hasMoreTokens())
			return;

		// Check to see if characters other than numbers are in the month token
		holderMonth = tokenizedDate.nextToken();
		if (holderMonth.matches("[0-9]+"))
			month = Integer.parseInt(holderMonth);
		else
			return;
		// Error
		if (!tokenizedDate.hasMoreTokens())
			return;

		// Check to see if characters other than numbers are in the day token
		holderDay = tokenizedDate.nextToken();
		if (holderDay.matches("[0-9]+"))
			day = Integer.parseInt(holderDay);
		else
			return;

		// Error
		if (!tokenizedDate.hasMoreTokens())
			return;

		// Check to see if characters other than numbers are in the year token
		holderYear = tokenizedDate.nextToken();
		if (holderYear.matches("[0-9]+"))
			year = Integer.parseInt(holderYear);
		else
			return;
	}

	/**
	 * Constructor. Creates instance of date object.
	 * 
	 * @param d is a date object
	 */
	public Date(Date d) {

		day = d.day;
		month = d.month;
		year = d.year;
	}

	/**
	 * This method checks whether or not a date object is valid. Returns true if
	 * valid, else returns false.
	 * 
	 * @return boolean value
	 */
	public boolean isValid() // Check if a date is valid
	{
		if (day == 0 || year == 0) {
			return false;
		}

		switch (month) // If month not within 1 - 12 default returns false
		{
		case Month.JAN:
		case Month.MAR:
		case Month.MAY:
		case Month.JUL:
		case Month.AUG:
		case Month.OCT:
		case Month.DEC:
			if (day > Month.DAYS_ODD) {
				return false;
			} else {
				return true;
			}
		case Month.APR:
		case Month.JUN:
		case Month.SEP:
		case Month.NOV:
			if (day > Month.DAYS_EVEN) {
				return false;
			} else {
				return true;
			}
		case Month.FEB:
			if (day == (Month.DAYS_FEB + 1)) {
				if (isLeapYear()) {
					return true;
				} else {
					return false;
				}
			} else if ((day > Month.DAYS_FEB)) {
				return false;
			} else {
				return true;
			}
		default:
			return false;
		}
	}

	/**
	 * This method checks if the current year is a leap year. Returns true if
	 * leapYear, else returns false.
	 * 
	 * @return boolean value
	 */
	public boolean isLeapYear() { // Check if year is a leap year

		if (year % Month.QUADRENNIAL == 0) {

			if (year % Month.CENTENNIAL == 0) {

				if (year % Month.QUATERCENTENNIAL == 0) {
					return true;
				} else {
					return false;
				}

			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Takes the current month, day, and year and returns them as a string.
	 * 
	 * @return String value
	 */
	@Override
	public String toString() {

		return month + "/" + day + "/" + year;
	}

	/**
	 * This method compares two instances of an object and determines if their
	 * values are equal. If equal returns true, else false.
	 * 
	 * @param obj to compare
	 * @return boolean value.
	 */
	@Override
	public boolean equals(Object obj) {

		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Date)) {
			return false;
		}

		Date date = (Date) obj;

		// Compare the data members and return accordingly
		return (Integer.compare(day, date.day) == 0 && Integer.compare(month, date.month) == 0
				&& Integer.compare(year, date.year) == 0);
	}

	public static void main(String[] args) {

		// Test 1

		Date correctDate = new Date("2/7/2020");
		Date invalidDate = new Date("12/32/2020");

		if (correctDate.isValid()) {
			System.out.println("Correct Date: " + correctDate.toString()); // This should run
		} else {
			System.out.println("Invalid Date");
		}

		if (invalidDate.isValid()) {
			System.out.println("Correct Date");
		} else {
			System.out.println("Invalid Date: " + invalidDate.toString()); // This should run
		}

		// Test 2

		Date today = new Date("2/6/2020");
		Date tomorrow = new Date("2/7/2020");

		if (today.equals(tomorrow)) {
			System.out.println(today.toString() + " and " + tomorrow.toString() + " are the same date");
		} else {
			System.out.println(today.toString() + " and " + tomorrow.toString() + " are different dates");
		}

	}
}
