//Aqui se realizan las operaciones de la tabla dispersa
//EXPLORACION DE DIRECCIONES: 
package HashTable2;

public class TablaDispersaCR {

    static final int TAMTABLA = 101;
    private int numElementos;
    private double factorCarga;
    private CasaRural[] tabla;

    /*
    El constructor de TablaDispersa crea el array con el tamaño especificado 
    e inicializa a null cada posición. Los atributos numElementos y factorCarga
    se inicializan a 0.
     */
    public TablaDispersaCR() {
        tabla = new CasaRural[TAMTABLA];
        for (int j = 0; j < TAMTABLA; j++) {
            tabla[j] = null;
        }
        numElementos = 0;
        factorCarga = 0.0;
    }

    private long transformaCadena(String c) {
        long d;
        d = 0;
        for (int j = 0; j < Math.min(10, c.length()); j++) {
            d = d * 27 + (int) c.charAt(j);
        }
        if (d < 0) {
            d = -d;
        }
        return d;
    }

    private int direccion(String clave) {
        int i = 0, p;
        long d;
        d = transformaCadena(clave);
        // aplica aritmética modular para obtener dirección base 
        p = (int) (d % TAMTABLA);
        //bucle de exploracion:
        while (tabla[p] != null && !tabla[p].getCodigo().equals(clave)) {
            i++;
            p = p + i * i;
            p = p % TAMTABLA;//considera el array como circular
        }
        return p;
    }

    public void insertar(CasaRural r) {
        int posicion;
        posicion = direccion(r.getCodigo());
        tabla[posicion] = r;
        numElementos++;
        factorCarga = (double) (numElementos / TAMTABLA);
        if (factorCarga > 0.5) {
            System.out.println("\n!! Factor de carga supera el 50%.!!"
                    + " Conviene aumentar el tamaño.");
        }
    }
    
    public CasaRural buscar(String clave){
        CasaRural pr;
        int posicion;
        posicion = direccion(clave);
        pr = tabla[posicion];
        if(pr !=null)
            if(!pr.esAlta) pr = null;
        return pr;        
    }
    
    //EN realidad siguen existiendo los elementos nunca se eleiminan.
    public void eliminar(String clave){
        int posicion = direccion(clave);
        if(tabla[posicion] !=null)//Osea q si existe un objeto guardado
            tabla[posicion].esAlta = false;//Solo en esa posicion se da de baja-
    }

}
