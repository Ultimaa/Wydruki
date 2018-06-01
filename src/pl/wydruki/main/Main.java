package pl.wydruki.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public final static String VERSION = "0.7";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

				
		try {
			Parent parent = (Parent)FXMLLoader.load(getClass().getResource(
					"/pl/wydruki/view/MainPane.fxml"));
			Scene scene = new Scene(parent);
			stage.setTitle("Aplikacja \"Wydruki\" wersja : "+VERSION);
			stage.setScene(scene);
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
