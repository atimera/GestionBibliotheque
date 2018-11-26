package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.business.contract.manager.OuvrageManager;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheOuvrage;
import com.opc.projet.gestionbiblio.model.bean.Book;

import javax.inject.Named;
import java.util.List;

@Named("ouvrageManager")
public class OuvrageManagerImpl extends AbstractManager implements OuvrageManager {
    @Override
    public Book getOuvrage(Integer pId) throws NotFoundException {
        // TODO: 19/11/2018
        return null;
    }

    @Override
    public List<Book> getListOuvrage(RechercheOuvrage pRechercheOuvrage) {
        // TODO: 19/11/2018
        return null;
    }

    @Override
    public int getCountOuvrage(RechercheOuvrage pRechercheOuvrage) {
        // TODO: 19/11/2018
        return 0;
    }
}
