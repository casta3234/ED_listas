/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_listas;

/**
 *
 * @author Estudiante
 */
public class Nodo {
    
    String grade;
    double value;
    Nodo siguiente;

    public Nodo() {
    }

    public Nodo(String grade, double value) {
        this.grade = grade;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Grade: " + this.grade + "\t" + "Value: " + this.value + "\n";
    }
    
    
    
}
