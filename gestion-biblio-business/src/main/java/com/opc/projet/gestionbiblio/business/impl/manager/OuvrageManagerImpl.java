package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.business.contract.manager.OuvrageManager;
import com.opc.projet.gestionbiblio.business.exception.NotFoundException;
import com.opc.projet.gestionbiblio.business.recherche.RechercheOuvrage;
import com.opc.projet.gestionbiblio.business.bean.Ouvrage;

import java.util.List;

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
