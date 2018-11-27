package com.opc.projet.gestionbiblio.model.bean;

public abstract class Person {

    // ==================== Attributs ==================== //
    private Integer id;
    private String nom;
    private String prenom;
    private Address adresse;


    // ==================== Constructeurs ==================== //
    /**
     * Constructeur par défaut.
     */
    public Person() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Person(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ==================== //

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Address getAdresse() {
        return adresse;
    }

    public void setAdresse(Address adresse) {
        this.adresse = adresse;
    }

    // ==================== Méthodes ==================== //

}
