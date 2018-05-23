package pl.wydruki.controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ComboBox<Double> tempOd;
    @FXML
    private ComboBox<Double> tempDo;
    

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

	public ComboBox<Double> getTempOd() {
		return tempOd;
	}

	public ComboBox<Double> getTempDo() {
		return tempDo;
	}

	public TextArea getPodgladText() {
		return podgladText;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		odCzas.setIs24HourView(true);  // Naprawic wyœwietlanie 24h po wybraniu  
		doCzas.setIs24HourView(true);
		
		

		odCzas.setValue(LocalTime.now()); // formatowanie daty na HH:mm
		doCzas.setValue(LocalTime.now());
		
		odData.setValue(LocalDate.now());
		doData.setValue(LocalDate.now());
		
		

		numeryRej.setItems(NumeryRej.numeryObservableList());
		numeryRej.setValue(NumeryRej.numeryObservableList().get(0));
		
		tempOd.setItems(Temp.temperatury());
		tempDo.setItems(Temp.temperatury());
		
		tempOd.setValue(Temp.temperatury().get(54));
		tempDo.setValue(Temp.temperatury().get(54));
		
	}

}
	
	
