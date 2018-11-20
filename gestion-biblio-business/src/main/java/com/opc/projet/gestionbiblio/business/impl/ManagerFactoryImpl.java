package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.ManagerFactory;
import com.opc.projet.gestionbiblio.business.contract.manager.*;
import com.opc.projet.gestionbiblio.model.bean.Employe;

import javax.inject.Inject;
import javax.inject.Named;

@Named("managerFactory")
public final class ManagerFactoryImpl implements ManagerFactory {

    // Ajout d'un attribut projetManager
    @Inject
    private OuvrageManager ouvrageManager;
    @Inject
    private ExemplaireManager exemplaireManager;
    @Inject
    private AdresseManager adresseManager;
    @Inject
    private EmployeManager employeManager;
    @Inject
    private BibliothequeManager bibliothequeManager;
    @Inject
    private AdherentManager adherentManager;


    @Override
    public void setOuvrageManager(OuvrageManager pOuvrageManager) {
        ouvrageManager = pOuvrageManager;
    }

    @Override
    public OuvrageManager getOuvrageManager() {
        return ouvrageManager;
    }

    @Override
    public void setExemplaireManager(ExemplaireManager pExemplaireManager){
        exemplaireManager = pExemplaireManager;
    }


    @Override
    public ExemplaireManager getExemplaireManager() {
        return exemplaireManager;
    }

    @Override
    public void setAdresseManager(AdresseManager pAdresseManager){
        adresseManager = pAdresseManager;
    }

    @Override
    public AdresseManager getAdresseManager(){
        return adresseManager;
    }

    @Override
    public void setEmployeManager(EmployeManager pEmployeManager){
        employeManager = pEmployeManager;
    }

    @Override
    public EmployeManager getEmployeManager(){
        return employeManager;
    }

    @Override
    public void setBibliothequeManager(BibliothequeManager pBibliothequeManager){
        bibliothequeManager = pBibliothequeManager;
    }

    @Override
    public BibliothequeManager getBibliothequeManager(){
        return bibliothequeManager;
    }

    @Override
    public void setAdherentManager(AdherentManager pAdherentManager){
        adherentManager = pAdherentManager;
    }

    @Override
    public AdherentManager getAdherentManager(){
        return adherentManager;
    }

}
