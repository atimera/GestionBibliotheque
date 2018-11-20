package com.opc.projet.gestionbiblio.model.bean;

public class Bibliotheque {

    // ==================== Attributs ================//
    private Integer id;
    private String nom;
    private Adresse adresse;

    // ==================== Constructeurs =====================//
    public Bibliotheque(){
    }

    public Bibliotheque(Integer pId){
        id = pId;
    }

    // ==================== Getters/Setters ====================//
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    // ==================== Methods ====================//

}
