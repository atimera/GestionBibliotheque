package com.opc.projet.gestionbiblio.webapp.rest.resource;

import com.opc.projet.gestionbiblio.business.contract.manager.AdresseManager;
import com.opc.projet.gestionbiblio.model.bean.adresse.Adresse;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Ressource REST pour les {@link Adresse}.
 *
 * @author lgu
 */
@Path("/adresses")
@Produces(MediaType.APPLICATION_JSON)
public class AdresseResource extends AbstractResource{



    /**
     * Renvoie l' {@link Adresse} d'id {@code pId}
     *
     * @param pId id de l' {@link Adresse}
     * @return L' {@link Adresse}
     * @throws NotFoundException Si l' {@link Adresse} n'a pas été trouvé
     */
    @GET
    @Path("{id}")
    public Adresse get(@PathParam("id") Integer pId) throws NotFoundException {
        AdresseManager aAdresseManager  = getManagerFactory().getAdresseManager();
        Adresse vAdresse = aAdresseManager.getAdresse(pId);
        return vAdresse;
    }

    /**
     * Renvoie tous les {@link Adresse}
     *
     * @return List
     */
    @GET
    public List<Adresse> get() {
        AdresseManager vAdresseManager = getManagerFactory().getAdresseManager();
        List<Adresse> vAdresseList = vAdresseManager.getListAdresse();
        return vAdresseList;
    }




}
