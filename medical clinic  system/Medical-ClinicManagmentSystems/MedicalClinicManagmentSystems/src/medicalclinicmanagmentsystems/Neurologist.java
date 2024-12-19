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
// File: Neurologist.java
// Specialized Doctor: Neurologist
class Neurologist extends Doctor {

    private int id;
    // نمرر "name" و "specialty" إلى الـ Doctor عبر الـ constructor
    Neurologist(String name) {
        super(name, "Neurologist"); // تم تمرير specialty كـ "Neurologist"
    }

    // إضافة كونستركتور آخر لقبول id و name
    Neurologist(int id, String name) {
        super(name, "Neurologist"); // تم تمرير specialty كـ "Neurologist" و name
        this.id = id; // تعيين الـ id هنا بعد التمرير
    }

    @Override
    public void diagnose() {
        System.out.println("Diagnosing brain-related issues.");
    }
}

