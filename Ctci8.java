import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ctci8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        Heap heap = new Heap();
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            heap.add(a[a_i]);
            System.out.println(heap.median());        
        }
        
    }
    
    static class Heap{
        private Queue<Integer> low = new PriorityQueue<Integer>(Comparator.reverseOrder());
        private Queue<Integer> high = new PriorityQueue<Integer>();
        
        public void add(int number){
            Queue<Integer> target = low.size() <= high.size() ? low: high;
            target.add(number);
            balance();
            
        }
        
        public void balance(){
            if(!low.isEmpty() && !high.isEmpty() && low.peek() > high.peek()){
                Integer lowkey = low.poll();
                Integer highkey = high.poll();
                low.add(highkey);
                high.add(lowkey);
            }
        }
        
        public double median(){
             if(low.isEmpty() && high.isEmpty()) {
                 throw new IllegalStateException("Heap is empty");
             }
            else{
                return low.size() == high.size() ? (low.peek() + high.peek())/2.0 : low.peek();
        }
    }
}
}
