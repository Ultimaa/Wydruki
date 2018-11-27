package pl.wydruki.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Generuj {

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
		DateTimeFormatter godzinyMinuty = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter dzienMiesiacRok = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
		LocalDateTime start = LocalDateTime.parse(dataCzasStart, formatter);
		LocalDateTime koniec = LocalDateTime.parse(dataCzasKoniec, formatter);
		
		LocalDateTime tmp = LocalDateTime.of
				(start.getYear(), start.getMonth(), start.getDayOfMonth(), 23, 59);
		
		StringBuilder nag = new StringBuilder();
		StringBuilder reszta = new StringBuilder();
		Temp temp = new Temp(tempOd, tolerancja);
		
		nag.append("A b c d e f \n");
		nag.append("N I C O \n");
		nag.append(numerRej+" "+NumeryRej.numerySeria().get(numerRej)+"\n");
		nag.append(start.toString()+"\n");
		nag.append("T1 Sensor 1 \n");
		nag.append("T2 SENSOR 2 \n");
		reszta.append("          T1     T2 \n");
		do {
			if(start.isAfter(tmp))
			{
				reszta.append(tmp.format(dzienMiesiacRok));
				reszta.append("\n");
				tmp = tmp.plusDays(1);
			}
			reszta.append(start.format(godzinyMinuty));
			reszta.append("   ");
			//txt.append(rand.nextDouble()* tempDo);
			reszta.append("  ");
			reszta.append(temp.generujTemp());
			reszta.append("   ");
			reszta.append(temp.generujTemp());
			reszta.append("\n");
			start = start.plusMinutes(czas);
		}while(start.isBefore(koniec));
		
		Text naglowek = new Text(nag.toString());
		Text reszta_txt = new Text(reszta.toString());
		this.naglowek = naglowek;
		this.reszta_txt = reszta_txt;
		
		nag.append(reszta.toString());
		generuj = nag.toString();
	}

	public TextFlow wydruk()
	{
		naglowek.setFont(Font.font("Calibri Light", FontWeight.BLACK, 10));
		reszta_txt.setFont(Font.font("Calibri Light", FontWeight.EXTRA_LIGHT, 7));
		TextFlow wydruk = new TextFlow();
		wydruk.getChildren().addAll(naglowek, reszta_txt);
		return wydruk;
	}
	
	public String generuj1()
	{
		return generuj;
	}
}
