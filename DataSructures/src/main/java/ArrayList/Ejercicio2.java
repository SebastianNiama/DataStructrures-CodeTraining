
package ArrayList;
import java.util.ArrayList;

public class Ejercicio2 {
    
    public static void main(String[] args) {
        
        /*
        Empleado listaEmpleados[] = new Empleado[3];
        
        listaEmpleados[0] = new Empleado("Ana", 45, 2500);
        listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
        listaEmpleados[2] = new Empleado("Maria", 25, 2600);
    */
        //Constructor por defecto: (los parentesis vacios.)
        ArrayList <Empleado> listaEmpleados = new ArrayList<Empleado>();
        //Vamos a decirle la cantidad de elementos que queremos en el array
        //listaEmpleados.ensureCapacity(11);
        
        
        listaEmpleados.add(new Empleado("Ana", 45, 2500));
        listaEmpleados.add(new Empleado("Antonio", 55, 2000));
        listaEmpleados.add(new Empleado("Maria", 25, 2600));
        listaEmpleados.add(new Empleado("Jose", 35, 2900));
        //Reemplazos un nuevo dato en una posicion especifica.
        listaEmpleados.set(1, new Empleado("Olga", 22, 2000));
        //Para acceder a un elemento en concreto:
        //Vamos a decirle que nos imprima el elemento que esta en 5to lugar
        System.out.println(listaEmpleados.get(3).dameDatos());
        System.out.println("");
        //System.out.println(listaEmpleados.size());
        
        /*
        Cuando este seguro de que no voy a agregar mas objetos a mi 
        array list y quiero/debo optimizar los recursos de memoria
        utilizo el siguiente metodo que va a redimensionar mi
        arrayList. osea, va a eliminar los espacios en memoria
        que se crearon por defecto y va a dejar solo los espacios que
        estoy ocupando, minimiza/recorta la capacidad. Cierra el arrayList.
        */
        listaEmpleados.trimToSize();
        
       /*
        for(Empleado e:listaEmpleados){
            System.out.println(e.dameDatos());
        }
        */
        
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado e = listaEmpleados.get(i);
            System.out.println(e.dameDatos());
        }
    
        
    }
}

class Empleado{
    
    private String nombre;
    private int edad;
    private double salario;
    
    public Empleado(String nombre, int edad, double salario){
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }
    
    public String dameDatos(){
        return "El Empleado se llama "+nombre+" tiene "+ edad+
                " años. Y un salario de "+salario;
    }
            
    
}
        

