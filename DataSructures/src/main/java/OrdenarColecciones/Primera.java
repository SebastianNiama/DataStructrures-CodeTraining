
package OrdenarColecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//SE HACE CON LA INTERFAZ COMPARATOR
public class Primera {
    public static void main(String[] args) {
             
        List<Integer> lista = new ArrayList<>();      
        lista.add(25);
        lista.add(10000);
        lista.add(1);      
        
        //Si coloco la clase Collections:
        Collections.sort(lista);
        Collections.reverse(lista);

        System.out.println(lista);
        System.out.println("");
        
        
        List<String> lista2 = new ArrayList<>();
        lista2.add("Jaime");
        lista2.add("MitoCode");
        lista2.add("AAA");
        
        Collections.sort(lista2);
        System.out.println(lista2);
        System.out.println("");
        //-------------------------------------------------------
        
        
        
        //Queremos ordenar objetos de una Clase:
          
        List<Persona> lista3 = new ArrayList<Persona>();
        
        lista3.add(new Persona(1, "Jaime", 25));
        lista3.add(new Persona(1, "Zito", 15));
        lista3.add(new Persona(1, "Aode", 29));
         //Debemos usar el sort con parametro comparator
         //Comparamos solo los nombres:
         //Se agregar un objeto del tipo primeraComparator (clase)
         //Que tiene implementada la interfaz Comparator y su metodo
         //compare() el cual se codifico para que ordene Nombres.
        Collections.sort(lista3, new PrimeraComparator());
        
        System.out.println("Ordenacion por nombre: ");
        
        for (Persona persona : lista3) {
            System.out.println(persona.getNombre());
        }
        
        System.out.println("");
        //SI queremos comparar el ID y la edad, se debe hacer
        //un Clase que implemente la Interfaz comparator para cada uno, 
        //en este caso para no crear mas clases hacemos lo siguiente:
        //Clase anonima:
        Collections.sort(lista3, new Comparator<Persona>(){
            @Override
            public int compare(Persona p1, Persona p2) {
               int rpta = 0;
               if(p1.getEdad() > p2.getEdad()){
                   rpta = 1;
               }else if(p1.getEdad() < p2.getEdad()){
                   rpta =-1;
               }else{
                   rpta =0;
               }
               return rpta;
            }
            
        });
        
        System.out.println("Ordenacion por edad pero que salgan los nombres: ");
        for (Persona p : lista3) {
            System.out.println(p.getEdad()+"-"+p.getNombre());
        }
        
       
    }
}
