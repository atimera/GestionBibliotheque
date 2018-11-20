package com.opc.projet.gestionbiblio.webapp.rest.resource;

import com.opc.projet.gestionbiblio.model.bean.Exemplaire;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.business.contract.manager.ExemplaireManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Ressource REST pour les {@link Exemplaire}.
 *
 * @author lgu
 */
@Path("/exemplaires")
@Produces(MediaType.APPLICATION_JSON)
public class ExemplaireResource extends AbstractResource{


    /**
     * Renvoie l' {@link Exemplaire} d'id {@code pId}
     *
     * @param pId id de l' {@link Exemplaire}
     * @return L' {@link Exemplaire}
     * @throws NotFoundException Si l' {@link Exemplaire} n'a pas été trouvé
     */
    @GET
    @Path("{id}")
    public Exemplaire get(@PathParam("id") Integer pId) throws NotFoundException {
        ExemplaireManager vExemplaireManager  = getManagerFactory().getExemplaireManager();
        Exemplaire vExemplaire = vExemplaireManager.getExemplaire(pId);
        return vExemplaire;
    }
    
    @GET
    public List<Exemplaire> get(){
        // TODO: 21/11/2018  
        return null;
    }


}
