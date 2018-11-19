package com.opc.projet.gestionbiblio.business.bean;

public class Employe extends Personne {

    // ===================== Attributs =================//
    private String email;
    private String mdp;

    // ==================== Constructeurs =====================//
    public Employe(){
    }

    public Employe(Integer pId){
        super(pId);
    }

    // ==================== Getters/Setters ====================//

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    // ==================== Methods ====================//


}
