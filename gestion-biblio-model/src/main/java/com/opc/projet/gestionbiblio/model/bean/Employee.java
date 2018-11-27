package com.opc.projet.gestionbiblio.model.bean;

public class Employee extends Person {

    // ===================== Attributs =================//
    private String email;
    private String mdp;

    // ==================== Constructeurs =====================//
    public Employee(){
    }

    public Employee(Integer pId){
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
