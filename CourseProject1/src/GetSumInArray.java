
public class GetSumInArray {

	public static int sum(int[] array)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		if (array == null)
			return 0;
		if (array.length == 0)
			return 0;
		if (array.length == 1)
			return 0;
		
		for (int i=0; i < array.length; i++)
		{
			if (array[i] < min)
				min = array[i];
			
			if (array[i] > max)
				max = array[i];
			
			sum += array[i];
		}
		
		sum -= max;
		sum -= min;
		
		return sum;
	}
	
}
