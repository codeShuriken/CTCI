import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static class MyQueue<E>{
        public Stack<E> s1;
        public Stack<E> s2;
    
    public MyQueue(){
        s1 = new Stack<E>();
        s2 = new Stack<E>();
    }
    
    public Stack<E> gets1(){
        return s1;
    }
     public Stack<E> gets2(){
        return s2;
    }
    
    public void enqueue(E i){
        s1.push(i);
        
    }
    
    public E dequeue(){
        prepOld();
        return s2.pop();
    }
    
    public E peek(){
        prepOld();
        return s2.peek();
    }
        public void prepOld(){
            if (s2.isEmpty())
                while(!s1.isEmpty())
                    s2.push(s1.pop());
        }
    
    }
    
    public static void main(String[] args) {
        
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }


}
    
