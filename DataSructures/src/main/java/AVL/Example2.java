/*
Se desea formar un árbol binario de búsqueda equilibrado de altura 5. El campo dato de cada
nodo debe ser una referencia a un objeto que guarda un número entero que será la clave de
búsqueda. Una vez formado el árbol, mostrar las claves en orden creciente y el número de nodos
de que consta el árbol.
 */
package AVL;

public class Example2 {//Clase principal
    static final int TOPEMAX = 999;
    
    public static void main(String [] a) throws Exception{
        
        ArbolAvl avl = new ArbolAvl();
        Numero elemento;
        int numNodos;
        
        while(altura(avl.raizArbol())<5){
            elemento = new Numero((int)(Math.random()*TOPEMAX)+1);
            avl.insertar(elemento);
        }      
        numNodos = visualizar(avl.raizArbol());
        System.out.println("\n Número de nodos: " + numNodos);     
    }
    
    static int visualizar(NodoAvl r){//Escribir claves de arbol     
        if(r != null){
             int cuantosIzquierda, cuantosDerecha;       
             cuantosIzquierda = visualizar((NodoAvl)r.subArbolIzq());
             System.out.println(r.valorDelNodo()); 
             cuantosDerecha = visualizar((NodoAvl)r.subArbolDcho());
             return cuantosIzquierda + cuantosDerecha +1;                     
         }else{
            return 0;
        }     
    }
    
    static int altura(NodoAvl r){//calcula y devuelve la altura 
        if(r!=null){
            return mayor(altura((NodoAvl)r.subArbolIzq()), altura((NodoAvl)r.subArbolDcho())+1);
        }else{return 0;}
    }
    
    static int mayor(int x, int y){
        return(x>y ? x: y);
    }
    
}

class Numero implements Comparable<Numero>{

    int valor;
    
    public Numero(int n){
        valor = n;
    }
    
    public String toString(){
        return " "+ valor;
    }
    
    
    @Override
    public int compareTo(Numero o) {
         if(this.valor < o.valor){
             return -1;
         }else if(this.valor > o.valor){
             return 1;
         }else {
             return 0;
         }
    }
    
}
