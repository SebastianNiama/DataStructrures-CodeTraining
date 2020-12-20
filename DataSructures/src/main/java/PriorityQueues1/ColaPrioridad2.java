//Se podria decir que se usa una lista enlazada de colas:
/*
La forma mas sencilla de implementar una cola de prioridades es mediante una 
Lista Enlazda de objetos (Tareas)(que debe implementar Comparable) ordenada
respecto a la prioridad del objeto. 
La lista enlazada se organiza de tal forma que
un elemento x precede a y si:
1. Prioridad(x) es mayor que Prioridad(y).
2. Ambos tienen la misma prioridad, pero x se añadió antes que y.
Con esta organización, siempre el primer elemento del vector es el elemento de 
la cola de prioridades de máxima prioridad y el último elemento es el de menor 
prioridad y, por consiguiente, el último a procesar. La clase que se declara 
para representar la cola de prioridades(esta) define la lista, y su constructor
inicializa la estructura. Ahora, no es necesario establecer el número máximo de
prioridades.
*/
package PriorityQueues1;
import java.util.LinkedList;

public class ColaPrioridad2 {
    
    //Declaro lista enlazada en ves de array estatico
    protected LinkedList<Tarea> miLista;
    
    public ColaPrioridad2(){
        miLista = new LinkedList<>();//la inicializo
    }
    
    // INSERTAR:
    /*
    La nueva tarea de la cola de prioridades se añade en la posición que le 
    corresponda, teniendo encuenta la prioridad de ésta. Es necesario recorrer 
    la Lista hasta encontrar la posición, p, de un elemento (tarea) cuya 
    prioridad sea menor. A continuación, se inserta en p la tarea.
    */
    
    public void insertarEnPrioridad(Tarea t) throws Exception{
       if(t.numPrioridad() <0) 
           throw new Exception("Tarea con prioridad fuera de rango.");
       //busqueda de la posicion de insrecion
       Tarea a;
       int p =0;
       int n= miLista.size();
       while(p<n){
           a = (Tarea) miLista.get(p);
           if(a.numPrioridad()<= t.numPrioridad()) p++;
           else n = p-1;
       }
       miLista.add(p, t);//Elementos psoteriores son desplazados
    }
    
    //DEVOLVER ELEMENTO DE MAXIMA PRIORIDAD
    //La complejidad de la operación elementoMin es constante.
    public Tarea elementoMin() throws Exception{
        if(colaPrioridadVacia())
            throw new Exception("Cola de prioridades vacia.");
        return (Tarea) miLista.get(0);
    }
    //ELIMINA Y DEVUELVE EL PRIMER ELEMENTO
    //La operación quitarMin es de complejidad lineal 
    public Tarea quitarMin() throws Exception{
        if(colaPrioridadVacia())
            throw new Exception("Cola de prioridades vacia.");
        Tarea a= (Tarea)miLista.get(0);
        miLista.remove(0);
        return  a;
    }
    
    public boolean colaPrioridadVacia(){
        return miLista.size()==0;
    }
}
