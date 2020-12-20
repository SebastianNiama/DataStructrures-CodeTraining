//Example of Properties class to get information from the properties file
// let's create the java class to read the data from the properties file.


package PropertiesClass;
import java.util.*;
import java.io.*;


public class Test {
    public static void main(String[] args)throws Exception{
        
        FileReader rader = new FileReader("C:\\Users\\henry\\OneDrive - Universidad Técnica Particular de Loja - UTPL\\Documentos\\Mas cosas\\vocabulary.txt");
        
        /*
        C:\\Users\\henry\\OneDrive - Universidad Técnica Particular de Loja - UTPL\\Documentos\\Mas cosas\\vocabulary.txt
        C:\\Users\\henry\\OneDrive - Universidad Técnica Particular de Loja - UTPL\\Documentos\\Java\\EjerciciosNetBeansJava\\DataSructures\\src\\main\\java\\PropertiesClass\\db.txt
        */
        Properties p = new Properties();
        p.load(rader);
        
        
        /*
        System.out.println(p.getProperty("user"));
        System.out.println(p.getProperty("password"));
        */
         Set set = p.entrySet();
        
        Iterator itr = set.iterator();
        
        while(itr.hasNext()){
            Map.Entry entry = (Map.Entry)itr.next();
            System.out.println(entry.getKey()+"="+ entry.getValue());
            
        }
        
    }
}
