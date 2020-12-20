//This code is a min priority queue implementation using a binary heap.
package PriorityQueue2;
import java.util.*;
/*
Con esto: <T extends Comparable<T>> decimos que todos los tipos de
datos/objetos que pasemos, deben implementar la interfaz Comparable
osea deben ser comparables
*/
public class BinaryHeap <T extends Comparable<T>> {
    
    //A dynamic list to track the elements inside the heap
    private List<T> heap = null;
    
    //Construct and initially empty priority queue
    public BinaryHeap(){
        this(1);
    }
    
    //Construct a priority queue with an initial capacity
   public BinaryHeap(int sz){
       heap = new ArrayList<>(sz);
   }
   
   //Construct a priority queue using heapify in O(n) time
   /*
   If you know all the elements that are going to be inside the
   heap. We construct our priority queue in linear time using
   an operation called heapify.
   Este constructor lo que hace es que recibe un array estatico
   ya llenado, y lo copia a mi array List (ArrayList) y va 
   comprobando cada elemento "Padre" que tengo sus correspondientes
   hijos, si no tiene sus correspondientes hijos osea no
   satisface la propiedad de ordenacion minHeap
   ye sto lo que hace es ir cambiando o renovando los nuevos padres
   e hjos.
   */
   public BinaryHeap(T[] elems){
       int heapSize = elems.length;
       heap= new ArrayList<T>(heapSize);     
       //Place all elements in heap
       for(int i=0; i<heapSize;i++) heap.add(elems[i]);
       //heapify process, O(n)
       for(int i=Math.max(0, (heapSize/2)-1); i>=0; i--) sink(i);
   }
   
   // Priority queue construction, O(nlog(n))
   /*
   Este constructor sirsve si yo, ya tengo una coleccion de 
   elementos (no un aray estatico), entonces lo paso como
   parametro y le copio a mi ArrayList.
   */
   public BinaryHeap(Collection <T> elems){
       this(elems.size());
       for(T nuevo: elems) heap.add(nuevo);    
   }
   
   //Returns tru/false depending on if the priority queue is empty
   public boolean isEmpty(){
       return size()==0;
   }
   
   //CLears everything inside the heap, O(n)
   public void clear(){
       heap.clear();
   }
   
   // Returns the value of the element with the lowest
   // priority in this priority queue. If the priority
   // queue is empty null is returned.
   public T peek(){
       if(isEmpty()) return null;
       return heap.get(0);
   }
   
   //Removes the root of the heap, O(log(n))
   public T poll(){
       return removeAt(0);
   }
   
   // Test if an element is in heap, O(n)
   public boolean contains(T elem){
       // Linear scan to check containment
       for(int i=0; i<size(); i++) if(heap.get(i).equals(elem)) return true;
       return false;
   }
   /*
   // Adds an element to the priority queue, the
  //  element must not be null, O(log(n))
   */
   public void add(T elem){
       if(elem == null) throw new IllegalArgumentException();
       
       heap.add(elem);
       
       int indexOflastElem = size()-1;
       swim(indexOflastElem);
   }
   // Removes a particular element in the heap, O(n)
   public boolean remove(T element){
       if(element == null) return false;
       //Linear removal via search, O(n)
       for(int i=0; i<size(); i++){
           if(element.equals(heap.get(i))){
               removeAt(i);
               return true;
           }
       }
       return false;
   }
   
   // Removes a node at particular index, O(log(n))
   private T removeAt(int i){
       if(isEmpty()) return null;
       T removed_data = heap.get(i);
       
       int indexOfLastElem = size()-1;
       
       swap(i, indexOfLastElem);//Cambios elementos en las posici
       //Obliterate the value
       heap.remove(indexOfLastElem);//Se remuve el que pasamos i
       
       //check if the last element was removed
       //Si hay un solo unico elemento:
       if(i == indexOfLastElem) return removed_data;
       
       T elem = heap.get(i);//El que era ultimo elemento
       //Try sinkin element:;
       sink(i);//el q era ultimo
       
       //if sinkin did not work, try swimming:
       if(heap.get(i).equals(elem)) swim(i);
       
       return removed_data;
   
   }
   
