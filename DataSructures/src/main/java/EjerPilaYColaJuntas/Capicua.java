/*
Comprobar si un numero es capicua, se utiliza la clase PilaListaEnlazada
y ColaCircular.
Una vez que se terminan de leer los dígitos y de ponerlos en la Cola
y en la Pila, comienza el paso de comprobación: se extraen en paralelo elementos 
de la cola y de la pila, y se comparan por igualdad.  De producirse alguna no 
coincidencia entre dígitos, significa que el número no es capicúa, y entonces se
vacían las estructuras para pedir, a continuación, otra entrada. El número es 
capicúa si el proceso de comprobación termina con la coincidencia de
todos los dígitos en orden inverso y tanto la pila como la cola quedan vacías.
 */
package EjerPilaYColaJuntas;

import Queues.ColaCircular;
import PilaEnlazada.PilaListaEnlazada;
import java.io.*;

public class Capicua {
    public static void main(String[] args) {
        
        boolean capicua;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String numero;
        
        PilaListaEnlazada pila = new PilaListaEnlazada();
        ColaCircular cola = new ColaCircular();
        
        try {
            capicua = false;
            while(!capicua){//Mientras capicua sea falso
                do{
                    System.out.println("Teclee el numero: ");
                    numero = entrada.readLine();
                }while(!valido(numero));//Mientras el numero sea invalido/falso
                //Una vez el numero es correcto:
                //Llenamos en la cola y en la pila, cada digito:
                for(int i=0; i<numero.length();){
                    char c;
                    c = numero.charAt(i++);
                    cola.insertar(c);
                    pila.insertar(c);
                }
                //Retiramos cada elemento de la cola y pila para comparar
                do{
                    capicua = cola.quitar().equals(pila.quitar());                
                }while(capicua && !cola.colaVacia());
                
                if(capicua) System.out.println(numero+ " es capicua.");
                else System.out.println(numero+ " no es capicua.\nIntente otra vez.");
                
                cola.borrarCola();
                pila.limpiarPila();
                
            }
        } catch (Exception e) {
            System.err.println("Error (Exepcion) en el proceso "+e);
        }
    }
    
    public static boolean valido(String numero){
        boolean sw = true;
        int i=0;
        
        while(sw &&(i<numero.length())){
            char c;
            c = numero.charAt(i++);
            sw = (c>='0' && c<='9');
        }
        return sw;
    }
}
