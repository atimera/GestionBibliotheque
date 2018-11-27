package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Named
public interface EmployeeDao {

    @Transactional
    public void add(Employee employee);

    @Transactional
    public int getEmploye(Integer employeeId);

    @Transactional
    public List<Employee> getEmployees();

}
