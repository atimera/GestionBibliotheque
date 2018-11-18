package com.opc.projet.gestionbiblio.impl.manager;

import com.opc.projet.gestionbiblio.contract.manager.OuvrageManager;
import com.opc.projet.gestionbiblio.exception.NotFoundException;
import com.opc.projet.gestionbiblio.bean.Ouvrage;
import com.opc.projet.gestionbiblio.recherche.RechercheOuvrage;

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
