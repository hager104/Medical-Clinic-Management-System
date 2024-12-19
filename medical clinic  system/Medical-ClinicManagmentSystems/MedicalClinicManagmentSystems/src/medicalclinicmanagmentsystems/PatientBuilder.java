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
// File: PatientBuilder.java
// Pattern: Builder Pattern
class PatientBuilder {
    private String name;
    private int age;

    public PatientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PatientBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public Patient build() {
        return new Patient(name, age);
    }
}
