package pl.wydruki.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class Generuj {
	private Text firma = new Text();
	private Text naglowek = new Text();
	private Text reszta_txt = new Text();
	
	private String generuj = new String();
	public Generuj() {
		
	}

	public Generuj(String dataStart, String czasStart, String dataKoniec, String czasKoniec, int tempOd,
			int tolerancja, int czas, String numerRej) 
	{
		String dataCzasStart = dataStart+" "+czasStart;
		String dataCzasKoniec = dataKoniec+" "+czasKoniec;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter dayOfWeek = DateTimeFormatter.ofPattern("EEEE");
		DateTimeFormatter godzinyMinuty = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter dzienMiesiacRok = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		LocalDateTime start = LocalDateTime.parse(dataCzasStart, formatter);
		LocalDateTime start_2 = LocalDateTime.parse(dataCzasStart, formatter);
		LocalDateTime koniec = LocalDateTime.parse(dataCzasKoniec, formatter);
		
		LocalDateTime tmp = LocalDateTime.of
				(start.getYear(), start.getMonth(), start.getDayOfMonth(), 23, 59);
		
		StringBuilder nag = new StringBuilder();
		StringBuilder reszta = new StringBuilder();
		StringBuilder firma = new StringBuilder();

		Temp temp = new Temp(tempOd, tolerancja);
		
		firma.append("NICO \n");
		nag.append(numerRej+" "+NumeryRej.numerySeria().get(numerRej)+"\n");
		nag.append(start.format(dayOfWeek).toUpperCase()+" "+start.format(dzienMiesiacRok)+" "+start.format(godzinyMinuty)+"\n");
		nag.append("Interwal (min): "+ czas +"min. \n");
		nag.append("T1 Sensor 1 \n");
		nag.append("T2 Tyl \n \n");
		reszta.append("do: "+koniec.format(dayOfWeek)+" "+koniec.format(dzienMiesiacRok)+" "+koniec.format(godzinyMinuty)+"\n");
		reszta.append("           T1     T2 \n");
		reszta.append("           °C     °C \n");
		do {
			if(start.isAfter(tmp))
			{
				reszta.append(tmp.format(dzienMiesiacRok));
				reszta.append("\n");
				tmp = tmp.plusDays(1);
			}
			reszta.append(start.format(godzinyMinuty));
			reszta.append("   ");
			reszta.append(temp.generujTemp());
			reszta.append("   ");
			reszta.append(temp.generujTemp());
			reszta.append("\n");
			start = start.plusMinutes(czas);
		}while(start.isBefore(koniec));
		reszta.append("od: "+start_2.format(dayOfWeek)+" "+start_2.format(dzienMiesiacRok)+" "+start_2.format(godzinyMinuty)+"\n");
		reszta.append("\n \n ..................................... \n");
		reszta.append("Podpis: ");
		
		Text firma_a = new Text(firma.toString());
		Text naglowek = new Text(nag.toString());
		Text reszta_txt = new Text(reszta.toString());
		this.firma = firma_a;
		this.naglowek = naglowek;
		this.reszta_txt = reszta_txt;
		firma.append(nag.toString());
		firma.append(reszta.toString());
		generuj = firma.toString();
	}

	public TextFlow wydruk()
	{
		firma.setFont(Font.font("Consolas", FontWeight.BOLD, 13));
		naglowek.setFont(Font.font("Consolas", FontWeight.NORMAL, 9));
		reszta_txt.setFont(Font.font("Consolas", FontWeight.NORMAL, 6.5));
		TextFlow wydruk = new TextFlow();
		wydruk.getChildren().addAll(firma, naglowek, reszta_txt);
		return wydruk;
	}
	
	public String generuj1()
	{
		return generuj;
	}
}
