/*
Crear una lista de números aleatorios. Insertar los nuevos nodos por la cabeza de la lista. Un vez
creada la lista, se han de recorrer los nodos para mostrar los número pares.
Desde el método main() se crea un objeto
Lista, se llama iterativamente al método que añade nuevos elementos, y por último se llama a
visualizar() para mostrar los elementos.
 */
package LinkedList;

import java.util.Random;

public class Ejercicio1 {
    
    private class Nodo{
        int data;
        Nodo next;
        public Nodo(int data){
            this.data = data;
            next =null;
        }      
        public int getData(){
            return data;
        }
        public Nodo getNext(){
            return next;
        }
        public void setNext(Nodo n){
            this.next = n;
        }
    }
    
    private Nodo first;
    
    public Ejercicio1(){
        first = null;
    }
    
    public Ejercicio1 addFisrt(int data){
        Nodo nuevo = new Nodo(data);
        nuevo.next = first;
        first = nuevo;
        return this;               
    }
    
    public void show(){
        Nodo n;
        int  k =0;
        
        n= first;
        
        System.out.print("[");
        while(n !=null){
            System.out.print(n.data+", ");
            n = n.next;      
            k++;
            System.out.print( (k%15 != 0 ? " " : "\n"));
        }
        System.out.print("]");     
    }
    
    public static void main(String[] args) {
        Random r;
        int d, k;
        Ejercicio1 lista;
        
        r = new Random();
        lista = new Ejercicio1(); //Creo lista vacia
        k = Math.abs(r.nextInt()%55); //Numero de nodos
        //Se insertan elementos en la lista:
        for(; k>0; k--){
            d = r.nextInt() %99;
            lista.addFisrt(d);
        }
        
        //// recorre la lista para escribir sus elementos
        System.out.println("Elementos de la lista generados al azar");
        lista.show();
    }
}
