package com.opc.projet.gestionbiblio;


import com.opc.projet.gestionbiblio.business.AddressRepository;
import com.opc.projet.gestionbiblio.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestionbiblioApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private AddressRepository addressRepository;
    
	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(GestionbiblioApplication.class, args);

//        System.out.println("*************** Beans ******************");
//        System.out.println(ctx.getBeanDefinitionCount());
//        for (String beanName: ctx.getBeanDefinitionNames()) {
//            System.out.println(beanName);
//        }
//        System.out.println("*************** Beans ******************");
	}


    // === execute a command line on start up
    @Override
    public void run(String... args) throws Exception {

        logger.info("\n====> All users -> {}", addressRepository.findAll());

        logger.info("\n====> User with id 100004 -> {}", addressRepository.findById(100004L));

        //logger.info("\n====> User with Last Name Timera -> {}", dao.findByLastName("Timera"));


        //logger.info("\n====> Deleting Users Last Name TIMERA -> Number of rows deleted - {}", dao.deleteByLastName("timera"));

        logger.info("\n====> Insert User -> Number of rows inserted - {}",
                addressRepository.insert(new Address("5 Boulevard du palais", "", "75015", "Paris")));

        logger.info("\n====> Updating User with id 100004 -> {}");
        addressRepository.update(
                new Address(
                        1L,
                        "5 Boulevard du palais",
                        "",
                        "75015",
                        "Paris")
        );

        /*
	    Address newAddress = new Address("Robert", "Mogabé", "Yaoudé", new Date());
        logger.info("\n====> Updating User with id 10001 -> {}",
                dao.updateById(10001, newAddress));
        */

        Thread.sleep(1000);

        logger.info("\n====> Deleting User with with id 100001 -> Number of rows deleted ");
        addressRepository.deletById(1L);

        logger.info("\n====> All users -> {}", addressRepository.findAll());

    }
}
