
package PilaLineal;

import java.util.EmptyStackException;

public class Pila <T>{    
    //Declaro mis atributos propios de la Pila:
    private static final int  TAMANO = 19;//Mi tamaño
    private Object arreglo[];
    private static int cima;   
    //Inicializo mi Pila vacía:
    public Pila(){
        arreglo = new Object[TAMANO];
        cima =-1;//Cuando la pila esta vacia     
    }
    //Metodo para insertar
    public void push(T valor){
        if(!isFull()){//Si la pila no esta llena
            arreglo[++cima] = valor;//Incremento cima y agrego al array
        }else{
            throw new StackOverflowError("Pila llena");//Sobrecarga de elementos
        }
    }
    //Metodo para quitar la cima
    public T pop(){
        T dato;
        if(isEmpty()) throw  new EmptyStackException();
        else{
            dato = (T) arreglo[cima];
            arreglo[cima]=0; //Limpio la memoria
            cima--;
            return dato;
        }            
    }
    //Metodo para devolver el valor que esta en la cima de la pila:
    public T peekFirst(){
        if(isEmpty()) throw  new EmptyStackException();
        return (T) arreglo[cima];          
    }    
    //Metodo para limpiar toda la pila
    public String clearAll(){
        if(isEmpty()) throw  new EmptyStackException();
        else{
            while(!(cima==-1)){
                arreglo[cima--]=0;
            }
            return "Se ha vaciado la pila.";
        }
    }
    //Metodo para imprimir los valores de la Pila:
    public void show(){
        if(isEmpty()) throw  new EmptyStackException();
        else{
            for(int i=0; i<= cima;){
                System.out.print("|"+arreglo[i++]);
            }
            System.out.print("|");
        }
    }
    //Metodos que comprueban estados de la Pila:
    public boolean isEmpty(){
        return cima==-1;
    }
    public boolean isFull(){
        return cima ==TAMANO;
    }
    
}
