//Para utilizar esta busqueda, el arreglo debe estar previamente arreglado.
package EstructurasDatos;

import java.util.Scanner;

public class BusquedaBinaria {
/*
    Necesariamente el arreglo debe estar ordenado
    */
    public static void main(String[] args) {
        int aux, pos, arreglo[], dato;

        Scanner es = new Scanner(System.in);
        System.out.println("Ingrese tamaño del vector: ");
        int nElementos = es.nextInt();

        arreglo = new int[nElementos];

        for (int i = 0; i < nElementos; i++) {
            System.out.println("Ingrese dato " + (i + 1) + ": ");
            arreglo[i] = es.nextInt();
        }

        System.out.println("Arreglo: \n");

        for (int i = 0; i < nElementos; i++) {
            System.out.print(" [" + arreglo[i] + "]");
        }

        System.out.println("\n");

        //Ordenado por insercion         
        for (int i = 0; i < nElementos; i++) {
            pos = i;
            aux = arreglo[i];

            while (pos > 0 && (arreglo[pos - 1]) > aux) {
                arreglo[pos] = arreglo[pos - 1];
                pos--;
            }
            arreglo[pos] = aux;
        }
        //Arreglo ordenado
        System.out.println("Arreglo ordenado: \n");

        for (int i = 0; i < nElementos; i++) {
            System.out.print(" [" + arreglo[i] + "]");
        }

        System.out.println("\n");
        System.out.println("Ingrese numero a buscar: ");
        dato = es.nextInt();
        //Mando por parametros al metodo

        int numeroEncontrado = busquedaBinaria(arreglo, dato);

        if (numeroEncontrado == -1) {
            System.out.println("El numero " + dato + " no fue encontrado.");
        } else {
            System.out.println("El numero " + dato + " esta en la posicion " + numeroEncontrado);
        }

    }
/*
    El algoritmo realiza comparaciones para determinar si el  valor
    buscado está ubicado en el punto medio del  arreglo o estaría en su
    mitad superior o inferior.

    */
    public static int busquedaBinaria(int[] X, int elemento) {

        int inicio, fin, medio;
        inicio = 0;
        fin = X.length;

        try {
            while (inicio <= fin) {

                medio = (inicio + fin) / 2;

                if (X[medio] == elemento) {
                    return medio;
                } else {

                    if (X[medio] > elemento) {
                        fin = medio - 1;
                    } else {
                        inicio = medio + 1;
                    }
                }
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }

        return -1;
    }
    /*
    Al igual que en el caso de la búsqueda secuencial, este  algoritmo 
    devolverá la posición del elemento buscado,  o un valor de -1, en caso 
    de que tal elemento no se encuentre en el arreglo.

    */
}
