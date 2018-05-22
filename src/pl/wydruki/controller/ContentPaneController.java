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

	public TextArea getPodgladText() {
		return podgladText;
	}

	public void setPodgladText(String text) {
		podgladText.setText(text);
	}

	
	public LocalDate odData()
	{
		LocalDate data = odData.getValue();
		return data;
	}
	
	public LocalTime odCzas()
	{
		LocalTime czas = odCzas.getValue();
		return czas;
	}
	
	public LocalDate doData()
	{
		LocalDate data = doData.getValue();
		return data;
	}
	
	public LocalTime doCzas()
	{
		LocalTime czas = doCzas.getValue();
		return czas;
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
		
	}

}
	
	
