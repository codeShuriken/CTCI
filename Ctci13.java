import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ctci13 {

     
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt(); 
                    
            }
            int[] b = findChoices(a, m);
            for(int i = 0; i < b.length; i++){
                    System.out.print((b[i] + 1) + " ");
                 }
            System.out.println();
        }
        
    }
    
    public static int[] findChoices(int[] menu, int money){
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);
        
        for (int i = 0; i < sortedMenu.length; i++){
            int complement = money - menu[i];
            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
            
            if(location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement){
                int[] indices = getIndicesFromValues(menu, menu[i], complement);
                
                return indices;
            }
        }
        return null;
    }
    
    public static int[] getIndicesFromValues(int[] menu, int value1, int value2){
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);
        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }
    
    public static int indexOf(int[] menu, int value, int excludeThis){
        for(int i = 0; i < menu.length; i++){
            if(menu[i] == value && i != excludeThis){
                return i;
            }
        }
        return -1;
    }
}
