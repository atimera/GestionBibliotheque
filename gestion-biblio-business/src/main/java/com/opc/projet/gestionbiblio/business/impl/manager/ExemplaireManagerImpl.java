package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.model.bean.Copy;
import com.opc.projet.gestionbiblio.business.contract.manager.ExemplaireManager;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheExemplaire;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("exemplaireManager")
public class ExemplaireManagerImpl extends AbstractManager implements ExemplaireManager {
    @Override
    public Copy getExemplaire(Integer pId) throws NotFoundException {
        // TODO: 15/11/2018
        return  new Copy(2);
    }


    @Override
    public List<Copy> getListExemplaire(RechercheExemplaire pRechercheExemplaire) {
        // TODO: 15/11/2018
        return  new ArrayList<>();
    }


    @Override
    public int getCountExemplaire(RechercheExemplaire pRechercheExemplaire) {
        // TODO: 18/11/2018
        return 42;
    }
}
