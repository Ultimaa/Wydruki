package pl.wydruki.logic;

import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.text.TextFlow;

public class Drukuj {
	
	
	public static void printSetup(Node node, TextFlow a) 
	{
		// Create the PrinterJob		
		PrinterJob job = PrinterJob.createPrinterJob();
		
		// Ustawienie parametrów druku
		Printer b = Printer.getDefaultPrinter();
		PageLayout ustawieniaStrony = b.createPageLayout(Paper.EXECUTIVE, PageOrientation.PORTRAIT, 0.01, 0.01, 0.01, 0.01);
		job.getJobSettings().setPageLayout(ustawieniaStrony);
		// ---------   ----------------
		
		if (job == null) 
		{
			return;
		}

		// Show the print setup dialog
		boolean proceed = job.showPrintDialog(node.getScene().getWindow());
		
		if (proceed) 
		{
			print(job, a);
		}
	}
	
	private static void print(PrinterJob job, Node node) 
	{
		// Set the Job Status Message
		
		// Print the node
		boolean printed = job.printPage(node);
	
		if (printed) 
		{
			job.endJob();
		}
	}
	
}
