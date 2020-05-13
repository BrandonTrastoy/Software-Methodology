package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The Main class creates a GUI for the program.
 * 
 * @author Brandon Trastoy
 * @author Kyle VanWageninge
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent first = FXMLLoader.load(getClass().getResource("primaryView.fxml"));
			primaryStage.setTitle("COVID Pizza");
			Scene scene1 = new Scene(first, 510, 620);
			primaryStage.setScene(scene1);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
