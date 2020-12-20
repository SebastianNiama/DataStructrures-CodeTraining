/*
COLA DE PRIORIDADES EN UN MONTÍCULO
A continuación se escribe su implementación utilizando las operaciones básicas del montículo.
Naturalmente, los elementos son referencias a Tarea que implementa la interfaz Comparador.
 */
package PriorityQueues1;

public class AplicacionCP {

    //Creo un Monticulo/Binary heap
    protected Monticulo cp;//Creo un Monticulo/Binary heap

    //Construcutor
    public AplicacionCP() {
        //Inciializo mi monticulo:
        cp = new Monticulo();
    }

    //Añade una tarea a la cola
    public void insertarEnPrioridad(Tarea t) {
        cp.insertar((Comparable) t);
    }

    public Tarea elementoMin() throws Exception {
        return (Tarea) cp.buscarMinimo();
    }

    public Tarea quitarMin() throws Exception {
        return (Tarea) cp.eliminarMinimo();
    }

    public boolean colaPrioridadVacia() {
        return cp.esVacio();
    }

}
