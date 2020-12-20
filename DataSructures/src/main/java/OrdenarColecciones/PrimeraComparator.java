package OrdenarColecciones;

import java.util.Comparator;
//Implementamos la interfaz Comparator y especifico el tipo que recibe

public class PrimeraComparator implements Comparator <Persona> {

    //Sobreeescribimos el metodo compare
    @Override
    public int compare(Persona p1, Persona p2) {

        //Me va a retornar un valor positivo o negativo o 0 sea el caso
        return p1.getNombre().compareTo(p2.getNombre());

    }
}
