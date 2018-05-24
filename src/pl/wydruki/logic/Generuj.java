package pl.wydruki.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import pl.wydruki.controller.ContentPaneController;

public class Generuj {
	
	private String dataStart;
	private String dataKoniec;
	private String czasStart;
	private String czasKoniec;
	
	private Double tempOd;
	private Double tempDo;
	
	private String numerRej;
	
	public Generuj() {
		
	}

	public Generuj(String dataStart, String czasStart, String dataKoniec, String czasKoniec, Double tempOd,
			Double tempDo, String numerRej) 
	{
		this.dataStart = dataStart;
		this.dataKoniec = dataKoniec;
		this.czasStart = czasStart;
		this.czasKoniec = czasKoniec;
		this.tempOd = tempOd;
		this.tempDo = tempDo;
		this.numerRej = numerRej;
	}



	public String generuj() {
		String dataCzasStart = dataStart+" "+czasStart;
		String dataCzasKoniec = dataKoniec+" "+czasKoniec;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime start = LocalDateTime.parse(dataCzasStart, formatter);
		LocalDateTime koniec = LocalDateTime.parse(dataCzasKoniec, formatter);
		
		
		StringBuilder txt = new StringBuilder();
		
		for(int i = 0; i <= 100; i++)
		{
			start = start.plusMinutes(120);
			txt.append(start.toString());
			txt.append(numerRej);
			txt.append("\n");
		}
		do {
			
		}while(true);
			
		 
		return txt.toString();
		
	}
}
