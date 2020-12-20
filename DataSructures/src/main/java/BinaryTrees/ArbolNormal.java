
package BinaryTrees;

import java.util.Scanner;


class Node{
        private int dato;
        private Node izq, der;
        
        public Node(int dato){
            this.dato = dato;
            this.izq = this.der = null;
        }
        
        public int getDato(){
            return dato;
        }
        
        public void setDato(int dato){
            this.dato=dato;
        }

        public Node getIzq() {
            return izq;
        }

        public void setIzq(Node izq) {
            this.izq = izq;
        }

        public Node getDer() {
            return der;
        }

        public void setDer(Node der) {
            this.der = der;
        }            
    }


public class ArbolNormal {
   
    public static void main(String[] args) {
        
    
        Metodos myArbol = new Metodos();
        int op, num;
        
        do{
            op = myArbol.menu();
            
            switch(op){
                
                case 1: System.out.println("Digite elemento a insertar; ");
                num = myArbol.en.nextInt();
                myArbol.raiz = myArbol.insertar(myArbol.raiz, num);
                break;
                
                case 2: System.out.println("Digite elemento a eliminar: ");
                num = myArbol.en.nextInt();
                myArbol.raiz= myArbol.borrar(myArbol.raiz, num);
                break;
                
                case 3: myArbol.preOrden(myArbol.raiz);
                break;
                
                case 4: myArbol.inOrden(myArbol.raiz);
                break;
                
                case 5: myArbol.posOrden(myArbol.raiz);
                break;
                
                default: break;
            }
            
        }while(op !=0);
                
    }
    
}  


 class Metodos{
     
    Scanner en = new Scanner(System.in); 
    Node raiz;
    
    public Metodos(){
        this.raiz=null;
    }
    
    public boolean arbolVacio(Node actual){
        if(actual==null) return true;
        else return false;
    }
    
    public int menu(){
        int op;
        System.out.println("[1]: Ingresar ");
        System.out.println("[2]: Eliminar");
        System.out.println("[3]: Preorden");
        System.out.println("[4]: Inorden");
        System.out.println("[5]: Posorden");
        op = en.nextInt();
        return op;
    }
    
    private int reemplazar(Node actual){
        Node p =actual;
        Node a = actual.getIzq();
        int valor;
        
        while(!arbolVacio(a.getDer())){
            p=a;
            a=a.getDer();
        }
        
        valor = a.getDato();
        
        if(p==actual){
            p.setIzq(a.getIzq());
        }else{
            p.setDer(a.getIzq());            
        }
        
        return valor;
    }
    
    public Node borrar(Node actual, int num){
        if(arbolVacio(actual)){
            System.out.println("No existe elemento a eliminar..");
        }else if(actual.getDato() > num){
            actual.setIzq(borrar(actual.getIzq(), num));
        }else if(actual.getDato() < num){
            actual.setDer(borrar(actual.getDer(), num));
        }else{
            Node aux = actual;
            if(arbolVacio(aux.getIzq())){
                return aux.getDer();
            }else if(arbolVacio(aux.getDer())){
                return aux.getIzq();
            }else{
                aux.setDato(reemplazar(aux));
            }           
        }
        return actual;
    }
    
    public Node insertar (Node actual, int num){
        
        if(arbolVacio(actual)){
            Node nuevo = new Node(num);
            return nuevo;
        }else if(actual.getDato() > num){
            actual.setIzq(insertar(actual.getIzq(), num));
        }else if(actual.getDato() < num){
            actual.setDer(insertar(actual.getDer(), num));
        }
        return actual;    
    }
    
    public void preOrden(Node actual){
        if(actual !=null){
            System.out.println(actual.getDato()+" ");
            preOrden(actual.getIzq());
            preOrden(actual.getDer());
        }
    }
    
    public void inOrden(Node actual){
        if(actual!=null){
            inOrden(actual.getIzq());
            System.out.println(actual.getDato()+" ");
            inOrden(actual.getDer());
        }       
    }
    
    public void posOrden(Node actual){
        if(actual!=null){
            posOrden(actual.getIzq());
            posOrden(actual.getDer());
            System.out.println(actual.getDato()+" ");
        }
    }
}


