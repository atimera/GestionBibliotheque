package com.opc.projet.gestionbiblio.webapp.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddressEntity {


    @NotNull(message = "Obligatoire")
    @Size(min = 5, message = "doit avoir au moins 5 caractère")
    private String address;

    private String address2;

    @NotNull(message = "Obligatoire")
    @Pattern(regexp = "^[0-9]{5}", message = "Code postale invalide")
    private String postalCode;

    @NotNull(message = "Obligatoire")
    @Size(min = 1, message = "Obligatoire")
    private String city;

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
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", postal_code='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }}
