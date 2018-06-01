package pl.wydruki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pl.wydruki.main.Main;

public class AboutMePaneController implements Initializable {

    @FXML
    private Button closeButton;

	@FXML
    private Label version;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		version.setText(Main.VERSION);
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				 Stage stage = (Stage) closeButton.getScene().getWindow();
				 stage.close();
				
			}
		});
	}

}
