package EstructurasDatos;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class MetodoBurbuja2 {

    public static void main(String args[]) {

        int arreglo[];
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantida de elementos; "));
        MetodoBurbuja2 objeto = new MetodoBurbuja2();
        arreglo = new int[n];
        objeto.setNumeros(arreglo);
        objeto.ordenados();
        arreglo = objeto.getNumeros();
        for (int i = 0; i < n; i++) {
            System.out.print(" [" + arreglo[i] + "}");
        }

    }

    Scanner sc = new Scanner(System.in);
    int numeros[];

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenados() {
        int auxiliar, bandera = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Digite [%d]: ", (i + 1));
            numeros[i] = sc.nextInt();
        }

        do {
            bandera = 0;
            for (int i = 1; i < numeros.length; i++) {
                if (numeros[i - 1] > numeros[i]) {
                    auxiliar = numeros[i];
                    numeros[i] = numeros[i - 1];
                    numeros[i - 1] = auxiliar;
                    bandera = 1;
                }
            }
        } while (bandera != 0);
    }

}
