package LinkedList;

public class Runner {

    public static void main(String[] args) {
        MiPropiaLinkedList1 lista = new MiPropiaLinkedList1();

        lista.insert(18);
        lista.insert(45);
        lista.insert(12);
        
        lista.insertAtStart(25);
        
        lista.insetAt(0, 55);

       lista.removeAt(1);
        lista.show();
    }

}
