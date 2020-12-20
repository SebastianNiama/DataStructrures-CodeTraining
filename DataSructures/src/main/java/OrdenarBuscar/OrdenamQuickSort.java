package EstructurasDatos;
//Este es un metodo recursivo y es el mas eficiente para ordenar 
//una secuencia de numeros

public class OrdenamQuickSort {

    public static void main(String[] args) {
            int arreglo[] = {9,6,7,0,5,13,2,1,11,12,4,3};

            ordenarQuicksort(arreglo);
            
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print("["+arreglo[i]+"] ");
        }
    }
    
    

    public static void ordenarQuicksort(int[] array) {
        array = quicksort1(array);
    }

    public static int[] quicksort1(int numeros[]) {
        return quicksort2(numeros, 0, numeros.length - 1);
    }

    public static int[] quicksort2(int numeros[], int izq, int der) {

        if (izq >= der) {
            return numeros;
        }
        
        int i = izq, d = der;

        if (izq != der) {
            int pivote;
            int aux;
            pivote = izq;
            while (izq != der) {

                while (numeros[der] >= numeros[pivote] && izq < der) {
                    der--;
                }
                
                while (numeros[izq] < numeros[pivote] && izq < der) {
                    izq++;
                }
                if (der != izq) {
                    aux = numeros[der];
                    numeros[der] = numeros[izq];
                    numeros[izq] = aux;
                }
                if (izq == der) {
                    quicksort2(numeros, i, izq - 1);
                    quicksort2(numeros, izq + 1, d);
                }
            }

        } else {
            return numeros;
        }
        
        
        return numeros;

    }

}
