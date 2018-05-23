package pl.wydruki.logic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Temp {
	public static ObservableList<Double> temperatury(){
		ObservableList<Double> lista = 
				FXCollections.observableArrayList();
		
		for(double i = -25; i <= 25; i+= 0.5)
		{
			lista.add(i);
		}
		
		return lista;
		
	}

	
	
}
