import java.util.*;

public class HappyOrSad {

	public static void main(String[] a)
	{
		Scanner console = new Scanner(System.in);
		
		String message = console.nextLine();
		
		String happy = ":-)";
		String sad = ":-(";
		
		int countHappy = 0;
		int countSad = 0;
		
		for (int i = 0; i < message.length(); i++)
		{
			if (message.startsWith(happy, i))
				countHappy++;
			
			if (message.startsWith(sad, i))
				countSad++;
		}
		
		if (countHappy > countSad)
			System.out.println("happy");
		
		if (countSad > countHappy)
			System.out.println("sad");
		
		if (countHappy == 0 && countSad == 0)
			System.out.println("none");
		
		if (countHappy == countSad)
			System.out.println("unsure");
	}
	
}
