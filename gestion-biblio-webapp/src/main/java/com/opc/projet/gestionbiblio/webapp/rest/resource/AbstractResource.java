package com.opc.projet.gestionbiblio.webapp.rest.resource;

import com.opc.projet.gestionbiblio.business.impl.ManagerFactoryImpl;

public abstract class AbstractResource {

    private static ManagerFactoryImpl managerFactory;

    protected static ManagerFactoryImpl getManagerFactory() {
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactoryImpl pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}
