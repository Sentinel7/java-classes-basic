import java.util.*;

public class MagicSquare {
	
	public static void main(String[] a) 
    {
    	int[][] square = new int[4][4];

		Scanner console = new Scanner(System.in);
		
		for(int row=0; row<4; row++) 
		{
			for(int col=0; col<4; col++)
			{
				square[row][col] = console.nextInt();
			}
		}
		 
		/*
		//Print out the array for debugging
		for(int row=0; row<4; row++) 
		{
			for(int col=0; col<4; col++)
			{
				System.out.print(square[row][col] + " ");
			}
			System.out.println();
		}*/
		
		//Logic
    	boolean isMagicSquare = true;
    	int initialRowSum = 0;    	
    	    	
    	for (int row=0; row<4; row++) 
    	{
    		int rowSum = 0;
    		
    		for (int col=0; col<4; col++) 
    		{
    			rowSum += square[row][col];
    		}

    		if (initialRowSum == 0) 
    		{
    			initialRowSum = rowSum;
    		}
    		
    		if (rowSum != initialRowSum)
    		{
    			System.out.println("This is not a magic square!");    			
    			isMagicSquare = false;
    			
    			return;
    		}
    	}
    	
    	
    	int initialColSum = 0;
    	
    	for (int i=0; i<4; i++) 
    	{
    		int colSum = 0;
    		
    		for (int j=0; j<4; j++) 
    		{
    			colSum += square[j][i];
    		}
    		
    		
    		if (initialColSum == 0) 
    		{
    			initialColSum = colSum;
    		}
    		
    		if (colSum != initialColSum)
    		{
    			System.out.println("This is not a magic square!");    			
    			isMagicSquare = false;
    			
    			return;
    		}
    	}
    	
    	
    	if (isMagicSquare == true) 
    	{
    		System.out.println("This is a magic square!");
    	}
    }
}
