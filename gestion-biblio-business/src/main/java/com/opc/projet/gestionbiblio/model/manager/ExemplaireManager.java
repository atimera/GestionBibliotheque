package com.opc.projet.gestionbiblio.model.manager;

import com.opc.projet.gestionbiblio.model.bean.Exemplaire;
import com.opc.projet.gestionbiblio.model.exception.NotFoundException;
import com.opc.projet.gestionbiblio.model.recherche.RechercheExemplaire;

import java.util.ArrayList;
import java.util.List;

public class ExemplaireManager {
    /**
     * Cherche et renvoie le {@link Exemplaire} numéro {@code pNumero}
     *
     * @param pId l'id de l'exemplaire
     * @return Le {@link Exemplaire}
     * @throws NotFoundException Si l'exemplaire n'est pas trouvé
     */
    public Exemplaire getExemplaire(Integer pId) throws NotFoundException {
        // TODO: 15/11/2018
        return  new Exemplaire(2);
    }


    /**
     * Renvoie la liste des {@link Exemplaire} correspondants aux critères de recherche.
     *
     * @param pRechercheExemplaire -
     * @return List
     */
    public List<Exemplaire> getListTicket(RechercheExemplaire pRechercheExemplaire) {
        // TODO: 15/11/2018  
        return  new ArrayList<>();
    }


    /**
     * Renvoie le nombre d' {@link Exemplaire} correspondants aux critères de recherche.
     *
     * @param pRechercheExemplaire -
     * @return int
     */
    public int getCountTicket(RechercheExemplaire pRechercheExemplaire) {
        // TODO: 18/11/2018  
        return 42;
    }
}
