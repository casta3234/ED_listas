/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_listas;

import java.io.BufferedWriter;
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
        catch(Exception ex){
            
        }
    }
    
    public static void main(String[] args) {
        Lista n = new Lista();
        Nodo l = new Nodo("quiz", 1.2);
        n.añadirInicio(l);
        n.imprimir();
    }
}
