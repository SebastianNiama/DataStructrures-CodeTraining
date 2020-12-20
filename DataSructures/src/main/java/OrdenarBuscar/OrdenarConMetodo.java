
package EstructurasDatos;
import java.util.Arrays;

public class OrdenarConMetodo {
    public static void main(String[] args) {
        
        int arr[]= {3,4,1,7,2,0,9,8,6,5};
        
        //La API de Java API ofrece un método de ordenación
//eficiente (ascendente por defecto)

        Arrays.sort(arr);
        
        for(int e:arr){
            System.out.print(e+", ");
        }
    }
}
