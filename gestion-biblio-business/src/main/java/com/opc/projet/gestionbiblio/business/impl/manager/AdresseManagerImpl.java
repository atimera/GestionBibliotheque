package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.business.contract.manager.AdresseManager;
import com.opc.projet.gestionbiblio.model.bean.Address;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("adresseManager")
public class AdresseManagerImpl extends AbstractManager implements AdresseManager {

    @Override
    public Address getAdresse(Integer pId) throws NotFoundException {
        return new Address(pId);
    }

    @Override
    public List<Address> getListAdresse() {
        List<Address> vAdresseList = new ArrayList<>();

        return vAdresseList;
    }
}
