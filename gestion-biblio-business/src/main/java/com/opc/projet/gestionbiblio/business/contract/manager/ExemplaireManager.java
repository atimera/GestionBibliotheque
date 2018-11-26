package com.opc.projet.gestionbiblio.business.contract.manager;

import com.opc.projet.gestionbiblio.model.bean.Copy;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheExemplaire;

import java.util.List;

public interface ExemplaireManager {
    /**
     * Cherche et renvoie le {@link Copy} numéro {@code pNumero}
     *
     * @param pId l'id de l'exemplaire
     * @return Le {@link Copy}
     * @throws NotFoundException Si l'exemplaire n'est pas trouvé
     */
    Copy getExemplaire(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Copy} correspondants aux critères de recherche.
     *
     * @param pRechercheExemplaire -
     * @return List
     */
    List<Copy> getListExemplaire(RechercheExemplaire pRechercheExemplaire);

    /**
     * Renvoie le nombre d' {@link Copy} correspondants aux critères de recherche.
     *
     * @param pRechercheExemplaire -
     * @return int
     */
    int getCountExemplaire(RechercheExemplaire pRechercheExemplaire);
}
