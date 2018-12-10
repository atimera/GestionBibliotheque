package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.contract.EmployeeRepository;
import com.opc.projet.gestionbiblio.model.Book;
import com.opc.projet.gestionbiblio.model.Employee;
import com.opc.projet.gestionbiblio.service.contract.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(long pId) {
        Employee vEmployee = null;
        Optional<Employee> optional = repository.findById(pId);

        if(optional.isPresent()){
            vEmployee = optional.get();
        }
        return vEmployee;
    }


    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
