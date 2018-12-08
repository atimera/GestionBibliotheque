package com.opc.projet.gestionbiblio;


import com.opc.projet.gestionbiblio.business.AddressRepository;
import com.opc.projet.gestionbiblio.business.LibraryRepository;
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
    @Autowired
    private LibraryRepository libraryRepository;

    
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

//        logger.info("\n====> All Addresses -> {}", addressRepository.findAll());
//
//        libraryRepository.save(new Library("Ma biblio"));
//
//        Library library = new Library("Ma biblotheque");
//        Address a = new Address();
//        a.setCity("Ma ville"); a.setPostalCode("99999");
//        library.setAddress(a);
//        logger.info("\n====> Seved Library -> {}", libraryRepository.save(library));

//
//        logger.info("\n====> Librery with id 3 -> {}", libraryRepository.findById(200000L));
//
//        Library l = libraryRepository.findById(200000L);
//        System.out.println("\nLibrairie trouvé: \n"+ l);
    }
}
