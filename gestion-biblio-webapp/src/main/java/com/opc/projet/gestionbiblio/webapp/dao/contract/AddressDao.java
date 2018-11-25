package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Address;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AddressDao {

    @Transactional
    public List<Address> getAddresses();
}
