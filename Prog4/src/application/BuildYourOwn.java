package application;

import java.util.ArrayList;

/**
 * The BuildYourOwn class is a child class of the Pizza class. It inherits its
 * values and methods. It also overrides the abstract method pizzaPrice and
 * toString.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class BuildYourOwn extends Pizza {

	private int SMALL = 5;
	private int MEDIUM = SMALL + 2;
	private int LARGE = SMALL + 4;

	/**
	 * Constructor
	 * 
	 * @param style    the type of pizza being ordered
	 * @param size     the size of pizza being ordered
	 * @param toppings list of toppings
	 */
	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
	}

	/**
	 * Constructor
	 * 
	 * @param style the type of pizza being ordered
	 * @param size  the size of pizza being ordered
	 */
	public BuildYourOwn(String style, String size) {
		super(style, size);
	}

	/**
	 * Calculates the price of a pizza and returns the value. This method also adds
	 * the price per topping and adds it as well.
	 * 
	 * @return integer price of pizza
	 */
	@Override
	public int pizzaPrice() {
		if (super.size.compareTo("Small") == 0) {
			return SMALL + (toppings.size() * 2);

		} else if (super.size.compareTo("Medium") == 0) {
			return MEDIUM + (toppings.size() * 2);

		} else if (super.size.compareTo("Large") == 0) {
			return LARGE + (toppings.size() * 2);

		} else {
			return -1;
		}
	}

	/**
	 * Overrides the toString method and adds class specific information
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString() + "\n\nTotal: $" + pizzaPrice();
	}
}
