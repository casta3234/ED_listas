/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

/**
 *
 * @author SC
 */
public class Nodo {
    
    private String grade;
    private  double value;
    private Nodo siguiente = null;

    public Nodo() {
    }

    public Nodo(String grade, double value) {
        this.grade = grade;
        this.value = value;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    

    @Override
    public String toString() {
        return "Grade: " + this.grade + "\t" + "Value: " + this.value + "\n";
    }
    
    
    
}
