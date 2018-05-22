package pl.wydruki.logic;

import java.io.BufferedReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NumeryRej {

	public static ObservableList<String> numeryObservableList()
	{
		
		String nextLine = null;
		
		ObservableList<String> lista =
				FXCollections.observableArrayList();
		try {
			BufferedReader plik = Files.odczyt("rej.txt");
			while((nextLine = plik.readLine()) != null)
			{
				System.out.println(nextLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("tutaj");
		}
		
		lista.add("vvv");
		return lista;
	}
	
}
