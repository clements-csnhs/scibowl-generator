import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SortQuestionsBySubject
{
	public SortQuestionsBySubject()
	{
		
	}
	public void sort(String fn,int numberOfFiles) throws IOException
	{
		PrintWriter pwB  = new PrintWriter(new BufferedWriter(new FileWriter("Biology.txt")));
		PrintWriter pwC  = new PrintWriter(new BufferedWriter(new FileWriter("Chemistry.txt")));
		PrintWriter pwP  = new PrintWriter(new BufferedWriter(new FileWriter("Physics.txt")));
		PrintWriter pwM  = new PrintWriter(new BufferedWriter(new FileWriter("Math.txt")));
		PrintWriter pwES = new PrintWriter(new BufferedWriter(new FileWriter("EarthandSpace.txt")));
		PrintWriter pwE  = new PrintWriter(new BufferedWriter(new FileWriter("Energy.txt")));
	
		String[] topics = {"BIOLOGY", "CHEMISTRY", "PHYSICS", "MATH", "EARTH AND SPACE", "ENERGY"};
		PrintWriter[] prints = {pwB, pwC, pwP, pwM, pwES, pwE};
		
		for (int i = 1; i < numberOfFiles; i++ )
		{
			String filename = fn + i + ".txt";
			System.out.println(filename);

			Scanner in = new Scanner(new File(filename));
			in.nextLine();	in.nextLine();
			String op = "TOSS-UP\r\n";

			while(in.hasNext())
			{
				String line = in.nextLine();
				if (line.equals("TOSS-UP"))
				{
					for (int t = 0 ; t < 6; t++ ) {
						if (op.contains(topics[t]) ) {
							prints[t].println(op);
							op = "";
						}
					}	
				}
				if(!(line.contains("ROUND")||line.contains("Page ")||line.equals("")))
				op += line + "\r\n";
				
			}
		}

		for (PrintWriter pw:prints)
			pw.close();
	}
}