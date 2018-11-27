package com.opc.projet.gestionbiblio.webapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member extends Person{

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Member(){
    }

    public Member(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
