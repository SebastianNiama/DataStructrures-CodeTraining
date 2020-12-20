
package ArrayList;

import java.util.ArrayList;//Agregamos la clase.
import java.util.Iterator;//Para recorrer un ArrayList

public class Declaraciones {
    
    public static void main(String[] args) {
        
        /*
        Existen dos formas de declarar y crear un ArrayList, su uso depende de 
        la necesidad del pro-gramador.
        */

      //------------------------------------
      //PRIMERA FORMA DE DECLARAR UN ARRAY LIST
      /*
      La primera es factible si se desea almacenar objetos de diferentes clases
        en el mis-mo ArrayList.
      */
      ArrayList lista = new ArrayList();
      
      //Se pueden agregar elementos de la siguiente manera:   
      lista.add("Lista dinámica");//Se agrega un objeto String
      lista.add(36);//Se agrega un dato primitivo
      lista.add('j');//Se agrega un dato primitivo
      lista.add(31.1);//Se agrega un dato primitivo
      /*
      Como se observa no todos son objetos sino datos primi-tivos, por lo que
      antes de agregarlos al ArrayList, el compilador los convierte en objetos.
      En conclusión, en el ejemplo se agregaron objetos de diferentes tipos
      */
      
      //---------------------------------------------------
      // SEGUNDA FORMA DE DECLARAR UN ARRAY LIST.
      /*
      La 2da forma es factible cuando se desea almacenar en éste, objetos del 
      mismo tipo:
      En este caso se crea un ArrayList de números enteros denominado edades,
      que almacena edades de personas
      */
        
      ArrayList <Integer> edades = new ArrayList<Integer>();
      
      edades.add(23);
      edades.add(56);
      edades.add(73);
      edades.add(12);
      edades.add(99);
      
     //-------------------------------------------------------------------------------------- 
      //RECORRIDO DE ARRAYLIST
      
        //Primera forma: Con bucle for
      
        System.out.println("Primera forma:");
        for(int i=0; i<lista.size(); i++){
            System.out.println(lista.get(i));
        }     
        System.out.println("");
        
        //Segunda forma: COn bucle for each
      //Se pone Integer, por que en este caso se lo creó con ese tipo
        System.out.println("Segunda forma:");
        for(Integer e:edades){
            System.out.println(e);
        }
      
        System.out.println("");
        //Tercera forma
        /*
        El tercer camino para recorrer una lista de tipo ArrayList, es bajo 
        el supuesto de que existe una lista objetos de distintos tipos, 
        lo cual se hace de la siguiente manera:
        */
        System.out.println("Tercera forma:");
        for(Object o:lista){ //En este caso el ArrayList "lista" guarda != tipos de objetos.
            System.out.println(o);
        }
        
        System.out.println("");  
        
        //Cuarta forma: Clase: Iterator (se usan iteradores)
        /*
         El beneficio de usar un objeto de la clase Iterador es que no se 
        necesita especificar el tipo de objeto que contiene el ArrayList, por ejemplo
        */
        
        ArrayList<Double> pagos = new ArrayList<Double>();//Se declara el array Double
        
        Iterator itera = pagos.iterator();//Se crea el iterador "itera" para el array
        
        //A continuacion, se agregan elementos:
        pagos.add(33.9);       
        pagos.add(133.25);
        pagos.add(14.2);
        
        //System.out.println("Cuarta forma:");
        //Ahora se recorre el array list por pantalla:
        /*
        while(itera.hasNext()){//Mientras queden elementos.
            System.out.println(itera.next());//Se obtienen y se muestran 
        }
*/
    }
  
}
