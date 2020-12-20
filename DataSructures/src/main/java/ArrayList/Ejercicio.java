
package ArrayList;

//Almacenamiento de datos en lista dinámica a través de ArrayList.

import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio {
    
    static ArrayList<String> listaEmpl = new ArrayList<String>();
       
    
    public static void menu(){
         System.out.println("Menú principal");
         System.out.println("1. Incluir Empleado");
         System.out.println("2. Actualizar Empleado.");
         System.out.println("3. Eliminar Empleado.");
         System.out.println("4. Mostrar Empleado.");
         System.out.println("5. Salir.");
               
     }
    
    
   public static void main(String[] args) {
        
     Scanner entrada = new Scanner(System.in);
     
     int opcion;
     String empl;
        
     do{
         System.out.println("\n");
         menu();
         opcion = entrada.nextInt();
         switch(opcion){
             
             case 1: //Insertando
                    System.out.println("Insertando un empleado");
                    entrada.nextLine();//Limpiar el buffer.
                    System.out.println("Nombre: ");
                    empl = entrada.nextLine();
                    listaEmpl.add(empl);//Se agreg el objeto empleado a la lista.
                    break;
                    
             case 2: //Actualizando
                    String nuevoEmp = new String();
                    boolean bandera = false;                   
                    System.out.println("\n");   
                    
                    entrada.nextLine();//Limpia el bufer
                    System.out.println("Nombre del empleado a modificar: ");
                    empl = entrada.nextLine();
                    
                    for(int pos =0; pos<listaEmpl.size(); pos++){
                        if(empl.compareToIgnoreCase(listaEmpl.get(pos))==0){//Si son iguales..
                            System.out.println("Nuevo nombre del empleado: ");
                            nuevoEmp = entrada.nextLine();
                            listaEmpl.set(pos, nuevoEmp);
                            System.out.println("\n\nRegistro Actualizado.");
                            bandera=true;
                            break;    
                        }
                    }
                    if(bandera==false){
                        System.out.println("El empleado no existe.");
                    }
                    break;
                    
             case 3://Eliminando
                bandera = false;
                char resp;
                
                 System.out.println("\n");
                 entrada.nextLine();
                 System.out.println("Nombre del empleado a eliminar: ");
                 empl = entrada.nextLine();
                 
                 for(String e: listaEmpl){
                     if(e.equalsIgnoreCase(empl)){
                         System.out.println("Desea eliminar al empleado (s/n) ");
                         resp = entrada.nextLine().toLowerCase().charAt(0);
                            if(resp =='s'){
                                listaEmpl.remove(e);
                                System.out.println("\n\nEmpleado eliminado.");
                                bandera=true;                               
                            }
                            break;
                     }
                 }
                 if(bandera==false){
                     System.out.println("El empleado no existe.");
                 }
                 break;
              
             case 4: //Mostrar EMpleados.
                 System.out.println("\nLista de Empleados\n");
                 if(listaEmpl.isEmpty()){
                     System.out.println("No hay registros en la lista. ");
                 }else{
                     //Forma de DIOSES para imprimir un array...
                     listaEmpl.forEach((e) ->{
                         System.out.println(e);
                     });
                 }
                 break;
             case 5: //salir
                 opcion=5;
                 break;
             default://Si no es ninguna de las opciones anteriores
                 System.out.println("Opcion Inválida.");
                 break;
         }
     }while(opcion !=5);                   
    }
}
