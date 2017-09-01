import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int temp;
        for(int i = 0; i < k; i++){
            temp = a[0];
            System.arraycopy(a, 1, a, 0, (a.length - 1));
            a[a.length - 1] = temp;
        }
        
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
