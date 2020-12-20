
package EjercicioPila2;
//Diseñamos el comportamiento:

import java.util.EmptyStackException;
import javax.swing.JOptionPane;

public class Pila {
    /*
    Este objeto sirve de referencia para saber cual fue el ultimo valor
    en ingresar a la pila
    */
    private Nodo ultimoValorIngresado;//Top
    private int tamano;
    String lista ="";
    
    public Pila(){
        ultimoValorIngresado = null;
        tamano =0;
    }
    
    //Metodo para saber si la pila esta vacia
    public boolean pilaVacia(){//isEmpty()
        return ultimoValorIngresado==null;
    }
    //Metodo para insertar un nodo en la pila:
    public void insertarNodo(int nodo){//push()
        Nodo nuevo_nodo = new Nodo(nodo);
        nuevo_nodo.siguiente =ultimoValorIngresado;
        ultimoValorIngresado = nuevo_nodo;
        tamano++;
    }
    //Metodo para eliminar un nodod de la pila
    public int eliminarNodo(){//pop()
       // if(ultimoValorIngresado == null) throw new EmptyStackException();
        
        int auxiliar = ultimoValorIngresado.informacion;
        ultimoValorIngresado = ultimoValorIngresado.siguiente;
        tamano--;      
        return auxiliar;
    }
    
    //Metodo para conocer cual es el ultimo valor ingresado:
    public int mostrarUltimoValorIngresado(){//Devuelve la cabeza
        return ultimoValorIngresado.informacion;
    }
    
    //Metodo para conocer el tamaño de la pila
    public int tamanoPila(){
        return  tamano;
    }
    
    //Metodo para vaciar la pila
    public void vaciarPila(){
        while(!pilaVacia()){//Mientras sea falso/este llena
            eliminarNodo();//se vacia
        }
    }
    
    //Metodo para mostrar el contenido de la pila
    public void mostratValores(){
        Nodo recorrido = ultimoValorIngresado;
        while (recorrido !=null) {            
            lista += recorrido.informacion + "\n";
            recorrido = recorrido.siguiente;          
        }
        
        JOptionPane.showMessageDialog(null, lista, "Pila", JOptionPane.INFORMATION_MESSAGE);
        lista="";//al final la vaciamos
        
    }
}
