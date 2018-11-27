package com.opc.projet.gestionbiblio.model.bean;

public class Book {
    // ==================== Attributs ====================
    private Integer id;
    private String titre;
    //private Bibliotheque bibliotheque;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Book() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Book(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    // ==================== Méthodes ====================
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id=").append(id)
                .append(vSEP).append("Titre=\"").append(titre).append('"')
                .append("}");
        return vStB.toString();
    }
}
