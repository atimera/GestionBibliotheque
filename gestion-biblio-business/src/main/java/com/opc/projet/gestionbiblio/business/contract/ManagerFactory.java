package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.business.contract.manager.*;


public interface ManagerFactory {

    void setOuvrageManager(OuvrageManager pOuvrageManager);
    OuvrageManager getOuvrageManager();


    void setExemplaireManager(ExemplaireManager pExemplaireManager);
    ExemplaireManager getExemplaireManager();

    void setAdresseManager(AdresseManager pAdresseManager);
    AdresseManager getAdresseManager();

    void setEmployeManager(EmployeManager pEmployeManager);
    EmployeManager getEmployeManager();

    void setBibliothequeManager(BibliothequeManager pBibliothequeManager);
    BibliothequeManager getBibliothequeManager();

    void setAdherentManager(AdherentManager pAdherentManager);
    AdherentManager getAdherentManager();






}
