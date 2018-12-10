package com.opc.projet.gestionbiblio.business;

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
public class LibraryRepository {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    // === find all
    public List<Library> findAll(){
        TypedQuery<Library> namedQuery = em.createNamedQuery("find_all_libraries", Library.class);
        return namedQuery.getResultList();
    }
    // === find all order by name
    public List<Library> findAllOrderByName(){
        TypedQuery<Library> namedQuery = em
                .createNamedQuery("find_all_libraries_order_by_name",
                Library.class);
        return namedQuery.getResultList();
    }
    // === find all group by city
    public List<Library> findAllGoupByCity(){
        TypedQuery<Library> namedQuery = em
                .createNamedQuery("find_all_libraries_group_by_city",
                Library.class);
        // TODO: 08/12/2018 What to return ?? 
        return namedQuery.getResultList();
    }

    // === find by id
    public Library findById(long id){
        return em.find(Library.class, id);
    }

    // === insert / update
    public Library save(Library library){
        if(library.getId() == null){
            em.persist(library);
        }else {
            em.merge(library);
        }
        return library;
    }

    // === insert / update : with the address
//    public Library saveLibraryWithAddress(Library library){
//        Address address = new Address();
//
//        if(library.getAddress().getCity() == null || library.getAddress().getPostalCode() == null){
//            library.setAddress(null);
//            em.detach(address);
//        }else {
//            address = library.getAddress();
//            em.persist(address);
//        }
//
//        if(library.getId() == null){
//            library.setAddress(address);
//            em.persist(library);
//
//        }else {
//            em.merge(library);
//        }
//        return library;
//    }



    // === delete by id
    public void deletById(long id){
        Library library = findById(id);
        if(library != null)
            em.remove(library);
    }



}
