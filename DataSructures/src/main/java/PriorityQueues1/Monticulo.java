package PriorityQueues1;

import java.util.*;

public class Monticulo <T extends Comparable<T>> {//BINARY HEAP

    private static final int TAMINI = 20;
    private int numElem;
    private T[] v;//xq los elementos necesitan compararse

    public Monticulo() {
        numElem = 0;
        v = (T[])new Comparable[TAMINI];
    }

    //INSERCION O(LOG n)
    /*
    Primero se codifican los métodos que devuelven las posiciones de nodo padre,
    hijo izquierdo e hijo derecho:
     */
    public static int padre(int i) {
        return (i - 1) / 2;
    }

    public static int hijoIzq(int i) {
        return (2 * i + 1);
    }

    public static int hijoDer(int i) {
        return (2 * i + i) + i;
    }

    /*
    El método flotar() realiza el movimiento hacia arriba, en busca de la 
    posición de inserción. Tiene como argumento el índice, i, correspondiente 
    al hueco donde, inicialmente, se encuentra la nueva clave. La comparación 
    entre dicha clave y la del nodo padre, se realiza muy eficientemente, con
    acceso directo al padre. El bucle de búsqueda que realiza el proceso 
    termina cuando la clave del nodo padre es menor o igual
    (v[padre(i)] <= nuevaClave) o bien se ha subido hasta la raíz (i = 0).
     */
    private void flotar(int i) {//Swim

        T nuevaClave = v[i];

        while (i > 0 && (v[padre(i)].compareTo(nuevaClave)) > 0) {
            v[i] = v[padre(i)]; // baja el padre al hueco
            i = padre(i); // sube un nivel en el árbol
        }
        v[i] = nuevaClave; // sitúa la clave en su posición 
    }

    /*
    El método insertar() comprueba que no esté lleno el montículo, asigna la 
    clave en la primera posición libre (hueco), llama a flotar() para que 
    restablezca la condición de ordenación del montículo e incrementa el 
    número de claves. Un montículo lleno no es un problema, ya que se amplía 
    el vector en la cantidad TAMINI. 
     */
    private boolean monticuloLleno() {
        return numElem == v.length;
    }

    private void ampliar() {
        T[] anteriorV = v;
        v = (T[])new Comparable[numElem + TAMINI];
        for (int j = 0; j < numElem; j++) {
            v[j] = anteriorV[j];
        }
    }

    public void insertar(T clave) {
        if (monticuloLleno()) {
            ampliar();
        }
        v[numElem] = clave;
        flotar(numElem);
        numElem++;
    }

    //BUSCAR MINIMO
    public T buscarMinimo() throws Exception {
        if (esVacio()) {
            throw new Exception("Acceso a monticulo vacio");
        }
        return v[0];
    }

    //METODO PARA ELIMINAR LA RAIZ O EL MINIMO
    //Antes de escribir tal metodo, se detalla el metodo criba
    //que sirve para hundir el la nueva raiz que proviene del nodo
    //inferior derecho. Leer materia
    /*
    //se pasa como argumento el índice del elemento
(   raiz que se ha de dejar hundir.
     */
    private void criba(int raiz) {
        boolean esMonticulo;
        int hijo;
        esMonticulo = false;
        while ((raiz < numElem / 2) && !esMonticulo) {
            //Determina el indice del hijo menor
            if (hijoIzq(raiz) == (numElem - 1))//Unico descendiente
                hijo = hijoIzq(raiz);
              else {
                if (v[hijoIzq(raiz)].compareTo(v[hijoDer(raiz)]) < 0) {
                    hijo = hijoIzq(raiz);
                } else  hijo = hijoDer(raiz);           
            }
            // compara raiz con el menor de los hijos
            if (v[hijo].compareTo(v[raiz])<0){
                T t = v[raiz];
                v[raiz] = v[hijo];
                v[hijo] = t;
                raiz = hijo; /* continua por la rama de claves mínimas */
            }else esMonticulo = true;
        }
    }
/*
    El método eliminarMinimo() realiza la operación: extrae la clave raíz y llama a criba()
para restablecer la condición de ordenación.
    */
    public Comparable eliminarMinimo() throws Exception{
        if(esVacio())
            throw new Exception("Acceso a monticulo vacio");
        Comparable menor;
        menor = v[0];
        v[0] = v[numElem-1];
        criba(0);
        numElem--;
        return menor;
    }
    
    public boolean esVacio() {
        return numElem == 0;
    }

}
