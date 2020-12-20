
package EstructurasDatos;

import java.util.Scanner;

 public class Arreglos1 {
     public static void main(String[] args) {
         Scanner entrada = new Scanner(System.in);
         int arreglo [] = new int [10];
         boolean creciente = false;
         boolean decreciente = false;
         
         System.out.println("Llenar el arreglo; ");
         for (int i = 0; i < 10; i++) {
             System.out.println((i + 1)+". Digite un numero; ");
             arreglo[i]= entrada.nextInt();
             
         }
         
         for (int i = 0; i < 9; i++) {
             if(arreglo[i]< arreglo[i+1]){//creciente
                 creciente=true;
             }
             if(arreglo[i] > arreglo[i+1]){
                 decreciente =true;
             }
         }
         
         if(creciente==true && decreciente==false){
             System.out.println("/nEl arreglo esta en forma creciente.");
         }else if(creciente==false && decreciente==true){
             System.out.println("El arreglo esta en forma decreciente.");  
         }else if(creciente==true && decreciente==false){
             System.out.println("El arreglo esta en forma desordenada.");
         }else if(creciente==false && decreciente==false){
             System.out.println("Todos los numeros del arreglo son iguales.");
         }
           
         
     }
}
