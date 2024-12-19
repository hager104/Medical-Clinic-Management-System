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
// File: DatabaseManager.java
// Pattern: Singleton Pattern

import java.sql.*;

public class DatabaseManager {
    private static DatabaseManager instance;
    private Connection connection;

    // مُنشئ خاص لمنع إنشاء مثيل مباشر من الفئة
    private DatabaseManager() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:medical.db");
            initializeDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // طريقة للحصول على المثيل الوحيد للفئة
    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    DatabaseManager(String clinic_dbsqlite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // طريقة للحصول على الاتصال بقاعدة البيانات
    public Connection getConnection() {
        return connection;
    }

    // تهيئة قاعدة البيانات وإنشاء الجداول في حال عدم وجودها
    private void initializeDatabase() {
        try (Statement stmt = connection.createStatement()) {
            // جدول المرضى
            stmt.execute("CREATE TABLE IF NOT EXISTS Patients (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "name TEXT NOT NULL, " +
                         "age INTEGER NOT NULL)");

            // جدول الأطباء
            stmt.execute("CREATE TABLE IF NOT EXISTS Doctors (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "name TEXT NOT NULL, " +
                         "specialty TEXT NOT NULL)");

            // جدول المواعيد
            stmt.execute("CREATE TABLE IF NOT EXISTS Appointments (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "patient_id INTEGER, " +
                         "doctor_id INTEGER, " +
                         "time TEXT NOT NULL, " +
                         "FOREIGN KEY(patient_id) REFERENCES Patients(id), " +
                         "FOREIGN KEY(doctor_id) REFERENCES Doctors(id))");
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ResultSet getAppointments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addAppointment(int parseInt, int parseInt0, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ResultSet getDoctors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addDoctor(String name, String specialty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addPatient(String name, int parseInt, String disease) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ResultSet getPatients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


