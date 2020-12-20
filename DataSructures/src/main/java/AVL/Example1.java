/*Ejemplo 1:
Se tienen n claves que se van a organizar jerárquicamente formando un árbol equilibrado.
Escribir un programa para formar el árbol AVL siguiendo la estrategia de los árboles de
Fibonacci descrita en la sección anterior.
En este ejercicio el árbol no va a ser de búsqueda, simplemente un árbol binario de números
enteros, generados aleatoriamente
 */
package AVL;

import java.io.*;
import BinaryTrees.ArbolBinario;//Arbol binario normal
import BinaryTrees.Nodo;//El nodo de un arbol binario.

public class Example1 {
    
    public static final int TOPEMAX = 29;
    
    public static void main(String[] args) throws IOException {
        
        ArbolBinario arbolFib;
        int n;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        do{
            System.out.println("Numero de nodos del arbol: ");
            n = Integer.parseInt(entrada.readLine());
          
        }while(n<=0);
          
        arbolFib = new ArbolBinario(arbolFibonacci(n));
        System.out.println("Árbol de Fibonacci de máxima altura:");
        dibujarArbol(arbolFib.raizArbol(), 0);
        
    } 
    
    // método recursivo que genera el árbol de Fibonacci
    public static Nodo arbolFibonacci(int n){
        int nodosIz, nodosDr;
        Integer clave;
        Nodo nuevoRaiz;
        
        if(n ==0){
            return null;
        }else{
            nodosIz = n/2;
            nodosDr = n- nodosIz-1;
            //nodo raíz con árbol izquierdo y derecho de Fibonacci
            clave = (int)(Math.random()*TOPEMAX)+1;//Un valor aleatorio
            //se van creando los nodos aleatoriamente:
            nuevoRaiz = new Nodo(arbolFibonacci(nodosIz), clave, arbolFibonacci(nodosDr));
            
            return nuevoRaiz;
        }
    }
    
    // Método de escritura de las claves del árbol
    static void dibujarArbol(Nodo r, int h){
        /*
        escribe las claves del arbol de fibonacci; h estable
        una separacion entre nodos
        */      
        if(r != null){
            dibujarArbol(r.subArbolIzq(), h+1);
            for(int i =1; i<=h; i++) System.out.println(" ");
            
            System.out.println(r.valorDelNodo());
            dibujarArbol(r.subArbolDcho(), h+1);
        }
        
    }
}
