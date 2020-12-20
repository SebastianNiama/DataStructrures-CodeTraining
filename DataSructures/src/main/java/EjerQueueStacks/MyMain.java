
package EjerQueueStacks;

public class MyMain {
    public static void main(String[] args) {
       
        MyQueue<Integer> miCola = new MyQueue<>();
        miCola.add(2);
        miCola.add(3);
        miCola.add(4);
       
        
        miCola.show();
        System.out.println("Se remueve el primer: "+miCola.remove());
        miCola.show();
         miCola.add(5);
        miCola.show();
       
        
    }
}
