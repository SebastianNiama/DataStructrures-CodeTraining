package EstructurasDatos;

public class OrdenaQuickSort2 {

    public static void main(String[] args) {
        
        double data[] = {9, 10, 1, 4, 3, 8, 0, 7, 5, 6, 2}; //Array a ordenar
        //Invocacion metodo ordenacion
        quicksort(data, 0, data.length - 1);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+", ");
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