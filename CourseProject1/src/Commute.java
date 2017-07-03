public class Commute {

	public static void main(String[] args) 
	{
		java.util.Scanner console = new java.util.Scanner(System.in);
		String depTime = console.nextLine();
		
		String[] strArray = depTime.split(":");
		
		//Turn string to number
		int hour = Integer.parseInt(strArray[0]);
		int min = Integer.parseInt(strArray[1]);
		
		System.out.print(hour+2);
		
		if(min<10)
			System.out.print(":0" + min);
		else
			System.out.print(":" + min);
	}
}
