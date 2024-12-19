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

public class AppointmentDatabaseManager {
    private static AppointmentDatabaseManager instance;
    private Connection connection;

    // Constructor to initialize database connection
    private AppointmentDatabaseManager() {
        try {
            String url = "jdbc:sqlite:medical.db"; // Adjust the path if needed
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Singleton pattern to get a single instance of the database manager
    public static synchronized AppointmentDatabaseManager getInstance() {
        if (instance == null) {
            instance = new AppointmentDatabaseManager();
        }
        return instance;
    }

    // Method to get a list of all appointments
    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";  // SQL query to select all appointments

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String patientName = resultSet.getString("patient_name");
                String doctorName = resultSet.getString("doctor_name");
                String time = resultSet.getString("time");

                Patient patient = new Patient(patientName, 30); // يمكن تعديل العمر حسب البيانات المخزنة في قاعدة البيانات
                Doctor doctor = new SpecialistDoctor(doctorName, "Specialty"); // استخدم فئة فرعية للطبيب

                Appointment appointment = new Appointment(id, patient, doctor, time);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    // Method to add a new appointment to the database
    public void addAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (patient_name, doctor_name, time) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, appointment.getPatient().getName());
            preparedStatement.setString(2, appointment.getDoctor().getName());
            preparedStatement.setString(3, appointment.getTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an appointment from the database
    public void deleteAppointment(int appointmentId) {
        String query = "DELETE FROM appointments WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, appointmentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void scheduleAppointment(Appointment appointment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


