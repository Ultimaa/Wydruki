package pl.wydruki.controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import pl.wydruki.logic.NumeryRej;
import pl.wydruki.logic.Temp;

public class ContentPaneController implements Initializable {

    @FXML
    private TextArea podgladText;
    @FXML
    private JFXDatePicker odData;
    @FXML
    private JFXTimePicker odCzas;
    @FXML
    private JFXDatePicker doData;
    @FXML
    private JFXTimePicker doCzas;
    @FXML
    private ComboBox<String> numeryRej;
    @FXML
    private ComboBox<Integer> tempOd;
    @FXML
    private ComboBox<Integer> tempTolerancja;
    @FXML
    private Button refresh;
    @FXML
    private ComboBox<Integer> czas;
    

	public JFXDatePicker getOdData() {
		return odData;
	}


	public JFXTimePicker getOdCzas() {
		return odCzas;
	}

	public JFXDatePicker getDoData() {
		return doData;
	}

	public JFXTimePicker getDoCzas() {
		return doCzas;
	}

	public ComboBox<String> getNumeryRej() {
		return numeryRej;
	}

	public ComboBox<Integer> getTempOd() {
		return tempOd;
	}

	public ComboBox<Integer> tempTolerancja() {
		return tempTolerancja;
	}

	public TextArea getPodgladText() {
		return podgladText;
	}
	

	public ComboBox<Integer> getCzas() {
		return czas;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		odCzas.setIs24HourView(true);  // Naprawic wyœwietlanie 24h po wybraniu  
		doCzas.setIs24HourView(true);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime teraz = LocalTime.parse(LocalTime.now().format(formatter));
		
		odCzas.setValue(teraz); // formatowanie daty na HH:mm
		doCzas.setValue(teraz);
		
		
		odData.setValue(LocalDate.now());
		doData.setValue(LocalDate.now());
		
		ObservableList<Integer> a = FXCollections.observableArrayList();
		for(int i=15; i<=60; i+=15)
		{
			a.add(i);
		}
		czas.setItems(a);
		czas.setValue(a.get(0));
		
		numeryRej.setItems(NumeryRej.numeryObservableList());
		numeryRej.setValue(NumeryRej.numeryObservableList().get(0));
		refresh.setOnAction(x -> numeryRej.setItems(NumeryRej.numeryObservableList()));
		
		tempOd.setItems(Temp.temperatury());
		tempTolerancja.setItems(Temp.tolerancja());
		
		tempOd.setValue(Temp.temperatury().get(30));
		tempTolerancja.setValue(Temp.tolerancja().get(1));
		
	}


}
	
	
