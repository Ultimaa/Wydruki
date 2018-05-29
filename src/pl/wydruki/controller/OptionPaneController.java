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
    private Button zapiszNowy;@Override
    public void initialize(URL location, ResourceBundle resources) {
    	numeryRej.setItems(NumeryRej.numeryObservableList());
    	
    	
    }

}
