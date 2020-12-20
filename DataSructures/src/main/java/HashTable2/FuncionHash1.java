/*
FUNCION HAS: METODO DE LA MULTIPLICACION
Las claves son cadenas de caracteres, primero se transforma
a valor entero. A continuación se aplica el método de multiplicación
 */
package HashTable2;
import java.io.*;

public class FuncionHash1 {
    
    static final int M=1024;//Tamaño de mi tabla
    static final double R = 0.618034;//valor aletorio decimal entre 0-1
    
    static long transformaClave(String clave){
        long d;
        d =0;
        for(int j=0; j<Math.min(clave.length(), 10); j++){
            d = d*27 + (int) clave.charAt(j);           
        }
     /*
    Para un valor mayor que el máximo entero genera un
    numero negativo.
    */   
       if(d<0) d =-d;
       
       return d;
    }
    
    static int dispersion(long x){
        double t;
        int v;
        t = R*x - Math.floor(R*x); //Parte decimal
        v = (int) (M*t);
        return v;//retorna una posicion
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        
        String clave;
        long valor;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
       
        
        for(int k=1; k<=10; k++){
            System.out.println("\nClave a dispersar: ");
            clave = entrada.readLine();
            valor = transformaClave(clave);
            valor = dispersion(valor);
            System.out.println("Dispersion de la clave "+clave+" \t " + valor);
        }

    }
}
