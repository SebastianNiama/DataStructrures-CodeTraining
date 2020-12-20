package EstructurasDatos;

import java.util.Scanner;

public class InsertElemEnArray {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int array[] = new int[100];
        char a;
                String b;
        int n = 0, elemen, aux;
        boolean bandera = true;

        System.out.println("Digite la cantidad de elementos del array = ");
        n = entrada.nextInt();

        System.out.println("Digite los datos: ");
        for (int i = 0; i < n; i++) {
            System.out.print("[" + i + "] ");
            array[i] = entrada.nextInt();
        }

        System.out.println("Se tiene el arreglo: ");
        for (int i = 0; i < n; i++) {
            System.out.print("[" + array[i] + "] ");
        }

        do {

            //Dea agregar al inicio o al final?
            System.out.println("\nDesea agregar al inicio o al final?");
            a = entrada.next().toUpperCase().charAt(0);

            System.out.println("Digite el numero: ");
            elemen = entrada.nextInt();

            if (a == 'I') {
                aux = array[n - 1];
                for (int i = n - 1; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = elemen;
                array[n] = aux;
                n = n + 1;
            } else if (a == 'F') {
                array[n] = elemen;
                n = n + 1;
            } else {
                System.out.println("Incorrecto");
            }
            System.out.println("New Array: ");
            for (int i = 0; i < n; i++) {
                System.out.print("[" + array[i] + "] ");
            }
            
            System.out.println("Quiere seguir agregando?");
            b = entrada.next();

            if (b.equalsIgnoreCase("Si")) {
                bandera = true;
            } else if (b.equalsIgnoreCase("No")) {
                bandera = false;
            }
            
            
            
        } while (bandera == true);

        System.out.println("Hasta nunca.");
    }
}
