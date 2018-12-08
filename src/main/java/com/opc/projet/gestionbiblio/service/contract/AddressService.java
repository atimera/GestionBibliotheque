package com.opc.projet.gestionbiblio.service.contract;

import com.opc.projet.gestionbiblio.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<Address> getAll();
    Address getById(long id);
    Address save(Address address);
    Address updtae(Address address);
    void deleteById(long id);

}
