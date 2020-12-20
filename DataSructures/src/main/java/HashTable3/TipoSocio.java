/*
Realizacion de una tabla dispersa encadenada:
 */
package HashTable3;

public class TipoSocio {
              
    private String nombre;
    int codigo;
    private int edad;
    private Fecha f;
    
    public TipoSocio(String name, int code, int edad, int d, int m, int a){
        nombre = name;
        codigo = code;
        this.edad = edad;
        f = new Fecha(d, m, a);
    }
    
    public int getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    
          
}


class Fecha{
        int dia, mes, anno;
       Fecha(int d, int m, int a){
           dia = d;
           mes = m;
           anno = a;
       }    
       public String toString(){
           return " "+ dia+ "-"+mes+"-"+anno;
       }
    }


class Elemento{
    
        TipoSocio socio;
        Elemento sgte;
        
        public Elemento(TipoSocio e){
            socio = e;
            sgte = null;
        }
        public TipoSocio getSocio(){
            return socio;
        }              
    }