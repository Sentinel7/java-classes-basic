public class Maskify {
  
  public static void main(String[] args) {
  
  	System.out.println(maskify("123456"));
    
  }

  public static String maskify(String str) {
  
      String newString = "";
      
      for (int i=0; i < str.length(); i++) {
          
          if (str.length() >= 4) {

            if (i < str.length()-4) {
                newString = newString + "#";
            }
            else {
                newString = newString + str.charAt(i);
            }
          }
          else {
            return str;
          }
      }

      return newString;
  }
  
}
