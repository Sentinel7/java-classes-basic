import java.util.*;

public class TournamentSelection {

	public static void main(String[] a)
	{
		Scanner console = new Scanner(System.in);
		
		int points = 0;
		
		String result1 = console.nextLine();
		String result2 = console.nextLine();
		String result3 = console.nextLine();
		String result4 = console.nextLine();
		String result5 = console.nextLine();
		String result6 = console.nextLine();
		
		if (result1.equals("W"))
			points++;
		
		if (result2.equals("W"))
			points++;
		
		if (result3.equals("W"))
			points++;
		
		if (result4.equals("W"))
			points++;
		
		if (result5.equals("W"))
			points++;
		
		if (result6.equals("W"))
			points++;
		
		
		if (points >= 5)
			System.out.println(1);
		
		if (points == 3 || points == 4)
			System.out.println(2);
		
		if (points == 2 || points == 1)
			System.out.println(3);
		
		if (points == 0)
			System.out.println(-1);
			
	}
	
}
