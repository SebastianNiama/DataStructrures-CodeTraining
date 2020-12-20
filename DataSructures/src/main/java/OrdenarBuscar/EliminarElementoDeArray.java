package EstructurasDatos;

import java.util.Scanner;

public class EliminarElementoDeArray {

    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);

        int array[] = {3, 8, 1, 0, 2, 7};
        int n, pos = 0, nFinal = 0, n2 = 0;
        boolean E = false;
        char a ='n';

        System.out.println("Se tiene el arreglo: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "] ");
        }

        do {
            System.out.println("");
            System.out.println("¿Què numero desea eliminar?");
            n = es.nextInt();

            //Busqueda secuencial pa ver si existe el numero.       
            for (int i = 0; i < array.length; i++) {
                if (array[i] == n) {
                    pos = i;
                    E = true;
                }
            }

            if (E == false) {
                System.out.println("El numero no existe.");
            } else {
                   //Codigo para eliminar:
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == array[pos]) {
                        for (int j = pos; j < array.length - 1; j++) {
                            array[j] = array[j + 1];
                        }
                    }
                }

                n2++;

                int cantidad = array.length - n2;

                if (cantidad == 0) {
                    System.out.println(" Ya te chingaste todo el vector cabron.");
                    break;
                } else {

                    System.out.println("Vector actualizado: ");
                    for (int v = 0; v < (array.length - n2); v++) {
                        System.out.print("[" + array[v] + "] ");
                    }
                    System.out.println("");
                    System.out.println("Desea eliminar otro numero?");
                    a = es.next().toUpperCase().charAt(0);

                }
            }

        } while ( a == 'S');

        System.out.println("Gracias..");
    }

}
