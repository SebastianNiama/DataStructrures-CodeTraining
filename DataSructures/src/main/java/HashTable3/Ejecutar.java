
package HashTable3;

public class Ejecutar {
    public static void main(String[] args) {
        
        TablaDispersaEnlazada miTabla = new TablaDispersaEnlazada();
        
        TipoSocio[] socios = new TipoSocio[2];
        socios[0] = new TipoSocio("Henry", 1720, 21, 22, 5, 2020);
        
        miTabla.insertar(socios[0]);
        //miTabla.insertar(new TipoSocio("Enrique", 111, 21, 6, 5, 2020));
        System.out.println("Nombre de mi socio: "+miTabla.buscar(111));
        
    }
}
