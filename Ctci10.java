import java.io.*;
import java.util.*;

public class Ctci10 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            int num = keyboard.nextInt();
            numbers[i] = num;
        }
        
        int numberOfSwaps = sortArray(numbers);
        System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
        System.out.println("First Element: " + numbers[0]);
        System.out.println("Last Element: " + numbers[n - 1]);
        
    }
    
    public static int sortArray(int[] array){
        int numberOfSwaps = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - (i + 1); j++){
                if (array[j] >= array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    numberOfSwaps++;
                }
            }
            if (numberOfSwaps == 0){
                break;
                }
        }
        return numberOfSwaps;
    }
}
