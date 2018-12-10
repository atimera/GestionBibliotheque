package com.opc.projet.gestionbiblio.service.contract;

import com.opc.projet.gestionbiblio.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getAll();
    Employee getById(long id);
    Employee save(Employee employee);
    void deleteById(long id);

}
