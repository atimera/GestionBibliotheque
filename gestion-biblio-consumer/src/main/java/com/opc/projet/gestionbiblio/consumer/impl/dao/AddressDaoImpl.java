package com.opc.projet.gestionbiblio.consumer.impl.dao;

import com.opc.projet.gestionbiblio.consumer.contract.dao.AddressDao;
import com.opc.projet.gestionbiblio.consumer.impl.AbstractDaoImpl;
import com.opc.projet.gestionbiblio.model.bean.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Named
public class AddressDaoImpl extends AbstractDaoImpl implements AddressDao {

    // need to inject session Factory
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Address> getAddresses() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Address> theQuery = currentSession.createQuery("from Address", Address.class);

        // executre query and get results
        return theQuery.getResultList();

        // for example without db
//        List<Address> addressList = new ArrayList<>();
//        addressList.add( new Address("15 Avenue auguste renoir", "77680", "Roissy en brie"));
//        addressList.add( new Address("2 Boulevard des près", "77008", "Paris"));
//        addressList.add( new Address("10 Allée Eugène Pottier", "77420", "Champs sur marne"));
//        return addressList;
    }

    @Override
    @Transactional
    public void add(Address address) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(address);

    }

    @Override
    @Transactional
    public Address get(Integer addressId) {

        return sessionFactory.getCurrentSession().get(Address.class, addressId);

    }

    @Override
    @Transactional
    public void delete(Integer addressId) {
        sessionFactory.getCurrentSession().delete(addressId);
    }


}
