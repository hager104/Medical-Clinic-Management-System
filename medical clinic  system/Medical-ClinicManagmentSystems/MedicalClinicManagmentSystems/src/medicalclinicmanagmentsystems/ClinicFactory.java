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
// File: ClinicFactory.java
// Pattern: Abstract Factory Pattern
class ClinicFactory implements AbstractFactory {
    public Doctor createDoctor(String specialty, String name) {
        return DoctorFactory.createDoctor(specialty, name);
    }

    public MedicalRecord createMedicalRecord(String type) {
        return MedicalRecordFactory.createMedicalRecord(type);
    }
}
