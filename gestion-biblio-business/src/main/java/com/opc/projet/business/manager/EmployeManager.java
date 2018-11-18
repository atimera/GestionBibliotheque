package com.opc.projet.business.manager;

import com.opc.projet.business.bean.Employe;
import com.opc.projet.business.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EmployeManager {
    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Employe}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    public Employe getProjet(Integer pId) throws NotFoundException {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        if (pId < 1) {
            throw new NotFoundException("Employé non trouvé : ID=" + pId);
        }
        Employe vEmploye = new Employe(pId);
        vEmploye.setNom("Projet n°" + pId);
        return vEmploye;
    }


    /**
     * Renvoie la liste des {@link Employe}
     *
     * @return List
     */
    public List<Employe> getListProjet() {
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
