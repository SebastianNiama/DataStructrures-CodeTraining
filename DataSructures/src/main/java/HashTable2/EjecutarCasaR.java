
package HashTable2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutarCasaR {
    public static void main(String[] args) {
        
        String codigo="", poblacion, direccion;
        int numHabitacion;
        double precio;
        
        TablaDispersaCR miTabla = new TablaDispersaCR();
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("\nCodigo (10 caracteres):");
            codigo = entrada.readLine();
            System.out.println("\nPoblacion: ");
            poblacion = entrada.readLine();
            System.out.println("\nDireccion: ");
            direccion = entrada.readLine();
            System.out.println("\nNumero de habitaciones: ");
            numHabitacion = Integer.parseInt(entrada.readLine());
            System.out.println("\nPrecio por día de instancia: ");
            precio = (new Double(entrada.readLine())).doubleValue();
            CasaRural miCasa = new CasaRural(codigo, poblacion, direccion, numHabitacion, precio);
            miTabla.insertar(miCasa);
            
            
        } catch (IOException e) {
            System.out.println(" Excepcion en la entrada de datos "
                    + e.getMessage() + " . No se da de alta");
            CasaRural.esAlta = false;
        }
    
        System.out.println("El codigo de la casa previamente almacenada es: "+ miTabla.buscar(codigo).getCodigo());
        
        
        
    
    
    }
        
        
  
}
