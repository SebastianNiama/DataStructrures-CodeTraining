//Ejemplo de Priority Queue con su clase de java
/*
The PriorityQueue class provides the facility of using queue.
But it does not orders the elements in FIFO manner. It inherits
AbstractQueue class.
*/
package PriorityQueue3;

import java.util.*;

public class Ex1 {

    public static void main(String[] args) {

        PriorityQueue<String> queue = new PriorityQueue<String>();

        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");
        
        /*.element() method
        It is used to retrieves, but does not remove, the head of 
        this queue.
        */     
        System.out.println("head: "+queue.element());
        /*
        peek()It is used to retrieves, but does not remove,
        the head of this queue, or returns null if this queue is empty.
        */
        System.out.println("head: "+queue.peek()); 
        
        System.out.println("");
        
        System.out.println("iterating the queue elements:");
        //Iterator itr = queue.iterator();      
        queue.forEach(System.out::println);
        
        System.out.println("");
        /*
        Object remove()	It is used to retrieves and removes the
        head of this queue.
        */
        queue.remove();
        queue.poll();
        System.out.println("After removing two elements: ");
        queue.forEach(System.out::println);
    }

}
