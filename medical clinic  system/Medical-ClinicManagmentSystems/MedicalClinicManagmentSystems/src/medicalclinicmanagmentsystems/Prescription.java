/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalclinicmanagmentsystems;

/**
 *
 * @author UNITED
 */
// File: Prescription.java
// Pattern: Prototype Pattern
class Prescription implements MedicalRecord {
    public void display() {
        System.out.println("Displaying prescription.");
    }

    public MedicalRecord clone() {
        return new Prescription();
    }
}
