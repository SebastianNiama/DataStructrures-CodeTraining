package ListaDobleEnlazada2;

import java.util.Iterator;

public class ListaDoble<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;//With null means the link list starts empty
    private Node<T> tail = null;

    //Internal node class to represent data.   
    private class Node<T> {

        T data;
        Node<T> prev, next;//These are the pointers for the nodes.

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    //Empty this linked list, 0(n)
    //Hace tiempo lineal, recorriendo todos los elementos.
    public void clear() {
        Node<T> trav = head;

        while (trav != null) {
            Node<T> nextNode = trav.next;//Salta al siguiente nodo.
            trav.prev = trav.next = null;//Con esto lo elimino.
            trav.data = null;
            trav = nextNode;
        }
        head = tail = trav = null;//Reiniciamos la cabeza y la cola.
        size = 0;
    }

    //Return the size of this linked list 
    public int size() {
        return size;
    }

    //Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;//Returns true if so.
    }

    //Add element to the tail of the linked list, 0(1)
    public void add(T elem) {
        addLast(elem);
        
    }

    //add and element to the beginning of the linked list, 0(1)
    public void addFirst(T elem) {
        //if the linked list is empty?
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }

        size++;
    }

    private void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {

            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
              
        }
        size++;
    }

    //Check the value of the first  node if it exists, O(1).
    public T getFirst() {//peekFirst

        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }else{
            return head.data;
        }  
    }
    
    //Check the value of the last  node if it exists, O(1).   
    public T getLast(){//peekLast
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }else{
            return tail.data;
        }  
    }
    
   //Remove the first value at the head of the linked list, O(1)
    
    public void removeFirst(){
        //Can't remove data from an empty list.
        if (isEmpty()) {
            tail = null;
            throw new RuntimeException("Empty list");
        }else{
            Node <T> elem = head;
            head = head.next;
            head.prev = null;
            --size;
      
            System.out.println("Elemento "+elem.data+" eliminado");
        }           
    }
    
      public void removeLast(){
        //Can't remove data from an empty list.
        if (isEmpty()) {
            head = null;
            throw new RuntimeException("Empty list");
        }else{
            Node <T> elem = tail;
            tail = tail.prev;//retrocede un nodo
            tail.next = null;  //el nodo siguiente se elimina.
            --size;
             System.out.println("Elemento "+elem.data+" eliminado");
            
        }           
    }
    
    private T remove(Node <T> node){
        //If the node to remove is somewhere either at the head
        //or the tail handle those independently
        
        if(node.prev == null){
             removeFirst();
        }  else if(node.next == null){
            removeLast();
        }else{
              //Make the pointers of adjacent nodes skip over "node"
        node.next.prev= node.prev;
        node.prev.next = node.next;
        
        //Temporary store the data we want to return
        T data = node.data;
        //Memory cleanup
        node.data = null;
        node = node.prev = node.next =null;
        --size;
        //Return the data at the node we just removed:   
        
        return data;
        
        }   
        return null;
      
    }
    
    //Remove a node at a particular index, 0(n)
    public void removeAt(int index){
        //Make sure the index providede is valid.
        if(index <0 || index >= size) throw  new IllegalArgumentException("No es un indice valido");
        
        int i;
        Node <T> trav;
        
        //Search from  the front of the list
        if(index < size/2){
            for(i=0, trav = head; i != index; i++){
                trav = trav.next;
            }
        }else{//Search from the back of the lsist
            for(i = size-1, trav = tail; i != index; i--){
                trav = trav.prev;
            }
        }
              remove(trav);
        System.out.println("Elemento en la posicion "+index+" eliminado");
    }
    
    //Remove a patricular value in the linked list, 0(n) 
    public void remove(Object obj){
        
        Node <T> trav = head;
        boolean encontrado = false;
        
        //Suport searching for null
       if(obj == null){
           for(trav = head; trav !=null; trav = trav.next){
               if(trav.data == null){
                   encontrado = true;
                   remove(trav);
                   
               }
           }
       }else {//Search for non null object
           for(trav = head; trav != null; trav = trav.next){
               if(obj.equals(trav.data)){
                   encontrado = true;
                   remove(trav);
                 
               }
           }
       }
        if(encontrado == false){
            System.out.println("No existe el elemento "+obj);
        }
        
    }
    
    //Find the index of a particular value in the linked list O(n)  
    public int indexOf(Object obj){
        int index =0;
        Node <T> trav = head;
        //Support searching for null
        if(obj ==null){
            for(trav = head; trav !=null; trav = trav.next, index++){
                if(trav.data ==null){
                    return index;
                }
            }
        }else{//Search for non null object
            for(trav = head; trav !=null; trav = trav.next, index++){
                if(obj.equals(trav.data)){
                    return index;
                }                
            }
        }
        return -1;
    }
    
    //Check if the value is conained within the linked list
    public boolean contains (Object obj){
        return  indexOf(obj)!=-1;
    }
    

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
          
            private Node <T> trav = head;
            
            @Override
            public boolean hasNext(){
                return trav !=null;
            }
            @Override
            public T next(){
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
        
    }
    
    //TO print my linked list;
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node <T> trav = head;
        int i=0;
        while(trav  != null ){
            
            if(i< size()-1){
                sb.append(trav.data+ ", ");
            }else{
                sb.append(trav.data);
            }
              i++;
              
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}

