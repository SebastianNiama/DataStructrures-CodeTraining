
package Stacks;
//Pila con nodo a mano

import java.util.EmptyStackException;


public class Stack1 <T>{
    
    private static class StackNode<T>{
        private T data;
        private StackNode <T> next;
        
        public StackNode(T data){
            this.data = data;
        }
    }
    
    private StackNode <T> top;
    private int size =0;
    
    public T pop(){
        if(top == null) throw new EmptyStackException();
         T item = top.data;   
        top = top.next;
        size--;
        return  item;      
    }
    
    public void push(T item){
        StackNode<T> myNew= new StackNode<>(item);
        myNew.next = top;
        top = myNew;
        size++;
    }
    
    public T peek(){
        if(top ==null) throw  new EmptyStackException();
        return top.data;
    }
    
    public boolean isEmpty(){
        return top ==null;
    }
        
     public void show(){
         String Lista="";
        StackNode<T> recorrido = top;
        while(recorrido != null){
            Lista += recorrido.data + "\n";
            recorrido = recorrido.next;
        }
         System.out.println(Lista);
        Lista = "";
    }
            
    public int size(){
        return  size;
    }
    
    public void sort(Stack1<Integer> s){
        Stack1<Integer> r = new Stack1<Integer>();
        while (!s.isEmpty()) {
            //Insert each element in s in sorted order into r.
            int temp = s.pop();
            while(!r.isEmpty() && r.peek() > temp){
                s.push(r.pop());
            }
            r.push(temp);           
        }
        //Copy the elements from r back into s
        while(!r.isEmpty()){
            s.push(r.pop());
        }
    }
}
