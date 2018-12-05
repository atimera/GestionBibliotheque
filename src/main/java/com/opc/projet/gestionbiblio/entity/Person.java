//package com.opc.projet.gestionbiblio.entity;
//
//import javax.persistence.*;
//
//
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//public abstract class Person {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false, nullable = false)
//    protected Integer id;
//
//    @Column(name = "first_name")
//    protected String firstName;
//
//    @Column(name = "last_name")
//    protected String lastName;
//
//    @Column(name = "gender")
//    protected char gender; // F or M or O for other;
//
//    public Person(){
//    }
//
//    public Person(String firstName, String lastName){
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public char getGender() {
//        return gender;
//    }
//
//    public void setGender(char gender) {
//        this.gender = gender;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", gender=" + gender +
//                '}';
//    }
//}
