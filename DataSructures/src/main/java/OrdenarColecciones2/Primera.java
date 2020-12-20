
package OrdenarColecciones2;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;
//SE HACE CON LA INTERFAZ COMPARABLE
public class Primera {
    public static void main(String[] args) {
              
        List<Persona> lista3 = new ArrayList<Persona>();
        
        lista3.add(new Persona(1, "Jaime", 25));
        lista3.add(new Persona(1, "Zito", 15));
        lista3.add(new Persona(1, "Aode", 29));
         
        /*
        Atencion, ya no creamos un objeto del tipo Comparator dentro
        del metodo .sort() ni tampoco ponemos un objeto de una clase
        que haya implementado la clase Comparator.
        Ahora, solamente ubicamos el nombre de la lista  y punto.
        Esto, al momento de imprimir, me ordenara automaticamente
        de acuerdo a la edad, puesto que se definió en la misma
        clase Persona
        */
        Collections.sort(lista3);
 
        System.out.println("Ordenacion por edad pero que salgan los nombres: ");
        for (Persona p : lista3) {
            System.out.println(p.getNombre()+"-"+p.getEdad());
        }
        

    }
}
