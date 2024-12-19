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
// File: MedicalRecordFactory.java
// Pattern: Factory Pattern
class MedicalRecordFactory {
    public static MedicalRecord createMedicalRecord(String type) {
        switch (type.toLowerCase()) {
            case "history":
                return new PatientHistory();
            case "prescription":
                return new Prescription();
            case "labresult":
                return new LabResult();
            default:
                throw new IllegalArgumentException("Invalid medical record type");
        }
    }
}

