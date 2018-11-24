package com.opc.projet.gestionbiblio.webapp.dao.impl;

import com.opc.projet.gestionbiblio.webapp.dao.contract.CustomerDao;
import com.opc.projet.gestionbiblio.webapp.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    // nend to inject session Factory
    //@Autowired
    private SessionFactory sessionFactory = null;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

/*        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

        // executre query and get results
        List<Customer> results = theQuery.getResultList();

        // return the list
        return results;
        */

        // for example without db
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("John", "Doe", "john.doe@gmail.com"));
        customerList.add(new Customer("Franc", "Leroy", "leroy.franc@gmail.com"));
        customerList.add(new Customer("Moise", "Camara", "moise.camara@hotmail.com"));
        return customerList;
    }

}
