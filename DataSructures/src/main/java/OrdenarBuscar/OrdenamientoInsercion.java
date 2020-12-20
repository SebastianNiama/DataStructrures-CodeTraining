package EstructurasDatos;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class OrdenamientoInsercion {

    /*
    Generalmente, se considera una buena
solución si solo hay unos pocos elementos que necesiten ser ordenados, dado
que es un algoritmo muy corto y que el tiempo requerido para realizar la
ordenación no suele ser un problema. Sin embargo, si estamos tratando con
una gran cantidad de datos de entrada, la ordenación por inserción no es una
elección correcta porque requiere demasiado tiempo.
    */
    
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int arreglo[], nElementos, pos, aux;

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
        
        //Ordenamiento por insercion
        
        for (int i = 0; i < nElementos; i++) {
            pos=i;
            aux=arreglo[i];
         
            while(pos>0 && (arreglo[pos-1])> aux){
                arreglo[pos] = arreglo[pos-1];
                pos--;
            }
            arreglo[pos]=aux;
        }
        
          System.out.println("Arreglo ordenado: \n");

        for (int i = 0; i < nElementos; i++) {
            System.out.print(" [" + arreglo[i] + "]");
        }
        
    }
}
