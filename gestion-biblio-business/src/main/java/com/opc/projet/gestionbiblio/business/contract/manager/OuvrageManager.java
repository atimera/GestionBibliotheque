package com.opc.projet.gestionbiblio.business.contract.manager;

import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheOuvrage;
import com.opc.projet.gestionbiblio.model.bean.Ouvrage;

import java.util.List;

public interface OuvrageManager {
    /**
     * Cherche et renvoie le {@link Ouvrage} numéro {@code pNumero}
     *
     * @param pId l'id de l'exemplaire
     * @return Le {@link Ouvrage}
     * @throws NotFoundException Si l'ouvrage n'est pas trouvé
     */
    Ouvrage getOuvrage(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Ouvrage} correspondants aux critères de recherche.
     *
     * @param pRechercheOuvrage -
     * @return List
     */
    List<Ouvrage> getListOuvrage(RechercheOuvrage pRechercheOuvrage);

    /**
     * Renvoie le nombre d' {@link Ouvrage} correspondants aux critères de recherche.
     *
     * @param pRechercheOuvrage -
     * @return int
     */
    int getCountOuvrage(RechercheOuvrage pRechercheOuvrage);
}
