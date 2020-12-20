package PilaEnlazada;

import java.util.EmptyStackException;

public class PilaListaEnlazada {

    private class NodoPila {

        Object elemento;
        NodoPila siguiente;

        public NodoPila(Object x) {
            elemento = x;
            siguiente = null;
        }
    }

    private NodoPila cima; //dirección de referencia al primer nodo de la lista.

    public PilaListaEnlazada() {
        /*
        El constructor inicializa la pila vacía (cima = null),
        realmente, a la condición de lista vacía. 
         */
        cima = null;
    }

    //Operaciones
    //Verificación del estado de la pila
    public boolean pilaVacia() {
        return cima == null;
    }

    //Poner un elemento en la pila
    public void insertar(Object elemento) {
        NodoPila nuevo;
        nuevo = new NodoPila(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    //Eliminación del elemento cima
    public Object quitar() throws Exception {
        if (pilaVacia()) {
            throw new Exception("Pila vacía, no se puede extraer.");
        }

        Object aux = cima.elemento;
        cima = cima.siguiente;
        return aux;

    }

    //Obtención del elemento cabeza o cima de la pila, sin modificar la pila:
    public Object cimaPila() throws Exception {
        if (pilaVacia()) {
            throw new Exception("Pila vacia no se puede leer la cima.");
        }

        return cima.elemento;
    }

    //Vaciado de la pila.
    public void limpiarPila() {
        NodoPila t;
        while (!pilaVacia()) {
            t = cima;
            cima = cima.siguiente;
            t.siguiente = null;
        }
    }

    //imprimir valores de pila:
    public void mostrar() throws Exception {

        if (pilaVacia()) {
            throw new Exception("No existen elementos.");
        }

        NodoPila T = cima;
        while (T != null) {
            System.out.println(T.elemento);
            T = T.siguiente;
        }

    }

    //Copiar de una pila a otra mi llave:
    public void copiarPila(PilaListaEnlazada p1, PilaListaEnlazada p2) throws Exception {

        if (pilaVacia()) {
            throw new Exception("No existen elementos.");
        }

        Object valores1[] = new Object[100];
        Object valores2[] = new Object[100];
        int i;

        NodoPila T = p1.cima;

        for (i = 0; T != null; i++) {
            valores1[i] = T.elemento;
            T = T.siguiente;
        }
        
        System.arraycopy(valores1, 0, valores2, 0, i);
        i--;

        for (int j = 0; j < valores1.length && i >= 0; j++) {
            valores2[j] = valores1[i];
            p2.insertar(valores2[j]);
            i--;
        }

    }
    
}

class PilaAdicional extends PilaListaEnlazada{
    
    PilaListaEnlazada pilaX;
    
    public PilaAdicional(){
        pilaX = new PilaListaEnlazada();
    }
    
   
    public void push(int valor) throws Exception{
        if(valor <= minimo() ){
            pilaX.insertar(valor);
        }
        super.insertar(valor);
    }
    
    public Integer pop() throws Exception{
        int value = (int) super.quitar();
        
        if(value == minimo()){
            pilaX.quitar();            
        }   
        return value;
    }
    
    
    public int minimo() throws Exception{
        if(pilaX.pilaVacia()) return Integer.MAX_VALUE;   //Esta linea es la clave.    
        else return (int) pilaX.cimaPila();
    }
}

