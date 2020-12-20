/*
Example of Properties class to get all the system properties.
By System.getProperties() method we can get all the properties of the system.
Let's create the class that gets information from the system properties.
 */

package PropertiesClass;

import java.util.*;  
import java.io.*;  

public class Test2 {
    public static void main(String[] args)throws Exception {
        
        Properties p = System.getProperties();
        Set set = p.entrySet();
        
        Iterator itr = set.iterator();
        
        while(itr.hasNext()){
            Map.Entry entry = (Map.Entry)itr.next();
            System.out.println(entry.getKey()+"="+ entry.getValue());
            
        }
    }
}
