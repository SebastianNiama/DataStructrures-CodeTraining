/*
Las operaciones básicas de un árbol de búsqueda equilibrado son insertar y 
eliminar un elemento; además, se necesitan operaciones auxiliares para 
mantener los criterios de equilibrio (de cada nodo). La clase ArbolAvl implementa 
estas operaciones, su constructor inicializa la raíz a null, es decir
árbol vacío:
 */
package AVL;

public class ArbolAvl {

    NodoAvl raiz;

    public ArbolAvl() {
        raiz = null;
    }

    public NodoAvl raizArbol() {
        return raiz;
    }
    //***************************************************************************
    //ROTACIONES
    // Todos devuelven la referencia al
    //nodo raíz del subárbol implicado en la rotación. 

    //Rotacion simple II
    private NodoAvl rotacionII(NodoAvl n, NodoAvl n1) {
        n.ramaIzdo(n1.subArbolDcho());
        n1.ramaDcho(n);
        // actualización de los factores de equilibrio 
        if (n1.fe == -1) {//Se cumple en la insercion
            n.fe = 0;
            n1.fe = 0;
        } else {
            n.fe = -1;
            n1.fe = 1;
        }
        return n1;
    }

    private NodoAvl rotacionDD(NodoAvl n, NodoAvl n1) {
        n.ramaDcho(n1.subArbolIzq());
        n1.ramaIzdo(n);
        // actualización de los factores de equilibrio 
        if (n1.fe == +1) {//Se cumplen en la insercion
            n.fe = 0;
            n1.fe = 0;
        } else {
            n.fe = +1;
            n1.fe = -1;
        }
        return n1;
    }

    private NodoAvl rotacionID(NodoAvl n, NodoAvl n1) {
        NodoAvl n2;

        n2 = (NodoAvl) n1.subArbolDcho();
        n.ramaIzdo(n2.subArbolDcho());
        n2.ramaDcho(n);
        n1.ramaDcho(n2.subArbolIzq());
        n2.ramaIzdo(n1);
        // actualización de los factores de equilibrio
        if (n2.fe == +1) {
            n1.fe = -1;
        } else {
            n1.fe = 0;
        }
        if (n2.fe == -1) {
            n.fe = 1;
        } else {
            n.fe = 0;
        }
        n2.fe = 0;
        return n2;
    }

    private NodoAvl rotacionDI(NodoAvl n, NodoAvl n1) {
        NodoAvl n2;
        n2 = (NodoAvl) n1.subArbolIzq();
        n.ramaDcho(n2.subArbolIzq());
        n2.ramaIzdo(n);
        n1.ramaIzdo(n2.subArbolDcho());
        n2.ramaDcho(n1);
        //actualicacion de los factores de equilibrio
        if (n2.fe == +1) {
            n.fe = -1;
        } else {
            n.fe = 0;
        }
        if (n2.fe == -1) {
            n1.fe = 1;
        } else {
            n1.fe = 0;
        }
        n2.fe = 0;
        return n2;
    }
//***************************************************************************
    //METODO INSERTAR CON BALANCEO

    public void insertar(Object valor) throws Exception {
        Comparable dato = (Comparable) valor;
        Logical h = new Logical(false);//intercambia un valor booleano      
        raiz = insertarAvl(raiz, dato, h);
    }

    private NodoAvl insertarAvl(NodoAvl raiz, Comparable dt, Logical h) throws Exception {
        NodoAvl n1;
        if (raiz == null) {
            raiz = new NodoAvl(dt);
            h.setLogical(true);
        } else if (dt.compareTo(raiz.valorDelNodo()) < 0) {
            NodoAvl iz = insertarAvl((NodoAvl) raiz.subArbolIzq(), dt, h);
            raiz.ramaIzdo(iz);
            // regreso por los nodos del camino de búsqueda
            if (h.booleanValue()) {
                //decrementa el fe por aumentar la altura de rama izquierda 
                switch (raiz.fe) {
                    case 1:
                        raiz.fe = 0;
                        h.setLogical(false);
                        break;
                    case 0:
                        raiz.fe = -1;
                        break;
                    case -1://Aplicar la rotacion a la izquierda
                        n1 = (NodoAvl) raiz.subArbolIzq();
                        if (n1.fe == -1) {
                            raiz = rotacionII(raiz, n1);
                        } else {
                            raiz = rotacionID(raiz, n1);
                            h.setLogical(false);
                        }
                        break;
                }
            }
        } else if (dt.compareTo(raiz.valorDelNodo()) > 0) {
            NodoAvl dr = insertarAvl((NodoAvl) raiz.subArbolDcho(), dt, h);
            raiz.ramaDcho(dr);
            //regreso por los nodos del camino de búsqueda
            if (h.booleanValue()) {
                //incrementa el fe por aumentar la altura de rama izquierda
                switch (raiz.fe) {
                    case 1: // aplicar rotación a la derecha
                        n1 = (NodoAvl) raiz.subArbolDcho();
                        if (n1.fe == +1) {
                            raiz = rotacionDD(raiz, n1);
                        } else {
                            raiz = rotacionDI(raiz, n1);
                        }
                        break;
                    case 0:
                        raiz.fe = +1;
                        break;
                    case -1:
                        raiz.fe = 0;
                        h.setLogical(false);
                        break;
                }
            }
        } else {
            throw new Exception("No puede haber claves repetidas");
        }
        return raiz;
    }
    //***************************************************************************
    //METODO BORRAR UN NODO

