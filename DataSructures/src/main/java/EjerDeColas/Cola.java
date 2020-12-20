
package EjerDeColas;

import javax.swing.JOptionPane;

public class Cola {
    
    /*
    Para saber elementos que estan al inicio y final de la cola.
    */
    private Nodo inicioCola, finalCola;
    
    String Cola = "";// Para saber cual es el contenido de nuestra cola.
    
   public Cola(){
       /*
       Indicamos los valores iniciales de los punteros que vamos a crear.
       */
       inicioCola=null;//Por que al inicio del programa no hay ningun nodo/elementos.
       finalCola=null;
       
   } 
    
   //Metodo para saber si la cola esta vacia:
   
   public boolean ColaVacia(){
       if(inicioCola==null){//Si la cola esta vacia, osea q no ha creado ningun nodo.
           return true;//a ok si esta vacia
       }else{
           return false;
       }       
   }
   
   //Metodo para insertar la cola.
    public void Insertar(int informacion){//Pasamos parametro
        Nodo nuevo_nodo = new Nodo();
        //Logica:
        /*
        El nuevo nodo con su campo informacion es igual al parametro q nos 
        estan pasando.
        */
        nuevo_nodo.informacion = informacion;
        /*
        Despues indicamos hacia donde debe apuntar este nuevo nodo
        Al serl el ultimo de la lista, no tiene donde apuntar
        es x eso q se le pone el valor null
        */
        nuevo_nodo.siguiente = null;
        if (ColaVacia()) {
            /*
            SI colavacia es true, se va a guardar el nuevo nodo q acabamos
            de crear.
            */
            inicioCola = nuevo_nodo; 
            finalCola = nuevo_nodo;   
        } else {
            
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }
    }
    
    //Metodo para extraer de la cola
    
    public int Extraer(){//Int por q trabajamaremos con int
        
        if (!ColaVacia()) {
            int informacion = inicioCola.informacion;           
            /*
            Verificamos si lo que esta en inicioCola == finalCola
            se cumple, si el elemento lo esta quiere decir q ees el ultumo
            elemento q esta dentro de la cola.
            */
            if (inicioCola == finalCola) {
                //Por ende, los apuntadores ya no apuntan hacia otro nodo
                //y se les da el valor null.
                inicioCola = null;
                finalCola = null;
            } else {//Si no es el ultimo elemento de la cola:
                //Seguimos enlazando los nodos dentro de nuestra cola.
                inicioCola = inicioCola.siguiente;
            }
            
            return  informacion;
            
        } else {
            
            return Integer.MAX_VALUE;
        }
        
    }
    
    //Metodo para mostrar ek contenido de la cola:
    
    public void MostrarContenido(){
        Nodo recorrido = inicioCola;//apolla como apuntador y apunta al iniciodelacola.
        String ColaInvertida ="";//Invertirmeos unacadenade texto .
        
        while(recorrido != null){
            Cola += recorrido.informacion + " ";//Con el apuntador vaya viendo todos los campos de informacion
            recorrido = recorrido.siguiente;
        }       
        String cadena [] = Cola.split(" "); //para q invierta
        /*
        10 20 30 
        30 20 10
        */
        
        /*
        El -1 sirve para evitar un desbordamiento de memoria.
        */
        for (int i = cadena.length-1; i>=0; i--) {//Va arecorrer de adelante hacia atras
            ColaInvertida += " " + cadena[i]; //El espacio es para evitar q se vayan amontonando           
        }
        
        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";
    }
    
}
