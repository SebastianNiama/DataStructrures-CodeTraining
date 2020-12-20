
package PilaEnlazada;
import Stacks.Stack1;
import Stacks.Stack1;
public class EjecPilaListaEnlaza {
    public static void main(String[] args) throws Exception {
        PilaListaEnlazada pila1 = new PilaListaEnlazada();
        PilaListaEnlazada pila2 = new PilaListaEnlazada();
        
        
        
        System.out.println("Pila 1: ");
        pila1.insertar(1);
        pila1.insertar(2);
        pila1.insertar(3);
        pila1.insertar(4);
        pila1.insertar(5);
        pila1.insertar(6);
        pila1.insertar(7);
        pila1.quitar();
        pila1.mostrar();
        
        System.out.println("");
        System.out.println("Pila 2:");
        pila1.copiarPila(pila1, pila2);
        pila2.mostrar();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Pila Adicional: ");
        PilaAdicional miPila = new PilaAdicional();
        miPila.push(3);
        miPila.push(4);
        miPila.push(5);
        miPila.push(1);
        miPila.push(2);
        miPila.mostrar();
        System.out.println("Minimo; "+miPila.minimo());
        
        System.out.println("Ordenar elemento de Pila: ");
        Stack1<Integer> pilaO = new Stack1<>();
        pilaO.push(3);
        pilaO.push(8);
        pilaO.push(5);
        pilaO.sort(pilaO);
        pilaO.show();
        
        
        
        
        
        
    }
}
