package com.opc.projet.gestionbiblio.webapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee extends Person{

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "library_id")
    private Library library;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "lendBy",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    private List<BookCopy> lendedCopies;


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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<BookCopy> getLendedCopies() {
        return lendedCopies;
    }

    public void setLendedCopies(List<BookCopy> lendedCopies) {
        this.lendedCopies = lendedCopies;
    }

    // inconvenience methods for bi-directional relationship

    public void addLendedCopy(BookCopy copy){
        if(lendedCopies == null){
            lendedCopies = new ArrayList<>();
        }
        // set the link
        lendedCopies.add(copy);
        copy.setLendBy(this);
    }


}
