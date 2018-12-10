package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("JpaQueryApiInspection")
public interface AddressRepository extends JpaRepository<Address, Long> {

//    // === find all
//    public List<Address> findAll();
//
//
//    // === find by id
//    public Address findById(long id);
//
//    // === find by id
//    public Library getLibraryDetails(Address address);
//
//    // === update
//    public Address save(Address address);
//
//    // === delete by id
//    public void deletById(long id);



}
