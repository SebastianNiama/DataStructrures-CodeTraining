
package Queues;

public class Bicola <T> extends ColaLista{
    
    //Inicializa Frente y Fin a Null
    public Bicola(){
        super();
    }
    
    //Inserta por el final de la bicola:
    public void ponerFinal(T elemento){
        insertar(elemento);//Metodo heredado de ColaLista
    }
    //Insertar por el frente: metodo propio de Bicola
    public void ponerFrente(T elemento){
        Nodo<T> a;
        a = new Nodo(elemento);
        if(colaVacia()){
            fin =a;
        }
        a.siguiente = frente;
        frente = a;       
    }
    //Retirar elemento frente de la Bicola
    public T quitarFrente() throws Exception{
        return (T) quitar();//Metodo heredado de la ColaLista
    }
    //Retirar elemento final, metodo propio de la Bicola.
    //Es necesario recorrer la bicola para situarse en el
    //nodo anterior al final, para despues enlazar
    public T quitarFinal() throws Exception{
        T aux;
        if(!colaVacia()){         
            if(frente ==fin){//La bicola dispone de un solo nodo
                aux = (T) quitar();       
            }else{
                Nodo <T> a = frente;
                while(a.siguiente !=fin) a = a.siguiente;                
                //siguiente del nodo anterior se pone a null
                a.siguiente = null;
                aux = (T) fin.elemento;
                fin =a;
            }       
          }else{
            throw  new Exception("No se puede eliminar de bicola vacia.");
           }
        return aux;    
    }
    
    public T frenteBicola() throws Exception{
        return (T) frenteCola();//Metodo hereredado de ColaLista
    }
    
    //Devuelve el elemento final:
    public T finalBicola() throws Exception{
        if(colaVacia())throw  new Exception("Error: Cola vacia");                  
        return (T) fin.elemento;
    }
    // comprueba el estado de la bicola
    public boolean bicolaVacia(){
       return colaVacia();//Metodo hereredado de ColaLista
    }
    //Eliminar bicola:
    public void borrarBicola(){
        borrarCola();//Metodo hereredado de ColaLista
    }
    
    public int numElemsBicola(){
        int n;
        Nodo<T> a= frente;
        
        if(bicolaVacia()) n=0;
        else {
            n=1;
            while(a !=fin){
                n++;
                a =a.siguiente;
            }
        }
            
           return n; 
        
                
    }
}
