package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.model.bean.Exemplaire;
import com.opc.projet.gestionbiblio.business.contract.manager.ExemplaireManager;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheExemplaire;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("exemplaireManager")
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
