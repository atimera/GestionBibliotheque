package com.opc.projet.gestionbiblio.webapp.rest.resource;

import com.opc.projet.gestionbiblio.business.contract.manager.EmployeManager;
import com.opc.projet.gestionbiblio.model.bean.Employe;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Ressource REST pour les {@link Employe}.
 *
 * @author lgu
 */
@Path("/employes")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeResource extends AbstractResource{

    /**
     * Renvoie l' {@link Employe} d'id {@code pId}
     *
     * @param pId id de l' {@link Employe}
     * @return L' {@link Employe}
     * @throws NotFoundException Si l' {@link Employe} n'a pas été trouvé
     */
    @GET
    @Path("{id}")
    public Employe get(@PathParam("id") Integer pId) throws NotFoundException {
        EmployeManager vEmployeManager  = getManagerFactory().getEmployeManager();
        Employe vEmploye = vEmployeManager.getEmploye(pId);
        return vEmploye;
    }

    /**
     * Renvoie tous les {@link Employe}
     *
     * @return List
     */
    @GET
    public List<Employe> get() {
        return getManagerFactory().getEmployeManager().getListEmploye();
    }




}
