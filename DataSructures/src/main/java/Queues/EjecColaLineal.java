
package Queues;

public class EjecColaLineal {
    public static void main(String[] args) throws Exception {
        
        ColaLineal<Integer> miCola = new ColaLineal<>();
        
        miCola.insertar(2);
        miCola.insertar(3);
        miCola.insertar(4);
        miCola.mostrarCola();
        System.out.println("");
        System.out.println("Numero quitado: "+miCola.quitar());
        miCola.mostrarCola();
        
        System.out.println("");
        System.out.println("");
        
        
        
        /*OJO              
        int i =0;
        int lista[] ={2,3,4};
        System.out.println(lista[i++]);
        System.out.println(lista[i++]);
        */
    }
}
