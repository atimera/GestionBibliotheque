package com.opc.projet.gestionbiblio.webapp.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Address {

    @NotNull
    @Size(min = 5, message = "addresse trop courte")
    private String address;
    private String address2;

    @NotNull(message = "Le code postal est obligatoire")
    @Size(min = 1, message = "Le code postal est obligatoire")
    @Pattern(regexp = "", message = "Code postal invalide")
    private String postalCode;


    @NotNull(message = "Le nom de la ville est obligatoire")
    @Size(min = 1, message = "Le nom de la ville est obligatoire")
    @Pattern(regexp = "", message = "Code postal invalide")
    private String city;

    public Address(){

    }

    public Address(String address, String postalCode, String city) {
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
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
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", postal_code='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
