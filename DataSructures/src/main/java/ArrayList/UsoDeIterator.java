package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;//Iterator es una interfaz

public class UsoDeIterator {

    public static void main(String[] args) {

        /*
        La interfaz Iterator solo contiene 3 metodos
        hasnext(); devuelve true o false si existe un elemento
        next(); devuelve el objeto que hay en ese arrayList
        remove();
         */
        ArrayList<Empleados> listaEmpleados = new ArrayList<Empleados>();

        listaEmpleados.add(new Empleados("Ana", 45, 2500));
        listaEmpleados.add(new Empleados("Antonio", 55, 2000));
        listaEmpleados.add(new Empleados("Maria", 25, 2600));
        listaEmpleados.add(new Empleados("Jose", 35, 2900));
        listaEmpleados.trimToSize();
        System.out.println("");

        //Creacion del iterador
        /*
        Debemos especificar el tipo de objeto que va a recorrer
        el iterador, el cual va hacer el encargado de recorrer
        elemento a elemento la coleccion.
        Entonces, le vamos a indicar que tipo de objeto tenemos
        en la coleccion a traves de <>
         */
        Iterator<Empleados> mi_iterador = listaEmpleados.iterator();
        /*
        El metodo .iterator, nos devuelve un objeto del tipo
        Iterator, y pues debo guardarlo en un sitio
        en este caso lo guardo en "mi_iterator".
         */

        while (mi_iterador.hasNext()) {//Si existe mas elementos.

            System.out.println(mi_iterador.next().dameDatos());//devuelve el objeto

        }

    }
}

class Empleados {

    private String nombre;
    private int edad;
    private double salario;

    public Empleados(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos() {
        return "El Empleado se llama " + nombre + " tiene " + edad
                + " años. Y un salario de " + salario;
    }

}
