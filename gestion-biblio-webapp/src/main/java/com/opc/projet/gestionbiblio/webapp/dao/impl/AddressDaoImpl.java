package com.opc.projet.gestionbiblio.webapp.dao.impl;

import com.opc.projet.gestionbiblio.webapp.dao.contract.AddressDao;
import com.opc.projet.gestionbiblio.webapp.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {

    // need to inject session Factory
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Address> getAddresses() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Address> theQuery = currentSession.createQuery("from Address", Address.class);

        // executre query and get results
        return theQuery.getResultList();

    }

    @Override
    public void save(Address address) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(address);

    }

    @Override
    public Address get(Integer addressId) {

        return sessionFactory.getCurrentSession().get(Address.class, addressId);

    }

    @Override
    public void delete(Integer addressId) {
        sessionFactory.getCurrentSession().delete(addressId);
    }


}
