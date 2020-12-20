
package HashTable3;



public class TablaDispersaEnlazada {
    
    private static final int M = 101;
    private static final double R =0.618034;
    private Elemento [] tabla;
    private int numElementos;
    
    //Contructor que inicializa tabla vacia
    public TablaDispersaEnlazada(){
        tabla = new Elemento[M];//Inicio tabla de elementos/nodos
        for(int k =0; k<M; k++) tabla[k] = null;//relleno todas con null
        numElementos=0;
    }
    
    //Operaciones:
    private int dispersion(long x){
        double t;
        int v;
        t = R*x - Math.floor(R*x);
        v = (int)(M*t);
        return v;
    }
    
    public void insertar(TipoSocio s){
        int posicion;
        Elemento nuevo;
        
        posicion= dispersion(s.getCodigo());
        nuevo = new Elemento(s);
        nuevo.sgte = tabla[posicion];//en sgte se guarda el anterior
        tabla[posicion] = nuevo;//Se sobreescribe esa posicion
        numElementos++;        
    }
    
    public void eliminar(int codigo){
        int posicion = dispersion(codigo);
               
        if(tabla[posicion]!=null){//Si no esta vacia
            Elemento anterior, actual;
            
            anterior = null;
            actual = tabla[posicion];
            
            while((actual.sgte !=null) && actual.getSocio().getCodigo()!=codigo){
                anterior = actual;
                actual = actual.sgte;
            }
                
            if(actual.getSocio().getCodigo()!=codigo){
                System.out.println("No se encuentra en la tabla el socio "
                + codigo);
            }else{//Si son iguales, debemos eliminar el nodo:
                if(anterior ==null) tabla[posicion]= actual.sgte;
                else anterior.sgte = actual.sgte;
                
                actual =null;
                numElementos--;
            }               
        }else{System.out.println("No está registrado. ");}
    }
    
    public Elemento buscar(int codigo){
        Elemento p=null;
        int posicion =dispersion(codigo);
        
        if(tabla[posicion] !=null){
            p = tabla[posicion];
            while((p.sgte!=null)&& p.socio.codigo !=codigo) p = p.sgte;
                
            if(p.socio.codigo !=codigo) p =null;         
        }
        return  p;            
    }
    
    
}
