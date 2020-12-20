
package Spliterator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import javax.swing.SpringLayout;

public class Concept {
    public static void main(String[] args) {
        /*
        DIFFERENCES BETWEEN ITERATOR AND SPLITERATOR
        Iterator:
        An Iterator is a simple representation of a series of 
        elements that can be iterated over.An Iterator always has 
        an unknown size: you can traverse elements only via hasNext/next;
        Ex:
        */
        List<String> list1 =Arrays.asList("Apple", "banana"," Organge");
        Iterator<String> i = list1.iterator();
        i.next();
        i.forEachRemaining(System.out::println);
        
        System.out.println("\n");
        /*
        Spliterator:
        It can Split some source, and it can iterate it too. It roughly has
        the same funcionality as an Iterator but with the thing that it can
        potentially split into multiple pieces: this is what trySplit 
        is for. Splitting is needed for parallel processing.
        On the other hand, tryAdvance is what hasNext/next is from an Iterator.
        A Spliterator can be used to split given element set into multiple sets 
        so that we can perform some kind of operations/calculations on each set
        in different threads independently, possibly taking advantage of
        parallelism. It is designed as a parallel analogue of Iterator.
        There are 2 main methods in the Spliterator interface.
        - tryAdvance() and forEachRemaining()
        With tryAdvance(), we can traverse underlying elements one by one 
        (just like Iterator.next()). If a remaining element exists,
        this method performs the consumer action on it, returning 
        true; else returns false.
        */
        List<String> list2 = Arrays.asList("Apple", "banana","Orange","Watermelon");
        Spliterator<String> s = list2.spliterator();
        s.tryAdvance(System.out::println);//Divido el primer elemento "Apple"
        //Ahora imprimo normalmente la list2 y noto que se han dividido
        System.out.println("Nueva lista: ");
        s.forEachRemaining(System.out::println);
        
        System.out.println("\nattempting tryAdvance again\n");
        boolean b = s.tryAdvance(System.out::println);      
        System.out.println("Element exists: "+b);
        
        
        
    }
}
