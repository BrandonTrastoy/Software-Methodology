package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * The MainController class creates an instance of all TextFields, Buttons,
 * RadioButtons, CheckBoxes and TextAreas. It then uses those instances to
 * monitor user input from the GUI and perform actions based on the users
 * choice.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class MainController {

	// Create student list
	StudentList cs213 = new StudentList();

	@FXML
	private TextField fname;

	@FXML
	private TextField lname;

	@FXML
	private TextField credit;

	@FXML
	private Button add;

	@FXML
	private Button remove;

	@FXML
	private Button print;

	@FXML
	private RadioButton instate;

	@FXML
	private RadioButton outstate;

	@FXML
	private RadioButton international;

	@FXML
	private CheckBox funding;

	@FXML
	private CheckBox tristate;

	@FXML
	private CheckBox exchange;

	@FXML
	private TextField funding_text;

	@FXML
	private TextArea display_area;

	/**
	 * This method checks what radio button is active and disables any features not
	 * needed for what is currently selected.
	 */
	@FXML
	public void unclickable() {
		if (instate.isSelected() == true) {
			funding.setDisable(false);
			tristate.setDisable(true);
			exchange.setDisable(true);
			tristate.setSelected(false);
			exchange.setSelected(false);
		} else if (outstate.isSelected() == true) {
			funding.setDisable(true);
			funding_text.setDisable(true);
			funding_text.setText("");
			tristate.setDisable(false);
			exchange.setDisable(true);
			funding.setSelected(false);
			exchange.setSelected(false);
		} else {
			funding.setDisable(true);
			funding_text.setDisable(true);
			funding_text.setText("");
			tristate.setDisable(true);
			exchange.setDisable(false);
			funding.setSelected(false);
			tristate.setSelected(false);
		}
	}

	/**
	 * This method enables the funding text area if the following checkbox is
	 * selected. Otherwise it is disabled.
	 */
	@FXML
	public void disableFunds() {

		if (funding.isSelected()) {
			funding_text.setDisable(false);
		} else {
			funding_text.setDisable(true);
			funding_text.setText("");
		}
	}

	/**
	 * This method is called when the add button is pushed. Adds a student to the
	 * list and outputs to the display area.
	 */
	@FXML
	public void addStudent() {
		int funds = 0;
		int tempCredit = 0;

		if (errorMessageHandling()) {
			return;
		}

		if (credit.getText().equals("")) {
			display_area.setText(String.valueOf("Error: Credits Empty \nEnter a value for credit!"));
			return;
		}

		if (credit.getText().matches("[0-9]+")) {
			tempCredit = Integer.parseInt(credit.getText());

			if (tempCredit == 0) {
				display_area.setText(String.valueOf("Error: Credits must be greater than 0!"));
				return;
			}
		} else {
			display_area.setText(
					String.valueOf("Error: Invalid sequence for 'credit' entered. \nEnter an interger value!"));
			return;
		}

		if (instate.isSelected()) {

			if (funding.isSelected()) {

				if (tempCredit < 12) {
					display_area.setText(String.valueOf("Part time students are NOT eligible for funding.\n"
							+ "Please de-select the funding checkbox to continue!"));
					return;
				}

				if (funding_text.getText().matches("[0-9]+")) {
					funds = Integer.parseInt(funding_text.getText());

				} else {
					display_area.setText(
							String.valueOf("Error: Invalid sequence for 'funds' entered. \nEnter an interger value!"));
					return;
				}
			}

			Instate newStudent = new Instate(fname.getText(), lname.getText(), tempCredit, funds);
			cs213.addForGUI(display_area, newStudent);

		} else if (outstate.isSelected()) {

			Outstate newStudent = new Outstate(fname.getText(), lname.getText(), tempCredit, tristate.isSelected());
			cs213.addForGUI(display_area, newStudent);

		} else if (international.isSelected()) {

			if (tempCredit < 9) {
				display_area.setText(
						String.valueOf("Error: All International students must been enrolled for 9 or more credits!"));
				return;
			}

			International newStudent = new International(fname.getText(), lname.getText(), tempCredit,
					exchange.isSelected());
			cs213.addForGUI(display_area, newStudent);

		} else {
			display_area.setText(String.valueOf("Error: Please Select a Student Type!"));
			return;
		}
	}

	/**
	 * This method is called when the remove button is pushed. Removes a student
	 * from the list and outputs to the display area.
	 */
	@FXML
	public void removeStudent() {

		if (errorMessageHandling()) {
			return;
		}

		credit.setText("");

		// Does not matter what type of student for removal, only need first and last
		// name.
		Instate studentToRemove = new Instate(fname.getText(), lname.getText(), 0, 0);
		cs213.removeForGUI(display_area, studentToRemove);

	}

	/**
	 * This method is called when the print button is pushed. Displays all students
	 * to the display area.
	 */
	@FXML
	public void printStudents() {

		cs213.printToGUI(display_area);

	}

	/**
	 * This method validates the fname and lname TextFields
	 * 
	 * @return true if fname and lname empty, else false
	 */
	public boolean errorMessageHandling() {

		if (fname.getText().equals("")) {
			display_area.setText(String.valueOf("Error: Enter a first name!"));
			return true;
		}

		if (lname.getText().equals("")) {
			display_area.setText(String.valueOf("Error: Enter a last name!"));
			return true;
		}

		return false;
	}
}
