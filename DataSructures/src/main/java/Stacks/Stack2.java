
package Stacks;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack2 <T> implements Iterable <T> {
/*
    We instancaite a doubly linked list provided by Java
    this is used for portability 
    */
    private LinkedList <T> list = new LinkedList<T>();
    
    //Create an empty stack
    public Stack2(){};
    
    //Create a stack with an initial element:
    public Stack2 (T firstElem){
        
        push(firstElem);
    }
    
    //Return the number of elements in the stack
    public int size(){
        return list.size();
    }
    
    //Check if the stack is empty
    public boolean isEmpty(){
        return size()==0;
    }
    
    //Push an element on the stack
    public void push(T element){
        list.addLast(element);
    }
     
    //pop an element off the stack
    //Throws an error is the stack is empty
    public T pop(){
        if(isEmpty()){
            throw  new EmptyStackException();
        }
        return list.removeLast();
    }
    
    public T peek(){
        if(isEmpty()){
            throw  new EmptyStackException();
        }
        return  list.peekLast();
    }
            
/*
    lastly we return an interator to allow the  user
    to iterate through our stack
    */
    @Override
    public Iterator<T> iterator() {
        /*
        This iterator returns an interator for our
        linked list 
        */
        return list.iterator();
    }
    
}
