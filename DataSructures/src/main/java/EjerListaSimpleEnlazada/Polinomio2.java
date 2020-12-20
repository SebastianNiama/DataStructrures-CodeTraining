package EjerListaSimpleEnlazada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Polinomio2 {

    private Nodo inicio;
    private int tamagno;

    public Polinomio2() {
        inicio = null;
        tamagno = 0;
    }

    private void addFirst(Nodo n) {
        Nodo nuevo = n;
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
        tamagno++;
    }

    public void addNode(int coef, int expo) {

        if (expo == 0) {
            expo = 1;
        }

        Nodo nuevo = new Nodo(coef, expo, null);//Nodo final, apunta a nulo
        //Si esta vacio:
        if (inicio == null) {
            addFirst(nuevo);
        } else {//si existen elementos:

            Nodo temp = inicio;//creo nodo temporal
            int contar = 0;
            boolean bandera = true;

            while (temp.getExpo() > nuevo.getExpo()) {

                if ((temp.getSiguiente() == null)) {
                    bandera = false;
                    break;
                }
                temp = temp.getSiguiente();
                contar++;
            }

            if (bandera == false) {//si nunca entro al for..

                temp.setSiguiente(nuevo);//lo ubico en su posicion correcta.
                tamagno++;
            } else if (bandera && contar == 0) {
                addFirst(nuevo);
            } else if (bandera && contar != 0) {
                temp = inicio;

                if (contar == 1) {
                    nuevo.setSiguiente(temp.getSiguiente());
                    temp.setSiguiente(nuevo);
                } else if (contar > 1) {
                    for (int i = 0; i < contar - 1; i++) {
                        temp = temp.getSiguiente();
                    }
                    nuevo.setSiguiente(temp.getSiguiente());
                    temp.setSiguiente(nuevo);
                }

            }

        }
    }

    
    
    public void show() {
        Nodo temp = inicio;
        int contador = 0;
        while (temp != null) {
            contador++;
            if ((temp.getExpo() == 1) && contador == 1) {
                System.out.print(temp.getCoef() + "X ");
            } else if ((contador != 0 && temp.getCoef() < 0) || contador == 1 && temp.getCoef() > 0) {
                System.out.print(temp.getCoef() + "X^" + temp.getExpo() + "  ");
            } else if ((temp.getExpo() == 1) && contador != 1) {
                System.out.print("+" + temp.getCoef() + "X ");
            } else if (contador != 0 && temp.getCoef() > 0) {
                System.out.print("+" + temp.getCoef() + "X^" + temp.getExpo() + "  ");
            }

            temp = temp.getSiguiente();
        }
    }

    
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        Polinomio2 mipoli = new Polinomio2();
        Scanner en = new Scanner(System.in);
        int base, expo;
        char c = 'n';

        System.out.println("Escriba un polinomio de la forma: \n"
                + "P(x) = ax^n + bx^n + ......c \n"
                + "Donde: \n"
                + "1. a != 0, b !=0\n"
                + "2. n pertenece a Z (enteros + o -)\n");

        try {

            do {
                do {
                    System.out.println("Digite base: ");
                    base = en.nextInt();
                    if (base == 0) {
                        System.out.println("Hombre, digite una base !=0");
                    }
                } while (base == 0);
                System.out.println("Digite exponente de la base: ");
                expo = en.nextInt();
                if (expo == 0) {
                    expo = 1;
                }
                mipoli.addNode(base, expo);
                mipoli.show();

                System.out.println("\nDesea agregar mas terminos? (S/N)");
                c = en.next().toUpperCase().charAt(0);

            } while (c == 'S');

        } catch (InputMismatchException | NumberFormatException e) {
            String valor;
            valor = en.next();
            System.out.println("Error en la entrada de datos " + valor + "\n" + e.toString());
        }

        System.out.println("Polinomio: ");
        mipoli.show();

    }

}

class Nodo {

    private int coef, expo;
    private Nodo siguiente;

    public Nodo(int coef, int expo, Nodo s) {
        this.coef = coef;
        this.expo = expo;
        siguiente = s;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExpo() {
        return expo;
    }

    public void setExpo(int expo) {
        this.expo = expo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
