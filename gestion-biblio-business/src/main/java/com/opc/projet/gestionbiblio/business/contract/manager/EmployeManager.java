package com.opc.projet.gestionbiblio.business.contract.manager;

import com.opc.projet.gestionbiblio.model.bean.Employe;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import java.util.List;

public interface EmployeManager {
    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant de l'emplyé
     * @return Le {@link Employe}
     * @throws NotFoundException Si l'employé n'est pas trouvé
     */
    Employe getEmploye(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Employe}
     *
     * @return List
     */
    List<Employe> getListEmploye();
}
