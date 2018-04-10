import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class CopyFiles extends ConsoleProgram {

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
				println("That file does not exist.");
			}
		}
		return rd;
	}
	
	public void run()
	{
		BufferedReader rd = openFile("Please enter file name: ");
		
		try {
			PrintWriter wr = new PrintWriter(new FileWriter("copy.txt"));
			
			while (true)
			{
				String line = rd.readLine();
				if (line == null) break;
				
				println("Copying line: [" + line + "]");
				wr.println(line);
			}
			rd.close();
			wr.close();
		}
		catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
}
