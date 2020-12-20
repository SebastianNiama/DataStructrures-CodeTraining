//Java 8 Comparator Example: nullsFirst() and nullsLast() method
//Here, we sort the list of elements that also contains null.
package ComparatorInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ejemplo2 {

    public static void main(String[] args) {
        
        ArrayList<Student> al = new ArrayList<>();
        
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, null, 21));

        Comparator<Student> cm1 = Comparator.comparing(Student::getName, Comparator.nullsFirst(String::compareTo));
        Collections.sort(al, cm1);
        System.out.println("Considers null to be less than non-null");
        al.forEach((st) -> {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        });

        Comparator<Student> cm2 = Comparator.comparing(Student::getName, Comparator.nullsLast(String::compareTo));
        Collections.sort(al, cm2);
        System.out.println("Considers null to be greater than non-null");
        for (Student st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }
    }
}
