package pl.wydruki.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pl.wydruki.logic.Generuj;
import pl.wydruki.logic.GenerujWord;


public class MainPaneController implements Initializable  {
	
	@FXML
	private ContentPaneController contentPaneController;
	
	@FXML
	private ControlPaneController controlPaneController;
	
	@FXML
	private MenuPaneController menuPaneController;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		generujButton();
		//Wyczysc
		controlPaneController.getWyczyscButton().setOnAction(
				x -> contentPaneController.getPodgladText().setText(""));
		controlPaneController.getGenerujPDF().setOnAction(x -> {
			try {
				GenerujWord.generateWordDoc();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	
	}

	public void generujButton()
	{
		controlPaneController.getGenerujButton().setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String dataS = contentPaneController.getOdData().getValue().toString();
				String czasS = contentPaneController.getOdCzas().getValue().toString();
				
				String dataK = contentPaneController.getDoData().getValue().toString();
				String czasK = contentPaneController.getDoCzas().getValue().toString();
				
				int tempS = contentPaneController.getTempOd().getValue();
				int tempTolerancja = contentPaneController.tempTolerancja().getValue();
				int czas = contentPaneController.getCzas().getValue();
				String numerR = contentPaneController.getNumeryRej().getValue();
				
				Generuj a = new Generuj(dataS, czasS, dataK, czasK, tempS, tempTolerancja, czas, numerR);
				contentPaneController.getPodgladText().setText(a.generuj());
				
			}
		});	
	}
}
