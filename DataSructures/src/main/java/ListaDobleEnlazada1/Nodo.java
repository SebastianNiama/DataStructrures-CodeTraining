
package ListaDobleEnlazada1;

import java.util.Objects;

/*
Un nodo de una lista doblemente enlazada tiene dos punteros (referencias)
para enlazar con los nodos izquierdo y derecho, además de la parte 
correspondiente al campo dato.
*/
public class Nodo {
    
    public String dato;
    public Nodo siguiente;
    public Nodo anterior;
    
    /*
    El constructor asigna un valor al campo dato y las referencias adelante, 
    atras se  inicializan a null.
    */
    
    public Nodo (String dat, Nodo ant, Nodo sig)
    {
       siguiente =sig;
       anterior = ant;
       dato =dat;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nodo other = (Nodo) obj;
        if (!Objects.equals(this.dato, other.dato)) {
            return false;
        }
        return true;
    }
    

    
    
}
