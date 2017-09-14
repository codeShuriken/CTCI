import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ctci19 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(numberOfCoins(coins, n));
    }
    
    public static long numberOfCoins(int[] coins, int n){
       long[] dp = new long[n + 1];
        dp[0] = (long)1;
        for(int i : coins){
            for(int j = i; j < dp.length; j++){
                dp[j] += dp[j - i];
            }
        }
        return dp[n];
        
    }
}
