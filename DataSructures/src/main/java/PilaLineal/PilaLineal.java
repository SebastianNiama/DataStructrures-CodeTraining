/*
Tipo de PILA LINEAL implementada con array estatico, ver definicions y conceptos
en el word de la materia.
 */
package PilaLineal;
import java.io.*;
import java.util.EmptyStackException;
public class PilaLineal <T> {
    
    private static final int TAMPILA = 49;//50
    private int cima;//Puntero de la pila
    private Object [] listaPila;
    
    public PilaLineal(){
        
        cima =-1;//Condicion de pila vacia
        listaPila = new Object [TAMPILA];
        
    }
    //Operaciones que modifican la pila:
    public void insertar(T elemento){
        if(pilaLlena()){
            throw new StackOverflowError();
        }else{
            cima++;
            listaPila[cima]= elemento;       
        }   
    }
    
    public  T quitar(){
        if(pilaVacia()){
            throw  new EmptyStackException();
        }else{            
            T data = (T) listaPila[cima];
            listaPila [cima] = 0;//Limpio
            cima--;
            return data;
        }
    }
    public void limpiarPila(){
        if(pilaVacia()){
            throw new EmptyStackException();
        }else{
            for (int i = 0; i <= cima; i++) {
                listaPila[i]=0;
            }
            cima=-1;
        }
    
    }
   
    //Operacion de acceso a la pila:
    public T cimaPila(){
        if(pilaVacia()) throw new EmptyStackException();
        
        return (T)listaPila[cima];
    }
    //Verificacion de estado de pila
    public boolean pilaVacia(){
        return cima ==-1;
    
    }
    public boolean pilaLlena(){
           return cima == TAMPILA;        
    }
    public void mostrarDatos(){
        if(pilaVacia()){
            throw new EmptyStackException();
        }else{
            for (Object tipoLista : listaPila) {
                System.out.print("["+tipoLista+"] ");
            }
        }
        
    }
    
}
