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
// File: LabResult.java
// Pattern: Prototype Pattern
class LabResult implements MedicalRecord {
    public void display() {
        System.out.println("Displaying lab result.");
    }

    public MedicalRecord clone() {
        return new LabResult();
    }
}
