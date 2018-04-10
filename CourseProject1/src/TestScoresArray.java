import acm.program.*;

public class TestScoresArray extends ConsoleProgram {
	
	int[][] scores;
	
	public void run()
	{
		int numScores = readInt("Number of scores: ");
		scores = new int[2][numScores];
		
		initScores();
		println("Scores[0] before increment");
		printList(scores[0]);
		
		incrementScoreList(scores[0]);
		println("Scores[0] after increment");
		printList(scores[0]);
	}

	private void initScores() 
	{
		for (int i=0; i < scores.length; i++)
		{
			for (int j=0; j < scores[0].length; j++)
			{
				scores[i][j] = 0;
			}
		}
	}
	
	private void printList(int[] list)
	{
		for (int i=0; i < list.length; i++)
		{
			println(list[i]);
		}
	}
	
	private void incrementScoreList(int[] list)
	{
		for (int i=0; i < list.length; i++)
		{
			list[i] += 1;
		}
	}
	
}