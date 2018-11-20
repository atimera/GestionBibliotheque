package com.opc.projet.gestionbiblio.model.bean;

public abstract class Personne {

    // ==================== Attributs ==================== //
    private Integer id;
    private String nom;
    private String prenom;
    private Adresse adresse;


    // ==================== Constructeurs ==================== //
    /**
     * Constructeur par défaut.
     */
    public Personne() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Personne(Integer pId) {
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    // ==================== Méthodes ==================== //

    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id=").append(id)
                .append(vSEP).append("Prénom=\"").append(prenom).append('"')
                .append(vSEP).append("Nom=\"").append(nom).append('"')
                .append(vSEP).append("Ville=\"").append(adresse.getVille()).append('"')
                .append("}");
        return vStB.toString();
    }
}
