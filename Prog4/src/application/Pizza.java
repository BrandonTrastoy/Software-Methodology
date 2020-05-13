package application;

import java.util.ArrayList;

/**
 * The Pizza class is an abstract class that stores the style, size, and
 * toppings of a pizza. It has three child classes that will inherit its values
 * and will have a complete implementation of the pizzaPrice method.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public abstract class Pizza {

	protected String style;
	protected String size;
	protected ArrayList<String> toppings;

	/**
	 * This is a constructor
	 * 
	 * @param style    the type of pizza being ordered
	 * @param size     the size of pizza being ordered
	 * @param toppings list of toppings
	 */
	public Pizza(String style, String size, ArrayList<String> toppings) {
		this.style = style;
		this.size = size;
		this.toppings = toppings;
	}

	/**
	 * This is a constructor
	 * 
	 * @param style the type of pizza being ordered
	 * @param size  size the size of pizza being ordered
	 */
	public Pizza(String style, String size) {
		this.style = style;
		this.size = size;
		toppings = new ArrayList<String>();
	}

	/**
	 * This method returns the price of a pizza. To be implemented in child class.
	 * 
	 * @return integer price of pizza
	 */
	public abstract int pizzaPrice();

	/**
	 * This method returns a string containing the style, size and toppings of a
	 * pizza.
	 * 
	 * @return String value
	 */
	public String toString() {
		return style + " : " + size + "\n" + getToppings();
	}

	/**
	 * This method returns a string containing the toppings of a pizza
	 * 
	 * @return String toppings list
	 */
	public String getToppings() {
		String temp = "";

		for (int i = 0; i < toppings.size(); i++) {
			if (i == 0) {
				temp = toppings.get(i);
			} else {
				temp = temp + "\n" + toppings.get(i);
			}
		}
		return "Toppings:\n" + temp;
	}
}
