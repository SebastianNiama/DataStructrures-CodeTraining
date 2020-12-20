
package Queues;
//Cola circular.
public class ColaCircular {
    
    private static final int MAXTAM = 99;
    protected int frente;
    protected int fin;
    protected Object [] listaCola;
  
    //Inicializa la cola vacia:
    public ColaCircular(){
        frente =0;
        fin = MAXTAM-1;//98
        listaCola = new Object[MAXTAM];
    }
     //Avanza una posicion:
    private int siguiente(int r){
        return (r+1) % MAXTAM;
    }
    
    //Operaciones de modificacion de la cola
    public void insertar(Object elemento) throws Exception{
        if(!colaLlena()){
            fin = siguiente(fin);//0
            listaCola[fin] = elemento;
        }else{
            throw new Exception("Overflow en la cola.");
        }
    }
    
    public Object quitar() throws Exception{
        if(!colaVacia()){
            Object tm = listaCola[frente];
            frente  = siguiente(frente);
            return tm;
        }else{
            throw  new Exception("Cola Vacia");
        }
    }
    
    public void borrarCola(){
        frente =0;
        fin = MAXTAM-1;
    }
    //Acceso a la cola:
    public Object frenteCola() throws Exception{
        if(!colaVacia()){
            return listaCola[frente];
        }else{
            throw new Exception("Cola vacia");
        }
    }
    
    //Metodos de verificacion del estado de la cola
    public boolean colaVacia(){
        return frente == siguiente(fin);
    }
    //Comprobamos si la cola esta llena
    public boolean colaLlena(){
        return frente == siguiente(siguiente(fin));
    }
    
    
}
