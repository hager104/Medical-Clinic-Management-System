/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalclinicmanagmentsystems;

import java.sql.*;
import java.util.*;
/**
 *
 * @author UNITED
 */
// File: PatientDatabaseManager.java
// Pattern: Singleton Pattern


class PatientDatabaseManager {
    private static PatientDatabaseManager instance;
    private Connection connection;

    private PatientDatabaseManager() {
        try {
            connection = DatabaseManager.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized PatientDatabaseManager getInstance() {
        if (instance == null) {
            instance = new PatientDatabaseManager();
        }
        return instance;
    }

    public void addPatient(Patient patient) {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO Patients (name, age) VALUES (?, ?)")) {
            stmt.setString(1, patient.name);
            stmt.setInt(2, patient.age);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM Patients")) {
            while (rs.next()) {
                patients.add(new Patient(rs.getString("name"), rs.getInt("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    List<Patient> getAllPatients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean deletePatient(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Patient getPatientByName(String patientName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
