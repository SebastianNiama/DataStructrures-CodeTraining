/*
La estructura del nodo en un árbol equilibrado, es una extensión de la declarada para un
árbol binario. Para determinar si el árbol está equilibrado debe manejarse información relativa al
balanceo o factor de equilibrio de cada nodo. Por esa razón, se añade al nodo un campo más: el
factor de equilibrio (fe). Este campo puede tomar los valores: -1, 0, +1.
 */
package AVL;

import BinaryTrees.Nodo;

public class NodoAvl <T extends Comparable<T>> extends Nodo{
    
    int fe;
    
    public NodoAvl(T valor) {
        super(valor);
        fe=0;
    }
    
    public NodoAvl(T valor, NodoAvl ramaIzdo, NodoAvl ramaDcho){
        super(ramaIzdo, valor, ramaDcho);
        fe=0;
    }
    
}
