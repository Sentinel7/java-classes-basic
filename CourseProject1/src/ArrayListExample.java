import acm.program.*;
import java.util.*;

public class ArrayListExample extends ConsoleProgram {
    
	public void run()
	{
		ArrayList<Integer> sList = new ArrayList<Integer>();
		
		readList(sList); //Initialize list
		printList(sList);
		
		readList(sList); //Add on to list
		printList(sList);
	}
	
	public void readList(ArrayList list)
	{
		while (true)
		{
			int line = readInt(" ? ");
			if (line == 0) break;
			
			list.add(line);
		}
	}
	
	public void printList(ArrayList list)
	{
		println("List contains " + list.size() + " elements:");
		
		for (int i=0; i < list.size(); i++)
		{
			println(list.get(i));
		}
	}
	
}
