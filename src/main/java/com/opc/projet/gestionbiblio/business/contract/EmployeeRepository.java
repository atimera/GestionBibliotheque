package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    // === find all
//    public List<Employee> findAll();
//
//    // === find by id
//    public Employee findById(long id);
//
//    // === insert / update
//    public Employee save(Employee employee);
//
//    // === delete by id
//    public void deletById(long id);



}
