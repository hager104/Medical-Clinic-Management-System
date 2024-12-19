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

public class DatabaseConnection {

    // الاتصال بقاعدة البيانات
    public static Connection connect() {
        try {
            // استخدام URL الخاص بقاعدة البيانات
            String url = "jdbc:sqlite:medical.db";  // تأكد من أن اسم الملف مطابق لقاعدة البيانات التي أنشأتها
            Connection conn = DriverManager.getConnection("jdbc:sqlite:medical.db");

            return conn;
        } catch (SQLException e) {
            System.out.println("Connection to SQLite failed.");
            e.printStackTrace();
            return null;
        }
    }

    // اختبار الاتصال بقاعدة البيانات
    public static void main(String[] args) {
        Connection conn = connect();
        if (conn != null) {
            System.out.println("Connection to SQLite has been established.");
        }
    }
}


