/*
Note: String class and Wrapper classes implement the Comparable interface.
So if you store the objects of string or wrapper classes, it will be Comparable.
public void sort(List list): is used to sort the elements of List. List elements must be of the Comparable type.
*/

package CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SortingElements {

    public static void main(String[] args) {
        
        //Ordenando Strings
        ArrayList<String> al = new ArrayList<>();
        al.add("Viru");
        al.add("Saurav");
        al.add("Mukesh");
        al.add("Tahir");
        Collections.sort(al);
        Iterator itr = al.iterator();
        System.out.println("Sorted elements; ");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        Collections.sort(al, Collections.reverseOrder());
        
        System.out.println("Sorted in reverse order: ");
        Iterator i=al.iterator();  
        while(i.hasNext())  
        {  
            System.out.println(i.next());  
        }  
        
    }
}
