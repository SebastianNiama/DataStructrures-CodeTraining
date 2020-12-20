
package LinkedList;

import java.util.LinkedList;//Importamos el paquete
import java.util.ListIterator;

public class PruebaLinkedList1 {
    public static void main(String[] args) {
        
        //La construimos:
        /*
        Es una clase generica, en este caso le decimos q ser{a de String
        */
        LinkedList<String> personas = new LinkedList<String>();
        
        //Para agregar elementos:
        personas.add("Pepe");
        personas.add("Sandra");
        personas.add("Ana");
        personas.add("Laura");
        personas.add("Juancho");
        
        /*
        Debemos usar la interfaz ListIterator que maneja este tipo de listas
        y es mejor que el iterator, por sus metodos       
        */
        ListIterator <String> it = personas.listIterator();
        
        it.next();//Solo con esta linea, ya no saltamos una posicionn mas adelante
        /*
        Como ya movi para adelante una posicion, ahora uso el ITERATOR para
        añadir un elemento el cual estará en segunda posicion y no al final
        como defecto. eL ITERATOR se encargara de añadir y remover
        */
        it.add("Henry");
        
        
        
        //Elementos totales de la lista:
        System.out.println("Elementos totales: "+personas.size());
        
        //Imprimo mis elementos:
        for (String persona: personas) {
            System.out.println(persona);
        }
                
        
    }
}
