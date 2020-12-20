
package HashTable1;

public class HashTableArray <T> {
    
    Entry [] arrHash;
    int size;//Siempre Primo
    
    public HashTableArray(int size){
        this.size = size;//Inicializo
        arrHash = new Entry[size];//Inicializo
        for(int i = 0; i<size; i++){
            arrHash[i] = new Entry();//Cada enlance siguiente a null
        }
    }
     
    private int getHash(int key){
        return key%size;
    }
    
    public void insert(int key, Object value){
        int hashIndex = getHash(key);
        Entry arrayValue =  arrHash[hashIndex];
        Entry newItem = new Entry(key, value);
        newItem.next = arrayValue.next;
        arrayValue.next = newItem;
    }
    
    public T get(int key){
        T value = null;
        int hashIndex = getHash(key);
        Entry arrayValue =  arrHash[hashIndex];
        while(arrayValue != null){
            if(arrayValue.getkey() == key){
                value =(T)arrayValue.getValue();
                break;
            }
            arrayValue = arrayValue.next;
        }
        
        return value;
    } 
   
    
}
