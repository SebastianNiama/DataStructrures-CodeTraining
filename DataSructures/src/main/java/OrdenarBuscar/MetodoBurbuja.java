
package EstructurasDatos;
import java.util.*;
import javax.swing.JOptionPane;

public class MetodoBurbuja {
    public static void main(String[] args) {
        
        int arreglo[], nElementos, aux;
        
        Scanner entrada = new Scanner(System.in);
        
        nElementos = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantida de elementos del arreglo; "));
        arreglo = new int[nElementos];
        
        for (int i = 0; i < nElementos; i++) {          
            arreglo[i]=(int) Math.round(Math.random()*100);           
        }
        System.out.println("Arreglo desordenado: \n");
        
         for (int i = 0; i < nElementos; i++) {          
             System.out.print(" ["+arreglo[i]+"]");        
        }
         System.out.println("\n");
         
         //Metodo de la burbuja ascendente:
         for(int i = 0; i<nElementos-1; i++){
             for (int j = 0; j < nElementos-1; j++) {
                 if(arreglo[j]>arreglo[j+1]){
                     aux = arreglo[j];
                     arreglo[j]= arreglo[j+1];
                     arreglo[j+1]= aux;
                 }
             }
         }
         
         System.out.println("Arreglo ordenado crecientemente: \n");
        
         for (int i = 0; i < nElementos; i++) {          
             System.out.print(" ["+arreglo[i]+"]");        
        }
         
         //Metodo de la burbuja descendente:
         for(int i = 0; i<nElementos-1; i++){
             for (int j = 0; j < nElementos-1; j++) {
                 if(arreglo[j]<arreglo[j+1]){
                     aux = arreglo[j+1];
                     arreglo[j+1]= arreglo[j];
                     arreglo[j]= aux;
                 }
             }
         }
         System.out.println("\n");
          System.out.println("Arreglo ordenado decrecientemente: \n");
        
         for (int i = 0; i < nElementos; i++) {          
             System.out.print(" ["+arreglo[i]+"]");        
        }
         
         
    }
}
