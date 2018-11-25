package com.opc.projet.gestionbiblio.webapp.dao.impl;

import com.opc.projet.gestionbiblio.webapp.dao.contract.AddressDao;
import com.opc.projet.gestionbiblio.webapp.entity.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {

    // nend to inject session Factory
    //@Autowired
    @Override
    @Transactional
    public List<Address> getAddresses() {

/*        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Address> theQuery = currentSession.createQuery("from Address", Address.class);

        // executre query and get results
        List<Address> results = theQuery.getResultList();

        // return the list
        return results;
        */

        // for example without db
        List<Address> addressList = new ArrayList<>();
        addressList.add( new Address("15 Avenue auguste renoir", "77680", "Roissy en brie"));
        addressList.add( new Address("2 Boulevard des près", "77008", "Paris"));
        addressList.add( new Address("10 Allée Eugène Pottier", "77420", "Champs sur marne"));
        return addressList;
    }
}
