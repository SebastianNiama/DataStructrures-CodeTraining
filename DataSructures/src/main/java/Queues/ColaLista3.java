
package Queues;

import java.util.NoSuchElementException;

public class ColaLista3 <T>{
    
    private static class Node<T>{
        private T data;
        private Node<T> next;
        
        public Node(T data){
            this.data = data;
        }
    }
    
    private Node<T> first;
    private Node<T> last;
    
    public void add(T item){
        Node <T> t = new Node(item);
        if(last !=null){//Si la cola no esta vacia
            last.next = t;
        }
        last = t;
        if(first == null){//Si la cola esta vacia
            first = last;
        }
    }
    public T remove(){
        if(first ==null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first ==null){//Si este es el ultimo elemento...
            last = null;
        }
        return data;   
    }
    public T peek(){
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }
    
    public boolean isEMpty(){
        return first ==null;
    }
    
    
  
    
}
