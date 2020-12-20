package EstructurasDatos;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class OrdenamientoSeleccion{

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int arreglo[], nElementos, minimo, aux;

        nElementos = Integer.parseInt(JOptionPane.showInputDialog("# de elementos; "));

        arreglo = new int[nElementos];

        for (int i = 0; i < nElementos; i++) {
            arreglo[i] = (int) Math.round(Math.random() * 100);
        }
        System.out.println("Arreglo desordenado: \n");

        for (int i = 0; i < nElementos; i++) {
            System.out.print(" [" + arreglo[i] + "]");
        }
        System.out.println("\n");
        
        //Ordenamiento por Seleccion
        
        for (int i = 0; i < nElementos-1; i++) {
          minimo=i;//esta variable sabe cual es la posicion mas pequenia del arreglo
            for (int j = i+1; j < arreglo.length; j++) {
                if(arreglo[j]<arreglo[minimo]){
                    minimo=j;
                }
            }
            aux=arreglo[i];
            arreglo[i]=arreglo[minimo];
            arreglo[minimo]=aux;
        }
        
          System.out.println("Arreglo ordenado: \n");

        for (int i = 0; i < nElementos; i++) {
            System.out.print(" [" + arreglo[i] + "]");
        }
        
    }
}
