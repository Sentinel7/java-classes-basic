import java.util.*;
import acm.program.*;

public class TestScoresArrayList extends ConsoleProgram {
	
	int numScores;
	ArrayList<Integer> scores = new ArrayList<Integer>();
	
	public void run()
	{
		numScores = readInt("Number of scores: ");
		
		initScores(numScores);
		println("Scores before increment:");
		printList(scores);
		
		incrementScoreList();
		println("Scores after increment:");
		printList(scores);
	}

	private void initScores(int n) 
	{
		for (int i=0; i < n; i++)
		{
			scores.add(0);
		}
	}
	
	private void printList(ArrayList list)
	{
		for (int i=0; i < list.size(); i++)
		{
			println(list.get(i));
		}
	}
	
	private void incrementScoreList()
	{
		for (int i=0; i < scores.size(); i++)
		{
			scores.set(i, scores.get(i) + 1);
		}
	}
	
}