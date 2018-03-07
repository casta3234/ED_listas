/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_listas;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Estudiante
 */
public class Lista {
    
    Nodo cabeza = null;
    
    public boolean vacia(){
        return this.cabeza == null; 
        
    }
    
    public void añadirInicio(Nodo nuevoNodo){
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }
    
    public void añadirFinal(Nodo nuevoNodo){
        if (vacia()){
            cabeza = nuevoNodo;                     
        }
        else{
            Nodo temp = cabeza;
            while(temp.siguiente != null){
                temp = temp.siguiente;               
            }
            temp.siguiente = nuevoNodo;
        }
    }
    
    public void añadirPosicion(Nodo nuevoNodo, int posicion){
        Nodo temp = cabeza;
        for(int i = 0; i < posicion-1; i++ ){
            temp = temp.siguiente;
        }
        nuevoNodo.siguiente = temp.siguiente;
        temp.siguiente = nuevoNodo;            
    }
       
    public void eliminarInicio(){
        Nodo temp = cabeza;
        cabeza = cabeza.siguiente;
        temp = null;
        System.gc();
    }
    
    public void eliminarFinal(){
        Nodo pre = cabeza;
        Nodo temp = cabeza.siguiente.siguiente;
        while (temp != null){            
            pre = pre.siguiente;
            temp = temp.siguiente;
        }        
        pre.siguiente = null;
        System.gc();
    }
    
    public void eliminarPosicion(int posicion){
        Nodo temp = cabeza;
        Nodo eliminado;
        for(int i = 0; i < posicion-1; i++){
            temp = temp.siguiente;
        }
        eliminado = temp.siguiente;
        temp.siguiente = temp.siguiente.siguiente;
        eliminado = null;
        System.gc();
    }
    
    public void imprimir(){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Nodo temp = cabeza;
        try{
            while(temp != null){
                bw.write(temp.toString());
                temp = temp.siguiente;
            }
            bw.flush();
        }
        catch(IOException ex){
        }
    }
    
    public static void main(String[] args) {
        Lista n = new Lista();
        Nodo l = new Nodo("quiz", 1.2);
        Nodo ld = new Nodo("quiz", 1.2);
        n.añadirInicio(l);
        n.añadirInicio(new Nodo("123df", 0));
        n.añadirInicio(new Nodo("123df", 0));  
        n.añadirInicio(new Nodo("123df", 0));
        n.añadirFinal(new Nodo("2314", 12));        
        n.eliminarFinal();
        n.eliminarFinal();
        n.imprimir();
    }
    /*    public void añadirFinal(Nodo nuevoNodo){
        if (vacia()){
            cabeza = nuevoNodo;                     
        }
        else{
            Nodo temp = cabeza;
            while(temp.siguiente != null){
                temp = temp.siguiente;               
            }
            temp.siguiente = nuevoNodo;
        }
    }*/
}
