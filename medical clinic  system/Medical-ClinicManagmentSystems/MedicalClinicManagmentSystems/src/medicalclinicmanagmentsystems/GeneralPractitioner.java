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
// File: GeneralPractitioner.java
// Specialized Doctor: General Practitioner
class GeneralPractitioner extends Doctor {

    private int id;
    // نمرر "name" و "specialty" إلى الـ Doctor عبر الـ constructor
    GeneralPractitioner(String name) {
        super(name, "General Practitioner"); // تم تمرير specialty كـ "General Practitioner"
    }

    // إضافة كونستركتور آخر لقبول id و name
    GeneralPractitioner(int id, String name) {
        super(name, "General Practitioner"); // تم تمرير specialty كـ "General Practitioner"
        this.id = id; // تعيين الـ id هنا بعد التمرير
    }

    @Override
    public void diagnose() {
        System.out.println("Diagnosing general health issues.");
    }
}


