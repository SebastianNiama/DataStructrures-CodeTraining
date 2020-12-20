
package EstructurasDatos;

public class OrdenarShellSort {
    //Es un metodo iterativo.
    //Es mejor que el ordenamiento de insercion
    
    public static void main(String[] args) {
        int array[] = {3, 9, 1, 8, 2, 7};
        shell(array);
    }
    
    //Metodo shell sort
    public static void shell (int []arreglo){
        int salto, i, j, k, auxiliar;
        
        salto =arreglo.length/2;
        
        while(salto >0){
            for(i=salto; i<arreglo.length; i++){
                j = i-salto;
                while(j>=0){
                    k=j+salto;
                    if(arreglo[j]<=arreglo[k]){
                        j=-1;
                    }else{
                        auxiliar = arreglo[j];
                        arreglo[j]=arreglo[k];
                        arreglo[k]=auxiliar;
                        j-=salto;
                    }
                        
                }
                    
            }
            salto=salto/2;
        }
        System.out.println("Arreglo ordenado con shell");
        mostrarArreglo(arreglo);
    }
    
    public static void mostrarArreglo(int x[]){
        for(int i=0; i<x.length;i++){
            System.out.print("["+x[i]+"] ");
        }
    }
    
    
}
