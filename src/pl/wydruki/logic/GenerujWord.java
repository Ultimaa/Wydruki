package pl.wydruki.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

public class GenerujWord {

	public static void generateWordDoc() throws IOException
	{
		XWPFDocument document = new XWPFDocument(); 
		FileOutputStream out = new FileOutputStream( new File("createdocument.docx"));

		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		
		
		
	      //Set Bold an Italic
	      XWPFRun paragraphOneRunOne = paragraph.createRun();
	      paragraphOneRunOne.setBold(true);
	      paragraphOneRunOne.setItalic(true);
	      paragraphOneRunOne.setText("Font Style");
	      paragraphOneRunOne.addBreak();
	        
	      //Set text Position
	      XWPFRun paragraphOneRunTwo = paragraph.createRun();
	      paragraphOneRunTwo.setText("Font Style two");
	      paragraphOneRunTwo.setTextPosition(100);
	 
	      //Set Strike through and Font Size and Subscript
	      XWPFRun paragraphOneRunThree = paragraph.createRun();
	      paragraphOneRunThree.setStrike(true);
	      paragraphOneRunThree.setFontSize(20);
	      paragraphOneRunThree.setSubscript(VerticalAlign.SUBSCRIPT);
	      paragraphOneRunThree.setText(" Different Font Styles");
	        
		
		run.setText("At tutorialspoint.com, we strive hard to " +
		         "provide quality tutorials for self-learning " +
		         "purpose in the domains of Academics, Information " +
		         "Technology, Management and Computer Programming Languages. \n");
		
		run.setText("At tutorialspoint.com, we strive hard to " +
		         "provide quality tutorials for self-learning " +
		         "purpose in the domains of Academics, Information " +
		         "Technology, Management and Computer Programming Languages.");
	    document.write(out);
	    out.close();
	    System.out.println("createdocument.docx written successully");
	}
}
