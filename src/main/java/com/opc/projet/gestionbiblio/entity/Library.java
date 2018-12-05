//package com.opc.projet.gestionbiblio.entity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Entity
//@Table(name = "library")
//public class Library {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "name")
//    private String name;
//
//    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "address_id")
//    private Address address;
//
//    @OneToMany(
//            fetch = FetchType.LAZY,
//            mappedBy = "library",
//            cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private List<Employee> employees;
//
//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinTable(name = "library_member",
//            joinColumns = @JoinColumn(name = "library_id"),
//            inverseJoinColumns = @JoinColumn(name = "member_id"))
//    private List<Member> members;
//
//    public Library(){
//
//    }
//
//    public Library(String name){
//        this.name = name;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
//
//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }
//
//
//    // convenience methods for bi-directional relationship
//
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
//
//}
