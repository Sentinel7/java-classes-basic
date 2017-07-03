import java.util.*;

public class XO {
  
  public static boolean getXO (String str) 
  {
    int numX = 0;
    int numO = 0;
    
    for (int i=0; i < str.length(); i++)
    {
      if (str.charAt(i) == 'X' || str.charAt(i) == 'x')
      {
        numX++;
      }
      else if (str.charAt(i) == 'O' || str.charAt(i) == 'o')
      {
        numO++;
      }
    }
    
    if (numX == numO)
      return true;
      
    return false;
    
  }

}