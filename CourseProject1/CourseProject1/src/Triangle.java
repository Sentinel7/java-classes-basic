import java.util.*;

public class Triangle {

	public static void main(String[] a)
	{
		Scanner console = new Scanner(System.in);
		
		int s1 = console.nextInt();
		int s2 = console.nextInt();
		int s3 = console.nextInt();
		
		if ((s1 == 60) && (s2 == 60) && (s3 == 60))
			System.out.println("Equilateral");
		else 
			if ((s1 == s2) || (s1 == s3) || (s2 == s3) && (s1+s2+s3 == 180))
				System.out.println("Isosceles");
		
		if ((s1 != s2) && (s1 != s3) && (s2 != s3) && (s1+s2+s3 == 180))
			System.out.println("Scalene");
		
		if ((s1+s2+s3 != 180))
			System.out.println("Error");
	}
	
}
