/*
La clase Vertice representa un nodo del grafo, con su nombre (String) y 
número asignado. El constructor inicializa el nombre y pone como número
de vértice -1; el método que añade el vértice al grafo establece el 
número que le corresponda.
 */
package GrafosMatrizAdyacencia;

public class Vertice {

    String nombre;
    int numVertice;

    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
    }

    public String nombreVertice() { // devuelve identificador del vértice
        return nombre;
    }

    public boolean equals(Vertice n) {  // true, si dos vértices son iguales
        return nombre.equals(n.nombre);
    }

    public void asigNumVert(int n) {//Establece el numero de vertices
        numVertice = n;
    }

    @Override
    public String toString(){ // características del vértice
        return nombre + " (" + numVertice + ")";
    }

}
