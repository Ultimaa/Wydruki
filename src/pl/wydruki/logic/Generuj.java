package pl.wydruki.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import pl.wydruki.controller.ContentPaneController;

public class Generuj {

	public static String generuj() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime data = LocalDateTime.parse(ContentPaneController.getOdData().toString()+" "+ContentPaneController.getOdCzas().toString(), formatter);
		//DateTime dt = formatter.parse(ContentPaneController.getOdData().toString()+" "+ContentPaneController.getOdCzas().toString());
		String b = data.toString();
		return b;	
	}
}
