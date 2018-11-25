package com.opc.projet.gestionbiblio.webapp.dao.impl;

import com.opc.projet.gestionbiblio.webapp.dao.contract.LibraryDao;
import com.opc.projet.gestionbiblio.webapp.entity.Library;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class LibraryDaoImpl implements LibraryDao {

    // need to inject session Factory
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void add(Library library) {

        sessionFactory.getCurrentSession().save(library);

    }

    @Override
    @Transactional
    public int getLibrary(Integer libraryId) {
        return 0;
    }

    @Override
    @Transactional
    public List<Library> getLibraries() {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession
                .createQuery("select  from", Library.class)
                .getResultList();

    }
}
