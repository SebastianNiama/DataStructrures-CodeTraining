package Queues;
//Se implementan con una estructura estática (arrays) 
public class ColaLineal <T>{
    
    private static final int MAXTAM = 39;
    protected int frente;
    protected int fin;
    protected Object [] listaCola;
    /*
    inicializamos una cola vacia y definimos el array.
    */
    public ColaLineal(){
        frente=0;
        fin =-1;
        listaCola =  new Object[MAXTAM];
    }
    //OPERACIONES DE MODIFICACION DE LA COLA
    public void insertar(T elemento) throws Exception{
        if(!colaLlena()){//Si la cola no esta llena, agregar
            listaCola[++fin] = elemento;
        }else{//Sino, lanzar error.
            throw new Exception("Overflow en la cola.");
        }
    }
    public T quitar() throws Exception{
        if(!colaVacia()){           
            return (T) listaCola[frente++];
        }else{
            throw new Exception("Cola Vacía.");
        }
    }
    //Vaciar Cola
    public void borrarCola(){
        frente =0;
        fin =-1;
    }
    //Acceso a la cola
    public T frenteCola() throws Exception{
        if(!colaVacia()){
            return (T) listaCola[frente];
        }else{
            throw new Exception("Cola vacía");
        }
    }
    
    public void mostrarCola(){
        for (int i = frente; i <= fin; i++) {
            System.out.print(listaCola[i]+" ");
        }
    }
    
    //METODOS DE VERIFICACION DE ESTADO DE COLA.                 
    public boolean colaVacia(){
        return frente >fin;
    }
    public boolean colaLlena(){
        return fin == MAXTAM-1;
    }
    
    
    
    
}
