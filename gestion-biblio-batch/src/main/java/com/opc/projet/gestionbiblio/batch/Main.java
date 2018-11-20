package com.opc.projet.gestionbiblio.batch;

import com.opc.projet.gestionbiblio.business.contract.ManagerFactory;
import com.opc.projet.gestionbiblio.model.exception.TechnicalException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main
{
    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(Main.class);


    /**
     * The entry point of application.
     *
     * @param pArgs the input arguments
     * @throws TechnicalException sur erreur technique
     */
    public static void main(String[] pArgs) throws TechnicalException {
        ApplicationContext vApplicationContext
                //= new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
                = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // Il est possible de récupérer un bean dans ce contexte :
        ManagerFactory vManagerFactory
                = vApplicationContext.getBean("managerFactory", ManagerFactory.class);

        try {
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }

            String vTraitementId = pArgs[0];
            if ("ExportTicketStatus".equals(vTraitementId)) {
                LOGGER.info("Execution du traitement : ExportTicketStatus");
                // ...
            } else {
                throw new TechnicalException("Traitement inconnu : " + vTraitementId);
            }
        } catch (Throwable vThrowable) {
            LOGGER.error(vThrowable);
            System.exit(1);
        }
    }
}
