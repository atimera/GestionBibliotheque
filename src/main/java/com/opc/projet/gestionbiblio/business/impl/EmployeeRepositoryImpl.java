package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.EmployeeRepository;
import com.opc.projet.gestionbiblio.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
public class EmployeeRepositoryImpl {

    // for connection to the db
    @PersistenceContext
    EntityManager em;



}
