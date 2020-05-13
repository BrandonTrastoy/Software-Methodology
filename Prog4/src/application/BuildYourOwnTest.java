package application;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * The BuildYourOwnTest class creates a JUnit test for the BuildYourOwn class.
 * It tests the validity of the pizzaPrice method.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class BuildYourOwnTest {

	/**
	 * Test method
	 */
	@Test
	public void testPizzaPrice() {

		ArrayList<String> toppings = new ArrayList<String>();
		toppings.add("Cheese");
		toppings.add("Pepperoni");
		BuildYourOwn test = new BuildYourOwn("Build Your Own", "Medium", toppings);

		int testValue = test.pizzaPrice();

		assertEquals(11, testValue);

		toppings.add("Ham");
		testValue = test.pizzaPrice();
		assertEquals(13, testValue);

		toppings.clear();

		toppings.add("Cheese");
		toppings.add("Bacon");
		toppings.add("Mushroom");
		BuildYourOwn test2 = new BuildYourOwn("Build Your Own", "Small", toppings);

		testValue = test2.pizzaPrice();

		assertEquals(11, testValue);

		toppings.remove(0);
		testValue = test2.pizzaPrice();

		assertEquals(9, testValue);

		BuildYourOwn test3 = new BuildYourOwn("Build Your Own", "Large", toppings);

		toppings.clear();
		toppings.add("Cheese");
		toppings.add("Bacon");

		testValue = test3.pizzaPrice();

		assertEquals(13, testValue);

		toppings.add("Ham");
		testValue = test3.pizzaPrice();

		assertEquals(15, testValue);

	}

}
