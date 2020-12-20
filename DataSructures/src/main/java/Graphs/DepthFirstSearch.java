/*
Java program to print DFS traversal from a given graph
*/
package Graphs;

import java.util.*;

/*
This class represents a directed graph using adjacency list
representation
*/
public class DepthFirstSearch {
    
    private int v; //Nº of vertices
    
    //Array of lists for Adjacency list Rresentation
    private LinkedList<Integer> adj[];
    
    //Constructor

    public DepthFirstSearch(int v) {
        this.v=v;
        adj = new LinkedList[v];
        
        for(int i=0; i<v; i++) 
            adj[i] = new LinkedList<>();
    }
    
    //Function to add an edge into the graph
    public void addEdge(int v, int w){
        adj[v].add(w); //Add w to v's list.
    }
    
    //A function used by DFS
    private void DFSUtil(int v, boolean visited[]){
        //Mark the current node as visited and print it
        visited[v] = true;
        System.out.println(v+" ");
        
        //Reccur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
        
    }
    
    //The function to do DFS traversal. It uses recursive DFSUtil()
    public void DFS(int v){
        //Mark all the vertices as not visited 
        //set as false by the default iin java
        boolean visited[] = new boolean[v];
        //Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
        
    }
    
    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
        g.DFS(2);
    }
}
