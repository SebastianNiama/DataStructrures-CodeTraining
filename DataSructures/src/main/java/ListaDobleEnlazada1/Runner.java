package ListaDobleEnlazada1;

public class Runner {

    public static void main(String[] args) {

        ListaDoble ld = new ListaDoble();

        ld.insertarInicio("a");
        ld.insertarFin("b");
        ld.insertarFin("c");

        
        
        
        ld.mostrarAdelante();
        System.out.println("");
        ld.mostrarRegreso();
        
        System.out.println("");
        
        System.out.println(ld.extraerInicio());
        System.out.println("");
        ld.mostrarAdelante();
        
        System.out.println("");
        System.out.println(ld.extraerFin());
        System.out.println("");
        
        ld.mostrarRegreso();
                
        
    }
}
