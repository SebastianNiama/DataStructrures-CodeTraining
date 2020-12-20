
package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Prueba2 {
    public static void main(String[] args) {
        
        //Creamos primera LinkedList
        LinkedList<String> paises = new LinkedList<String>();
        //Añado sus elementos
        paises.add("Espana");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Peru");
        
        //Creo 2da LinkedList
        
         LinkedList<String> capitales = new LinkedList<String>();
        //Añado sus elementos
        capitales.add("Madrid");
        capitales.add("Bogota");
        capitales.add("DF");
        capitales.add("Lima");
        
        //Imprimo ambas Listas
        System.out.println(paises);
        System.out.println(capitales);
       
        /*
        Ahora vamos a pasar los elementos de la 2da linkedList a la 1era
        con el orden correspondiente de sus capitales:
        Creamos un ListIterator, para q recorra cada una de las listas y
        añada elementos.
        */        
        ListIterator <String> iteraA = paises.listIterator();
        
        //Creamos un 2do iterator pa la 2da Linkedlist
        ListIterator <String> iteraB = capitales.listIterator();
        
        //Usaremos el metodo hashnext de la interfaz ListIterator
        //Comprobara si hay un siguiente elemento en la lista a comparar
        //Tambien usamos next() para q devuela el objeto de la lista.
        
        while (iteraB.hasNext()) {//Mientras haya un elemento siguiente en 
                                 //la lista de capitales
            if(iteraA.hasNext()){ //Comprobare si tamb hay un siguiente elemento en la lista de 
                                     //los paises
                /*
                Si esto es sierto, el iterator(A) que examina los paises va a
                saltar una posicion para a continuacion con el metodo add
                agregue un nuevo elemento, este caso el elemento de las capitales.
                */
                iteraA.next();//Entonces salta al siguiente elemento.              
            }
            /*
            Una vez q ha saltado ese elemento, voy a decirle q me agregue a ese
            elemento q acaba de saltar el siguiente elemento de las capitales.
            En este caso, el iterador(B) de las capitales no ha saltado, se encuentra
            antes. (al inicio)
            */
            iteraA.add(iteraB.next());//lo agrego madrid abajo de España.
        }
        
        //Unido:
        System.out.println("Unido en una sola lista:");
         System.out.println(paises);
         
         /*
         Voy a inciiar mi interador para q vuelva nuevamente al principio
         osea a su posicion inicial:
         */
         
         iteraB = capitales.listIterator();//Le hicimos q regrese a su posicion inicial
         
         while (iteraB.hasNext()) {//Mientras halla un elemento
             //Vas a salatar a la sigueinte posicion
              iteraB.next();
            //Una ves q has saltado
            if(iteraB.hasNext()){//Si hay una siguiente posicion 
                iteraB.next();//Salta de nuevo
                iteraB.remove();//Y elimina esta ultima.,               
            }              
        }
         /*
        Como hay 4 elementos en la lista capitales al final solamente se
         queda con los elementos 1 y 3. o (0 y 2)
        */
        
         //Muestro el LinkedList de iteraB (capitales) actualizado:
         System.out.println("Capitales actualizadas; ");
         System.out.println(capitales);
         
         
         /*
         Ahora si quisiera eliminar una coleccion completa: uso el
         metodo removeAll
         */
         
         paises.removeAll(capitales);//Elimino la coleccion capitales de mi 
         //coleccion de paises

         System.out.println("Eliminacion de las capitales: ");
         System.out.println(paises);
    }
}
