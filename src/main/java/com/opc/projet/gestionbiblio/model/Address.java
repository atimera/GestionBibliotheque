package com.opc.projet.gestionbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQueries({
    @NamedQuery(name = "find_all_addresses", query = "select a from Address a"),

    @NamedQuery(name = "find_libraries_group_by_city",
        query = "select a.city, count(L) from Address a join a.library L group by  a.city")
})
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
public class Address{

    @Id
    @GeneratedValue
    private Long id;
    private String address;
    private String address2;

    @NotBlank(message = "Obligatoire")
    @Pattern(regexp = "^[0-9]{5}", message = "Code postal invalide")
    @Column(nullable = false, length = 5)
    private String postalCode;

    @NotBlank(message = "Obligatoire")
    @Column(nullable = false)
    private String city;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "location")
    private Library library;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})  // TODO: 10/12/2018
    @JoinTable(name = "person_address",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> people;









    // === contructors with postalCode and city
    public Address(
                @NotBlank(message = "Obligatoire")
                @Pattern(regexp = "^[0-9]{5}", message = "Code postal invalide")
            String postalCode,
                @NotBlank(message = "Obligatoire")
            String city) {

        this.postalCode = postalCode;
        this.city = city;
    }
        public Address(
            String address,
            String address2,
                @NotBlank(message = "Obligatoire")
                @Pattern(regexp = "^[0-9]{5}", message = "Code postal invalide")
            String postalCode,
                @NotBlank(message = "Obligatoire")
            String city) {

        this.address = address;
        this.address2 = address2;
        this.postalCode = postalCode;
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }



//    public void addPerson(Person person) {
//        if(people == null){
//            people = new ArrayList<>();
//        }
//        people.add(person);
//        person.addAddress(this);
//    }
}
