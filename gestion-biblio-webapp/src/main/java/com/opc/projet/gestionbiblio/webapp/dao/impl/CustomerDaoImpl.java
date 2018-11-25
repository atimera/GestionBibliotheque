package com.opc.projet.gestionbiblio.webapp.dao.impl;

import com.opc.projet.gestionbiblio.webapp.dao.contract.CustomerDao;
import com.opc.projet.gestionbiblio.webapp.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    // nend to inject session Factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

//        // get the current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        EntityManager entityManager = sessionFactory.createEntityManager();
//
//        // create a query
//        //Query<Customer> theQuery = currentSession.createQuery("select a from Customer a", Customer.class);
//
//        // executre query and get results
//        String sql = "select c from Customer c";
//        List<Customer> results = entityManager.createQuery(sql, Customer.class).getResultList();
//
//        if(results == null){
//            System.out.println( "\nPAS de Résultalt\n");
//        }
//
//        // return the list
//        return results;

        // for example without db
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("John", "Doe", "john.doe@gmail.com"));
        customerList.add(new Customer("Franc", "Leroy", "leroy.franc@gmail.com"));
        customerList.add(new Customer("Moise", "Camara", "moise.camara@hotmail.com"));
        return customerList;
    }

}
