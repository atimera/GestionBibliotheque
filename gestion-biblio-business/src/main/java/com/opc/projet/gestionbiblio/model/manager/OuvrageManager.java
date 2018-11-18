package com.opc.projet.gestionbiblio.model.manager;

import com.opc.projet.gestionbiblio.model.bean.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class OuvrageManager {
    
    public Ouvrage getOuvrage(Integer pId) {
        // TODO: 18/11/2018  
        return new Ouvrage(pId);
    }

    public List<Ouvrage> getListProjet() {
        // TODO: 18/11/2018  
        return new ArrayList<>();
    }
}
