public class Palindrome2 {

	public static boolean isPalindrome(String str) 
	{
		for (int i = 0, j = str.length()-1; i <= j; i++, j--) 
		{
			if (str.charAt(i) != str.charAt(j))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		java.util.Scanner console = new java.util.Scanner(System.in);
				
		String line = console.nextLine();
		
		
		if (isPalindrome(line) == true)
			System.out.println("This is a palindrome");
		else 
			System.out.println("This is not a palindrome");
	}

}
