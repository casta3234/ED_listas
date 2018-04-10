/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author SC
 */
public class Lista {
    
    private Nodo cabeza = null;
    private int size = 0;
    public boolean vacia(){
        return this.cabeza == null; 
        
    }
    
    public void añadirInicio(Object o){
        Nodo nuevoNodo = new Nodo(o);
        nuevoNodo.setSiguiente(this.cabeza);
        this.cabeza = nuevoNodo;
        this.size++;
    }
    
    public void añadirFinal(Object o){
        Nodo nuevoNodo = new Nodo(o);
        if (vacia()){
            this.cabeza = nuevoNodo;
            this.size++;
        }
        else{
            Nodo temp = this.cabeza;
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();         
            }
            temp.setSiguiente(nuevoNodo);
            this.size++;
        }        
    }
    
    public void añadirPosicion(Object o, int posicion){
        Nodo nuevoNodo = new Nodo(o);
        Nodo temp = this.cabeza;
        for(int i = 0; i < posicion-1; i++ ){
            temp = temp.getSiguiente();
        }
        nuevoNodo.setSiguiente(temp.getSiguiente()); 
        temp.setSiguiente(nuevoNodo);
        this.size++;
    }
       
    public void eliminarInicio(){
        Nodo temp = this.cabeza;
        this.cabeza = this.cabeza.getSiguiente();
        temp = null;
        this.size--;
        System.gc();
    }
    
    public void eliminarFinal(){
        Nodo pre = this.cabeza;
        Nodo temp = this.cabeza.getSiguiente().getSiguiente();
        while (temp != null){            
            pre = pre.getSiguiente();
            temp = temp.getSiguiente();
        }        
        pre.setSiguiente(null);
        this.size--;
        System.gc();
    }
    
    public void eliminarPosicion(int posicion){
        Nodo temp = this.cabeza;
        Nodo eliminado;
        for(int i = 0; i < posicion-1; i++){
            temp = temp.getSiguiente();
        }
        eliminado = temp.getSiguiente();
        temp.setSiguiente(temp.getSiguiente().getSiguiente()); 
        eliminado = null;
        this.size--;
        System.gc();
    }
    
    public void inversa(){
        Pila ptemp = new Pila();
        Nodo temp = this.cabeza;
        
        while(temp != null){
            ptemp.agregar(temp.clon());
            temp = temp.getSiguiente();
        }
        
        this.cabeza = ptemp.mirar();
    }
    
    public int buscar(Object o){
        Nodo temp = this.cabeza;        
        int index = 0;
        
        do {
            if (temp.getO().equals(o)) {
                break;
            }            
                temp = temp.getSiguiente();
                index++;            
        }
        while (index < this.size - 1);
        return index;
    }
    
    public Object buscarIndex(int index){
        Nodo temp = this.cabeza;
        if (index > 0){
            for(int i = 0; i < index; i++){
                temp = temp.getSiguiente();
            }
        }
        return temp.getO();
    }
    
    public void imprimir(){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Nodo temp = this.cabeza;
        try{
            while(temp != null){
                bw.write(temp.toString());
                temp = temp.getSiguiente();
            }
            bw.flush();
        }
        catch(IOException ex){
        }
    }
    
    public static void main(String[] args) {
        Lista n = new Lista();
        Nodo l = new Nodo(new Grade("quiz1", 1.2));
        Nodo ld = new Nodo(new Grade("quiz2", 1.2));        
        Grade g = new Grade("quiz2", 1.2);
        n.añadirInicio(new Grade("quiz3", 0));
        n.añadirInicio(new Grade("quiz4", 0));  
        n.añadirInicio(new Grade("quiz5", 0));
        n.añadirPosicion(g, 1);
        n.añadirInicio(l);        
        n.añadirInicio(l);
//        n.añadirFinal(new Grade("quiz6", 0));   
//        n.añadirPosicion(ld, 1);
//        n.eliminarPosicion(3);
//        n.eliminarFinal();
//        n.eliminarFinal();
//        n.imprimir();
//        n.inversa();
//        System.out.println("");
        n.imprimir();
//        System.out.println("");
//        System.out.println(n.buscarIndex(2));
        System.out.println(n.buscar(l));
        
    }
    
}
