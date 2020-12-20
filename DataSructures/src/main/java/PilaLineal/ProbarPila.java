package PilaLineal;

public class ProbarPila {

    public static void main(String[] args) {

        Pila<Integer> miPila = new Pila();

        //Agrego valores
        miPila.push(1);
        miPila.push(2);
        miPila.push(3);
        miPila.push(4);
        miPila.push(5);
        miPila.push(6);
        //Imprimo:
        miPila.show();
        System.out.println("");
        //Quito valores:
        miPila.pop();
        miPila.pop();
        miPila.show();
        //¿Esta vacia?
        System.out.println("\nLa pila esta vacia: "+miPila.isEmpty());
        //¿Esta llena?
        System.out.println("\nLa pila esta llena: "+miPila.isFull());
        //Obtener primer elemento cima:
        System.out.println("\nEl elemento top/cima de la pila es: "+miPila.peekFirst());
        //Vaciado de pila
        System.out.println("\n"+miPila.clearAll());
                   
    }
}
