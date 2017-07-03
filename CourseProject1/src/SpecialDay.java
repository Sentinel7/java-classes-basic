import java.util.*;

public class SpecialDay {
		
	public static void main(String[] a) 
	{
		Scanner console = new Scanner(System.in);
		
		int month = console.nextInt();
		int day = console.nextInt();
		
		if (month < 2)
			System.out.println("Before");
		
		if (month > 2)
			System.out.println("After");
		
		if (month == 2 && day < 18)
			System.out.println("Before");
		
		if (month == 2 && day > 18)
			System.out.println("After");
		
		if (month == 2 && day == 18)
			System.out.println("Special");
	}
	
}
