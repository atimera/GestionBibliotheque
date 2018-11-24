package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerDao {

    @Transactional
    List<Customer> getCustomers();
}
