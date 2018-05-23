package pl.wydruki.logic;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NumeryRej {

	public static ObservableList<String> numeryObservableList()
	{
		final String SCIEZKA = "rej.txt";
		String nextLine = null;
		
		ObservableList<String> lista =
				FXCollections.observableArrayList();

		try(
				FileReader fileReader = new FileReader(SCIEZKA);
		        BufferedReader reader = new BufferedReader(fileReader);
			)
		{
			while((nextLine = reader.readLine()) != null)
			{
				lista.add(nextLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("tutaj");
		}
		
		return lista;
	}
	
}
