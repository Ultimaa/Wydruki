package pl.wydruki.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Generuj {
	
	private String dataStart;
	private String dataKoniec;
	private String czasStart;
	private String czasKoniec;
	
	private int tempOd;
	private int tolerancja;
	private int czas;
	
	private String numerRej;
	
	public Generuj() {
		
	}

	public Generuj(String dataStart, String czasStart, String dataKoniec, String czasKoniec, int tempOd,
			int tolerancja, int czas, String numerRej) 
	{
		this.dataStart = dataStart;
		this.dataKoniec = dataKoniec;
		this.czasStart = czasStart;
		this.czasKoniec = czasKoniec;
		this.tempOd = tempOd;
		this.tolerancja = tolerancja;
		this.numerRej = numerRej;
		this.czas = czas;
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
		Temp temp = new Temp(tempOd, tolerancja);
		
		txt.append("N I C O \n");
		txt.append(numerRej+" "+NumeryRej.numerySeria().get(numerRej)+"\n");
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
			//txt.append(rand.nextDouble()* tempDo);
			txt.append("  ");
			txt.append(temp.generujTemp());
			txt.append("\n");
			start = start.plusMinutes(czas);
		}while(start.isBefore(koniec));
			
		 
		return txt.toString();
		
	}
	
	public TextFlow GenerujTxtFlowNag()
	{
		String dataCzasStart = dataStart+" "+czasStart;
		String dataCzasKoniec = dataKoniec+" "+czasKoniec;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter godzinyMinuty = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter dzienMiesiacRok = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
		LocalDateTime start = LocalDateTime.parse(dataCzasStart, formatter);
		LocalDateTime koniec = LocalDateTime.parse(dataCzasKoniec, formatter);
		
		LocalDateTime tmp = LocalDateTime.of
				(start.getYear(), start.getMonth(), start.getDayOfMonth(), 23, 59);
		
		StringBuilder nag = new StringBuilder();
		StringBuilder reszta = new StringBuilder();
		Temp temp = new Temp(tempOd, tolerancja);
		
		nag.append("N I C O \n");
		nag.append(numerRej+" "+NumeryRej.numerySeria().get(numerRej)+"\n");
		nag.append(start.toString()+"\n");
		nag.append("T1 SENSOR 1 \n");
		nag.append("T2 SENSOR 2 \n");
		nag.append("         T1     T2 \n");
		do {
			if(start.isAfter(tmp))
			{
				reszta.append(tmp.format(dzienMiesiacRok));
				reszta.append("\n");
				tmp = tmp.plusDays(1);
			}
			reszta.append(start.format(godzinyMinuty));
			reszta.append("    ");
			//txt.append(rand.nextDouble()* tempDo);
			reszta.append("  ");
			reszta.append(temp.generujTemp());
			reszta.append("\n");
			start = start.plusMinutes(czas);
		}while(start.isBefore(koniec));
		
		Text naglowek = new Text(nag.toString());
		Text reszta_txt = new Text(reszta.toString());
		
		naglowek.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
		reszta_txt.setFont(Font.font("Helvetica", FontWeight.LIGHT, 7));
		TextFlow ret = new TextFlow();
		ret.getChildren().addAll(naglowek, reszta_txt);
		
		return ret;
	}
}
