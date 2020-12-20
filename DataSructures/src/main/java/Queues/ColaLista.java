//COLA CON LISTA ENLAZADA
package Queues;


import java.util.Iterator;

public class ColaLista <T> implements Iterable<T>{

    //Atributos de acceso:
    protected Nodo<T> frente;
    protected Nodo<T> fin;
    //Constructor que crea la cola vacia:
    public ColaLista(){
        frente = fin = null;//Cola vacia
    }
    //Insertar elemento al final de la cola:
    public void insertar(T elemento){
        Nodo <T>a;
        a = new Nodo(elemento);
        if(colaVacia()){
            frente =a;
        }else{
            fin.siguiente = a;
        }
        fin =a;
    }
    //Quitar sale el elemento frente;
    public T quitar() throws Exception{
        T aux;
        if(!colaVacia()){//Si la cola no esta vacia
            aux = frente.elemento;
            frente = frente.siguiente;
        }else{
            throw new Exception("No se puede eliminar de una cola vacia.");
        }
        return aux;   
    }
    //Liberar todos los nodos de la cola:
    public void borrarCola(){
        for(; frente != null;){
            frente = frente.siguiente;
        }
        System.gc();
    }
    //Acceso al primero de la cola
    public T frenteCola() throws Exception{
        if(colaVacia()){
            throw new Exception("Error: cola vacía.");
        }
        return (frente.elemento);
    }
    
    public boolean colaVacia(){
        return(frente == null);
    }
    
     @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
          
            private Nodo <T> trav = frente;
            
            @Override
            public boolean hasNext(){
                return trav !=null;
            }
            @Override
            public T next(){
                T data = trav.elemento;
                trav = trav.siguiente;
                return data;
            }
        };
    }
}

     class Nodo <T>{
        T elemento;
        Nodo <T> siguiente;//Enlace con el siguiente nodo.
        public Nodo(T dato){
            elemento = dato;
            siguiente = null;
        }
    }