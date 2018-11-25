package com.opc.projet.gestionbiblio.webapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends Person{

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


}
