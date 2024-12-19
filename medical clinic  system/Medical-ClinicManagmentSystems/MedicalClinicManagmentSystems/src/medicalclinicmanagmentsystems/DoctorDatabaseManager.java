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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Assuming Doctor is an abstract class or you have specific Doctor subclasses like Cardiologist, etc.
public class DoctorDatabaseManager {
    private static DoctorDatabaseManager instance;
    private Connection connection;

    // منع إنشاء نسخ متعددة
    private DoctorDatabaseManager() {
        connection = DatabaseManager.getInstance().getConnection();
    }

    // استخدام طريقة Singleton للحصول على الاتصال
    public static synchronized DoctorDatabaseManager getInstance() {
        if (instance == null) {
            instance = new DoctorDatabaseManager();
        }
        return instance;
    }

    // إضافة طبيب إلى قاعدة البيانات
    public void addDoctor(Doctor doctor) {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO doctors (name, specialty) VALUES (?, ?)")) {
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSpecialty());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // الحصول على قائمة الأطباء
    public List<Doctor> getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM doctors")) {
            while (rs.next()) {
                doctors.add(new Doctor(rs.getString("name"), rs.getString("specialty")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    // إضافة دالة أخرى مثل getDoctorByName() إذا كنت بحاجة لها
    public Doctor getDoctorByName(String name) {
        Doctor doctor = null;
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM doctors WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                doctor = new Doctor(rs.getString("name"), rs.getString("specialty"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }
}
