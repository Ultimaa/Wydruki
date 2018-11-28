package pl.wydruki.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NumeryRej {
	final static String SCIEZKA = "rej.txt";
	
	//Lista na potrzeby ComboBoxow
	public static ObservableList<String> numeryObservableList()
	{
		String nextLine = null;
		boolean empty = true;
		ObservableList<String> lista =
				FXCollections.observableArrayList();
		
		File file = new File(SCIEZKA);
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try(
				FileReader fileReader = new FileReader(SCIEZKA);
		        BufferedReader reader = new BufferedReader(fileReader);
			)
		{
				while((nextLine = reader.readLine()) != null)
				{
					String[] a = nextLine.split(";");
					lista.add(a[0]);
					empty = false;
				}
				if(empty)
				{
					dodajNowyNumer("Dodaj jakieœ numery :)", " ", false);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(lista);
		return lista;
	}
	
	//Mapa Stringów zawierajaca przypisany SN do danego numeru rej.
	public static Map<String, String> numerySeria()
	{
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
	
	//Metoda do zapisu nowych numerow do pliku
	public static void dodajNowyNumer(String number, String snNumber, boolean newLine) {
		
		if(snNumber == null)
		{
			Random rand = new Random();
			snNumber = "SN"+rand.nextInt(9999999);
		}
		try(
				FileWriter fileWriter = new FileWriter(SCIEZKA, true);
				BufferedWriter writer = new BufferedWriter(fileWriter);
			)
		{
			if(newLine)
			writer.newLine();
			
			writer.write(number);
			writer.write(";");
			
			writer.write(snNumber);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void wyczyscPlik()
	{
		try(
				FileWriter fileWriter = new FileWriter(SCIEZKA);
				BufferedWriter writer = new BufferedWriter(fileWriter);
			)
		{
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void usunNumer(String numer) {
		Map<String, String> tmp = numerySeria();
		tmp.remove(numer);
		
		Collection<String> a = tmp.values();
		Set<String> b = tmp.keySet();
		
		Iterator<String> i = a.iterator();
		Iterator<String> j = b.iterator();

		wyczyscPlik();
		if(i.hasNext() && j.hasNext()){
		dodajNowyNumer(j.next(), i.next(), false);
			while(i.hasNext() && j.hasNext())
			{
				dodajNowyNumer(j.next(), i.next(), true);
			}
		}
	}
	
}
