/*
Esta clase va a ayudar a crear nuevos nodos, cada ves que el usuario
introduzca un nuevo valor.
 */
package EjercicioPila2;

public class Nodo {
    
     int informacion;
     Nodo siguiente;
    /*
    EL constructor nos va a ayudar a guardar lo que contiene cada Nodo
    */
    public Nodo(int valor){
        informacion = valor;
        siguiente = null;//EL apuntador de inicio es nullo
    }
}
