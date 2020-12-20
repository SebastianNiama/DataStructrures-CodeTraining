//Para esta busqueda no es necesario que el arreglo este ordenado


package EstructurasDatos;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class BusquedaSecuencial{

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int arreglo[], nElementos, dato;
        int i=0;
        boolean bandera=false;
        
        nElementos = Integer.parseInt(JOptionPane.showInputDialog("# de elementos; "));

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
        
        //Busqueda secuencial
        
        i=0;
        while(i<nElementos && bandera==false){
            if(arreglo[i]==dato){
                bandera=true;
            }
            i++;
        }
      
        if(bandera==false){
            System.out.println("No existe el dato.");
        }else if(bandera==true){
            JOptionPane.showMessageDialog(null, "El dato encontrado"
                    + "esta en la posicion: "+ (i-1));
        }
    }
}