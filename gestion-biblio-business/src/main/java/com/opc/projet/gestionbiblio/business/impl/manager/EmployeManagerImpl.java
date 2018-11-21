package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.model.bean.Employe;
import com.opc.projet.gestionbiblio.business.contract.manager.EmployeManager;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("employeManager")
public class EmployeManagerImpl extends AbstractManager implements EmployeManager {

    @Override
    public Employe getEmploye(Integer pId) throws NotFoundException {
        // TODO: 19/11/2018

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

        List<Employe> vList = new ArrayList<>();
        for (int vI = 0; vI < 9; vI++) {
            Employe vEmploye = new Employe(vI);

            vEmploye.setNom("Employé n°" + vI);
            vEmploye.setEmail("email_employe"+vI+"@gmail.com");
            vEmploye.setMdp("passe_employe"+vI);

            vList.add(vEmploye);
        }
        return vList;
    }
}
