
package EjerDeCola;

import javax.swing.JOptionPane;

public class Cola {
    private Nodo inicioCola;//Apuntador 1
    private Nodo finalCola;//Apuntador 2
    String cola="";//Guarda el contenido
    
    public Cola(){
        inicioCola=finalCola=null;//Al iniciar la cola, no hay cola, esta vacia      
    }
    
    //Metodo para saber si la cola esta vacia
    public boolean colaVacia(){
        return inicioCola==null;         
    }
    //Insertar en la cola
    public void insertar(int informacion){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.informacion=informacion;
        nuevoNodo.siguiente=null;//Es el ultimo en la lista y x eso no tiene 
        //a donde apuntar   
        if (colaVacia()) {
            inicioCola = nuevoNodo;
            finalCola=nuevoNodo;
        } else {
            finalCola.siguiente=nuevoNodo;
            finalCola = nuevoNodo;
        }
    }
    //Metodo para extraer de la cola:
    public int extraer(){
        if (!colaVacia()) {
            int informacion = inicioCola.informacion;
            if(inicioCola ==finalCola){//Es el ultimo elemento en estar dentro
                //de la cola:
                inicioCola =finalCola=null; //Los vuelvo a vaiar
            }else{
                inicioCola = inicioCola.siguiente;//Enlazamos             
            }
            return  informacion;
        } else {
            return  Integer.MAX_VALUE;
        }
    }
    //Metodo para msotrar contenido de la cola
    public void mostrar(){
        
        Nodo recorrido = inicioCola;//Apoya como apuntador
        String colaInvertida="";
        
        while(recorrido !=null){
             cola += recorrido.informacion+ " ";
            recorrido= recorrido.siguiente;
        }
        
        /*
        El metodo split() nos permite separar cadenas de caracteres.
        Hay que agregar el espacio para q invierta la cadena
        */
        String cadena [] = cola.split(" ");
        
        for (int i = cadena.length -1; i >=0; i--) {
            colaInvertida += " "+ cadena[i];
        }
        
        JOptionPane.showMessageDialog(null, colaInvertida);
        cola = "";
    }
    
    
    
}
