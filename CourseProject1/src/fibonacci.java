import acm.program.*;

public class fibonacci extends ConsoleProgram {
	
	public void run() 
	{
		int old1 = 0;
	    int old2 = 1;
	    
	    int nextNumber = 0;
	    
	    println(old1);
	    println(old2);
	    
	    while (nextNumber <= 1000) 
	    {
	    	nextNumber = old1 + old2;
	    	
	    	if(nextNumber <= 1000) 
	    		println(nextNumber);
	    	
	    	old1 = old2;
	    	old2 = nextNumber;
	    }
	}
}
