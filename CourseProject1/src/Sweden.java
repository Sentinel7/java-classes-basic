import java.util.*;

public class Sweden {

	public static void main(String[] a)
	{
		Scanner console = new Scanner(System.in);
		
		String message = console.nextLine();
		
		for (int i = 0; i < message.length(); i++) 
		{
			String translation = "";
			
			char l = message.charAt(i);
			
			if (l=='a' || l=='e' || l=='i' || l=='o' || l=='u')
			{
				translation += message.charAt(i); //vowel, no change
			}
			else //consonant
			{
				translation += message.charAt(i); //starting consonant
				
				if(message.charAt(i) == 'b') {
					translation += "a"; //nearest vowel
					translation += "c"; //next consonant 
				}
				if(message.charAt(i) == 'c') { 
					translation += "a";
					translation += "d";
				}
				if(message.charAt(i) == 'd') { 
					translation += "e";
					translation += "f";
				}
				if(message.charAt(i) == 'f') { 
					translation += "e";
					translation += "g";
				}
				if(message.charAt(i) == 'g') { 
					translation += "e";
					translation += "h";
				}
				if(message.charAt(i) == 'h') { 
					translation += "i";
					translation += "j";
				}
				if(message.charAt(i) == 'j') { 
					translation += "i";
					translation += "k";
				}
				if(message.charAt(i) == 'k') { 
					translation += "i";
					translation += "l";
				}
				if(message.charAt(i) == 'l') { 
					translation += "i";
					translation += "m";
				}
				if(message.charAt(i) == 'm') { 
					translation += "o";
					translation += "n";
				}
				if(message.charAt(i) == 'n') { 
					translation += "o";
					translation += "p";
				}
				if(message.charAt(i) == 'p') { 
					translation += "o";
					translation += "q";
				}
				if(message.charAt(i) == 'q') { 
					translation += "o";
					translation += "r";
				}
				if(message.charAt(i) == 'r') { 
					translation += "o";
					translation += "s";
				}
				if(message.charAt(i) == 's') { 
					translation += "u";
					translation += "t";
				}
				if(message.charAt(i) == 't') { 
					translation += "u";
					translation += "v";
				}
				if(message.charAt(i) == 'v') { 
					translation += "u";
					translation += "w";
				}
				if(message.charAt(i) == 'w') { 
					translation += "u";
					translation += "x";
				}
				if(message.charAt(i) == 'x') { 
					translation += "u";
					translation += "y";
				}
				if(message.charAt(i) == 'y') { 
					translation += "u";
					translation += "z";
				}
				if(message.charAt(i) == 'z') { 
					translation += "u";
					translation += "z";
				}
			}
			System.out.println(translation);
		}
	}
	
}
