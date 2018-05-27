package pl.wydruki.logic;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
				String[] a = nextLine.split(";");
				lista.add(a[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static Map<String, String> numerySeria()
	{
		final String SCIEZKA = "rej.txt";
		String nextLine = null;
		
		Map<String, String> mapa = new HashMap<>();

		try(
				FileReader fileReader = new FileReader(SCIEZKA);
		        BufferedReader reader = new BufferedReader(fileReader);
			)
		{
			while((nextLine = reader.readLine()) != null)
			{
				String[] a = nextLine.split(";");
				mapa.put(a[0], a[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mapa;
	}
	
}
