package com.opc.projet.gestionbiblio.model;

import javax.persistence.*;

@Entity
public class Address implements DomainObject{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    //@NotBlank
    @Column(name = "postal_code")
    private String postalCode;

    //@NotBlank
    @Column(name = "city")
    private String city;

//    @Version
//    private Integer version;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
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

//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
