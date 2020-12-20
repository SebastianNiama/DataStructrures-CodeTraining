
package EjercicioPila4;
import java.util.Stack;//Uso clase por default
//Ejercicio que va a retornar una palabra 
public class Palabra {
     
    private Stack<Character> pila = new Stack<Character>();
   
    public void invertir_palabra(String cadena){
        
        char letras[] = cadena.toCharArray();
        
        for(int i =0; i<letras.length; i++){
          System.out.print(letras[i]);
            pila.push(letras[i]);
            
        }      
        System.out.println("\n");
        while (!pila.isEmpty()) {//Mientras tenga elementos
            System.out.print(""+pila.pop());
            
            
        }
        
        
    }
      
}
