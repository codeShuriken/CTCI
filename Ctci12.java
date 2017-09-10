import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long countInversions(int[] arr) {
        // Complete this function
        return countInversions(arr, 0, arr.length - 1);
    }
    
    public static long countInversions(int[] arr, int start, int end){
        if(start == end){
            return 0;
        }
        int mid = start + ((end - start) / 2);
        long count = 0;
        
        count += countInversions(arr, start, mid);
        count += countInversions(arr, mid + 1, end);
        count += merge(arr, start, end);
        
        return count;
    }
    
    public static long merge(int[] arr, int start, int end){
        int mid = start + ((end - start) / 2);
        long count = 0;
        int[] newArr = new int[end - start + 1];
        int k = 0;
        int i = start;
        int j = mid + 1;
        
        while(i <= mid && j <= end){
            if (arr[i] > arr[j]){
                newArr[k++] = arr[j++];
                count += mid - i + 1;
            }   
            else {
                newArr[k++] = arr[i++];
            }
        }
        while(i <= mid){
            newArr[k++] = arr[i++];
        }
        while(j <= end){
            newArr[k++] = arr[j++];
        }
        
        System.arraycopy(newArr, 0, arr, start, end - start + 1);
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}
