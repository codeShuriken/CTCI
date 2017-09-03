/**
 *  Version 1
 *
 */
 
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ctci2 { 
    
    public static final int MAX_SIZE = 26;
    
    public static int delta(int[] array1, int[] array2){
        if (array1.length != array2.length){
            return -1;
        }
        int delta = 0;
        for (int i = 0; i < array1.length; i++){
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        
        return delta;
    }
    
    public static int[] findCharCounts(String s){
        int[] charCounts = new int[MAX_SIZE];
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            int offset = (int)'a';
            int diff =  c - offset;
            charCounts[diff]++;
        }
        
        return charCounts;
        
    }
    
    public static int numberNeeded(String first, String second) {
        
        int[] charCount1 = findCharCounts(first);
        int[] charCount2 = findCharCounts(second);
        
        return delta(charCount1, charCount2);
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
    
}


/**
 *  Version 2 of number needed method
 */
 public static int numberNeeded(String first, String second) {
        StringBuilder a = new StringBuilder(first);
        StringBuilder b = new StringBuilder(second);
        String ch;
        for (int i = 0; i < second.length(); i++){
            ch = Character.toString(second.charAt(i));
            if (first.indexOf(ch) >= 0){
                b.deleteCharAt(b.indexOf(ch));
                a.deleteCharAt(a.indexOf(ch)); 
            }
        }
        return (a.length() + b.length());
    }
 
