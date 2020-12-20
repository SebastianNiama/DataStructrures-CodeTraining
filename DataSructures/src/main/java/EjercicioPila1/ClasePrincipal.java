
package EjercicioPila1;

import javax.swing.JOptionPane;

public class ClasePrincipal {
    public static void main(String[] args) {
        
        int opcion =0, nodo =0;
        /*
        Creamos objeto del tipo de la clase Pila.
        */
        Pila pila = new Pila();
        
        /*
        Esta clase mostrará el menú de opciones tanto logica como grafica
        */
        
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "Menu de Opciones\n\n"
                        + "1. Insertar un nodo\n"
                        + "2. Eliminar un nodo\n"
                        + "3. ¿la Pila está vacia?\n"
                        + "4. ¿Cual es el ultimo valor ingresado en la pila?\n"
                        + "5. ¿Cuantos nodos tiene la pila?\n"
                        + "6. Vaciar Pila\n"
                        + "7. Mostrar contenido de la Pila\n"
                        + "8. Salir. \n\n"));
                        
                switch(opcion){
                    case 1:
                        nodo = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Por favor ingrese el valor a guardar en el nodo"));
                        pila.InsertarNodo(nodo);
                        break;
                    case 2:
                        if(!pila.PilaVacia()){
                            JOptionPane.showMessageDialog(null, "Se ha eliminado un nodo con el valor de "+
                                     pila.EliminarNodo());
                        }else{
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        }
                        break;
                    case 3:
                        if(pila.PilaVacia()){
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        }else{
                            JOptionPane.showMessageDialog(null, "La pila NO esta vacia");
                        }
                        break;
                    case 4:
                        if(!pila.PilaVacia()){
                            JOptionPane.showMessageDialog(null, "El ultimo valor ingresado en la pila es "
                            + pila.MostrarUltimoValorIngresado());
                        }else{
                            JOptionPane.showMessageDialog(null, "La pila esta vacia.");
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "La pila contiene "+ pila.TamanoPila()+ " nodos.");
                        break;
                    case 6:
                        if(!pila.PilaVacia()){
                            pila.VaciarPila();
                            JOptionPane.showMessageDialog(null, "Se ha vaciado la pila correctamente");
                        }else{
                            JOptionPane.showMessageDialog(null, "La pila está vacía.");
                        }
                        break;
                    case 7:
                        pila.MostrarValores();
                        break;
                    case 8:
                        opcion=8;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelve a intentar.");
                        break;
                }        
                        
            }catch(NumberFormatException e){
                
            }
        }while(opcion !=8);
    }
}
