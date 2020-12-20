
package EstructurasDatos;

import java.util.Scanner;


public class InsertarElemEnArray {
    public static void main(String[] args) {
        
         Scanner entrada = new Scanner(System.in);

        int array[] = new int[100];
        int a;
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
            System.out.println("\nEn que posicion desea añadir un numero?");
            for (int i = 0; i < n; i++) {
                System.out.print("["+i+"] ");
            }
            a = entrada.nextInt();

            System.out.println("Digite el numero: ");
            elemen = entrada.nextInt();

            
      
                aux = array[n - 1];
                for (int i = n - 1; i > a; i--) {
                    array[i] = array[i - 1];
                }
                array[a] = elemen;
                array[n] = aux;
                n = n + 1;
            
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
