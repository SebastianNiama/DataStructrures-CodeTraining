
package Graphs;

import java.util.ArrayList;


public class Recorridos {
    
    public int[][] g = {{2,1,0,1,0},
                        {1,2,1,0,0},
                        {0,1,2,1,0},
                        {1,0,1,2,1},
                        {0,0,0,1,2}};
    
    private boolean [] visitadoAnchura = new boolean[5];
    private boolean[] visitadoProfundidad = new boolean[5];
   
    public Recorridos(){
        
        
    }
    
    public int[][] getG(){
        return g;
    }
    
    public ArrayList<Integer> recorridoAnchura(int nodoI){
        
        ArrayList<Integer> recorridos = new ArrayList<Integer>();
        visitadoAnchura[nodoI] = true;
        ArrayList<Integer> cola = new ArrayList<Integer>();
        recorridos.add(nodoI);
        cola.add(nodoI);
        
        while(!cola.isEmpty()){
            int j= cola.remove(0);
            for(int i=0;  i<g.length; i++){
                if(g[j][i]== 1 && !visitadoAnchura[i]){
                    cola.add(i);
                    recorridos.add(i);
                    visitadoAnchura[i] = true;
                }
            }
        }
        return recorridos;
    }
    
    public ArrayList<Integer> recorridoProfundidad(int nodoI){
        
        ArrayList<Integer> recorridos = new ArrayList<Integer>();
        visitadoAnchura[nodoI] = true;
        ArrayList<Integer> cola = new ArrayList<Integer>();
        recorridos.add(nodoI);
        cola.add(nodoI);
        
        while(!cola.isEmpty()){
            int j= cola.remove(0);
            for(int i=0;  i<g.length; i++){
                if(g[j][i]== 1 && !visitadoAnchura[i]){
                    cola.add(i);
                    recorridos.addAll(recorridoProfundidad(i));
                    visitadoProfundidad[i] = true;
                }
            }
        }
        return recorridos;
    }
    
    
    public static void main(String[] args) {
        Recorridos g = new Recorridos();
        
        ArrayList<Integer> enAnchura = g.recorridoAnchura(0);//Nodo inicial cero
        System.out.println("Recorrido en anchura de un grafo representado como matriz.");
        for(int i =0; i<enAnchura.size(); i++){
            System.out.println(""+ enAnchura.get(i)+" ");
        }
        
        ArrayList<Integer> enProfundidad = g.recorridoProfundidad(0);//Nodo inicial cero
        System.out.println("");
        System.out.println("Recorrido en profundidad de un grafo representado como matriz.");
        for(int i=0; i<enProfundidad.size(); i++){
            System.out.println(""+enProfundidad.get(i)+" ");
        }
    }
}
