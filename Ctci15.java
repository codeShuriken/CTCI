import java.io.*;
import java.util.*;
import java.math.*;

public class Ctci15
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++)
        {
            int n = in.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not Prime");
    	}
        in.close();
    }
    
    public static boolean isPrime(int n){
        if (n == 2){
            return true;
        }
        if (n == 1 || ((n % 2) == 0)){
            return false;
        }
        
        for(int i = 3; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
