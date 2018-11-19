package com.opc.projet.gestionbiblio.business.bean;

public class Adresse {
    // ===================== Attributs =================//
    private Integer id;
    private String adresse;
    private String codePostal;
    private String ville;

    // ==================== Constructeurs =====================//
   public Adresse(){
    }

    public Adresse(Integer pId){
        id = pId;
    }

    // ==================== Getters/Setters ====================//
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    // ==================== Methods ====================//

}
