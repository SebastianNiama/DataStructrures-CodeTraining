
package BinarySearchTree;
/*
Autor: Henry Niama
*/
import AVL2.TreePrinter;
import BinarySearchTree.ArbolBinarioBusqueda;
import java.util.Scanner;

public class EjecABinarioBusqueda {

    public static void main(String[] args) throws Exception {

        Scanner en= new Scanner(System.in);
        
        ArbolBinarioBusqueda<Integer> miArbolito = new ArbolBinarioBusqueda<>();

        //creo mi Arbolito lindo.
        miArbolito.nuevoArbol(null, 2, null);

        System.out.println("Digite la cantidad de nodos que desea en el ABB: ");
        int n= en.nextInt();
        
        for(int i=0; i<n;){
            System.out.println("Digite valor del nodo "+(i++)+": ");
            miArbolito.insertar(en.nextInt());
        }

        
        /*Cambiar a String en la declaracion del arbol.
        miArbolito.insertar("E");
        miArbolito.insertar("A");
        miArbolito.insertar("D");
        miArbolito.insertar("F");
        miArbolito.insertar("Z");
        miArbolito.insertar("B");
        miArbolito.insertar("C");
        miArbolito.insertar("Q");
*/
        //Muestro arbolito.
        System.out.println("Nuevo arbolito: ");
        System.out.println(TreePrinter.getTreeDisplay(miArbolito.raizArbol()));
        
        
        System.out.println("");
        System.out.println("In-order: ");
        miArbolito.inOrden(miArbolito.raizArbol());
        System.out.println("");
        System.out.println("Pre-order: ");
        miArbolito.preOrden(miArbolito.raizArbol());
        System.out.println("");
                System.out.println("Post-order: ");
        miArbolito.postOrden(miArbolito.raizArbol());
        
        System.out.println("");
        
        //elimino hojitas: 
        System.out.println("Nuevo arbol con 2 hojitas eliminada: ");
        miArbolito.eliminar(7);
        miArbolito.eliminar(3);
        //reemprimo arbol:
        System.out.println(TreePrinter.getTreeDisplay(miArbolito.raizArbol()));
                
    }

}
