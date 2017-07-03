import java.util.*;

public class CharacterCounter {

	public static boolean validateWord(String word) 
    {	
		Map<Character, Integer> cMap = new HashMap<Character, Integer>();
		word = word.toLowerCase();
			
		for (int i=0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			
			if (cMap.containsKey(ch))
			{
				int count = cMap.get(ch);
				cMap.put(ch, count + 1);
			}
			else 
				cMap.put(ch, 1);
		}
		
		Integer j = cMap.get(word.charAt(0)); //the count of the first character of the string
		for (Integer i : cMap.values())
		{ 				
			if(!j.equals(i))
				return false;
		}
		return true;
    }

	public static void main(String[] args) {
		System.out.println(CharacterCounter.validateWord("abcabc"));
		System.out.println(CharacterCounter.validateWord("abcabc"));
		System.out.println(CharacterCounter.validateWord("Abcabc"));
		System.out.println(CharacterCounter.validateWord("AbcCBa"));
		System.out.println(CharacterCounter.validateWord("?!?!?!"));
		System.out.println(CharacterCounter.validateWord("abc123"));
		System.out.println(CharacterCounter.validateWord("abc!abc!"));
		
		System.out.println(CharacterCounter.validateWord("AbcabcC"));
		System.out.println(CharacterCounter.validateWord("pippi"));
		System.out.println(CharacterCounter.validateWord("abcabcd"));
		System.out.println(CharacterCounter.validateWord("?abc:abc"));
	}
	
}