    public void eliminar(Object valor) throws Exception {
        Comparable dato;
        dato = (Comparable) valor;
        Logical flag = new Logical(false);
        raiz = borrarAvl(raiz, dato, flag);
    }

    private NodoAvl borrarAvl(NodoAvl r, Comparable clave,
            Logical cambiaAltura) throws Exception {
        if (r == null) {
            throw new Exception(" Nodo no encontrado ");
        } else if (clave.compareTo(r.valorDelNodo()) < 0) {
            NodoAvl iz;
            iz = borrarAvl((NodoAvl) r.subArbolIzq(), clave, cambiaAltura);
            r.ramaIzdo(iz);
            if (cambiaAltura.booleanValue()) {
                r = equilibrar1(r, cambiaAltura);
            }
        } else if (clave.compareTo(r.valorDelNodo()) > 0) {
            NodoAvl dr;
            dr = borrarAvl((NodoAvl) r.subArbolDcho(), clave, cambiaAltura);
            r.ramaDcho(dr);
            if (cambiaAltura.booleanValue()) {
                r = equilibrar2(r, cambiaAltura);
            }
        } else // Nodo encontrado
        {
            NodoAvl q;
            q = r; // nodo a quitar del árbol
            if (q.subArbolIzq() == null) {
                r = (NodoAvl) q.subArbolDcho();
                cambiaAltura.setLogical(true);
            } else if (q.subArbolDcho() == null) {
                r = (NodoAvl) q.subArbolIzq();
                cambiaAltura.setLogical(true);
            } else { // tiene rama izquierda y derecha 
                NodoAvl iz;
                iz = reemplazar(r, (NodoAvl) r.subArbolIzq(), cambiaAltura);
                r.ramaIzdo(iz);
                if (cambiaAltura.booleanValue()) {
                    r = equilibrar1(r, cambiaAltura);
                }
            }
            q = null;
        }
        return r;
    }

    private NodoAvl reemplazar(NodoAvl n, NodoAvl act, Logical cambiaAltura) {
        if (act.subArbolDcho() != null) {
            NodoAvl d;
            d = reemplazar(n, (NodoAvl) act.subArbolDcho(), cambiaAltura);
            act.ramaDcho(d);
            if (cambiaAltura.booleanValue()) {
                act = equilibrar2(act, cambiaAltura);
            }
        } else {
            n.nuevoValor(act.valorDelNodo());
            n = act;
            act = (NodoAvl) act.subArbolIzq();
            n = null;
            cambiaAltura.setLogical(true);
        }
        return act;
    }

    private NodoAvl equilibrar1(NodoAvl n, Logical cambiaAltura) {
        NodoAvl n1;
        switch (n.fe) {
            case -1:
                n.fe = 0;
                break;
            case 0:
                n.fe = 1;
                cambiaAltura.setLogical(false);
                break;
            case +1: //se aplicar un tipo de rotación derecha
                n1 = (NodoAvl) n.subArbolDcho();
                if (n1.fe >= 0) {
                    if (n1.fe == 0) //la altura no vuelve a disminuir
                    {
                        cambiaAltura.setLogical(false);
                    }
                    n = rotacionDD(n, n1);
                } else {
                    n = rotacionDI(n, n1);
                }
                break;
        }
        return n;
    }

    private NodoAvl equilibrar2(NodoAvl n, Logical cambiaAltura) {
        NodoAvl n1;
        switch (n.fe) {
            case -1:// Se aplica un tipo de rotación izquierda
                n1 = (NodoAvl) n.subArbolIzq();
                if (n1.fe <= 0) {
                    if (n1.fe == 0) {
                        cambiaAltura.setLogical(false);
                    }
                    n = rotacionII(n, n1);
                } else {
                    n = rotacionID(n, n1);
                }
                break;
            case 0:
                n.fe = -1;
                cambiaAltura.setLogical(false);
                break;
            case +1:
                n.fe = 0;
                break;
        }
        return n;
    }

}

class Logical {

    boolean v;

    public Logical(boolean f) {
        v = f;
    }

    public void setLogical(boolean f) {
        v = f;
    }

    public boolean booleanValue() {
        return v;
    }
}
