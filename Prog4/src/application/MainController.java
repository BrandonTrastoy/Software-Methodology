package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * The MainController class creates an instance of all ComboBoxes, ListViews,
 * Buttons, and TextAreas in the primaryView.fxml. It then uses those instances
 * to monitor user input from the GUI and perform actions based on the users
 * choice.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class MainController implements Initializable {

	ObservableList<String> typeOfPizza = FXCollections.observableArrayList("Build Your Own", "Deluxe", "Hawaiian");

	ObservableList<String> sizeOfPizza = FXCollections.observableArrayList("Small", "Medium", "Large");

	ObservableList<String> typeOfToppings = FXCollections.observableArrayList("Cheese", "Pepperoni", "Chicken",
			"Sausage", "Beef", "Ham", "Green Pepper", "Onion", "Mushroom", "Pineapple");

	// Keeps track of Customer order
	static ArrayList<Pizza> orderList = new ArrayList<Pizza>();

	@FXML
	private ImageView image_holder;

	@FXML
	private ComboBox<String> pizza_type;

	@FXML
	private ComboBox<String> pizza_size;

	@FXML
	private ListView<String> toppings;

	@FXML
	private ListView<String> selected_toppings;

	@FXML
	private Button add_topping;

	@FXML
	private Button remove_topping;

	@FXML
	private Button clear_topping;

	@FXML
	private TextArea display_area;

	@FXML
	private Button add_to_order;

	@FXML
	private Button show_order;

	/**
	 * On click of the add button, this method will add toppings to the
	 * selected_toppings ListView.
	 */
	@FXML
	public void add() {

		if (toppings.getSelectionModel().getSelectedItem() == null) {
			return;
		}

		if (selected_toppings.getItems().contains(toppings.getSelectionModel().getSelectedItem())) {
			return;
		}

		if (selected_toppings.getItems().size() > 5) {
			return;
		}

		display_area.setText("Topping Added");

		selected_toppings.getItems().addAll(toppings.getSelectionModel().getSelectedItem());

	}

	/**
	 * On click of the remove button, the selected topping will be removed from the
	 * selected_toppings ListView.
	 */
	@FXML
	public void remove() {

		display_area.setText("Topping Removed");

		selected_toppings.getItems().remove(selected_toppings.getSelectionModel().getSelectedItem());

	}

	/**
	 * On click of the clear button, all toppings will be removed from the
	 * selected_toppings ListView.
	 */
	@FXML
	public void clear() {

		display_area.setText("Toppings Cleared");

		selected_toppings.getItems().removeAll(selected_toppings.getItems());

	}

	/**
	 * On selection of a new Pizza Type, the image in the ImageView will change and
	 * certain features will be disabled.
	 */
	@FXML
	public void change() {
		if (pizza_type.getValue().equals("Deluxe")) {
			toppings.setDisable(true);
			add_topping.setDisable(true);
			remove_topping.setDisable(true);
			clear_topping.setDisable(true);
			selected_toppings.setItems(
					FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom"));

			Image image = new Image("application/deluxe.jpg");
			image_holder.setImage(image);

		} else if (pizza_type.getValue().equals("Hawaiian")) {
			toppings.setDisable(true);
			add_topping.setDisable(true);
			remove_topping.setDisable(true);
			clear_topping.setDisable(true);
			selected_toppings.setItems(FXCollections.observableArrayList("Pineapple", "Ham"));

			Image image = new Image("application/hawaiian.jpg");
			image_holder.setImage(image);

		} else {
			toppings.setDisable(false);
			add_topping.setDisable(false);
			remove_topping.setDisable(false);
			clear_topping.setDisable(false);
			clear();

			Image image = new Image("application/byo.jpg");
			image_holder.setImage(image);
		}
	}

	/**
	 * On click of the show order button, the stage will change to that of the
	 * secondaryView.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void changeScene(ActionEvent event) throws IOException {

		Parent second = FXMLLoader.load(getClass().getResource("secondaryView.fxml"));
		Scene scene2 = new Scene(second, 600, 400);

		Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		secondStage.setTitle("Your Order");
		secondStage.setScene(scene2);
		secondStage.show();
	}

	/**
	 * On click of the add to order button, the current selected pizza type, size,
	 * and toppings will be added to the order list.
	 */
	@FXML
	public void addTo() {

		ArrayList<String> testHolder = new ArrayList<String>();
		testHolder.addAll(selected_toppings.getItems());

		if (pizza_type.getSelectionModel().getSelectedItem().equals("Deluxe")) {
			Deluxe deluxe = new Deluxe(pizza_type.getSelectionModel().getSelectedItem(),
					pizza_size.getSelectionModel().getSelectedItem(), testHolder);
			orderList.add(deluxe);
		} else if (pizza_type.getSelectionModel().getSelectedItem().equals("Hawaiian")) {
			Hawaiian hawaiian = new Hawaiian(pizza_type.getSelectionModel().getSelectedItem(),
					pizza_size.getSelectionModel().getSelectedItem(), testHolder);
			orderList.add(hawaiian);
		} else {

			if (testHolder.size() < 1) {
				display_area.setText("Need at least one topping");
				return;
			}

			BuildYourOwn byo = new BuildYourOwn(pizza_type.getSelectionModel().getSelectedItem(),
					pizza_size.getSelectionModel().getSelectedItem(), testHolder);
			orderList.add(byo);
		}

		display_area.setText("Added To Order");
	}

	/**
	 * This initializes the scene and populates it with data when the program is
	 * run.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image("application/byo.jpg");
		image_holder.setImage(image);

		pizza_type.setValue("Build Your Own");
		pizza_type.setItems(typeOfPizza);

		pizza_size.setValue("Medium");
		pizza_size.setItems(sizeOfPizza);

		toppings.setItems(typeOfToppings);
	}
}
