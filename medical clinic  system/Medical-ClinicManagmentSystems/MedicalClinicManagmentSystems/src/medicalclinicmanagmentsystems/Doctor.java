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
// File: Doctor.java
// Base class for doctors
public class Doctor {
    String name;
    private String specialty;
    Object id;

    // Constructor يناسب المعاملات المطلوبة
    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public void diagnose() {
        // يمكنك إضافة منطق التشخيص هنا
        System.out.println("Diagnosing...");
    }

    // باقي الكود

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getSpecialty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

