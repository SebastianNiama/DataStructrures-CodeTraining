
package HashTable1;

public class Main {
    public static void main(String[] args) {
        
        /*
        HashTable tabla = new HashTable();
        
        for(Integer i = -50; i<= 50; i++){
            tabla.insertar(i);
        }
        */
        
        //HasttableArray:
        
        HashTableArray<String> hm = new HashTableArray<>(11);
        
        hm.insert(11, "hussein");
        hm.insert(12, "jenna");
        hm.insert(13, "Henry");
                
        System.out.println("Quiero el 12: "+hm.get(12));
        
        
        
    }
}
