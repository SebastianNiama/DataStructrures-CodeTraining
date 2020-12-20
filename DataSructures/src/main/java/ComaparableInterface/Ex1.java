package ComaparableInterface;

import java.util.*;

public class Ex1 {

    public static void main(String[] args) {
        
        ArrayList<Student> al = new ArrayList<>();
        
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));

        //Uso sort()) para ordenar xq noe stoy usando TreeSet ni TreeMap.
        Collections.sort(al);//Me deja xq ya implemente el Comparable
        for (Student st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }
    }

}

class Student implements Comparable<Student> {

    int rollno;
    String name;
    int age;

    public Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student st) {
        if (age == st.age) {
            return 0;
        } else if (age > st.age) {
            return 1;
        } else {
            return -1;
        }
    }

    //ReverseOrder:
    /*
    public int compareTo(Student st){    
    if(age==st.age)    
        return 0;    
    else if(age<st.age)    
        return 1;    
    else    
        return -1;    
 }    
 }   
     */
}
