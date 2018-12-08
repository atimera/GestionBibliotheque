package com.opc.projet.gestionbiblio.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQuery(name = "find_all_addresses", query = "select a from Address a")
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
    private String postalCode;

    @NotBlank(message = "Obligatoire")
    private String city;

    //@Setter(AccessLevel.NONE)
//    @Version
//    private Long version = 0L;

    // === contructors with args

    public Address(
            long id,
            String address,
            String address2,
                @NotBlank(message = "Obligatoire")
                @Pattern(regexp = "^[0-9]{5}", message = "Code postal invalide")
            String postalCode,
                @NotBlank(message = "Obligatoire")
            String city) {

        this.id = id;
        this.address = address;
        this.address2 = address2;
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

    @Override
    public String toString() {
        return "\n-> Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
