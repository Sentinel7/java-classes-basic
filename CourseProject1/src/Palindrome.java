public class Palindrome {
	
	public static boolean isPalindrome(String str) 
	{
		int i = 0;
		int j = str.length() - 1;
		
		while (i <= j) 
		{
			if (str.charAt(i) != str.charAt(j))
				return false;
			
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void main (String[] a) 
	{	
		java.util.Scanner console = new java.util.Scanner(System.in);
		
		String line = console.nextLine();
				
		int maxlength = 0;
		
		for(int x=0; x<line.length(); x++) 
		{
			for(int y=line.length()-1; y >= x+1; y--) 
			{
				String substr = line.substring(x, y);
				
				if(isPalindrome(substr) == true)
				{
					if(substr.length() > maxlength)
						maxlength = substr.length();
				}
			}
		}		
		
		System.out.println(maxlength);
	}
}