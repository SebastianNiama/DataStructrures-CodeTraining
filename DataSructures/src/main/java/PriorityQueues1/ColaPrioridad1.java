//Se podria decir que es un array estatico de colas.:

//La clase que representa la tabla, a su vez, utiliza la clase ColaLista
package PriorityQueues1;
import Queues.ColaLista;//Xq vamos a usar colas

public class ColaPrioridad1 {
    
    protected ColaLista []tabla;//Un arrays de Colas
    protected int maxPrioridad;
    
    /*
    El constructor es el responsable de establecer 
    el número de prioridades y definir el array:
    */
    public ColaPrioridad1(int n) throws Exception {
        if(n<1) throw new Exception("Error en prioridad "+n); 
        maxPrioridad = n;
        //Inicializo mi array de listas enlazadas(con Colas):
        tabla = new ColaLista[maxPrioridad+1];
        //Creo una nueva lista enlazada/cola para cada celda de la TABLA
        for(int i=0; i<=maxPrioridad;) tabla[i++] = new ColaLista();
    }
    
    /* INSERTAR:
    La operación añade una nueva tarea, un elemento, a la cola de prioridades.
    La tarea se inserta en la cola tabla[prioridad], siendo prioridad la asociada 
    a la tarea.
    La complejidad de añadir un elemento es la requerida por la operación de
    insertar en la cola tabla[p]. Por consiguiente, la operación tiene 
    complejidad constante (tiempo constante). O(1)
    */
    public void insertarEnPrioridad(Tarea t) throws Exception{
        int p = t.numPrioridad();
        if(p >=0 && p<=maxPrioridad) tabla[p].insertar(t);//Inserto objeto en lista
        else throw  new Exception("Tarea con prioridad fuera de rango. ");
    }
    
    //ELEMENTO DE MAXIMA PRIORIDAD;
    //El sig metodo me devuelve el valor minimo (max prioridad)
    public Tarea elementoMin() throws Exception{
        int i=0;
        int indiceCola =-1;
        
        //Busqueda de la primera cola, no vacia.
        do{
            if(!tabla[i].colaVacia()){//Si la primera cola, no esta vacía
                indiceCola =i;// =0; (Va cambiando)
                i = maxPrioridad +1;//termina el bucle.
            }else i++;
                        
        }while(i<= maxPrioridad);
        
        if(indiceCola !=-1) 
            return (Tarea)tabla[indiceCola].frenteCola();//Me devuelve un objeto.
        else throw new Exception("Cola de prioridades vacia");                
    }
    
    //La operación quitarMin sigue los mismos pasos que elementoMin, con la diferencia de
//que devuelve y retira el elemento frente de la cola de mayor prioridad:        
    
    public Tarea quitarMin() throws Exception{
        int i=0;
        int indiceCola =-1;
        
        //Busqueda de la primera cola, no vacia.
        do{
            if(!tabla[i].colaVacia()){//Si la primera cola, no esta vacía
                indiceCola =i;// =0; (Va cambiando)
                i = maxPrioridad +1;//termina el bucle.
            }else i++;
                        
        }while(i<= maxPrioridad);
        
        if(indiceCola !=-1) 
            return (Tarea)tabla[indiceCola].quitar();//Me devuelve un objeto.
        else throw new Exception("Cola de prioridades vacia");  
    }
    
    //La operación colaPrioridadVacia comprueba que cada una de las colas está vacía.
    public boolean colaPrioridadvacia(){
        int i=0;
        while(tabla[i].colaVacia() && i<maxPrioridad) i++;         
        return tabla[i].colaVacia();      
    }
    
    
}
