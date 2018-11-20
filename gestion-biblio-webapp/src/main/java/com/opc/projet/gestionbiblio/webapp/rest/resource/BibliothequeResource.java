package com.opc.projet.gestionbiblio.webapp.rest.resource;

import com.opc.projet.gestionbiblio.model.bean.Adresse;
import com.opc.projet.gestionbiblio.model.bean.Bibliotheque;

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
@Path("/bibliotheques")
@Produces(MediaType.APPLICATION_JSON)
public class BibliothequeResource extends AbstractResource{

    /**
     * Renvoie tous les {@link Bibliotheque}
     *
     * @return List
     */
    @GET
    public List<Bibliotheque> get() {
        return null;
    }




}
