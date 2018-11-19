package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.business.bean.Employe;
import com.opc.projet.gestionbiblio.business.contract.manager.EmployeManager;
import com.opc.projet.gestionbiblio.business.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EmployeManagerImpl implements EmployeManager {
    @Override
    public Employe getEmploye(Integer pId) throws NotFoundException {
        // TODO: 19/11/2018
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        if (pId < 1) {
            throw new NotFoundException("Employé non trouvé : ID=" + pId);
        }
        Employe vEmploye = new Employe(pId);
        vEmploye.setNom("Projet n°" + pId);
        return vEmploye;
    }


    @Override
    public List<Employe> getListEmploye() {
        // TODO: 19/11/2018
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        List<Employe> vList = new ArrayList<>();
        for (int vI = 0; vI < 9; vI++) {
            Employe vEmploye = new Employe(vI);
            vEmploye.setNom("Employé n°" + vI);
            vList.add(vEmploye);
        }
        return vList;
    }
}
