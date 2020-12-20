/*
Escribir un programa que utilice una Pila para comprobar si una determinada frase/palabra
(cadena de caracteres) es un palíndromo. Nota: una palabra o frase es un palíndromo cuando la
lectura directa e indirecta de la misma tiene igual valor: alila, es un palíndromo; cara (arac) no
es un palíndromo.
 */
package PilaLineal;

import PilaLineal.PilaLineal;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EjecutaPilaLineal2 {

    public static void main(String[] args) {

        PilaLineal<Character> pilaChar;
        char ch[];
        boolean esPal = true;
        String pal;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            pilaChar = new PilaLineal<Character>(); // crea pila vacía
            System.out.println("Teclee la palabra a verificar si es palindromo: ");
            pal = entrada.readLine();
            ch = new char[pal.length()];
            //Se crea la pila con los caracteres de la palabra:
            for (int i = 0; i < pal.length();i++) {
                ch[i]=pal.charAt(i);
                pilaChar.insertar(ch[i]);
            }
            //Ahora se comprueba si es palindromo:     
            esPal = true;
            for (int j = 0; esPal && !pilaChar.pilaVacia();j++) {
                char recibido;
                recibido =  pilaChar.quitar();
                esPal = ch[j] == recibido;
            }
            
            pilaChar.limpiarPila();
            
            if(esPal==true){
                System.out.println("La palabra"+pal+" es palindromo");
            }else if(esPal ==false){
                System.out.println("La palabra"+pal+" NO es palindromo");
            }

        } catch (Exception er) {
            System.err.println("Excepcion: " + er);
        }
    }
}
