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
// File: DoctorFactory.java
// Pattern: Factory Pattern
class DoctorFactory {
    public static Doctor createDoctor(String specialty, String name) {
        switch (specialty.toLowerCase()) {
            case "cardiologist":
                return new Cardiologist(name);
            case "neurologist":
                return new Neurologist(name);
            case "generalpractitioner":
                return new GeneralPractitioner(name);
            default:
                throw new IllegalArgumentException("Invalid doctor specialization");
        }
    }
}
