
package EjerDeCola;

import javax.swing.JOptionPane;

public class ClasePrincipal {
    public static void main(String[] args) {
        int opcion =0, nodoInformacion =0;
        Cola cola = new Cola();
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("\n"
                        + "Menu de Opciones\n\n"
                        + " 1. Insertar un nodo\n"
                        + "2. Extraer un Nodo\n"
                        + "3. Mostrar contenido de la Cola\n"
                        + "4. Salir.\n"));
                switch(opcion){
                    case 1:
                        nodoInformacion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa valor a guardar en el nodo"));
                        cola.insertar(nodoInformacion);
                        break;
                    case 2:
                        if(!cola.colaVacia()){
                            JOptionPane.showMessageDialog(null, "Se extrajo un nodo con el valor de "+cola.extraer());
                        }else{
                            JOptionPane.showMessageDialog(null, "Cola vacia ");
                        }
                        break;
                    case 3:
                        cola.mostrar();
                        break;
                    case 4:
                        opcion =4;
                        break;
                    default: JOptionPane.showMessageDialog(null, "Opcion no disponible.");
                }
            } catch (NumberFormatException e) {
            }
        }while(opcion !=4);
    }
}
