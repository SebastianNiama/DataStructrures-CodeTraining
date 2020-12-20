package ListaSimpleEnlazada;

public class Nodo <T>{

    private T info;
    private Nodo siguiente;

    public Nodo(T i, Nodo s) {
        info = i;
        siguiente = s;

    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
