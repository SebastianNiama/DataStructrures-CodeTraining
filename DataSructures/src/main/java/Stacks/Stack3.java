
package Stacks;
//Pila con array estaticos
public class Stack3 {
    
    private int stack[]= new int[5];
    private int top =0;
    
    
    public void push(int data){
        if(top ==5){
            System.out.println("Stack is full");
        }
        
        stack[top] = data;
        top++;
    }
    
    public int pop(){
      int data = -1;
      
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
             top--;
         data = stack[top];
        stack[top] =0;
        }
        
       
        return data;
    }
    
     public int peek(){
      
        int data = stack[top-1];  
        return data;
    }
    
     public int size(){
         return top;
     }
     
     public boolean isEmpty(){
         return top <=0;
     }
     
    public void show(){
        for(int n:stack){
            System.out.println(n+ " ");
        }
        System.out.println("");
    }
            
            
}
