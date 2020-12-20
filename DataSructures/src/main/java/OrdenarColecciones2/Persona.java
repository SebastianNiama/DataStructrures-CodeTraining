
package OrdenarColecciones2;
/*
Ahora, vamos a utilizar la interfaz "Comparable", para esto, ya no creo
una clase adicional e implemento la interfaz "Comparator", como se hizo
anteriormente. Esta vez, se va a la clase en la cual vamos a crear
Objetos de ella (Persona(esta de aqui)). Entonces, extendemos la 
interfaz "Comparable" e implementamos su metodo abstracto que es
"compareTo()" Ojo que le podemos pasar un generico, para indicar ek
valor que se va a pasar, o si no quedaria solamete asi:
public class Persona implements Comparable{
Y el metodo compareTo(Object e) recibiria solamente un parametro de
tipo Object. En este caso, si se va a indicar el parametro que queremos
manejar:
Será del tipo "Persona" mismo, ya que quiero comparar sus atributos
*/
public class Persona implements Comparable<Persona>{
    private int id;
    private String nombre;
    private int edad;

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona p) {
        /*
        Le decimos; Esta edad la vamos a restar con la edad que venga
        del parametro "p"
        */
         return (this.edad - p.getEdad());
         /*
         NOTA 1:
         En mi return tambien puedo poner (p.getEdad()- this.edad )
         al reves, asi me ordena de manera DESCENDENTE.
         NOTA 2:
         Tambien puedo comparar por los nombres:
         sería:
         return this.nombre.compareTo(p.getNombre); 
         Y se ordenaria en forma ascendente: A, B, C etc....
         SI los coloco al reves:
         return p.getNombre.compareTo(this.nombre); 
         Me ordenaria en forma descendente: Z, Y, X, W
         */
    }
    
    
}