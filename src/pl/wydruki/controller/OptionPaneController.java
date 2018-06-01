package pl.wydruki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.wydruki.logic.NumeryRej;

public class OptionPaneController implements Initializable {

    @FXML
    private ComboBox<String> numeryRej;

    @FXML
    private Button usunZaznaczony;

    @FXML
    private TextField nowyNumer;

    @FXML
    private Button zapiszNowy;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	numeryRej.setItems(NumeryRej.numeryObservableList());
    	zapiszNowy.setOnAction(x -> zapiszNowyNumer());
    	usunZaznaczony.setOnAction(x -> usunNumer());
    }
    private void zapiszNowyNumer()
    {
    	String wartoscPola = nowyNumer.getText();
    	NumeryRej.dodajNowyNumer(wartoscPola, null, true);
    	numeryRej.setItems(NumeryRej.numeryObservableList());
    }
    private void usunNumer() 
    {
    	String wybranyNumer = numeryRej.getValue();
    	if(wybranyNumer == null)
    		numeryRej.setValue("Wybierz poprany numer!");
    	else 
    	{
    		NumeryRej.usunNumer(wybranyNumer);
    	}
    	numeryRej.setItems(NumeryRej.numeryObservableList());

    }

}
