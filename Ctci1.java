/**
*   A left rotation operation on an array of size n shifts each of the array's elements 1
*   unit to the left. For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5], 
*    then the array would become [3, 4, 5, 1, 2].
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ctci1 {

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
