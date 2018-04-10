
public class DescendingOrder {
	
	public static int sortDesc(final int num) 
	{	
		String numberStr = Integer.toString(num);
		int[] numArray = new int[numberStr.length()];	
		
		for (int i=0; i < numArray.length; i++)
		{
			numArray[i] = numberStr.charAt(i) - '0';
		}
		
		//Now sort array
		for (int i=0; i < numArray.length; i++)
		{
			int maxDigit = -1;
			int indexOfMaxDigit = -1;
			
			for (int j=i; j < numArray.length; j++) 
			{
				if (numArray[j] > maxDigit) 
				{
					maxDigit = numArray[j];
					indexOfMaxDigit = j;
				}
			}
			
			//swap 
			int temp = numArray[i];
			numArray[i] = numArray[indexOfMaxDigit];
			numArray[indexOfMaxDigit] = temp;
		}
		
		
		//create result
		int result = 0;
		int powerOf10 = 1;
		
		for (int i=numArray.length-1; i >= 0; i--)
		{
			result += numArray[i] * powerOf10;
			powerOf10 *= 10;
		}
		
		return result;
	}
	
}