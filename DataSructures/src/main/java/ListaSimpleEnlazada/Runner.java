
package ListaSimpleEnlazada;

public class Runner {
    
    public static void main(String[] args) {
        
        ListaSimple lista = new ListaSimple();
        
        lista.addFirst("a");
        lista.add("b");
        
        lista.show();
        System.out.println("");
        
        System.out.println("El primer elemento es: "+lista.peekFirst());
        System.out.println("Remuevo el primero: "+lista.removeFirst());
        System.out.println("Agrego mas elementos: ");
        lista.add("e");
        lista.add("f");
        lista.show();
        System.out.println("Agrego g en la posicion 2");
        lista.addAt(2, "g");        
        lista.show();    
        System.out.println("Ahora, remuevo el primer elemento "+lista.removeFirst());
        lista.show();
        System.out.println("Busco el elemento en la posicion 1: "+lista.getAt(1));
        lista.show();
        System.out.println("Remuevo elemento en la pisicion 1: "+lista.removeAt(1));
        lista.show();
        System.out.println("El tamaño de la lista es: "+lista.size());
    
    }  
}
