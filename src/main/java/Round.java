import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.itextpdf.io.IOException;

public class Round
{
	int roundNumber;
	
	String BiologyQuestions[];
	String ChemistryQuestions[];
	String PhysicsQuestions[];
	String EarthandSpaceQuestions[];
	String EnergyQuestions[];
	String MathQuestions[];
	
	int sub[]={4,4,4,4,3,4};
	
	public Round() throws IOException, FileNotFoundException
	{
		
		randomQuestionNumbers();
		randomQuestions("Biology.txt",sub[0],BiologyQuestions);
		randomQuestions("Chemistry.txt",sub[1],ChemistryQuestions);
		randomQuestions("Physics.txt",sub[2],PhysicsQuestions);
		randomQuestions("EarthandSpace.txt",sub[3],EarthandSpaceQuestions);
		randomQuestions("Energy.txt",sub[4],EnergyQuestions);
		randomQuestions("Math.txt",sub[5],MathQuestions);
		
		roundNumber=1;
		
		
	}
	public Round(int rn) throws IOException, FileNotFoundException
	{
		
		randomQuestionNumbers();
		for(int i=0;i<sub.length;i++)
		{
			System.out.println(sub[i]);
		}
		randomQuestions("Biology.txt",sub[0],BiologyQuestions);
		randomQuestions("Chemistry.txt",sub[1],ChemistryQuestions);
		randomQuestions("Physics.txt",sub[2],PhysicsQuestions);
		randomQuestions("EarthandSpace.txt",sub[3],EarthandSpaceQuestions);
		randomQuestions("Energy.txt",sub[4],EnergyQuestions);
		randomQuestions("Math.txt",sub[5],MathQuestions);
		
		roundNumber=rn;
		
		
	}
	public void randomQuestionNumbers()
	{
		//Generate random question numbers for given ranges
		ArrayList<String> subjects=new ArrayList<String>();
		subjects.add("B");
		subjects.add("C");
		subjects.add("P");
		subjects.add("ES");
		subjects.add("E");
		subjects.add("M");
		
		//first addition
		int rng=0 + (int)(Math.random() * ((5 - 0) + 1));
		sub[rng]=sub[rng]+1;
		//second addition
		int rng1=0 + (int)(Math.random() * ((5 - 0) + 1));
		boolean added=false;
		while(!added)
		{
			if((!subjects.get(rng1).equals(subjects.get(rng)))||subjects.get(rng1).equals("M"))
			{
				sub[rng1]=sub[rng1]+1;
				added=true;
			}
		}
		
		BiologyQuestions=new String[sub[0]];
		ChemistryQuestions=new String[sub[1]];
		PhysicsQuestions=new String[sub[2]];
		EarthandSpaceQuestions=new String[sub[3]];
		EnergyQuestions=new String[sub[4]];
		MathQuestions=new String[sub[5]];
	}
	public void randomQuestions(String FileLocation, int NumberOfQuestions, String[] qtype) throws IOException, FileNotFoundException
	{
		Scanner in=new Scanner(new File(FileLocation));
		ArrayList<String> questions=new ArrayList<String>();
		String temp="";
		while(in.hasNext())
		{
			String line = in.nextLine();
			temp+=line+"\n";
			if(line.equals(""))
			{
				questions.add(temp);
				temp="";
			}
		}
		
		
		for(int i=0;i<NumberOfQuestions;i++)
		{
			int remaining=questions.size()-1;
			int RQN=(int)(Math.random() * ((remaining) + 1));
			qtype[i]=questions.remove(RQN);
		}
	}
}
