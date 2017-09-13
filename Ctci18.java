import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ctci18 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(howManyWays(n));
        }
    }
    
    public static int howManyWays(int n){
        if (n == 1 || n == 2){
            return n;
        }
        if (n == 3){
            return 4;
        }
        
        return howManyWays(n - 1) + howManyWays(n - 2) + howManyWays(n - 3);
    }
}
