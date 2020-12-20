package HashTable2;

public class CasaRural {

    private String codigo;
    private String poblacion;
    private String direccion;
    private int numHabitacion = 0;
    private double precio = 0;
    static boolean esAlta;

    public CasaRural(String codigo, String poblacion, String direc, int num, double precio) {
        this.codigo = codigo;
        this.poblacion = poblacion;
        direccion = direc;
        numHabitacion = num;
        this.precio = precio;
        esAlta = true;
        
    }

    

    public String getCodigo() {
        return codigo;
    }

    public void muestra() {
        System.out.println("\n Casa Rural " + codigo);
        System.out.println("Población: " + poblacion);
        System.out.println("Dirección: " + direccion);
        System.out.println("Precio por día: " + precio);
    }

}
