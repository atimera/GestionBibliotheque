package com.opc.projet.gestionbiblio.webapp.rest;


import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class RestApplication extends ResourceConfig {

    public RestApplication() {
        packages("com.opc.projet.gestionbiblio.webapp.rest");
    }
}