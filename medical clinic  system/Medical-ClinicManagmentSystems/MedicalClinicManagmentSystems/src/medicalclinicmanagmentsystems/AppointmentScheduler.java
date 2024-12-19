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
// File: AppointmentScheduler.java
// Pattern: Singleton Pattern


import java.sql.*;
import java.util.*;

public class AppointmentScheduler {

    static AppointmentScheduler getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Connection connection;

    public AppointmentScheduler(Connection connection) {
        this.connection = connection;
    }

    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM Appointments";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String patientName = rs.getString("patient_name");
                String doctorName = rs.getString("doctor_name");
                String time = rs.getString("appointment_time");

                // Create Patient and Doctor objects
                Patient patient = new Patient(patientName, rs.getInt("patient_age"));
                Doctor doctor = new SpecialistDoctor(doctorName, rs.getString("doctor_specialty")); // استخدم فئة فرعية

                // Create Appointment object
                appointments.add(new Appointment(id, patient, doctor, time));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public void scheduleAppointment(Patient patient, Doctor doctor, String time) {
        String query = "INSERT INTO Appointments (patient_name, patient_age, doctor_name, doctor_specialty, appointment_time) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, doctor.getName());
            stmt.setString(4, doctor.getSpecialty());
            stmt.setString(5, time);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int id) {
        String query = "DELETE FROM Appointments WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void scheduleAppointment(Appointment appointment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



