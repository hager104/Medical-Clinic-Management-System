/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalclinicmanagmentsystems;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicalClinicManagmentSystems {
    private JFrame frame;

    // بيانات وهمية للتخزين في الجداول
    private DefaultTableModel patientTableModel;
    private DefaultTableModel doctorTableModel;
    private DefaultTableModel appointmentTableModel;

    // عدادات لتوليد المعرّفات
    private int patientIdCounter = 1;
    private int doctorIdCounter = 1;

    public MedicalClinicManagmentSystems() {
        // إنشاء نافذة رئيسية
        frame = new JFrame("Medical Clinic Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(3, 1, 10, 10));
        
        // إضافة الأزرار مع اللون والخطوط الجذابة
        JButton addPatientButton = createStyledButton("Add Patient");
        JButton addDoctorButton = createStyledButton("Add Doctor");
        JButton addAppointmentButton = createStyledButton("Add Appointment");

        frame.add(addPatientButton);
        frame.add(addDoctorButton);
        frame.add(addAppointmentButton);

        // إنشاء الجداول (الموديلات) للبيانات
        patientTableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Age", "Disease", "Action"}, 0);
        doctorTableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Specialty", "Action"}, 0);
        appointmentTableModel = new DefaultTableModel(new Object[]{"Patient", "Doctor", "Date", "Action"}, 0);

        // إضافة مستمعين للأزرار
        addPatientButton.addActionListener(e -> openAddPatientDialog());
        addDoctorButton.addActionListener(e -> openAddDoctorDialog());
        addAppointmentButton.addActionListener(e -> openAddAppointmentDialog());

        // إظهار النافذة
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // دالة لإنشاء الأزرار ذات التصميم الجميل
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(0, 123, 255));  // اللون الأزرق
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // إضافة تأثير عند المرور فوق الزر
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 105, 217)); // اللون الداكن عند المرور
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 123, 255)); // العودة للون الأصلي
            }
        });
        
        return button;
    }

    // نافذة فرعية لإضافة مريض
    private void openAddPatientDialog() {
        JDialog addPatientDialog = new JDialog(frame, "Add Patient", true);
        addPatientDialog.setSize(frame.getWidth(), frame.getHeight());
        addPatientDialog.setLayout(new BorderLayout());

        JTable patientTable = new JTable(patientTableModel);
        JScrollPane tableScrollPane = new JScrollPane(patientTable);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel diseaseLabel = new JLabel("Disease:");
        JTextField diseaseField = new JTextField();
        JLabel idLabel = new JLabel("Patient ID:");
        JTextField idField = new JTextField();
        idField.setEditable(false);
        idField.setText(String.valueOf(patientIdCounter));

        JButton submitButton = createStyledButton("Submit");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(ageLabel);
        formPanel.add(ageField);
        formPanel.add(diseaseLabel);
        formPanel.add(diseaseField);
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(submitButton);

        addPatientDialog.add(formPanel, BorderLayout.NORTH);
        addPatientDialog.add(tableScrollPane, BorderLayout.CENTER);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String age = ageField.getText();
            String disease = diseaseField.getText();
            int id = patientIdCounter++; // توليد معرّف تلقائي
            patientTableModel.addRow(new Object[]{id, name, age, disease, "Delete"});
            JOptionPane.showMessageDialog(addPatientDialog, "Patient Added: ID = " + id + ", Name = " + name + ", Age = " + age + ", Disease = " + disease);
            addPatientDialog.dispose();
        });

        patientTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        patientTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));

        addPatientDialog.setLocationRelativeTo(frame);
        addPatientDialog.setVisible(true);
    }

    // نافذة فرعية لإضافة طبيب
    private void openAddDoctorDialog() {
        JDialog addDoctorDialog = new JDialog(frame, "Add Doctor", true);
        addDoctorDialog.setSize(frame.getWidth(), frame.getHeight());
        addDoctorDialog.setLayout(new BorderLayout());

        JTable doctorTable = new JTable(doctorTableModel);
        JScrollPane tableScrollPane = new JScrollPane(doctorTable);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel specialtyLabel = new JLabel("Specialty:");
        JTextField specialtyField = new JTextField();
        JLabel idLabel = new JLabel("Doctor ID:");
        JTextField idField = new JTextField();
        idField.setEditable(false);
        idField.setText(String.valueOf(doctorIdCounter));

        JButton submitButton = createStyledButton("Submit");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(specialtyLabel);
        formPanel.add(specialtyField);
        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(submitButton);

        addDoctorDialog.add(formPanel, BorderLayout.NORTH);
        addDoctorDialog.add(tableScrollPane, BorderLayout.CENTER);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String specialty = specialtyField.getText();
            int id = doctorIdCounter++; // توليد معرّف تلقائي
            doctorTableModel.addRow(new Object[]{id, name, specialty, "Delete"});
            JOptionPane.showMessageDialog(addDoctorDialog, "Doctor Added: ID = " + id + ", Name = " + name + ", Specialty = " + specialty);
            addDoctorDialog.dispose();
        });

        doctorTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        doctorTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));

        addDoctorDialog.setLocationRelativeTo(frame);
        addDoctorDialog.setVisible(true);
    }

    // نافذة فرعية لإضافة موعد
    private void openAddAppointmentDialog() {
        JDialog addAppointmentDialog = new JDialog(frame, "Add Appointment", true);
        addAppointmentDialog.setSize(frame.getWidth(), frame.getHeight());
        addAppointmentDialog.setLayout(new BorderLayout());

        JTable appointmentTable = new JTable(appointmentTableModel);
        JScrollPane tableScrollPane = new JScrollPane(appointmentTable);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JLabel patientLabel = new JLabel("Patient Name:");
        JTextField patientField = new JTextField();
        JLabel doctorLabel = new JLabel("Doctor Name:");
        JTextField doctorField = new JTextField();
        JLabel dateLabel = new JLabel("Appointment Date (YYYY-MM-DD):");
        JTextField dateField = new JTextField();
        JButton submitButton = createStyledButton("Submit");

        formPanel.add(patientLabel);
        formPanel.add(patientField);
        formPanel.add(doctorLabel);
        formPanel.add(doctorField);
        formPanel.add(dateLabel);
        formPanel.add(dateField);
        formPanel.add(submitButton);

        addAppointmentDialog.add(formPanel, BorderLayout.NORTH);
        addAppointmentDialog.add(tableScrollPane, BorderLayout.CENTER);

        submitButton.addActionListener(e -> {
            String patient = patientField.getText();
            String doctor = doctorField.getText();
            String date = dateField.getText();
            appointmentTableModel.addRow(new Object[]{patient, doctor, date, "Delete"});
            JOptionPane.showMessageDialog(addAppointmentDialog, "Appointment Scheduled: Patient = " + patient + ", Doctor = " + doctor + ", Date = " + date);
            addAppointmentDialog.dispose();
        });

        appointmentTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        appointmentTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));

        addAppointmentDialog.setLocationRelativeTo(frame);
        addAppointmentDialog.setVisible(true);
    }

    // خلايا الزر (ButtonRenderer)
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer() {
            setText("Delete");
            setBackground(new Color(255, 99, 71)); // لون أحمر
            setForeground(Color.WHITE);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // خلايا الزر (ButtonEditor)
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setText("Delete");
            button.setBackground(new Color(255, 99, 71)); // لون أحمر
            button.setForeground(Color.WHITE);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, button);
                    if (table != null) {
                        int selectedRow = table.getSelectedRow();
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            return button;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MedicalClinicManagmentSystems::new);
    }
}
