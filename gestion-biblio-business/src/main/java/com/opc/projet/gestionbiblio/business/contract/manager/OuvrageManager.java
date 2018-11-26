package com.opc.projet.gestionbiblio.business.contract.manager;

import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheOuvrage;
import com.opc.projet.gestionbiblio.model.bean.Book;

import java.util.List;

public interface OuvrageManager {
    /**
     * Cherche et renvoie le {@link Book} numéro {@code pNumero}
     *
     * @param pId l'id de l'exemplaire
     * @return Le {@link Book}
     * @throws NotFoundException Si l'ouvrage n'est pas trouvé
     */
    Book getOuvrage(Integer pId) throws NotFoundException;

    /**
     * Renvoie la liste des {@link Book} correspondants aux critères de recherche.
     *
     * @param pRechercheOuvrage -
     * @return List
     */
    List<Book> getListOuvrage(RechercheOuvrage pRechercheOuvrage);

    /**
     * Renvoie le nombre d' {@link Book} correspondants aux critères de recherche.
     *
     * @param pRechercheOuvrage -
     * @return int
     */
    int getCountOuvrage(RechercheOuvrage pRechercheOuvrage);
}
