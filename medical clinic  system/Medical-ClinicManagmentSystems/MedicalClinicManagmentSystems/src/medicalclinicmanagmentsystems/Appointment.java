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
// File: Appointment.java
// Represents an Appointment
public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String time;

    public Appointment(int id, Patient patient, Doctor doctor, String time) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
    }

    Appointment(Patient patient, Doctor doctor, String time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getTime() {
        return time;
    }
}

