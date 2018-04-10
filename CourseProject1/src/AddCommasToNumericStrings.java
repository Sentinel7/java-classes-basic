import acm.program.*;

public class AddCommasToNumericStrings extends ConsoleProgram {

	private String addCommas(String digits) 
	{
		String addComma = "";
		
		int numLength = digits.length();
		int numOfDigits = 0;
		
		for (int i = numLength - 1; i >= 0; i--)
		{
			addComma = digits.charAt(i) + addComma;
			numOfDigits++;
			
			if (((numOfDigits % 3) == 0) && i>0)
				addComma = "," + addComma;
		}
		
		return addComma;	
	}

	
	private String addCommas2(String digits) 
	{
		String addComma = "";
		
		int numLength = digits.length();
		int three = 0;
		
		for (int i = numLength - 1; i >= 0; i--)
		{
			addComma = digits.charAt(i) + addComma;
			three++;
			
			if(three == 3 && i>0) {
				addComma = "," + addComma;
				three = 0;
			}					
		}
		
		return addComma;	
	}
	
	public void run()
	{
		while (true) 
		{
			 String numString = readLine("Enter a numeric value: ");
			 
			 println(addCommas(numString));
		}
	}
}
