package com.opc.projet.gestionbiblio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQueries({
    @NamedQuery(name = "find_all_libraries", query = "select L from Library L"),

    @NamedQuery(name = "find_all_libraries_order_by_name", query = "select L from Library L order by L.name"),

})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Library {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 2)
    @Column(nullable = false)
    private String name;

    @Pattern(regexp = "[ 0-9]", message = "numero de téléphone incorrect")
    private String phoneNumber;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Address address;

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
                   Address address) {

        this.name = name;
        this.address = address;
    }


    // constructor with name, phoneNumber and the address
    public Library(@NotBlank @Size(min = 2)
                   String name,
                   @Pattern(regexp = "[ 0-9]", message = "numero de téléphone incorrect")
                   String phoneNumber,
                   Address address) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


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


    @Override
    public String toString() {
        return "\n-> Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address -> " + address +
                '}';
    }

}
