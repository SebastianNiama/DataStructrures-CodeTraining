/*
Let's see a PriorityQueue example where we are adding books to queue and
printing all the books. The elements in PriorityQueue must be of Comparable type.
String and Wrapper classes are Comparable by default. To add user-defined 
objects in PriorityQueue, you need to implement Comparable interface.
 */
package PriorityQueue3;

import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Queue<Book> queue = new PriorityQueue<Book>();
        
        Queue<Book2> queue2 = new PriorityQueue<Book2>( new Comparator<Book2>(){
            @Override
            public int compare(Book2 o1, Book2 o2) {               
                if(o1.getId()>o2.getId()){
                    return 1;
                }else if(o1.getId()< o2.getId()){
                    return -1;
                }else return 0;               
            }  
        });
        
        queue2.add(new Book2(121,"Let us C","Yashwant Kanetkar","BPB",8));
        queue2.add(new Book2(233,"Operating System","Galvin","Wiley",6));
        queue2.add(new Book2(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4));
    
        for (Book2 es : queue2) {
            System.out.println(es.getId()+" ");
        }
        System.out.println("");
        queue2.remove();
        System.out.println("");
        for (Book2 es : queue2) {
            System.out.println(es.getId()+" ");
        }
    
    }
}

class Book implements Comparable<Book> {

    int id;
    String name, author, publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public int compareTo(Book b) {
        if (id > b.id) {
            return 1;
        } else if (id < b.id) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
    
    class Book2 {

    int id;
    String name, author, publisher;
    int quantity;

    public Book2(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
    
    public int getId(){
        return this.id;
    }
    
  }



