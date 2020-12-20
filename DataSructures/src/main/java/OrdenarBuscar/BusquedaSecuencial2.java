
package EstructurasDatos;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class BusquedaSecuencial2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int arreglo[], nElementos, dato;
        int i=0;
        boolean bandera=false;
        
        System.out.println("Ingrese el # de elementos: ");
        nElementos = entrada.nextInt();

        arreglo = new int[nElementos];

        for ( i = 0; i < nElementos; i++) {
            System.out.println("Ingrese dato "+(i+1)+": ");
           arreglo[i]=entrada.nextInt();
        }
        
        System.out.println("Arreglo: \n");

        for ( i = 0; i < nElementos; i++) {
            System.out.print(" [" + arreglo[i] + "]");
        }
        System.out.println("\n");
        
        System.out.println("Ingrese numero a buscar: ");
        dato=entrada.nextInt();
        
        
        if(secuencial(arreglo, dato) == -1)
            System.out.println("No se encontro el numero.");
        if(secuencial(arreglo, dato)!= -1)
            System.out.println("El numero "+dato+" esta en la posicion "+ secuencial(arreglo, dato));
    }
    
    
    public static int secuencial(int x[], int elemento){
        
        for(int i=0; i<x.length; i++){
            if(x[i]==elemento)
                return i;          
        }
        return -1;
    }
}
