package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.business.contract.manager.OuvrageManager;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheOuvrage;
import com.opc.projet.gestionbiblio.model.bean.Ouvrage;

import javax.inject.Named;
import java.util.List;

@Named("ouvrageManager")
public class OuvrageManagerImpl implements OuvrageManager {
    @Override
    public Ouvrage getOuvrage(Integer pId) throws NotFoundException {
        // TODO: 19/11/2018
        return null;
    }

    @Override
    public List<Ouvrage> getListOuvrage(RechercheOuvrage pRechercheOuvrage) {
        // TODO: 19/11/2018
        return null;
    }

    @Override
    public int getCountOuvrage(RechercheOuvrage pRechercheOuvrage) {
        // TODO: 19/11/2018
        return 0;
    }
}
