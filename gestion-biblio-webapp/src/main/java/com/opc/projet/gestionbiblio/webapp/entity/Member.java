package com.opc.projet.gestionbiblio.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@JsonIgnoreProperties(ignoreUnknown = true) // ignore the unknown properties
public class Member extends Person{

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "library_member",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "library_id"))
    private List<Library> libraries;

    @OneToMany(mappedBy = "lender",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<BookCopy> lendedCopies;

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

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public List<BookCopy> getLendedCopies() {
        return lendedCopies;
    }

    public void setLendedCopies(List<BookCopy> lendedCopies) {
        this.lendedCopies = lendedCopies;
    }

    @Override
    public String toString() {
        return "Member{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    // inconvenience methods for bi-directional relationship

    public void addLibrary(Library library) {
        if(libraries == null){
            libraries = new ArrayList<>();
        }
        // set the link
        libraries.add(library);
        library.addMember(this);
    }

    public void addBookCopy(BookCopy copy){
        if(lendedCopies == null){
            lendedCopies = new ArrayList<>();
        }
        // set the link
        lendedCopies.add(copy);
        copy.setLender(this);
    }


}
