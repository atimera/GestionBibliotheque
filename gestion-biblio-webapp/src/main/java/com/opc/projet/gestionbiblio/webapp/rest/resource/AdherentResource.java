package com.opc.projet.gestionbiblio.webapp.rest.resource;

import com.opc.projet.gestionbiblio.model.bean.Adherent;
import com.opc.projet.gestionbiblio.model.bean.Adresse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Ressource REST pour les {@link Adresse}.
 *
 * @author lgu
 */
@Path("/adherents")
@Produces(MediaType.APPLICATION_JSON)
public class AdherentResource extends AbstractResource{


    /**
     * Renvoie tous les {@link Adherent}
     *
     * @return List
     */
    @GET
    public List<Adherent> get() {
        return null;
    }




}
