package com.opc.projet.gestionbiblio.webapp.dao.impl;

import com.opc.projet.gestionbiblio.webapp.dao.contract.LibraryDao;
import com.opc.projet.gestionbiblio.webapp.entity.Address;
import com.opc.projet.gestionbiblio.webapp.entity.Library;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Repository
@Named
public class LibraryDaoImpl implements LibraryDao {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Library> list() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Library", Library.class)
                .getResultList();

//        List<Library> libraryList = new ArrayList<>();
//        Library library = new Library("Ma Bibliothèque");
//        Address address = new Address("20 Rue du boid", "77500", "Rouen");
//        libraryList.add(library);
//        return libraryList;
    }

    @Override
    public void add(Library library) {

        sessionFactory.getCurrentSession().save(library);

    }
}
