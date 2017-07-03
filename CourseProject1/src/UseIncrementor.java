import acm.program.*;

public class UseIncrementor extends ConsoleProgram {
	
	public void run() 
	{
		Incrementor increment1 = new Incrementor(); //starts at 1
		Incrementor increment2 = new Incrementor(1000);
		
		println("Five values for count 1:");
		countFiveTimes(increment1);
		
		println("Five values for count 2:");
		countFiveTimes(increment2);
		
		println("Another five values for count 1:");
		countFiveTimes(increment1);
	}
	
	private void countFiveTimes(Incrementor myIncrementor)
	{
		for (int i = 0; i < 5; i++)
		{
			println(myIncrementor.NextValue());
		}
	}
	
}
