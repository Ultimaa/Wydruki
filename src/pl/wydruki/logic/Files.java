package pl.wydruki.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Files {
	
	public static BufferedReader odczyt(String nazwa) throws IOException
	{
        FileReader fileReader = new FileReader(nazwa);
        BufferedReader reader = new BufferedReader(fileReader);
		try (
			fileReader; 
			reader;
				
		) {}
		catch (IOException e) {
			e.printStackTrace();
			
		}
		return reader; 

		

	}
}
