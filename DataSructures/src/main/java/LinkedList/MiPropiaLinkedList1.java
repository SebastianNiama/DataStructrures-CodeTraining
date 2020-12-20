package LinkedList;
//Lista DInamica Version 1

public class MiPropiaLinkedList1 {

    Node head;

    public void insert(int data) {

        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;

            while (n.next != null) {
                n = n.next;//Jumping between nodes.
            }

            n.next = node;

        }
    }

    public void show() {

        Node node = head;

        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;//This is for shifting
        }
        System.out.println(node.data);//The last element printed

    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        //node.next = null;

        node.next = head;
        head = node;
    }

    public void insetAt(int index, int data) {

        Node node = new Node();
        node.data = data;
        node.next = null;

        Node n = head;

        if (index == 0) {
            insertAtStart(data);
        } else {
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }

            node.next = n.next;
            n.next = node;

        }

    }

    public void removeAt(int index) {

        Node n = head;
        Node n2 = null;

        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
               
            }
            n2 = n.next;
            n.next = n2.next;
            n2=null;
            
        }

    }

}
