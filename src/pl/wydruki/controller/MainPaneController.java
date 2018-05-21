package pl.wydruki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainPaneController implements Initializable {
	
	@FXML
	private ContentPaneController contentPaneController;
	
	@FXML
	private ControlPaneController controlPaneController;
	
	@FXML
	private MenuPaneController menuPaneController;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controlPaneController.getGenerujButton().setOnAction(x -> contentPaneController.setPodgladText(contentPaneController.doData().toString()+" "
				+contentPaneController.doCzas().toString()+" "
				+contentPaneController.odData().toString()+" "
				+contentPaneController.odCzas().toString()));
		controlPaneController.getWyczyscButton().setOnAction(x -> contentPaneController.setPodgladText(""));
}}
