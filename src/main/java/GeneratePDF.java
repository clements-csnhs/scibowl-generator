import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class GeneratePDF 
{
	public GeneratePDF()
	{
		
	}
public void createPdf(String dest, Round r) throws IOException {
    PdfWriter writer = new PdfWriter(dest);
    PdfDocument pdf = new PdfDocument(writer);
    Document document = new Document(pdf);
    
    PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
    
    Paragraph header=new Paragraph("ROUND "+r.roundNumber);
    header.setFont(font);
    
    Paragraph body=new Paragraph();
    body.setFont(font);
    
    ArrayList<String> questions=new ArrayList<String>();
    	for(int i=0;i<r.BiologyQuestions.length;i++)
    	{
    		questions.add(r.BiologyQuestions[i]);
    	}
    	for(int i=0;i<r.ChemistryQuestions.length;i++)
    	{
    		questions.add(r.ChemistryQuestions[i]);
    	}
    	for(int i=0;i<r.PhysicsQuestions.length;i++)
    	{
    		questions.add(r.PhysicsQuestions[i]);
    	}
    	for(int i=0;i<r.EarthandSpaceQuestions.length;i++)
    	{
    		questions.add(r.EarthandSpaceQuestions[i]);
    	}
    	for(int i=0;i<r.EnergyQuestions.length;i++)
    	{
    		questions.add(r.EnergyQuestions[i]);
    	}
    	for(int i=0;i<r.MathQuestions.length;i++)
    	{
    		questions.add(r.MathQuestions[i]);
    	}
    for(int i=0;i<questions.size();i++)
    {
    	int remaining=questions.size()-1;
		int RQN=(int)(Math.random() * ((remaining) + 1));
		body.add(questions.get(RQN));
    }
    
    document.add(header);
    document.add(body);
 
    document.close();
	}
}