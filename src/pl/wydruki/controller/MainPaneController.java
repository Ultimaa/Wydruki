package pl.wydruki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pl.wydruki.logic.Generuj;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


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
		controlPaneController.getDrukuj().setOnAction(
				x ->{
					TextFlow printArea = new TextFlow(new Text(contentPaneController.getPodgladText().toString()));
					printSetup(contentPaneController.getPodgladText(), printArea);
				} 
				);
	
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
	
	private void printSetup(Node node, TextFlow a) 
	{
		// Create the PrinterJob		
		PrinterJob job = PrinterJob.createPrinterJob();
	
		if (job == null) 
		{
			return;
		}

		// Show the print setup dialog
		boolean proceed = job.showPrintDialog(node.getScene().getWindow());
		
		if (proceed) 
		{
			print(job, a);
		}
	}
	
	private void print(PrinterJob job, Node node) 
	{
		// Set the Job Status Message
		
		// Print the node
		boolean printed = job.printPage(node);
	
		if (printed) 
		{
			job.endJob();
		}
	}		
}
