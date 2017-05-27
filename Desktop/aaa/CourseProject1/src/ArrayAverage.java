import acm.program.*;
 
public class ArrayAverage extends ConsoleProgram{

	public void run()
	{
		int maxLength = readInt("Max size of array: ");
		int[] testScores = new int[maxLength];
		int numScores = 0;
		
		for (int i=0; i < maxLength; i++)
		{
			testScores[i] = readInt("Next score: ");
			if (testScores[i] == -1) break;
			numScores++;
		}
		
		println("Average score: " + ComputeAverage(testScores, numScores));
	}
	
	private double ComputeAverage(int[] array, int totalScores)
	{
		double average = 0;
		
		for (int i=0; i < totalScores; i++)
		{
			average += array[i];
		}
		average = average/totalScores;
		
		return average;
	}
	
}
