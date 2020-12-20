
package EjercicioPila2;

import javax.swing.JOptionPane;

public class ClasePrincipal {
    public static void main(String[] args) {
        int opcion =0; 
        int nodo = 0;
        Pila pila = new Pila();
        
        do{
            
            try {
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
                       nodo =Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor a"
                                + " guardar en el nodo: "));
                       pila.insertarNodo(nodo);
                        break;
                    case 2:
                         if(!pila.pilaVacia()){
                            JOptionPane.showMessageDialog(null, "Se ha eliminado un nodo con el valor de "+
                                     pila.eliminarNodo());
                        }else{
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        }
                        break;
                    case 3:
                        if(pila.pilaVacia()){
                            JOptionPane.showMessageDialog(null, "La pila esta vacia.");
                        }else{
                            JOptionPane.showMessageDialog(null, "La pila NO esta vacia.");
                        }
                        break;
                    case 4:
                        if(!pila.pilaVacia()){//Si esta llena
                            JOptionPane.showMessageDialog(null, "El ultimo valor de la pila es: "
                                    +pila.mostrarUltimoValorIngresado());
                        }else{
                           JOptionPane.showMessageDialog(null, "La pila esta vacia."); 
                        }
                            
                            
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "La Pila contiene "+pila.tamanoPila()+ " nodos.");
                        break;
                    case 6:
                        if(!pila.pilaVacia()){//Si la pila no esta vacia(esta llena)
                            pila.vaciarPila();
                            JOptionPane.showMessageDialog(null, "Se ha vaciado la pila correctamente");
                        }else{
                            JOptionPane.showMessageDialog(null, "La pila esta vacia.");
                        }
                            
                        break;
                    case 7:
                        pila.mostratValores();
                        break;
                    case 8:
                        opcion=8;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelve a intentar.");
                        break;
                       
                }
                
            } catch (NumberFormatException e) {
                
            }
            
            
        }while(opcion !=8);
        
    }
}
