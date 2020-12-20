/*
Escribir un programa que cree una pila de enteros y realice operaciones de 
añadir datos a la pila, quitar...
El programa crea una pila de
números enteros, inserta en la pila elementos leídos del teclado (hasta 
leer la clave -1) y a continuación extrae los elementos de la pila hasta que
se vacía. El bloque de sentencias se encierra en un bloque try para tratar
errores de desbordamiento de la pila.
*/
package PilaLineal;

import PilaLineal.PilaLineal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaPilaLineal {
    public static void main(String[] args) throws IOException {
        
        PilaLineal<Integer> pila;
        int x;
        final int CLAVE =-1;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Teclea los elemento (termina con -1).");
        
        try {
            pila = new PilaLineal<>();//Crea una pila vacia          
            do{                    
                    x= Integer.parseInt(entrada.readLine());
                    pila.insertar(x);                  
              } while (x!=-1);
            
            System.out.println("Elementos de la pila: ");
            while(!pila.pilaVacia()){//Mientras la pila tenga elementos:
                x= pila.quitar();
                System.out.println(x+" "); 
            }
            
        } catch (Exception er) {
            String error = entrada.readLine();
            
            System.out.println(er.toString()+error);
        }
    }
}
