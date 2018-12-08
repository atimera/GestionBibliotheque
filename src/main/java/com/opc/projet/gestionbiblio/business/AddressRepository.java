package com.opc.projet.gestionbiblio.business;

import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.model.Library;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("JpaQueryApiInspection")
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

    // === find all
//    public void findLibrariesGroupByCity(){
//        System.out.println(entityManager.createNamedQuery("find_libraries_group_by_city", Address.class));
//
//    }
//

    // === find by id
    public Address findById(long id){
        return entityManager.find(Address.class, id);
    }

    // === find by id
    public Library getLibraryDetails(Address address){
        return entityManager.find(Library.class, address.getLibrary().getId());
    }


    // === update
    public Address save(Address address){
        if(address.getId() == null){
            entityManager.persist(address);
        }else {
            entityManager.merge(address);
        }
        return address;
    }

    // === delete by id
    public void deletById(long id){
        Address address = findById(id);
        if(address != null)
            entityManager.remove(address);
    }




}
