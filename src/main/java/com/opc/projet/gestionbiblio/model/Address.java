package com.opc.projet.gestionbiblio.model;

import lombok.*;

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
@Getter
@Setter
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "location")
    private Library library;

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


}
