//NUMEROS DE LA SUERTE
package Queues;

import java.util.Iterator;
import java.util.Random;

public class EjecColaListaEn {

    public static void main(String[] args) {
        int n, n1, n2, i;
        int nv;

        ColaLista<Integer> q = new ColaLista<Integer>();
        Random r = new Random();

        try {
            //Numero inicial de la lista:
            n = 11 + r.nextInt(49);
            //Se generan n numero aleatorios.
            for (i = 1; i <= n; i++) {
                nv = 1 + r.nextInt(101);
                q.insertar(nv);
            }
            //Se genera aleatoriamente el intervalo n1
            n1 = 1 + r.nextInt(11);
            // se retiran de la cola elementos a distancia n1
            System.out.print("\nSe quita de la lista: ");
            while (n1 <= n) {
                int nt;
                n2 = 0;//contador de elementos que quedan.
                for (i = 1; i <= n; i++) {
                    nt = q.quitar();
                    if (i % n1 == 1) {
                        System.out.println(nt + " ");
                    } else {
                        q.insertar(nt);//Se vuelve a meter en la cola
                        n2++;
                    }
                }
                n = n2;
                n1 = 1 + r.nextInt(11);
            }
            System.out.println("\nLos números de la suerte: ");
            mostrarCola(q);
            System.out.println();
        } catch (Exception e) {

        }
    }
    
    // extrae y escribe los elementos de la cola
private static void mostrarCola(ColaLista q) throws Exception
{
 while (!q.colaVacia())
 {
 Integer v;
 v = (Integer) q.quitar();
 System.out.print(" " + v.intValue());
 }
}
}

