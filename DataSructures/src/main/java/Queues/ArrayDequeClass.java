/*
The ArrayDeque class provides the facility of using deque and resizable-array. 
Unlike Queue, we can add or remove elements from both sides.
Null elements are not allowed in the ArrayDeque.
ArrayDeque is not thread safe, in the absence of external synchronization.
ArrayDeque has no capacity restrictions.
ArrayDeque is faster than LinkedList and Stack.
 */
package Queues;

import java.util.*;

public class ArrayDequeClass {

    public static void main(String[] args) {
        //Creating Deque and adding elements  
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Ravi");
        deque.add("Vijay");
        deque.add("Ajay");
        //Traversing elements  
        for (String str : deque) {
            System.out.println(str);
        }
        System.out.println("");
        deque.offerFirst("Henry");
        System.out.println("After offerFirst Traversal...");  
          for (String str : deque) {
            System.out.println(str);
        }
          System.out.println("");
        //deque.pollFirst();//it is same as poll()  
        deque.pollFirst();
           System.out.println("After pollLast() Traversal..."); 
           for (String str : deque) {
            System.out.println(str);
        }
    }
}
