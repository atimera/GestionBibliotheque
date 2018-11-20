package com.opc.projet.gestionbiblio.model.bean;

import java.util.Date;

public class Exemplaire {

    // ================= Attributs ======================= //
    private Integer id;
    private Date dateAchat;

    // ================== Constructors ================= //

    public Exemplaire(){
    }

    public Exemplaire(Integer pId){
        id = pId;
    }



}
