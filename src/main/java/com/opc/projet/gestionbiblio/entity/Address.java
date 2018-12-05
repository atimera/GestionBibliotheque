package com.opc.projet.gestionbiblio.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @NotBlank
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank
    @Column(name = "city")
    private String city;


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

    public void setPostalCode(String postal_code) {
        this.postalCode = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", postal_code='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
