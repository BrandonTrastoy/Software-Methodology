package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * The SecondaryController class creates an instance of all Buttons, and
 * TextAreas in the secondaryView.fxml. It then uses those instances to monitor
 * user input from the GUI and perform actions based on the users choice.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class SecondaryController implements Initializable {

	@FXML
	private TextArea display_order;

	@FXML
	private Button back;

	@FXML
	private Button clear;

	/**
	 * This method handles the "Go Back" button and on click changes the scene back
	 * to the primaryView.fxml
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void goBack(ActionEvent event) throws IOException {

		Parent first = FXMLLoader.load(getClass().getResource("primaryView.fxml"));
		Scene scene1 = new Scene(first, 510, 620);
		Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		secondStage.setTitle("COVID Pizza");
		secondStage.setScene(scene1);
		secondStage.show();
	}

	/**
	 * This method handles the "Clear" button and on click clears the orderlist
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void clear(ActionEvent event) throws IOException {

		MainController.orderList.clear();
		display_order.setText("Order Cleared");
	}

	/**
	 * This method initializes the scene and populates the text area with the users
	 * order.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (MainController.orderList.isEmpty()) {
			display_order.setText("Order Empty");
		} else {

			int total = 0;

			for (int i = 0; i < MainController.orderList.size(); i++) {
				total = total + MainController.orderList.get(i).pizzaPrice();
			}

			for (int i = 0; i < MainController.orderList.size(); i++) {

				if (i == 0) {
					display_order.setText(MainController.orderList.get(i).toString());
				} else {
					display_order
							.setText(display_order.getText() + "\n\n" + MainController.orderList.get(i).toString());
				}
			}

			display_order.setText(display_order.getText() + "\n\nSubTotal: $" + total);
		}
	}

}
