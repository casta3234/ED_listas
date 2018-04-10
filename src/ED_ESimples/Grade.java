/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

/**
 *
 * @author sebastian
 */
public class Grade {
    private String grade;
    private double value;

    public Grade(String grade, double value) {
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

    @Override
    public String toString() {
        return "Grade: " + this.grade + "\t" + "Value: " + this.value + "\n";
    }

    
    public boolean equals(Grade o) {
        return this.grade.equals(o.grade) && this.value == o.value;
    }
    
   
     
}
