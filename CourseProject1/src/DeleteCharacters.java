import acm.program.*;

public class DeleteCharacters extends ConsoleProgram {
	
	public void run() 
	{
		String str1 = "this is a test.";
		String result = removeAllOccurrences(str1, 't');
		println(result);
	}
	
	public String removeAllOccurrences(String str, char ch) 
	{
		String result = "";
		
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) != ch)
				result += str.charAt(i);
		}
		
		return result;
	}
	
}
