/*
Un arbol binario ordenado tiene la misma clase Nodo que el arbol binario.

Este es un arbol binario y al ser un arbol ordenado debe implementar la
interfaz Comparable.
El arbol bianrio de bsuqueda implementa las mismas operaciones que el 
Arbol binario yasea recorridos como  metodos etc. Por ende, heredamos
la clase ArbolBinario.
 */
package BinarySearchTree;

import BinaryTrees.ArbolBinario;//Usa mismas operaciones que ArbolBinario.
import BinaryTrees.Nodo;//Usan el mismo nodo


public class ArbolBinarioBusqueda <T extends Comparable<T>> extends ArbolBinario{

    public ArbolBinarioBusqueda(){
        super();
    }
//---------------------------------------------------------------------------    
    //OPERACION BUSCAR: 
    //EL objeto "buscado" debe implementar la interfaz Comparable.
     
    public Nodo buscar(Object buscado){
        Comparable dato = (Comparable) buscado;//Nos aseguramos.
        
        if(raiz == null){
            return null;
        }else{
            return localizar(raizArbol(),  dato);
        }       
    }
    
    private Nodo localizar(Nodo raizSub, Comparable buscado){
        if(raizSub == null){
            return null;
        }else if(buscado.compareTo(raizSub.valorDelNodo()) <0){
            return localizar(raizSub.subArbolIzq(), buscado);
        }else if(buscado.compareTo(raizSub.valorDelNodo())>0){
            return localizar(raizSub.subArbolDcho(), buscado);
        }else{//Si son iguales:
            return raiz;       //Retorna ese nodo
        }   
}
 //---------------------------------------------------------------------------    
 //OPERACION INSERTAR UN NODO
    public void insertar(T valor) throws Exception{
        Comparable dato = (Comparable) valor;
        raiz =insertar(raiz, dato);//Devuelve la raíz del nuevo arbol.      
    }
    //método interno para realizar el camino de busqueda y, al final, se enlaza.
    private Nodo insertar(Nodo raizSub, Comparable dato) throws Exception{
        if(raizSub == null){
            raizSub = new Nodo(dato);//Siempre se inserta el nuevo nodo como hoja.          
        }else if(dato.compareTo(raizSub.valorDelNodo())<0){
            Nodo iz = insertar(raizSub.subArbolIzq(), dato);
            raizSub.ramaIzdo(iz);//Actualizo
        }else if(dato.compareTo(raizSub.valorDelNodo())>0){
            Nodo dr= insertar(raizSub.subArbolDcho(), dato);
            raizSub.ramaDcho(dr);
        }else{//El A.B.B no permite nodos duplicados.
            throw new Exception("Nodo duplicado");           
        }
        return raizSub;
    } 
 //---------------------------------------------------------------------------    
    //OPERACION ELIMINAR
    public void eliminar(Object valor) throws Exception{
        Comparable dato = (Comparable) valor;
        raiz = eliminar(raiz, dato);//devuelve el nuevo arbol
    }
    //método interno para realizar la operación
    private Nodo eliminar(Nodo raizSub, Comparable dato) throws Exception{
        if(raiz == null){
            throw new Exception("No encontrado el nodo con la clave.");
        }else if(dato.compareTo(raizSub.valorDelNodo())<0){
            Nodo iz = eliminar(raizSub.subArbolIzq(), dato);
            raizSub.ramaIzdo(iz);
        }else if(dato.compareTo(raizSub.valorDelNodo())>0){
            Nodo dr = eliminar(raizSub.subArbolDcho(), dato);
            raizSub.ramaDcho(dr);
        }else{//Nodo encontrado, existen 2 casos:
            Nodo q = raizSub;//Nodo a quitar del arbol.
            if(q.subArbolIzq() == null){
                raizSub = q.subArbolDcho();
            }else if(q.subArbolDcho() == null){
                raizSub = q.subArbolIzq();
            }else{//Si tiene tanto rama izq como derecha.
                q = reemplazar(q);               
            }       
            q=null;            
        }
        return raizSub;
    }
  //--------------------------------------------------------------------------  
    // método interno para susutituir por el mayor de los menores (SubAizq)
    private Nodo reemplazar(Nodo act){
        Nodo a, p;
        p= act;
        a = act.subArbolIzq();//Rama de nodos menores.
        
        while(a.subArbolDcho() != null){
            p = a;//Se guarda el mayor del subarbol izq del nodo q quiero eliminar
            a = a.subArbolDcho();
        }
        
        act.nuevoValor(a.valorDelNodo());
        
        if(p == act){
            p.ramaIzdo(a.subArbolIzq());
        }else{
            p.ramaDcho(a.subArbolIzq());
        }
        return a;
    }
}
