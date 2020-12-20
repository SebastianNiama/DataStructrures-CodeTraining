/*
Para crear el árbol binario, se utiliza un esquema secuencial y con una
Pila que guarda, en cada paso, los subárboles
 */
package BinaryTrees;

import PilaEnlazada.PilaListaEnlazada;

public class EjecutaArbolBianrio {

    public static void main(String[] args) throws Exception {
        ArbolBinario<String> arbol = new ArbolBinario<>();
        Nodo a1, a2, a;

        PilaListaEnlazada pila = new PilaListaEnlazada();
        
        //Primero guardo los subarboles
        a1 = arbol.nuevoArbol(null, "Maria", null);//Hijo descendiente
        a2 = arbol.nuevoArbol(null, "Rodrigo", null);//Hijo descendiente
        a = arbol.nuevoArbol(a1, "Esperanza", a2);//Subraiz
        pila.insertar(a);//guardo en la pila al subarbol.
        
        //Gardo segundo subarbol
        a1 = arbol.nuevoArbol(null, "Anyora", null);
        a2 = arbol.nuevoArbol(null, "Abel", null);
        a = arbol.nuevoArbol(a1, "M jesus", a2);
        pila.insertar(a);
        
        //Ahora quito los subarboles de la pila y los alado a la RAIZ
        a2 = (Nodo) pila.quitar();//SubArbol 1
        a1 = (Nodo) pila.quitar();//SubArbol 2
        a = arbol.nuevoArbol(a1, "Esperanza", a2);//Los añado a la raiz
        arbol = new ArbolBinario(a);//Creo mi arbol.
        
       arbol.preOrden(a);
        System.out.println("Numero de nodos en el arbol : "+arbol.numNodos(a));
       
    }

}
