
package EstructurasDatos;

import java.util.Scanner;

 
public class DuplicadosEnArray {
    
    public static void main(String[] args) {
         Scanner es = new Scanner(System.in);
         boolean repite = false;
         
        int array[] = {3, 8, 1, 8, 2, 7};

        System.out.println("Se tiene el arreglo: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "] ");          
        }
        
        
        for(int i=0; i<array.length;i++){
            for (int j=i+1; j<array.length;j++) {               
                if(array[i]==array[j]){
                   repite =true;
                }             
            }
        }
        
        if(repite==true){
            System.out.println("\nse repiten.");
        }else{
            System.out.println("\nno se repiten");
        }
        
        
    }
   
}
