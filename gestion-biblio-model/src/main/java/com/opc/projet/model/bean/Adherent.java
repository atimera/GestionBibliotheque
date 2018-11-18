package com.opc.projet.model.bean;

public class Adherent extends Personne {

    // ===================== Attributs =================//
    private String email;
    private String mdp;

    // ==================== Constructeurs =====================//
    public Adherent(){
    }

    public Adherent(Integer pId){
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
