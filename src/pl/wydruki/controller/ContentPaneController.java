package pl.wydruki.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import jfxtras.scene.control.LocalDateTimeTextField;

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
   

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public TextArea getPodgladText() {
		return podgladText;
	}

	public void setPodgladText(String text) {
		podgladText.setText(text);
	}

	public JFXDatePicker getOdData() {
		return odData;
	}

	public void setOdData(JFXDatePicker odData) {
		this.odData = odData;
	}

	public JFXTimePicker getOdCzas() {
		return odCzas;
	}

	public void setOdCzas(JFXTimePicker odCzas) {
		this.odCzas = odCzas;
	}

	public JFXDatePicker getDoData() {
		return doData;
	}

	public void setDoData(JFXDatePicker doData) {
		this.doData = doData;
	}

	public JFXTimePicker getDoCzas() {
		return doCzas;
	}
	

	public void setDoCzas(JFXTimePicker doCzas) {
		this.doCzas = doCzas;
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

}
	
	
