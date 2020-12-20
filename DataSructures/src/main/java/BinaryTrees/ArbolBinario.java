
package BinaryTrees;

public class ArbolBinario <T extends Comparable<T>>{  
    /*
    A partir del nodo raíz de un árbol se puede acceder a los
    demás nodos del árbol, por ello se mantiene
    la referencia a la raíz del árbol.
    */
    protected Nodo raiz;
    
    //Constructor que inicializa raiz:
    public ArbolBinario(){
        raiz = null;
    }
    
    public ArbolBinario(Nodo raiz){
        this.raiz = raiz;
    }
    
    //Metodos que implementan las operaciones:
    public Nodo raizArbol(){
        return raiz;
    }
    
    public boolean esVacio(){
        return raiz == null;
    }
    
    //El método nuevoArbol() crea un árbol de raíz un nodo con el 
    //campo dato, rama izquierda y derecha pasadas en los argumentos. 
    public  Nodo nuevoArbol(Nodo ramaIzq, T dato, Nodo ramader){
        return new Nodo(ramaIzq, dato, ramader);
    }     
    
    /*METODOS DE RECORRIDO DE UN ARBOL BINARIO
    Tienen como argumento el nodo raíz del subárbol que se recorre  
    */
    
    //Recorrido de un arbol binario en preOrden
    public void preOrden(Nodo r){
        if(r != null){
            r.visitar();
            preOrden(r.subArbolIzq());
            preOrden(r.subArbolDcho());
        }
    }
    
    //Recorrido de un arbol binario en inOrden
    public void inOrden(Nodo r){
        if(r !=null){
            inOrden(r.subArbolIzq());
            r.visitar();
            inOrden(r.subArbolDcho());
        }
    }
    
    //Recorrido de un arbol binario en postOrden
    public void postOrden(Nodo r){
        if(r !=null){
            postOrden(r.subArbolIzq());
            postOrden(r.subArbolDcho());
            r.visitar();
        }
    }
    
    //CONTAR NUMERO DE NODOS EN EL ARBOL:
    public int numNodos(Nodo raiz){
        if(raiz == null) return 0;
        else //Eñ 1 es el de la raiz principal
            return 1+ numNodos(raiz.subArbolIzq()) + numNodos(raiz.subArbolDcho());
    }
    
    
}
