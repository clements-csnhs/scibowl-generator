import java.io.File;
import java.io.IOException;

public class Mainframe
{
	
	
	public static void main(String args[]) throws IOException
	{
		SortQuestionsBySubject SQBS=new SortQuestionsBySubject();
		SQBS.sort("Sample6_ROUND",16);
		
		for(int i=1;i<16;i++)
		{
		Round round=new Round(i);
			
		String DEST = "Rounds/round";
		DEST+=i;
		DEST+=".pdf";
		
		File file = new File(DEST);
        file.getParentFile().mkdirs();
        
        GeneratePDF generate=new GeneratePDF();
        generate.createPdf(DEST, round);
        System.out.println("Generated ROUND "+i);
		}
        
	}
}