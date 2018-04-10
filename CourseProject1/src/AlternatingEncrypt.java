import java.util.Arrays;

public class AlternatingEncrypt {

	public static void main(String[] args) {
		
		String t = "elhlo";
		int n = 1;
		System.out.println(decrypt(t, n));
	}
	
	public static String encrypt(String text, int n) {
		if (text == null) return null;
		
		String encrypted = text;
		
	    for (int i=0; i < n; i++) {
			String[] tArr = encrypted.split("");
			String tmp1 = "";
			String tmp2 = "";
			
			for (int j=1; j < tArr.length+1; j++) {
				if (j % 2 == 0) {
					tmp1 += tArr[j-1];
				} else {
					tmp2 += tArr[j-1];
				}
			}
			encrypted = tmp1 + tmp2;
	    }
	    return encrypted;   
	}
	  
    public static String decrypt(String text, int n) {
    	if (text == null) return null;
    	
    	String decrypted = text;
		
	    for (int i=0; i < n; i++) {
			String[] tArr = decrypted.split("");
			String[] newArr = new String[tArr.length];
			
			int mid = tArr.length / 2;
			
			int posEven = 1;
			for (int j=0; j < mid; j++) {
				newArr[posEven] = tArr[j];
				posEven += 2;
			}
			
			int posOdd = 0;
			for (int j=mid; j < tArr.length; j++) {
				newArr[posOdd] = tArr[j];
				posOdd += 2;
			}
			
			String tmp = "";
			for (int j=0; j < newArr.length; j++) {
				tmp += newArr[j];
			}
			decrypted = tmp;
	    }
	    return decrypted;
    }

}
