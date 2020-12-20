//La clase nodo siemrpe contiene 2 cosntructores
package BinaryTrees;
import AVL2.TreePrinter.PrintableNode;

public class Nodo <T extends Comparable<T>> implements PrintableNode{
    
     protected T dato;
     protected Nodo izq;
     protected Nodo der;
     
     //El 1ero indica que es una hoja
     public Nodo(T valor){
         dato = valor;
         izq = der = null;
     }
     
     //El 2do indica que es un nodo interno con subarboles en sus ramas
     public Nodo(Nodo ramaIzdo, T valor, Nodo ramaDcho){
         dato = valor;
         izq = ramaIzdo;
         der = ramaDcho;         
     }
     
     //Metodos:
     
     /*
     La visita al nodo se representa mediante la llamada 
     al método de Nodo, visitar(). ¿Qué hacer en el método? 
     Depende de la aplicación que se esté realizando. 
     Si simplemente se quieren listar los nodos, puede 
     emplearse la siguiente sentencia:
     */
     public void visitar(){
         System.out.println(dato+" ");
     }
     
     public Nodo subArbolIzq(){return izq;}
               
     public Nodo subArbolDcho(){return der;}
             
     public T valorDelNodo(){return dato;}
     
     public void nuevoValor(T b){dato = b;}
     
     public void ramaIzdo(Nodo n){izq = n;}
     
     public void ramaDcho(Nodo n){der = n;}

    @Override
    public PrintableNode getLeft() {
        return izq;
    }

    @Override
    public PrintableNode getRight() {
        return der;
    }

    @Override
    public String getText() {
        return dato.toString();
    }
     
         
     
}