   /*
   Este metodo sink con la ayuda del metodo swap, comprueba que el elemento
   padre tenga sus correctos hijos, en este caso minHeap, que el padre sea menor
   que sus hijos. si nos se cumplen, llama al metodo swap y hace el cambio
   de nuevo padre y nuevo hijo.
   */
    //Top down node sink, O(log(n)), de arriba a abajo
   private void sink(int k){//Bajar, Hundir
       
       int heapSize=size();
       
       while(true){
           int left = 2*k +1;//Left Node
           int right = 2*k + 2;//Right node
           int smallest = left;//// Assume left is the smallest node of the two children
           
           // Find which is smaller left or right
           // If right is smaller set smallest to be right
           if(right < heapSize && less(right, left)) smallest = right;
           
           // Stop if we're outside the bounds of the tree
           // or stop early if we cannot sink k anymore
           if(left >= heapSize || less(k, smallest)) break;
           
           //Move down the tree following the smallest node
           swap(smallest, k);
           k = smallest;
       }
       
   }
   
   /*
   Este metodo swap lo q hace, es actualizar al nuevo padre y al nuevo hijo.
   Osea hace un cambio de elementos en las posiciones.
   */
   //Swap two nodes. Assumes i & j are valid, O(1)
   private void swap(int i, int j){//Acualiza al nuevo pare e hijo
       T elem_i = heap.get(i);//Obtengo al hijo
       T elem_j = heap.get(j);//Obtengo al padre
       /*
       Como el hijo, es MAS GRANDE/MAYOR al papa, eje: 8, 3
       en la posicion del HIJO inserto el elemento papa.
       y en la posicion del PAPA inserto el elemento hijo.
       */
       heap.set(i, elem_j);
       heap.set(j, elem_i);      
   }
   
   // Perform bottom up node swim, O(log(n))
   /*
   El siguiente metodo funciona cuando agregamos un nuevo elemento
   este parte desde el ultimo(fondo)/ parte inferior derecha de 
   la PQ y va subiendo de acuerdo al padre e hijos hasta posici
   onarse en su posicion correcta en la PQ.
   */
   private void swim(int k){
       //Grab the index of the next parent node WRT to k.
       //Agaramos al papa del nodo k
       int parent = (k -1)/2;  
       // Keep swimming while we have not reached the
       // root and while we're less than our parent.
       while(k>0 && less(k, parent)){
           //Exchange k with the parent
           swap(parent, k);
           k=parent;//new child
           // Grab the index of the next parent node WRT to k
           parent = (k-1)/2;//parent of the child(k)
       }
   }
   
   
   
   
   private boolean less(int i, int j){
       T node1 = heap.get(i);
       T node2 = heap.get(j);
       return node1.compareTo(node2) <=0;
   }
   
   public int size(){
       return heap.size();
   }
   
    // Recursively checks if this heap is a min heap
  // This method is just for testing purposes to make
  // sure the heap invariant is still being maintained
  // Called this method with k=0 to start at the root
   public boolean isMinHeap(int k) {
    // If we are outside the bounds of the heap return true
    int heapSize = size();
    if (k >= heapSize) return true;

    int left = 2 * k + 1;
    int right = 2 * k + 2;

    // Make sure that the current node k is less than
    // both of its children left, and right if they exist
    // return false otherwise to indicate an invalid heap
    if (left < heapSize && !less(k, left)) return false;
    if (right < heapSize && !less(k, right)) return false;

    // Recurse on both children to make sure they're also valid heaps
    return isMinHeap(left) && isMinHeap(right);
  }
   
   @Override
  public String toString() {
    return heap.toString();
  }
}
