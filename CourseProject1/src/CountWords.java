import acm.program.*;
import java.io.*; 

public class CountWords extends ConsoleProgram {

	public void run()
	{
		int lines = 0;
		int words = 0;
		int chars = 0;
		BufferedReader rd = openFile("File: ");
		
		try {
			while (true)
			{
				String line = rd.readLine();
				if (line == null) break;
				
				lines++;
				words += CountWords(line);
				chars += line.length();
			}
		}
		catch (IOException ex) {
			println("An error has occured.");
		}
		
		println("Lines: " + lines);
		println("Words: " + words);
		println("Characters: " + chars);
	}
	
	public BufferedReader openFile(String prompt)
	{
		BufferedReader rd = null;
		
		while (rd == null)
		{
			try {
				String fileName = readLine(prompt);
				rd = new BufferedReader(new FileReader(fileName));
			} 
			catch(IOException ex) {
				println("File does not exist.");
			}
		}
		return rd;
	}
	
	public int CountWords(String line)
	{
		boolean inWord = false;
		int words = 0;
		
		for (int i=0; i < line.length(); i++)
		{
			char ch = line.charAt(i);
			
			if (Character.isLetterOrDigit(ch) == true) {
				inWord = true;
			}
			else {
				if (inWord == true) words++;
				inWord = false;
			}
		}
		if (inWord == true) words++;
		
		return words;
	}
	
}
