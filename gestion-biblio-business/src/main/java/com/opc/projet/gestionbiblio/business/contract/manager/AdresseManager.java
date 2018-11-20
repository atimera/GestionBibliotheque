package com.opc.projet.gestionbiblio.business.contract.manager;

import com.opc.projet.gestionbiblio.model.bean.Adresse;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import java.util.List;

public interface AdresseManager {

    /**
     * Cherche et renvoie le {@link Adresse} numéro {@code pNumero}
     *
     * @param pId l'id de l'exemplaire
     * @return Le {@link Adresse}
     * @throws NotFoundException Si l'ouvrage n'est pas trouvé
     */
    Adresse getAdresse(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Adresse} correspondants aux critères de recherche.
     *
     * @return List
     */
    List<Adresse> getListAdresse();
}
