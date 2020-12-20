// Java program to print BFS traversal from a given source vertex. 
// BFS(int s) traverses vertices reachable from s. 
//The implementation uses adjacency list representation of graphs
package GrafosListaAdyancencia;

import java.util.*;

// This class represents a directed graph using adjacency list 
// representation 
public class BreadthFirstTraversal {

    private int V; //Nº of vertices
    private LinkedList<Integer> adj[];//Adjacency list

    //Constructor
    public BreadthFirstTraversal(int v) {
        V = v;
        adj = new LinkedList[V];
        
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[V];

        //create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it 
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it 
            s = queue.poll();//removes the head of the queue
            System.out.println(s + " ");

            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    //Driver method to
    public static void main(String args[]) {
        BreadthFirstTraversal g = new BreadthFirstTraversal(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)");
        
        g.BFS(0);
    }
}
