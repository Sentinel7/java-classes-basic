import java.util.*;

public class Votes {

	public static void main(String[] a)
	{
		Scanner console = new Scanner(System.in);
		
		String totalVotes = console.nextLine();
		String votesInput = console.nextLine();
		
		int aVotes = 0;
		int bVotes = 0;
		
		for (int i = 0; i < votesInput.length(); i++)
		{
			if (votesInput.charAt(i) == 'A')
				aVotes++;
			else
				if (votesInput.charAt(i) == 'B')
					bVotes++;
		}
		
		if (aVotes > bVotes)
			System.out.println("A");
		
		if (bVotes > aVotes)
			System.out.println("B");
		
		if (aVotes == bVotes)
			System.out.println("Tie");
	}
	
}
