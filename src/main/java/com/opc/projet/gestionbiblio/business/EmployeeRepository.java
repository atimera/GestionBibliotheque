package com.opc.projet.gestionbiblio.business;

import com.opc.projet.gestionbiblio.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
@Transactional
public class EmployeeRepository {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    // === find all
    public List<Employee> findAll(){

        TypedQuery<Employee> namedQuery = em.createNamedQuery("find_all_employees", Employee.class);
        return namedQuery.getResultList();
    }

    // === find by id
    public Employee findById(long id){
        return em.find(Employee.class, id);
    }

    // === insert / update
    public Employee save(Employee employee){
        if(employee.getId() == null){
            em.persist(employee);
        }else {
            em.merge(employee);
        }
        return employee;
    }

    // === delete by id
    public void deletById(long id){
        Employee employee = findById(id);
        if(employee != null)
            em.remove(employee);
    }



}
