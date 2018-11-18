package com.opc.projet.gestionbiblio.impl.manager;

import com.opc.projet.gestionbiblio.bean.Exemplaire;
import com.opc.projet.gestionbiblio.contract.manager.ExemplaireManager;
import com.opc.projet.gestionbiblio.exception.NotFoundException;
import com.opc.projet.gestionbiblio.recherche.RechercheExemplaire;

import java.util.ArrayList;
import java.util.List;

public class ExemplaireManagerImpl implements ExemplaireManager {
    @Override
    public Exemplaire getExemplaire(Integer pId) throws NotFoundException {
        // TODO: 15/11/2018
        return  new Exemplaire(2);
    }


    @Override
    public List<Exemplaire> getListExemplaire(RechercheExemplaire pRechercheExemplaire) {
        // TODO: 15/11/2018
        return  new ArrayList<>();
    }


    @Override
    public int getCountExemplaire(RechercheExemplaire pRechercheExemplaire) {
        // TODO: 18/11/2018
        return 42;
    }
}
