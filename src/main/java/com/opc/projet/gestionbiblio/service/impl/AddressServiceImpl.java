package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.model.DomainObject;
import com.opc.projet.gestionbiblio.service.contract.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Profile("map")
public class AddressServiceImpl extends AbstractMapService implements AddressService {

    public AddressServiceImpl(){
        loadAddresses();
    }


    @Override
    public List<DomainObject> getAll() {
         return super.getAll();
    }

    @Override
    public Address getById(Integer addressId) {
        return (Address) super.getById(addressId);
    }

    @Override
    public Address saveOrUpdate(Address address) {
        return (Address) super.saveOrUpdate(address);
    }


    @Override
    public void delete(Integer addressId) {
        super.delete(addressId);
    }

    protected void loadAddresses(){
        domainMap = new HashMap<>();


        Address a1 = new Address();
        a1.setId(1);
        a1.setAddress("1 rue de paris");
        a1.setPostalCode("75020");
        a1.setCity("Paris");
        domainMap.put(1, a1);

        Address a2 = new Address();
        a2.setId(2);
        a2.setAddress("10 Allée augène pottier");
        a2.setPostalCode("77420");
        a2.setCity("Champs sur marne");
        domainMap.put(2, a2);

        Address a3 = new Address();
        a3.setId(3);
        a3.setAddress("33 Avenue Robert");
        a3.setPostalCode("77320");
        a3.setCity("Noisy");
        domainMap.put(3, a3);

        Address a4 = new Address();
        a4.setId(4);
        a4.setAddress("70 Rue molière");
        a4.setPostalCode("77420");
        a4.setCity("Noisiel");
        domainMap.put(4, a4);


    }
}
