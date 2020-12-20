
package CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;

public class SortingElements2 {
    
    public static void main(String[] args) {
        ArrayList <Student> al = new ArrayList<>();
        
        al.add(new Student("Viru"));
        al.add(new Student("Sarauv"));
        al.add(new Student("Mukesh"));
        al.add(new Student("Tahir"));
        
        Collections.sort(al);//Me dejo usarlo xq Student implementa
        //la interfaz Comparable. Y me va a ordenar por nombre xq
        //así lo especifiqué.
        al.forEach((s) -> {
            System.out.println(s.name);
        });
    }
    
    
    
}

class Student implements Comparable<Student>{

    public String name;
    
    public Student(String name){
        this.name = name;
    }
    
    
    @Override
    public int compareTo(Student person) {
        return name.compareTo(person.name);
    }
    
    
}