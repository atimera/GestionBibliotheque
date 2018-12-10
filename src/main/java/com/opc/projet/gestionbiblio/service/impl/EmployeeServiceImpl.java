package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.EmployeeRepository;
import com.opc.projet.gestionbiblio.model.Employee;
import com.opc.projet.gestionbiblio.service.contract.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        repository.deletById(id);
    }
}
