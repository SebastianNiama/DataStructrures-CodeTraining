package EstructurasDatos;

import static EstructurasDatos.OrdenaQuickSort2.quicksort;

public class BusquedaBinaria2 {

    public static void main(String[] args) {
        
        double data[] = {9, 10, 1, 4, 3, 8, 0, 7, 5, 6, 2}; //Array a ordenar
        quicksort(data, 0, data.length - 1);

        double searchedValue = 4; // Valor a buscar
        boolean found = false;
        int low = 0, pos = 0;
        int high = data.length - 1;
        
        while (low <= high && !found) {
            pos = (low + high) / 2; // Mitad del array
            if (data[pos] == searchedValue) {
                found = true;
            } // Encontrado
            else if (data[pos] < searchedValue) {
                low = pos + 1;
            } // Busca en la primera mitad
            else {
                high = pos - 1;
            } // Busca en la segunda mitad
        }
        
        if (found) {
            System.out.println("Encontrado en la posicion " + pos );
        } else {
            System.out.println("No encontrado");
        }
    }



static void quicksort(double data[], int izq, int der){
        int i= izq;
        int j = der;
        
        double pivote = data[izq+ (der-izq)/2];//Elemento pivote, mitad             
        //Division en 2 subarrays:       
        while(i<=j){
            while(data[i]<pivote) i++;//valores menores al pivote
            while(data[j]>pivote) j--;//valores mayores al pivote
            
            if(i<=j){//Intercambiar y seguir
                double tmp = data[i];
                data[i] = data[j];
                data[j] =tmp;
                i++;
                j--;
            }           
        }
            if(izq<j) quicksort(data, izq, j); //Recursion subarray <
            if(i< der) quicksort(data, i, der);//Recursion subarray >
            
    }
}
