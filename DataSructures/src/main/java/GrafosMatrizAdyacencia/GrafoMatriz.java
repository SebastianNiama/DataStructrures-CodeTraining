/*
La clase GrafoMatriz define la matriz de adyacencia, el array de vértices y los métodos
para añadir nodos y arcos al grafo. La declaración de la clase es:
 */
package GrafosMatrizAdyacencia;
import Queues.ColaLista;

public class GrafoMatriz {

    private int numVerts;
    private static int maxVerts = 20;
    private Vertice[] verts;//array de vertices, cada vertice tiene un indice
    private int[][] matAd;//matriz de adyacencia que guardará 1 o 0

    // El constructor sin argumentos crea la matriz de adyacencia para un máximo 
    // de vértices preestablecido; el otro constructor tiene un argumento
    // con el máximo número de vértices:
    public GrafoMatriz() {
        this(maxVerts);
    }

    public GrafoMatriz(int mx) {

        matAd = new int[mx][mx];
        verts = new Vertice[mx];

        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matAd[i][j] = 0;
            }
        }

        numVerts = 0;

    }

    /*
    Añadir un vértice
    La operación recibe la etiqueta (String) de un vértice del grafo,
    comprueba si ya está en la lista de vértices, en caso negativo incrementa 
    el número de vértices y lo asigna a la lista
     */
    //numVertice() busca el vértice en el array. Devuelve -1 si no lo encuentra:
    public int numVertice(String vs) {

        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;

        for (; (i < numVerts) && !encontrado;) {//O(n2)
            encontrado = verts[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }

        return (i < numVerts) ? i : -1;
    }

    public void nuevoVertice(String nom) {

        boolean esta = numVertice(nom) >= 0;

        if (!esta) {
            Vertice v = new Vertice(nom);
            v.asigNumVert(numVerts);
            verts[numVerts++] = v;
        }
    }

    /*
    Añadir un arco.
    El método recibe el nombre de cada vértice del arco, busca, en el array, el número de vértice
    asignado a cada uno de ellos y marca la matriz de adyacencia. */
    public void nuevoArco(String a, String b) throws Exception {//Para grafos valorados este método 
        //tiene un tercer argumento que es el factor de peso del arco. 
        int va,
         vb;
        va  = numVertice(a);
        vb = numVertice(b);

        if (va<0  || vb < 0) {
            throw new Exception("Vertice no existe");
        }

        matAd[va][vb] = 1;
    }

    /*
    Adyacente
    Determina si dos vértices, v1 y v2, forman un arco; es decir, si el elemento de la matriz de
    adyacencia es 1. Se escriben dos versiones.*/
    public boolean esAdyacente(String a, String b) throws Exception {
        int va,
         vb;
        va  = numVertice(a);
        vb = numVertice(b);

        if (va<0  || vb < 0) {
            throw new Exception("No existe arco entre los vertices.");
        }

        return matAd[va][vb] == 1;
    }

    public void imprimirVertices() {
        int i = 0;
        for (; i < numVerts;) {
            System.out.println(verts[i++].toString());
        }

    }

    //Recorrido en anchura
    public static int[] recorrerAnchura(GrafoMatriz g, String org) throws Exception {
        
        final int CLAVE = 1720;
        int w, v;
        int[] m;
        v = g.numVertice(org);
        if (v < 0) {
            throw new Exception("Vértice origen no existe");
        }
        ColaLista cola = new ColaLista();
        m = new int[g.numVerts];
// inicializa los vértices como no marcados
        for (int i = 0; i < g.numVerts; i++) {
            m[i] = CLAVE;
        }
        m[v] = 0; // vértice origen queda marcado
        cola.insertar(new Integer(v));
        while (!cola.colaVacia()) {
            Integer cw;
            cw = (Integer) cola.quitar();
            w = cw.intValue();
            System.out.println("Vértice " + g.verts[w] + "visitado");
            // inserta en la cola los adyacentes de w no marcados
            for (int u = 0; u < g.numVerts; u++) {
                if ((g.matAd[w][u] == 1) && (m[u] == CLAVE)) {
                    // se marca vertice u con número de arcos hasta el
                    m[u] = m[w] + 1;
                    cola.insertar(new Integer(u));
                }
            }
        }
        return m;
    }
    
    

}
