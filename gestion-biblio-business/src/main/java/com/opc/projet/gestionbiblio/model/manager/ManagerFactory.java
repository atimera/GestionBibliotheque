package com.opc.projet.gestionbiblio.model.manager;

public final class ManagerFactory {
    /** Instance unique de la classe (design pattern Singleton) */
    private static final ManagerFactory INSTANCE = new ManagerFactory();

    /**
     * Constructeur.
     */
    private ManagerFactory() {
        super();
    }

    /**
     * Renvoie l'instance unique de la classe (design pattern Singleton).
     *
     * @return {@link ManagerFactory}
     */
    public static ManagerFactory getInstance() {
        return ManagerFactory.INSTANCE;
    }

    // Ajout d'un attribut projetManager
    private OuvrageManager ouvrageManager;
    private ExemplaireManager exemplaireManager;

    // On renvoie désormais simplement l'attribut projetManager
    public OuvrageManager getProjetManager() {
        return ouvrageManager;
    }

    // Ajout d'un setter pour l'attribut projetManager
    public void setOuvrageManager(OuvrageManager pOuvrageManager) {
        ouvrageManager = pOuvrageManager;
    }

    public OuvrageManager getOuvrageManager() {
        return ouvrageManager;
    }

    public ExemplaireManager getExemplaireManager() {
        return  exemplaireManager;
    }

    public void setExemplaireManager(ExemplaireManager pExemplaireManager) {
        exemplaireManager = pExemplaireManager;
    }

}
