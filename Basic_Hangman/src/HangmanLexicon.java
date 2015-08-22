import java.util.Random;
import java.util.Scanner;

public class HangmanLexicon 
{

	public static String PWord;
	public static char[] PArray;
	
	/** Returns the word at the specified index. */
	public static String getWord(int index) 
	{
		switch (index) 
		{
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: return ""; //add exception
		}
	};
	
	public static void DisplayWord()
	{
		//prints the word
		int Length = PWord.length();
		for(int i=0;i<Length;i++)
		{			
			System.out.print(PArray[i]);
		}
		System.out.println("");
	}

	public static void FindOccurrence(String Check_Letter)
	{
		Check_Letter = Check_Letter.toUpperCase();
		//Find if the user input is a part of the word
		
		for (int index = PWord.indexOf(Check_Letter);index >= 0;index = PWord.indexOf(Check_Letter, index + 1))
		{

			PArray[index]=Check_Letter.charAt(0);				
		}
	}
	
	public static void UserPrompt()
	{
		//get the letter from the user
		
		Scanner sc =new Scanner(System.in);
		
		for(int i=0;i< 8;i++)
		{
			if(new String(PArray).contains("-"))
			{
				String Check_Letter;
				System.out.println("Enter a single letter");
				Check_Letter = sc.next();
				if(Check_Letter.length()>1)
				{
					//TODO: handle the exception
				}
				
				FindOccurrence(Check_Letter);
				
				DisplayWord();
			}
			else
			{
				break;
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		
		Random r = new Random();
		int index=r.nextInt((10));
		
		PWord = getWord(index);
		PArray=new char[PWord.length()];
		for(int i=0;i < PWord.length();i++)
		{
			PArray[i] = '-';
		}
		
		DisplayWord();
		
		UserPrompt();
		
		System.exit(0);
	}

}