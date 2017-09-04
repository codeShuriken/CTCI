import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        if (isReplica(magazine, ransom)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    
    public static boolean isReplica(String[] magazine, String[] ransom){
        if (magazine.length < ransom.length)
            return false;
        
        Hashtable<String, Integer> words = new Hashtable<String, Integer>();
        Integer i = new Integer(1);
        
        for(String r: ransom){
            if (words.get(r) != null){
                words.put(r, new Integer(words.get(r) + 1));
            }
            else{
                words.put(r, i);
            }
        }
        
        for(String m: magazine){
            if (words.get(m) != null){
                if(words.get(m) != 0){
                    words.put(m, new Integer(words.get(m) - 1)); 
                }
            }
        }
        
        Set<String> keys = words.keySet();
        for(String key: keys){
            if (words.get(key) != 0){
                return false;
            }
        }
        
        return true;
    }
    
}
