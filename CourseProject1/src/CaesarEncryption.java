import acm.program.*;

public class CaesarEncryption extends ConsoleProgram {
	
	private char encryptChar(char ch, int key) 
	{
		if (Character.isUpperCase(ch))
		{
			int relativeCh = ch - 'A';
			int shiftedRelativeCh = (relativeCh + key) % 26;
			int asciiShiftedCh = shiftedRelativeCh + 'A'; 
			
			return (char)asciiShiftedCh;
		}
		return ch;
	}
	
	private String encryptCaesar(String str, int key) 
	{
		if (key < 0) {
			key = 26 - (-key % 26); //turns negative number into positive
		}
		
		String result = "";
		
		for (int i=0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			result += encryptChar(ch, key);
		}
		return result;
	}

	public void run() 
	{
		int key = readInt("Enter encryption key: ");
		String plainText = readLine("Plain text: ");
		String cipherText = encryptCaesar(plainText, key);
		String decrypted = encryptCaesar(cipherText, -key);
		
		println("Cipher text: " + cipherText);
		println("Decrypted (original) text: " + decrypted);
	}
	
}
