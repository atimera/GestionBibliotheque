package com.opc.projet.gestionbiblio.webapp.service.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAddresses();

    Address get(Integer addressId);

    void delete(Integer addressId);

    void saveAddress(Address theAddress);
}
