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
 * @author sebastian
 */
public class Pila {
    private Nodo cabeza = null;
    
    public boolean vacia (){
        return this.cabeza == null;
    }
    
    public void agregar(Nodo nuevoNodo){
        nuevoNodo.setSiguiente(this.cabeza);
        this.cabeza = nuevoNodo;
    }
    
    public void eliminar(){
        Nodo temp = this.cabeza;
        this.cabeza = this.cabeza.getSiguiente();
        temp = null;
        System.gc();
    }
    
    public Nodo mirar(){
        return this.cabeza;
    }
    
    public Nodo sacar(){
        Nodo temp = this.cabeza;       
        this.cabeza = this.cabeza.getSiguiente();       
        System.gc();
        return temp;       
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
    Pila p = new Pila();
    p.agregar(new Nodo("t1", 4));
    p.agregar(new Nodo("t2", 3));
    p.agregar(new Nodo("t3", 2));
    p.agregar(new Nodo("t4", 1));
    //p.eliminar();
    Nodo n =p.mirar();
    Nodo n1 = p.sacar();
    p.imprimir();
    //System.out.println(n.toString() + n1.toString());
    
    }
}
