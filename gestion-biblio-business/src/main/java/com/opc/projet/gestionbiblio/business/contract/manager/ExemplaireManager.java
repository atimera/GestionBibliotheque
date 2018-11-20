package com.opc.projet.gestionbiblio.business.contract.manager;

import com.opc.projet.gestionbiblio.model.bean.Exemplaire;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheExemplaire;

import java.util.List;

public interface ExemplaireManager {
    /**
     * Cherche et renvoie le {@link Exemplaire} numéro {@code pNumero}
     *
     * @param pId l'id de l'exemplaire
     * @return Le {@link Exemplaire}
     * @throws NotFoundException Si l'exemplaire n'est pas trouvé
     */
    Exemplaire getExemplaire(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Exemplaire} correspondants aux critères de recherche.
     *
     * @param pRechercheExemplaire -
     * @return List
     */
    List<Exemplaire> getListExemplaire(RechercheExemplaire pRechercheExemplaire);

    /**
     * Renvoie le nombre d' {@link Exemplaire} correspondants aux critères de recherche.
     *
     * @param pRechercheExemplaire -
     * @return int
     */
    int getCountExemplaire(RechercheExemplaire pRechercheExemplaire);
}
