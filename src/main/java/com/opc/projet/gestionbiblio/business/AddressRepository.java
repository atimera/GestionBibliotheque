package com.opc.projet.gestionbiblio.business;

import com.opc.projet.gestionbiblio.model.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class AddressRepository {

    // for connection to the db
    @PersistenceContext
    EntityManager entityManager;

    // === find all
    public List<Address> findAll(){
        TypedQuery<Address> namedQuery = entityManager.createNamedQuery("find_all_addresses", Address.class);

        return namedQuery.getResultList();
    }

    // === find by id
    public Address findById(long id){
        return entityManager.find(Address.class, id);
    }

    // === update
    public Address update(Address address){ // can also be used for : insert(Address) depending if the id is set or not
        return entityManager.merge(address);
    }

    // === update
    public Address insert(Address address){
        return entityManager.merge(address);
    }

    // === delete by id
    public void deletById(long id){
        Address address = findById(id);
        if(address != null)
            entityManager.remove(address);
    }




}
