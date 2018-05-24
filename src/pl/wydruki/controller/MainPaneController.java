package pl.wydruki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pl.wydruki.logic.Generuj;

public class MainPaneController implements Initializable {
	
	@FXML
	private ContentPaneController contentPaneController;
	
	@FXML
	private ControlPaneController controlPaneController;
	
	@FXML
	private MenuPaneController menuPaneController;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		generujButton();
		
	}

	public void generujButton()
	{
		controlPaneController.getGenerujButton().setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String dataS = contentPaneController.getOdData().getValue().toString();
				String czasS = contentPaneController.getOdCzas().getValue().toString();
				
				String dataK = contentPaneController.getOdData().getValue().toString();
				String czasK = contentPaneController.getOdCzas().getValue().toString();
				
				double tempS = contentPaneController.getTempOd().getValue();
				double tempK = contentPaneController.getTempDo().getValue();
				
				String numerR = contentPaneController.getNumeryRej().getValue();
				
				Generuj a = new Generuj(dataS, czasS, dataK, czasK, tempS, tempK, numerR);
				contentPaneController.getPodgladText().setText(a.generuj());
				
			}
		});	
	}
}
