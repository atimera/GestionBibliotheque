package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.business.contract.manager.AdresseManager;
import com.opc.projet.gestionbiblio.model.bean.adresse.Adresse;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("adresseManager")
public class AdresseManagerImpl extends AbstractManager implements AdresseManager {

    @Override
    public Adresse getAdresse(Integer pId) throws NotFoundException {
        return new Adresse(pId);
    }

    @Override
    public List<Adresse> getListAdresse() {
        List<Adresse> vAdresseList = new ArrayList<>();
        for (int i= 1; i<5; i++){
            int cp = 75000;
            Adresse vAdresse = new Adresse(i);
            vAdresse.setRue("Rue "+ i);
            vAdresse.setCodePostal(Integer.toString(cp+i));
            vAdresseList.add(vAdresse);
        }
        return vAdresseList;
    }
}
