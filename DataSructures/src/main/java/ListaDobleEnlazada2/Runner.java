package ListaDobleEnlazada2;

public class Runner {

    public static void main(String[] args) {

        ListaDoble<Integer> miLista = new ListaDoble<Integer>();

        // miLista.addFirst(8);
        miLista.add(3);
        miLista.addFirst(2);
        miLista.add(4);
        miLista.add(5);
        miLista.add(6);
        
        System.out.println("Lista Impresa: "+miLista.toString());      
        System.out.println("Tamaño de la lista; " + miLista.size());
        System.out.println("¿Esta vacia? " + miLista.isEmpty());
        System.out.println("Primer elemento de la lista: "+miLista.getFirst());
        System.out.println("Ultimo elemento de la lista: "+miLista.getLast()); 
        miLista.removeFirst();
        System.out.println("Lista actualiazada: "+miLista.toString());  
        miLista.removeLast();
        System.out.println("Lista actualiazada: "+miLista.toString()); 
        miLista.removeAt(0);
        System.out.println("Lista actualiazada: "+miLista.toString()); 
      
    }
}
