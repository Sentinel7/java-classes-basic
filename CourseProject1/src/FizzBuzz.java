import acm.program.*;

public class FizzBuzz extends ConsoleProgram {
	
	public void run() 
	{
		for (int i = 1; i<=100; i++)
		{
			if (i % 3 == 0 && i % 15 != 0)
				println("fizz");
			
			if (i % 5 == 0 && i % 15 != 0)
				println("buzz");
			
			if (i % 3 != 0 && i % 5 != 0)
				println(i);
			
			if (i % 3 == 0 && i % 5 == 0)
				println("fizzbuzz");
		}
	}
	
}
