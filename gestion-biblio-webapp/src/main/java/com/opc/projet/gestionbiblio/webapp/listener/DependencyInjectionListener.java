package com.opc.projet.gestionbiblio.webapp.listener;

import com.opc.projet.gestionbiblio.impl.ManagerFactory;
import com.opc.projet.gestionbiblio.impl.manager.ExemplaireManagerImpl;
import com.opc.projet.gestionbiblio.impl.manager.OuvrageManagerImpl;
import com.opc.projet.gestionbiblio.webapp.rest.resource.AbstractResource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyInjectionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent pServletContextEvent) {
        ManagerFactory vManagerFactory = ManagerFactory.getInstance();
        // On ajoute l'injection de l'implémentation des Managers dans la ManagerFactory
        vManagerFactory.setExemplaireManager(new ExemplaireManagerImpl());
        vManagerFactory.setOuvrageManager(new OuvrageManagerImpl());
        //...
        AbstractResource.setManagerFactory(vManagerFactory);
    }
    @Override
    public void contextDestroyed(ServletContextEvent pServletContextEvent) {
        // NOP
    }
}