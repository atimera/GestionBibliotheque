package com.opc.projet.gestionbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@SuppressWarnings("JpaQlInspection")
@ApiModel
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty("Obligatoire et doit être d'au moins 2 caractères")
    @NotBlank(message = "Obligatoire") @Size(min = 2)
    @Column(nullable = false)
    private String name;
    //@Pattern(regexp = "(0|\\+33|0033)[1-9][0-9]{8}", message = "numero de téléphone incorrect")
    private String phoneNumber;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Address location;

    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "library",
            cascade = {CascadeType.ALL})
    private List<Book> books;

    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "library",
            cascade = {CascadeType.ALL})
    private List<Employee> employees;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "library_member",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private List<Member> members;

    // construction with name
    public Library(@NotBlank @Size(min = 2) String name) {
        this.name = name;
    }


    // constructor with name and phoneNumber
    public Library(@NotBlank @Size(min = 2)
                   String name,
                   @Pattern(regexp = "[ 0-9]", message = "numero de téléphone incorrect")
                   String phoneNumber) {

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // constructor with name and address
    public Library(@NotBlank @Size(min = 2)
                   String name,
                   @Pattern(regexp = "[ 0-9]", message = "numero de téléphone incorrect")
                   Address location) {

        this.name = name;
        this.location = location;
    }


    // constructor with name, phoneNumber and the address
    public Library(@NotBlank @Size(min = 2)
                   String name,
                   @Pattern(regexp = "[ 0-9]", message = "numero de téléphone incorrect")
                   String phoneNumber,
                   Address location) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }


    //convenience methods for bi-directional relationship

//    public void addEmployee (Employee employee){
//        if(employees == null){
//            employees = new ArrayList<>();
//        }
//        employees.add(employee);
//        employee.setLibrary(this);
//    }
//
//    public void addMember (Member member){
//        if(members == null){
//            members = new ArrayList<>();
//        }
//        members.add(member);
//        member.addLibrary(this);
//    }






}
