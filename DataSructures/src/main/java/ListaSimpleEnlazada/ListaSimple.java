package ListaSimpleEnlazada;

public class ListaSimple<T> {

    private Nodo inicio;
    private Nodo fin;
    private int tamagno;

    public ListaSimple() {
        inicio = null;
        fin = null;
        tamagno = 0;
    }

    public void addFirst(T info) {
        Nodo nuevo = new Nodo(info, inicio);

        inicio = nuevo;

        if (fin == null) {
            fin = inicio;
        }
        tamagno++;
    }

    public void add(T info) {

        Nodo nuevo = new Nodo(info, null);//Nodo final, apunta a nulo

        if (inicio == null) {
            fin = inicio = nuevo;
            tamagno++;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            tamagno++;
        }
    }

    public void addAt(int i, T info) {

        if (i == 0) {
            addFirst(info);
        } else if (i > tamagno) {
            throw new IndexOutOfBoundsException("Indice fuera de limite");
        } else {
            Nodo nuevo = new Nodo(info, null);//Nodo final, apunta a nulo
            Nodo temp = inicio;
            int k = 0;
            for (; k < i - 1; k++) {
                temp = temp.getSiguiente();
            }
            nuevo.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(nuevo);
            tamagno++;
        }

    }

    public T getAt(int i) {
        if (i == 0) {
            return peekFirst();
        } else if (i > tamagno) {
            throw new IndexOutOfBoundsException("Indice fuera de limite");
        } else {
            Nodo temp = inicio;
            int k = 0;
            for (; k < i; k++) {
                temp = temp.getSiguiente();
            }
            return (T) temp.getInfo();
        }
    }

    public T peekFirst() {
        T info = (T) inicio.getInfo();
        return info;
    }

    public T removeFirst() {

        T info = (T) inicio.getInfo();
        inicio = inicio.getSiguiente();

        if (inicio == null) {
            fin = null;
        }
        tamagno--;
        return info;
    }

    public T removeAt(int i) {

        if (i == 0) {
            return removeFirst();
        } else if (i > size()) {
            throw new IndexOutOfBoundsException("Indice fuera de limite");
        } else {
            Nodo temp = inicio;
            Nodo temp2 = null;
            T valor;
            int k = 0;
            for (; k < i-1; k++) {
                temp = temp.getSiguiente();
            }
            temp2 = temp.getSiguiente();
            
            valor = (T) temp2.getInfo();
            temp.setSiguiente(temp2.getSiguiente());
            temp2=null;
            tamagno--;
            return valor;
        }

    }

    public void show() {
        Nodo temp = inicio;

        while (temp != null) {
            System.out.println(temp.getInfo());
            temp = temp.getSiguiente();
        }

    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int size() {
        return tamagno;
    }
}
