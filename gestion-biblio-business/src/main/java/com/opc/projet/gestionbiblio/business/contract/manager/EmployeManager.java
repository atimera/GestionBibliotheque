package com.opc.projet.gestionbiblio.business.contract.manager;

import com.opc.projet.gestionbiblio.model.bean.Employee;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import java.util.List;

public interface EmployeManager {
    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant de l'emplyé
     * @return Le {@link Employee}
     * @throws NotFoundException Si l'employé n'est pas trouvé
     */
    Employee getEmploye(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Employee}
     *
     * @return List
     */
    List<Employee> getListEmploye();
}
