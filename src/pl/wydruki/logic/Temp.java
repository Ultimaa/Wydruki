package pl.wydruki.logic;

import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Temp {
	private int temp1;
	private int tolerancja;
	
	public Temp(int temp1, int tolerancja) {
		super();
		this.temp1 = temp1;
		this.tolerancja = tolerancja;
	}

	public String generujTemp() 
	{
		Random rand = new Random();
		String txt="";
		
		if(tolerancja == 0)
		{
			int liczba = temp1;
			int liczba2 = rand.nextInt(5);
			txt = ""+liczba+"."+liczba2;
		}
		else
		{
			int liczba = rand.nextInt(tolerancja)+temp1;
			int liczba2 = rand.nextInt(9);
			txt = ""+liczba+"."+liczba2;
		}  

		return txt;	
	}
	
	
	
	public static ObservableList<Integer> temperatury(){
		ObservableList<Integer> lista = 
				FXCollections.observableArrayList();
		
		for(int i = -25; i <= 25; i++)
		{
			lista.add(i);
		}
		
		return lista;
		
	}
	
	public static ObservableList<Integer> tolerancja(){
		ObservableList<Integer> lista = 
				FXCollections.observableArrayList();
		
		for(int i = 0; i <= 6; i++)
		{
			lista.add(i);
		}
		
		return lista;
		
	}

	
	
}
