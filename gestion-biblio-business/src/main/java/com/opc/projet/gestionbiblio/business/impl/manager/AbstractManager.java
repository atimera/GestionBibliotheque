package com.opc.projet.gestionbiblio.business.impl.manager;

import com.opc.projet.gestionbiblio.consumer.contract.DaoFactory;

public abstract class AbstractManager {

    private DaoFactory daoFactory;

    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory pDaoFactory) {
        daoFactory = pDaoFactory;
    }
}
