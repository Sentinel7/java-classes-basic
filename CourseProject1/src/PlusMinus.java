import java.util.*;

public class PlusMinus {
    
    public static double calculatePos(int[] a) {
        
        int n = 0;
        int size = a.length;
        double result = 0;
        
        for (int i=0; i < a.length; i++) {
            if (a[i] > 0)
                n++;
        }
        result = 1.0*n/size;
        
        return result;
    }
    
    public static double calculateNeg(int[] a) {
        
    	int n = 0;
        int size = a.length;
        double result = 0;
        
        for (int i=0; i < a.length; i++) {
            if (a[i] < 0)
                n++;
        }
        result = 1.0*n/size;
        
        return result;
    }
    
    public static double calculateZero(int[] a) {
        
    	int n = 0;
        int size = a.length;
        double result = 0;
        
        for (int i=0; i < a.length; i++) {
            if (a[i] == 0)
                n++;
        }
        result = 1.0*n/size;
        
        return result;
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        
        for (int i=0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        
        System.out.println(calculatePos(arr));
        System.out.println(calculateNeg(arr));
        System.out.println(calculateZero(arr));
    }
}