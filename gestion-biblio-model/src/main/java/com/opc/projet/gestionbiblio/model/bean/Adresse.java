package com.opc.projet.gestionbiblio.model.bean;

public class Adresse {
    // ===================== Attributs =================//
    private Integer id;
    private String rue;
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

    public String getRue() {
        return rue;
    }

    public void setRue(String adresse) {
        this.rue = adresse;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id=").append(id)
                .append(vSEP).append("rue=\"").append(rue).append('"')
                .append(vSEP).append("codePostal=\"").append(codePostal).append('"')
                .append(vSEP).append("ville=\"").append(ville).append('"')
                .append("}");
        return vStB.toString();
    }

}
