package com.opc.projet.gestionbiblio.model.bean;

public class Library {

    // ==================== Attributs ================//
    private Integer id;
    private String name;
    private Address address;

    // ==================== Constructeurs =====================//
    public Library(){
    }

    public Library(Integer pId){
        id = pId;
    }

    // ==================== Getters/Setters ====================//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    // ==================== Methods ====================//

}
