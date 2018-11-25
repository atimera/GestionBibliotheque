package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeDao {

    @Transactional
    public void add(Employee employee);

    @Transactional
    public int getEmploye(Integer employeeId);

    @Transactional
    public List<Employee> getEmployees();

}
