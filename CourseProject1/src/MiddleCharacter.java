import java.util.*;

public class MiddleCharacter {

	public static String getMiddle(String word)
	{
		int midPosition = 0;
		int midLength = 0;
		
		if (word.length() % 2 == 1) //Odd
		{
			midPosition = word.length() / 2;
			midLength = 1;
		}
		else if (word.length() % 2 == 0) //Even
		{
			midPosition = word.length() / 2 - 1;
			midLength = 2;
		}
		
		String result = word.substring(midPosition, midPosition + midLength);
		
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		
		System.out.println(getMiddle(input));
	}
	
}
