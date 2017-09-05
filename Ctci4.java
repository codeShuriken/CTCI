/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
if (head == null){
    return false;
}
   Node curr = head;
   Node temp = head.next;
    
   while(curr != temp){
       if(temp == null || temp.next == null){
           return false;
       }
       
       curr = curr.next;
       temp = temp.next.next;
   } 
   return true;
    
    
}
