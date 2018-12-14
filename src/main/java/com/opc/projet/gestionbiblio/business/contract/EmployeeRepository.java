package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
