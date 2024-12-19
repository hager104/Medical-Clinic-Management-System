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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:clinic.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // إنشاء جدول المرضى
            String createPatientsTable = "CREATE TABLE IF NOT EXISTS patients (" +
                                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         "name TEXT NOT NULL, " +
                                         "age INTEGER NOT NULL);";
            stmt.execute(createPatientsTable);

            // إنشاء جدول الأطباء
            String createDoctorsTable = "CREATE TABLE IF NOT EXISTS doctors (" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "name TEXT NOT NULL, " +
                                        "specialty TEXT NOT NULL);";
            stmt.execute(createDoctorsTable);

            // إنشاء جدول المواعيد
            String createAppointmentsTable = "CREATE TABLE IF NOT EXISTS appointments (" +
                                             "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                             "patient_id INTEGER, " +
                                             "doctor_id INTEGER, " +
                                             "date TEXT, " +
                                             "FOREIGN KEY(patient_id) REFERENCES patients(id), " +
                                             "FOREIGN KEY(doctor_id) REFERENCES doctors(id));";
            stmt.execute(createAppointmentsTable);

            System.out.println("Database and tables created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

