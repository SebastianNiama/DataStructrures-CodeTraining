
package EjercicioPila1;
/*
Esta clase va a ayudar a crear nuevos nodos cuando el usuario ingrese
un nuevo valor.
*/
public class Nodo {
    
    /*
    Como se sabe un nodo contiene 2 campos.
    */
    int informacion; //Primer campo: Declaro como entero por que guardaré enteros
    Nodo siguiente;//2do campo: El apuntador, creo un objeto del tipo nodo.
    
    /*
    Se crea un constructor:
    Va a ayudar a guardar lo que contiene cada nodo.
    Entonces, cada ves que el usuario guarde un valor, se lo va a recibir a través de
    este constructor.  
    Y esto lo vamos a lograr gracias a un parametro tipo entero que se va a nombrar
    "valor".
    */
    public Nodo(int valor){
        informacion=valor; //Guardamos en infor. El valor q ha digitado el usuario.
         siguiente = null; //Indicamos que el apuntador debe tener un inicio de valor nulo.     
    }
    
    
}
