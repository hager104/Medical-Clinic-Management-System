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
// File: AbstractFactory.java
// Pattern: Abstract Factory Pattern
interface AbstractFactory {
    Doctor createDoctor(String specialty, String name);
    MedicalRecord createMedicalRecord(String type);
}
