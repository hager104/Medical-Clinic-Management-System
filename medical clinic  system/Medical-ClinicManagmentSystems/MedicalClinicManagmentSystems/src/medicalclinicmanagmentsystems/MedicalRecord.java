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
// File: MedicalRecord.java
// Pattern: Prototype Pattern
interface MedicalRecord {
    void display();
    MedicalRecord clone();
}
