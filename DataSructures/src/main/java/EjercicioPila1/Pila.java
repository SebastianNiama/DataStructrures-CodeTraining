
package EjercicioPila1;

import javax.swing.JOptionPane;

/**
 Aqui se asigna el comportamiento de tipo pila al programa:
 */
public class Pila {
    /*
    Se debe crear un objeto del tipo nodo en encapsulacion private.
    
    */
    
    private Nodo UltimoValorIngresado;
    //Este objeto sirve de referencia para saber el ultimo elemento que entró a la pila.
    
    private int tamano =0;
    private String Lista ="";
    
    //Tambien se crea un constructor.
    
    public Pila(){
        UltimoValorIngresado = null;
        tamano =0;
    }
    /*
    Trabajamos con los metodos q dan vida al programa
    */
    //Método para saber si la pila esta vacia:
    public boolean PilaVacia(){
        return UltimoValorIngresado == null;//regresa V o F
    }
    //Metodo para insertar un valor en la pila
    public void InsertarNodo(int nodo){//parametro para q inserte numeros.
        Nodo nuevo_nodo = new Nodo(nodo);//Adentro de () va el parametro.
        nuevo_nodo.siguiente = UltimoValorIngresado;
        UltimoValorIngresado = nuevo_nodo;
        tamano++;
        
    }
    //Meotodo para eliminar un nodo de la pila.
    public int EliminarNodo(){
        int auxiliar = UltimoValorIngresado.informacion;
        UltimoValorIngresado = UltimoValorIngresado.siguiente;
        tamano--;
        return auxiliar;
    }
    //Metodo para conocoer cual es el ultimo valor ingresado
    public int MostrarUltimoValorIngresado(){
        return UltimoValorIngresado.informacion;
    }
    //Metodo para conocer el tamaño de la pila.
    public int TamanoPila(){
        return tamano;
    }
    //Metodo para vaciar la pila
    public void VaciarPila(){
        while(!PilaVacia()){
            EliminarNodo();
        }
    }
    //Metodo para mostrar contenido de la Pila
    public void MostrarValores(){
        Nodo recorrido = UltimoValorIngresado;
        while(recorrido != null){
            Lista += recorrido.informacion + "\n";
            recorrido = recorrido.siguiente;
        }
        JOptionPane.showMessageDialog(null, Lista);
        Lista = "";
    }
}
