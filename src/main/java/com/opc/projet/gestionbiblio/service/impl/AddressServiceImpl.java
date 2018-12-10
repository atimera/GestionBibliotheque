package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.contract.AddressRepository;
import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.service.contract.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository repository;

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }

    @Override
    public Address getById(long id) {
        Address vAddress = null;
        Optional<Address> optional = repository.findById(id);

        if(optional.isPresent()){
            vAddress = optional.get();
        }

        return vAddress;
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public void deleteById(long id) {

        repository.deleteById(id);
    }
}
