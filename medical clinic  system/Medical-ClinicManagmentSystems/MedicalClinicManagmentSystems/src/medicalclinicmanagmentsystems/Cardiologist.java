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
// File: Cardiologist.java
// Specialized Doctor: Cardiologist
class Cardiologist extends Doctor {

    private int id;
    // نمرر "name" و "specialty" إلى الـ Doctor عبر الـ constructor
    Cardiologist(String name) {
        super(name, "Cardiologist"); // تم تمرير specialty كـ "Cardiologist"
    }

    // إضافة كونستركتور آخر لقبول id و name
    Cardiologist(int id, String name) {
        super(name, "Cardiologist"); // تم تمرير specialty كـ "Cardiologist"
        this.id = id; // تعيين الـ id هنا بعد التمرير
    }

    @Override
    public void diagnose() {
        System.out.println("Diagnosing heart-related issues.");
    }
}

