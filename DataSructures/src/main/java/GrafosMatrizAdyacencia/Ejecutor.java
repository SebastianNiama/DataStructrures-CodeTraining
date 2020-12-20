
package GrafosMatrizAdyacencia;

public class Ejecutor {
    public static void main(String[] args) throws Exception {
        
        GrafoMatriz miGrafo = new GrafoMatriz(3);
        
        miGrafo.nuevoVertice("Henry");
        miGrafo.nuevoVertice("Sebas");
        miGrafo.nuevoVertice("Rodri");
        
        miGrafo.nuevoArco("Henry","Sebas");
        miGrafo.nuevoArco("Sebas", "Rodri");
        miGrafo.nuevoArco("Rodri", "Henry");
        
        System.out.println("Arco entre henry y Sebas?"+ miGrafo.esAdyacente("Henry", "Sebas"));
        
        miGrafo.imprimirVertices();
        
        
        
    }
}
