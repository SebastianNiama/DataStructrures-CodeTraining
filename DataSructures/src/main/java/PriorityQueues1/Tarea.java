package PriorityQueues1;

import java.util.*;

public class Tarea<T extends Comparable<T>> {

    /*
    Campos item y prioridad, para representar un objeto
    de la cola de prioridades:
     */
    protected T item;
    protected int prioridad;

    public Tarea(T item, int prioridad) {
        this.item = item;
        this.prioridad = prioridad;
    }

    public int numPrioridad() {
        return prioridad;
    }

}
/*
Se supone que la máxima prioridad es 0 y la mínima, maxPrioridad. También,
que hay una correspondencia biunívoca entre el índice de la tabla y el ordinal 
de la prioridad. 
*/
