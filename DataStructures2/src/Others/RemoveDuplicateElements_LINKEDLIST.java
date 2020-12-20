/*
Remove duplicate elements from a singly linked list

Algorithm

Create a class Node which has two attributes: data and next. Next is a pointer to the next node in the list.
Create another class RemoveDuplicate which has two attributes: head and tail.:
addNode() will add a new node to the list:
Create a new node.
It first checks, whether the head is equal to null which means the list is empty.
If the list is empty, both head and tail will point to a newly added node.
If the list is not empty, the new node will be added to end of the list such that tail's next will point to a newly added node. This new node will become the new tail of the list.
a. removeDuplicate() will remove duplicate nodes from the list.

Define a new node current which will initially point to head.
Node temp will point to current and index will always point to node next to current.
Loop through the list till current points to null.
Check whether current?s data is equal to index's data that means index is duplicate of current.
Since index points to duplicate node so skip it by making node next to temp to will point to node next to index, i.e., temp.next = index.next.
a. display() will display the nodes present in the list:

Define a node current which will initially point to the head of the list.
Traverse through the list till current points to null.
Display each node by making current to point to node next to it in each iteration.
 */
package Others;


public class RemoveDuplicateElements_LINKEDLIST {
    
    //Represent a node of the singly linked list
    class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next=null;
        }
        
    }
    
    
    //Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;
    
    
    //addNode() will add a new node to the lit
    public void addNode(int data){
        //create a new node
        Node newNode = new Node(data);
        
        //Check if the list is empty
        if(head==null){
            //If list is empty, both head and tail will point to new node.
            head = newNode;
            tail = newNode;
        }else{
            //newNode will be added after tail of the list
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
        
    }
    
    
    //removeDuplicate() will remove duplicate nodes from the list
    public void removeDuplicate(){
        //Node current will point to head
        Node current = head, index = null, temp = null;
        
        if(head==null){
            return;
        }else{
            while(current!=null){
                //Node temp will point to previous node to index
                temp = current;
                //Index will point to node next to current
                index = current.next;
                
                while(index != null){
                    //If current node`s data is equal to index node`s data
                    if(current.data == index.data){
                        //Here, index node is pointing to the node which is
                        //duplicate of current node
                        //Skips the duplicate node by pointing to next node  
                        temp.next = index.next;
                    }else{
                        //Temp will point to previous node of index
                        temp = index;
                    }
                    index = index.next;                        
                }
                
                current=current.next;
            }        
        }       
    }
    
    //display() will display all the nodes present in the list
    public void display(){
        //Node current will point to head
        Node current = head;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        
        while(current!=null){
            //Prints ech node by incrementing pointer
            System.out.println(current.data+ " ");
            current=current.next;
        }
        System.out.println();
    }
    
    
    public static void main(String[] args){
        RemoveDuplicateElements_LINKEDLIST sList= new RemoveDuplicateElements_LINKEDLIST();
        
        //Adds data to the list  
        sList.addNode(1);  
        sList.addNode(2);  
        sList.addNode(3);  
        sList.addNode(2);  
        sList.addNode(2);  
        sList.addNode(4);  
        sList.addNode(1);  
  
        System.out.println("Originals list: ");  
        sList.display();
        
        //Removes duplicate nodes
        sList.removeDuplicate();
        
        System.out.println("List after removing duplicates: ");
        sList.display();
                
                
    }
    
    
}
