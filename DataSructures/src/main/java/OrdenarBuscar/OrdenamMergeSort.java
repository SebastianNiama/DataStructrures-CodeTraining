package EstructurasDatos;

import static EstructurasDatos.OrdenamQuickSort.ordenarQuicksort;

public class OrdenamMergeSort {

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    private static int[] mergeSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int midpoint = array.length / 2;

        int[] left = new int[midpoint];
        int[] right;

        if (array.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }

        for (int i = 0; i < midpoint; i++) {
            left[i] = array[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = array[midpoint + j];
        }

        int[] result = new int[array.length];

        left = mergeSort(left);
        right = mergeSort(right);
        result = merge(left, right);

        return result;
    }

    //This method is going to merge both the left and the right array
    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        /*
        We are gonna declare variables which are the pointers
        for each integer array
         */
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        /*
         While there are elements in either the left array or the right 
        array, because we want to merge those together. If there are none,
        we do not want to merge those together.
        So this will ensure that we will have something to merge
         */
        while (leftPointer < left.length || rightPointer < right.length) {

            /*
            We are checking if both the left and right array have
            elements in them that is very important okay
             */
            if (leftPointer < left.length && rightPointer < right.length) {
                /*
                If the prior complies, we need to compare the left and right 
                array.
                We need to find out which is smaller:
                 */
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }

                //If there area only elements in the left array:
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }

        return result;

    }

    public static void main(String[] args) {
            int arreglo[] = {9,6,7,0,5,13,2,1,11,12,4,3};
            System.out.println("Initial Array: ");
                    
            printArray(arreglo);
            
            arreglo = mergeSort(arreglo);
            System.out.println("Sorted Array: ");
            printArray(arreglo);
    }
}
