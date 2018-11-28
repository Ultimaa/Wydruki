package pl.wydruki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControlPaneController implements Initializable {

    @FXML
    private Button generujButton;

    @FXML
    private Button wyczyscButton;
    
    @FXML
    private Button drukuj;

	public Button getDrukuj() {
		return drukuj;
	}

	public void setDrukuj(Button drukuj) {
		this.drukuj = drukuj;
	}

	public Button getGenerujButton() {
		return generujButton;
	}

	public void setGenerujButton(Button generujButton) {
		this.generujButton = generujButton;
	}

	public Button getWyczyscButton() {
		return wyczyscButton;
	}

	public void setWyczyscButton(Button wyczyscButton) {
		this.wyczyscButton = wyczyscButton;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
