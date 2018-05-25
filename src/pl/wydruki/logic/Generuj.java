package pl.wydruki.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
		DateTimeFormatter godzinyMinuty = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter dzienMiesiacRok = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
		LocalDateTime start = LocalDateTime.parse(dataCzasStart, formatter);
		LocalDateTime koniec = LocalDateTime.parse(dataCzasKoniec, formatter);
		
		LocalDateTime tmp = LocalDateTime.of
				(start.getYear(), start.getMonth(), start.getDayOfMonth(), 23, 59);
		
		StringBuilder txt = new StringBuilder();
		
		txt.append("N I C O \n");
		txt.append(numerRej+"  SNR 2313213 \n");
		txt.append(start.toString()+"\n");
		txt.append("T1 SENSOR 1 \n");
		txt.append("T2 SENSOR 2 \n");
		txt.append("         T1     T2 \n");

		do {
			if(start.isAfter(tmp))
			{
				txt.append(tmp.format(dzienMiesiacRok));
				txt.append("\n");
				tmp = tmp.plusDays(1);
			}
			txt.append(start.format(godzinyMinuty));
			txt.append("    ");
			txt.append(tempOd.toString());
			txt.append("  ");
			txt.append(tempDo.toString());
			txt.append("    ");
			txt.append("\n");
			start = start.plusMinutes(15);
		}while(start.isBefore(koniec));
			
		 
		return txt.toString();
		
	}
}
