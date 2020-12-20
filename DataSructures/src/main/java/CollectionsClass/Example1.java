
package CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        //Parte 1 addAll() method
        List<String> list = new ArrayList<>();
        
        list.add("C");
        list.add("Core Java");
        list.add("Advance Java");
        System.out.println("Iniiall collection value; "+list);
        Collections.addAll(list, "Servlet", "JSP", "Henry");
        System.out.println("After adding elements collection value"+list);
        String [] strArr = {"C#", ".Net"};
        Collections.addAll(list, strArr);
        System.out.println("After adding array collection value:"+list);
         
        System.out.println("");
        //Parte 2 max() method.
        List <Integer> list2 = new ArrayList<>();
        list2.add(46);
        list2.add(67);
        list2.add(24);
        list2.add(16);
        list2.add(8);
        list2.add(12);
        System.out.println("Value of maximun element from the collection: "+ Collections.max(list2));
        System.out.println("Value of minimum element from the collection: "+Collections.min(list2)); 
        Collections.sort(list2);
        System.out.println("Sorted elements: "+list2);
    }
            
}
