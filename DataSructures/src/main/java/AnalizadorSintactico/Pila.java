
package AnalizadorSintactico;


public class Pila {
    //Creamos un comportamiento del tipo lista pila.
    
    private Nodo UltimoValorIngresado; //Para conocer el ultimo elemento q ingresó a la Pila.
    
    public Pila(){
        /*
        Llamamos al objeto "UltimoValorIngresado" para indicarle que de arranque
        debe tener un valor null
        */
        UltimoValorIngresado = null;    
    }
    
    //Metodos para insertar dentro de la pila.
    
    /*
    El sigguiente metodo recibe un parametro del tipo char por que
    la variable informacion de la clase Nodo es del tipo char
    */
    public void Insertar(char valor){
        
        Nodo nuevo_nodo = new Nodo();
        /*
        Este nuevo objeto "nuevo_nodo" va a guardar dentro de su campo informacion
        el valor que no esta pasando por parametro.
        Y asi se tiene el valor que el usuario a ingresado.
        */
        nuevo_nodo.informacion = valor;
           
        if (UltimoValorIngresado == null) { //SI "UltimoV.." continua null, osea q no ha 
                                            //ingresado ningun valor dentro de la pila
            
            nuevo_nodo.siquiente = null; //El "nuevo nodo" en su campo siguiente será null                             
              
            UltimoValorIngresado = nuevo_nodo; //Es igual al nuevo nodo q acaba de entrar.
                                            
        } else {
            
            nuevo_nodo.siquiente = UltimoValorIngresado;
            UltimoValorIngresado = nuevo_nodo;
            
        }
        
    }
    
    //Metodo para extraer de la pila.
    
    public char extraer(){
        
        if (UltimoValorIngresado != null) { //Osea si la pila no esta vacia.
            
            char informacion = UltimoValorIngresado.informacion;
            UltimoValorIngresado = UltimoValorIngresado.siquiente; //Para apuntar al siguiente nodo.
            return  informacion;
        } else {
            return Character.MAX_VALUE; //debemos retornar un elemento de la clase character
        }
        
    }
    
    //Metodo para saber si la pila esta vacia:
    
    public boolean PilaVacia(){
        return UltimoValorIngresado == null;
    }
    
    
    
    
}
