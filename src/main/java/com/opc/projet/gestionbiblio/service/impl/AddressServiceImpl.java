package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.AddressRepository;
import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.service.contract.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository repository;

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }

    @Override
    public Address getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Address save(Address address) {
        return repository.insert(address);
    }

    @Override
    public Address updtae(Address address) {
        return repository.update(address);
    }

    @Override
    public void deleteById(long id) {
        repository.deletById(id);
    }
}
