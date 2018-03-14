/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author SC
 */
public class Lista {
    
    private Nodo cabeza = null;
    
    public boolean vacia(){
        return this.cabeza == null; 
        
    }
    
    public void añadirInicio(Nodo nuevoNodo){
        nuevoNodo.setSiguiente(this.cabeza);
        this.cabeza = nuevoNodo;
    }
    
    public void añadirFinal(Nodo nuevoNodo){
        if (vacia()){
            this.cabeza = nuevoNodo;                     
        }
        else{
            Nodo temp = this.cabeza;
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();         
            }
            temp.setSiguiente(nuevoNodo);
        }
    }
    
    public void añadirPosicion(Nodo nuevoNodo, int posicion){
        Nodo temp = this.cabeza;
        for(int i = 0; i < posicion-1; i++ ){
            temp = temp.getSiguiente();
        }
        nuevoNodo.setSiguiente(temp.getSiguiente()); 
        temp.setSiguiente(nuevoNodo);           
    }
       
    public void eliminarInicio(){
        Nodo temp = this.cabeza;
        this.cabeza = this.cabeza.getSiguiente();
        temp = null;
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
        n.añadirInicio(l);
        n.añadirInicio (new Nodo (new Grade("quiz3", 0)));
        n.añadirInicio(new Nodo(new Grade("quiz4", 0)));  
        n.añadirInicio(new Nodo(new Grade("quiz5", 0)));
        n.añadirFinal(new Nodo(new Grade("quiz6", 0)));   
        n.añadirPosicion(ld, 2);
        n.eliminarPosicion(3);
        n.eliminarFinal();
        n.eliminarFinal();
        n.imprimir();
        n.inversa();
        System.out.println("");
        n.imprimir();
    }
    
}
