import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Trie tree = new Trie();
        ArrayList<Integer> prefixCount = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")){
                tree.add(contact);
            }
            else if(op.equals("find")){
                prefixCount.add(tree.find(contact));
            }
        }
        
        for(Integer i : prefixCount){
            System.out.println(i);
        }
    }
    
    
    public static class Trie{
        private static class TrieNode{
            Map<Character, TrieNode> children;
            boolean endOfWord;
            int size;
            
            public TrieNode(){
                children = new HashMap<Character, TrieNode>();
                endOfWord = false;
            }
        }
        private final TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        
        public void add(String word){
            TrieNode current = root;
            
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                TrieNode node = current.children.get(c);
                
                if(node == null){
                    node = new TrieNode();
                    current.children.put(c, node);
                }
                current = node;
                current.size++;
            }
            current.endOfWord = true;
        }
        
        public int find(String word){
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                TrieNode node = current.children.get(c);
                if (node == null){
                    return 0;
                }
                current = node;
            }
            return current.size;
        }
        
    }
}

