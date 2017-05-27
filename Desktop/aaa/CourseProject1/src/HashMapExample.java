import acm.program.*;
import java.util.*;

public class HashMapExample extends ConsoleProgram {

	private Map<String, Integer> phonebook = new HashMap<String, Integer>();
	
	public void run()
	{
		println("Reading in phone numbers");
		readPhoneNumbers();
		
		println("Looking up phone numbers");
		lookUpNumbers();
		
		println("Displaying all phone numbers");
		displayAllNumbers();
	}

	private void readPhoneNumbers() 
	{
		while (true)
		{
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			
			int number = readInt("Enter phone number: ");
			phonebook.put(name, number);
		}
	}

	private void lookUpNumbers() 
	{
		while (true)
		{
			String name = readLine("Enter name to lookup: ");
			Integer number = phonebook.get(name);
			
			if (name.equals("")) break;
			
			if (number == null)
				println(name + " is not in phonebook.");
			else
				println("# " + number);
		}
	}

	private void displayAllNumbers() 
	{
		Iterator<String> i = phonebook.keySet().iterator();
		
		while (i.hasNext())
		{
			String name = i.next();
			Integer number = phonebook.get(name);
			
			println(name + ": " + number);
		}
	}
	
	private void displayAllNumbers2() 
	{
		for (String name : phonebook.keySet())
		{
			Integer number = phonebook.get(name);
			println(name + ": " + number);
		}
	}
	
}
