package com.opc.projet.gestionbiblio.business.contract.manager;

import com.opc.projet.gestionbiblio.model.bean.Address;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;

import java.util.List;

public interface AdresseManager {

    /**
     * Cherche et renvoie le {@link Address} numéro {@code pNumero}
     *
     * @param pId l'id de l'exemplaire
     * @return Le {@link Address}
     * @throws NotFoundException Si l'ouvrage n'est pas trouvé
     */
    Address getAdresse(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Address} correspondants aux critères de recherche.
     *
     * @return List
     */
    List<Address> getListAdresse();
}
