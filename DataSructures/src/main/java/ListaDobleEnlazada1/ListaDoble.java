package ListaDobleEnlazada1;

/*
Esta clase ListaDoble encapsula las operaciones básicas de las listas 
doblemente enlazadas.
 */
public class ListaDoble {

    private Nodo inicio;
    private Nodo fin;

    public ListaDoble() {
        inicio = fin = null;
    }

    public void insertarInicio(String dato) {

        if (inicio == null) {
            inicio = new Nodo(dato, null, null);
            fin = inicio;

        } else {//Osea q ya tengo elementos en la lista 
            Nodo nuevo = new Nodo(dato, null, inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }

    }

    public void insertarFin(String dato) {

        if (inicio == null) {
            fin = new Nodo(dato, null, null);
            inicio = fin;

        } else {//Osea q ya tengo elementos en la lista 
            Nodo nuevo = new Nodo(dato, fin, null);
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

    }

    public String extraerInicio() {
        String dato = inicio.getDato();
        inicio = inicio.getSiguiente();//Da un salto
        if (inicio != null) {
            inicio.setAnterior(null);//Lo borra
        } else {
            fin = null;
        }

        return "Dato del inicio eliminado: " + dato;

    }

    public String extraerFin() {
        String dato = fin.getDato();
        fin = fin.getAnterior();//Da un salto
        if (fin != null) {
            fin.setSiguiente(null);
        } else {
            inicio = null;
        }

        return "Dato del final eliminado: " + dato;

    }

    public void mostrarAdelante() {

        Nodo temp = inicio;

        while (temp != null) {
            System.out.println(temp.getDato());
            temp = temp.getSiguiente();//saltar
        }
    }

    public void mostrarRegreso() {

        Nodo temp = fin;

        while (temp != null) {
            System.out.println(temp.getDato());
            temp = temp.getAnterior();//saltar
        }

    }
    
    public Boolean buscar(String dato){
        Nodo temp = inicio;// o fin

        while (temp != null) {
            
            if(temp.getDato().equals(dato)){
                return true;
            }
            
            temp = temp.getAnterior();//saltar
        }
        return false;
    }

}
