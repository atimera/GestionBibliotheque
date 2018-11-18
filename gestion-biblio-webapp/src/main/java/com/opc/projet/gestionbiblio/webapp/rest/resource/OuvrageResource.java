package com.opc.projet.gestionbiblio.webapp.rest.resource;

import com.opc.projet.gestionbiblio.model.bean.Ouvrage;
import com.opc.projet.gestionbiblio.model.manager.OuvrageManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("/ouvrages")
@Produces(MediaType.APPLICATION_JSON)
public class OuvrageResource extends AbstractResource {

    /**
     * Renvoie l' {@link Ouvrage} d'identifiant {@code pId}
     *
     * @param pId identifiant du {@link Ouvrage}
     * @return Le {@link Ouvrage}
     * @throws NotFoundException Si le {@link Ouvrage} n'a pas été trouvé
     */
    @GET
    @Path("{id}")
    public Ouvrage get(@PathParam("id") Integer pId) throws NotFoundException {
        OuvrageManager vOuvrageManager = getManagerFactory().getOuvrageManager();
        Ouvrage vProjet = vOuvrageManager.getOuvrage(pId);
        return vProjet;
    }


    /**
     * Renvoie tous les {@link Ouvrage}
     *
     * @return List
     */
    @GET
    public List<Ouvrage> get() {
        OuvrageManager vProjetManager = getManagerFactory().getOuvrageManager();
        List<Ouvrage> vListOuvrage = vProjetManager.getListProjet();
        return vListOuvrage;
    }
}
