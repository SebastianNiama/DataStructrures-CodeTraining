
package HashTable1;

public class Entry {
    
    int key;
    Object value;
    Entry next;//Enlace
   
    public Entry(int key, Object value){
        this.key = key;
        this.value = value;
        next = null;
    }
    public Entry(){
        next = null;
    }
    
    public int getkey(){
        return key;
    }
    public Object getValue(){
        return value;
    }  
}
